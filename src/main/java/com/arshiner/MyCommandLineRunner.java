package com.arshiner;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.arshiner.common.FilePathName;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Zlsjwjb;
import com.arshiner.nio.transmitServer.TransmitServer;
import com.arshiner.quartz.job.FlashCelueTask;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.ClsjwjbService;
import com.arshiner.service.DbconProService;
import com.arshiner.service.ZlsjwjbService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	private static final Logger logger = Logger.getLogger(MyCommandLineRunner.class);
	@Autowired
	SchedulerJobService schedulerJobService;
	@Autowired
	FlashCelueTask FlashCelueTask;
	@Autowired
	DbconProService dbconProService;
	@Autowired
	ClsjwjbService clsjwjbService;
	@Autowired
	ZlsjwjbService zlsjwjbService;

	@Override
	public void run(String... var1) throws Exception {

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);

		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FlashCelueTask.executeF();
				} catch (JobExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 2, TimeUnit.MINUTES);

		/**
		 * 删
		 */
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				File userdir = new File(FilePathName.ROOT);
				long used = userdir.getUsableSpace() * 100 / userdir.getTotalSpace();
				logger.info("磁盘可用率--------" + used);
				List<Dbconpro> dblist = dbconProService.selectByExample();
				for (Iterator<Dbconpro> iterator = dblist.iterator(); iterator.hasNext();) {
					Dbconpro dbconpro = (Dbconpro) iterator.next();
					for (int i = 1; i <= dbconpro.getAgentype().intValue(); i++) {
						// 归档目录
						String gd = FilePathName.ROOT + dbconpro.getJgxtlb() + FilePathName.FileSepeartor + "thread"
								+ i + FilePathName.FileSepeartor+"log";
						logger.info("定时清理目录--------" + gd);
						deleteFileDIR(used, gd);
					}
					// 存量入库目录
					String cldir = FilePathName.ROOT + dbconpro.getJgxtlb() + FilePathName.FileSepeartor
							+ FilePathName.CLDIDPath;
					deleteFileDIR(used, cldir);
					logger.info("定时清理目录--------" + cldir);
					String zldir = FilePathName.ROOT + dbconpro.getJgxtlb() + FilePathName.FileSepeartor
							+ FilePathName.ZLDIDPath;
					deleteFileDIR(used, zldir);
					logger.info("定时清理目录--------" + zldir);
					String rzjx_old = FilePathName.ROOT + dbconpro.getJgxtlb() + FilePathName.FileSepeartor
							+ FilePathName.RZJXWJPath + "_old";
					deleteFileDIR(used, rzjx_old);
					logger.info("定时清理目录--------" + rzjx_old);
				}
			}
		}, 1, 10, TimeUnit.MINUTES);

		Thread tranServer = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					TransmitServer.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		tranServer.start();
	}

	public void deleteFileDIR(long used, String dir) {
		Date date = null;
		if (used < 60) {
			date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 10);
		} else if (used < 20) {
			date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 5);
		} else if (used < 10) {
			date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
		} else {
			return;
		}
		File folder = new File(dir);
		if (folder.exists()) {
			File[] files = folder.listFiles();
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					File file = files[i];
					if (new Date(file.lastModified()).before(date)) {
						file.delete();
					}
				}
			}
		}
	}

	public boolean moveFile(String oldPath, String newPath) {
		boolean flag = false;
		File file = new File(oldPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.renameTo(new File(newPath));
			flag = true;
		}
		return flag;
	}

}
