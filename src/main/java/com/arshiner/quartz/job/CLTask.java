package com.arshiner.quartz.job;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.common.ConfigManager;
import com.arshiner.common.FilePathName;
import com.arshiner.common.JDBCUtil;
import com.arshiner.common.SAXCreate;
import com.arshiner.common.ThreadPool;
import com.arshiner.common.XMLFileName;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.Clsjkddb;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Exeception;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.ScheduleJob;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.CjrjyxztService;
import com.arshiner.service.ClsjclztService;
import com.arshiner.service.ClsjkddbService;
import com.arshiner.service.ClsjwjbService;
import com.arshiner.service.DbconProService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.ExeceptionService;
import com.arshiner.service.RzcjqjcsService;

/**
 * 存量的任务 所需要的 目标数据库，连接参数，表名 断点所在位置 ，我所解析的表的筛选条件执行好过后，的rownum这个是从0到末尾，是连续不断，
 * 文件命名所在第几位 文件异常状态，1，写xml的时候任务异常关闭，但是xml没由完成， scheduleJob 使用守护线程池，注意
 * 之前的类中不能有静态变量 类加载机制 首先会加载 静态变量
 * 
 * @author 士林
 */
@Service("CLTASK")
public class CLTask implements Job{
	private static final Logger logger = Logger.getLogger(CLTask.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	ResultSet resultSet;
	ScheduleJob job;
	StringBuffer buffer = new StringBuffer(FilePathName.ROOT);
	/**
	 * 单表日志采集参数
	 */
	private List<Dbrzcjcs> dbrzcjcs;
	/**
	 * 日志采集全局参数
	 */
	private Rzcjqjcs rzcjqjcs;
	/**
	 * 连接参数
	 */
	private Dbconpro dbConpro;
	/**
	 * 单表日志采集全局参数
	 */
	@Autowired
	DbrzcjcsService dbrzcjcsService;
	/**
	 * 日志采集全局参数
	 */
	@Autowired
	RzcjqjcsService rzcjqjcsService;
	/**
	 * 数据库连接参数
	 */
	@Autowired
	DbconProService dbconProService;
	/**
	 * 存量数据块断点表
	 */
	@Autowired
	ClsjkddbService clsjkddbService;
	/**
	 * 存量数据处理状态表
	 */
	@Autowired
	ClsjclztService clsjclztService;
	/**
	 * 存量数据文件表
	 */
	@Autowired
	ClsjwjbService clsjwjbService;
	@Autowired
	SchedulerJobService schedulerJobService;
	@Autowired
	ScheduleJobInService scheduleJobInService;
	@Autowired
	ExeceptionService execeptionService;
	ConfigManager config = new ConfigManager(ConfigManager.babh);
	/**
	 * 采集软件运行状态
	 */
	@Autowired
	CjrjyxztService cjrjyxztService;

	static AtomicBoolean isRun = new AtomicBoolean(false);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		synchronized (isRun) {
			if (isRun.get()) {
				return;
			}
			isRun.set(true);
		}
		logger.info("存量任务" + sdf.format(getTime()));
		// 任务正在执行，跳过本次执行
		try {
			ScheduleJob job1 = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
			logger.info("存量任务==========start   安管代码:" + job1.getAdzm() + "  交管系统类别:" + job1.getJgxtlb() + "  表名:"
					+ job1.getBm());
			job = scheduleJobInService.selectByJobNameAngJobGroup(job1.getJobName(), job1.getJobGroup());
			if (job.getJobStatus().equals("COMPLETE") || job.getJobStatus().equals("PAUSED")) {
				if (job.getJobStatus().equals("COMPLETE")) {
					schedulerJobService.pauseJobByComplete(job.getJobName(), job.getJobGroup());
				} else {
					schedulerJobService.pauseJob(job.getJobName(), job.getJobGroup());
				}
				logger.info("存量任务==========start   安管代码:" + job.getAdzm() + "  交管系统类别:" + job.getJgxtlb() + "  /n表名:"
						+ job.getBm() + "此任务状态为 ：" + "COMPLETE" + "或" + "PAUSED");
				return;
			}
			job.setJobStatus("START");
			schedulerJobService.updateJob(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// 每次运行时获取策略信息
			flashCanshu(job);
			// 获取断点
			buffer.append(dbConpro.getJgxtlb()).append(FilePathName.FileSepeartor);
			//重置存量文件顺序
			XMLFileName.reClfile(dbConpro.getJgxtlb());
			// 获取size
			String bm = "";
			String jgxtlb = dbConpro.getJgxtlb();
			Clsjkddb clsjk;
			Clsjwjb clwj;
			Clsjclzt clzt;
			String bm1 = "";
			for (Iterator<Dbrzcjcs> iterator = dbrzcjcs.iterator(); iterator.hasNext();) {
				Dbrzcjcs dbrzcjcs2 = (Dbrzcjcs) iterator.next();
				bm1 = dbrzcjcs2.getBm();
				clsjk = null;
				clsjk = new Clsjkddb();
				clsjk.setBm(bm1);
				clsjk.setJgxtlb(jgxtlb);
				List<Clsjkddb> clddlist = clsjkddbService.selectBybmAndJGXTLB(clsjk);
				clzt = null;
				clzt = new Clsjclzt();
				clzt.setBm(bm1);
				clzt.setJgxtlb(jgxtlb);
				// 采集却并未执行的时候
				clwj = null;
				clwj = new Clsjwjb();
				clwj.setBm(bm1);
				clwj.setJgxtlb(jgxtlb);
				if (dbrzcjcs2.getClcjbj().equals("0") || dbrzcjcs2.getCjbj().equals("0")) {
					return;
				}
				if (clddlist.isEmpty() || clddlist == null) {
					// 如果上一个表名和现在表名相同，则跳下一个
					if (bm1.equals(bm)) {
						continue;
					}
					bm = dbrzcjcs2.getBm();
					// 无断点
					JDBCUtil db = new JDBCUtil(dbConpro.getUsername(), dbConpro.getPassword(), dbConpro.getIp(),
							dbConpro.getPort(), dbConpro.getSid());
					db.getConnection();
					db.setSchema(dbConpro.getSchema());
					db.setTb_name(bm);
					if (dbrzcjcs2.getClqsrq() == null || dbrzcjcs2.getClqsrq().equals("")) {
						if (dbrzcjcs2.getSjczd() == null || dbrzcjcs2.getSjczd().equals("")
								|| dbrzcjcs2.getSjczd().equals("*")) {
							db.setTimeFied("rowid");
						} else {
							db.setTimeFied(dbrzcjcs2.getSjczd());
						}
						db.setDate("");
					} else {
						if (dbrzcjcs2.getSjczd() == null || dbrzcjcs2.getSjczd().equals("")
								|| dbrzcjcs2.getSjczd().equals("*")) {
							db.setTimeFied("rowid");
						} else {
							db.setTimeFied(dbrzcjcs2.getSjczd());
						}
						db.setDate(dbrzcjcs2.getClqsrq().replace("-", "").replace(":", "").replace(" ", "")
								.replace(".0", ""));
					}
					if (dbrzcjcs2.getClgltj() != null && !dbrzcjcs2.getClgltj().equals("")) {
						db.setWhere(dbrzcjcs2.getClgltj());
					}
					int size = db.getCount();
					// // 此表所要查的条数大于10万 用多线程，，否则用单线程
					db.closeDB();
					cltaskD(size, dbrzcjcs2);
				}
				rzcjqjcs = null;
				Rzcjqjcs record = new Rzcjqjcs();
				record.setGjz("CLSJKLJZDZ");
				rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
				if (rzcjqjcs.getMrz() == null) {
					Exeception exeception = new Exeception();
					exeception.setCreatetime(getTime());
					exeception.setJgxtlb(dbConpro.getJgxtlb());
					exeception.setJobname(job.getJobName());
					exeception.setDesciption("CLTASK:" + "连接参数刷新失败  原因：此任务存量单个数据库最大值为空");
					execeptionService.insertSelective(exeception);
					return;
				}
				/**
				 * 重传
				 */
				clwj.setWjzt("5");
				String standyfilename = FilePathName.ROOT + jgxtlb + FilePathName.FileSepeartor
						+ FilePathName.CLStanbyPath + FilePathName.FileSepeartor;
				File file = null;
				List<Clsjwjb> ccwjllist = clsjwjbService.selectByWjzt(clwj);
				for (int i = 0; i < ccwjllist.size(); i++) {
					if (ccwjllist.size() >= 0) {
						clwj = ccwjllist.get(i);
						file = new File(standyfilename + clwj.getWjm());
						if (file.exists()) {
							clwj.setWjzt("1");
							clwj.setSbzt("0");
						} else {
							clwj.setWjzt("6");
							clwj.setSbzt("0");
						}
						clsjwjbService.updateByExampleSelective(clwj);
					}
				}
				/**
				 * 文件重采
				 */
				int count = new Integer(rzcjqjcs.getMrz());
				clwj.setBm(bm1);
				clwj.setJgxtlb(jgxtlb);
				clwj.setWjzt("6");
				List<Clsjwjb> clwjllist = clsjwjbService.selectByWjzt(clwj);
				if (!clwjllist.isEmpty() && clwjllist != null) {
					if (clwjllist.size() < count) {
						count = clwjllist.size();
					}
					logger.info("文件重采");
					ThreadPool threadPool = new ThreadPool(count);
					int i = 0;
					for (Clsjwjb clsjwjb : clwjllist) {
						i = new Integer(clsjwjb.getSbzt());
						threadPool.execute(createTask(i, clsjwjb.getWjstart().intValue(), clsjwjb.getWjend().intValue(),
								dbrzcjcs2, "cc", clsjwjb.getWjm()));
					}
					threadPool.waitFinish(); // 等待所有任务执行完毕
					threadPool.closePool(); // 关闭线程池
				}
				/**
				 * 断点未完成处理
				 */
				clsjk = null;
				clsjk = new Clsjkddb();
				clsjk.setBm(bm1);
				clsjk.setJgxtlb(jgxtlb);
				clsjk.setWcbj("0");
				clddlist = clsjkddbService.selectByWcbj(clsjk);
				int clddount = new Integer(rzcjqjcs.getMrz());
				if (!clddlist.isEmpty() && clddlist != null) {// 不为空
					if (clddlist.size() < clddount) {
						clddount = clddlist.size();
					}
					ThreadPool threadPool = new ThreadPool(clddount);
					for (Clsjkddb clsjkddb : clddlist) {
						threadPool.execute(createTask(clsjkddb.getSjkbh().intValue(), clsjkddb.getSjkstart().intValue(),
								clsjkddb.getSjkend().intValue(), dbrzcjcs2, "dd", ""));
					}
					threadPool.waitFinish(); // 等待所有任务执行完毕
					threadPool.closePool(); // 关闭线程池
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		job.setJobStatus("NORMAL");
		schedulerJobService.updateJob(job);
		isRun.set(false);
	}

	/**
	 * 刷新策略
	 */
	public void flashCanshu(ScheduleJob job) {
		/**
		 * 单表日志采集参数获取
		 */
		Dbrzcjcs dbrecord = new Dbrzcjcs();
		dbrecord.setJgxtlb(job.getJgxtlb().substring(0, 2));
		dbrecord.setBm(job.getBm());
		dbrzcjcs = dbrzcjcsService.selectByBMANDJGXTLB(dbrecord);
		/**
		 * 连接参数获取
		 */
		Dbconpro dbconpro = new Dbconpro();
		dbconpro.setAzdm(job.getAdzm());
		dbconpro.setJgxtlb(job.getJgxtlb());
		dbConpro = dbconProService.selectByExample(dbconpro).get(0);
	}

	/**
	 * 线程主体实现
	 * 
	 * @param taskID
	 * @param start
	 * @param end
	 * @return
	 */
	private Runnable createTask(final int taskID, int start, int end, Dbrzcjcs dbrzcjcs, String model, String wjm) {
		return new Runnable() {
			public synchronized void run() {
				ResultSet resultSet = null;
				Clsjkddb clsjkddb = new Clsjkddb();
				// 存量数据块断点表
				clsjkddb.setBm(dbrzcjcs.getBm());
				clsjkddb.setJgxtlb(dbConpro.getJgxtlb());
				Map<String, String> startmap = null;
				Map<String, String> endmap = null;
				JDBCUtil db = new JDBCUtil(dbConpro.getUsername(), dbConpro.getPassword(), dbConpro.getIp(),
						dbConpro.getPort(), dbConpro.getSid());
				SAXCreate sax = new SAXCreate();
				rzcjqjcs = null;
				Rzcjqjcs record = new Rzcjqjcs();
				record.setGjz("RZJXWJZDZ");
				rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
				if (rzcjqjcs.getMrz() == null) {
					job.setJobStatus("NORMAL");
					Exeception exeception = new Exeception();
					exeception.setCreatetime(getTime());
					exeception.setJgxtlb(dbConpro.getJgxtlb());
					exeception.setJobname(job.getJobName());
					exeception.setDesciption("CLTASK:" + "连接参数刷新失败  原因：此任务存量任务 日志解析文件最大值为空");
					execeptionService.insertSelective(exeception);
					return;
				}
				String jgxtlb = dbConpro.getJgxtlb();
				String azdm = dbConpro.getAzdm();
				Clsjwjb record1 = new Clsjwjb();
				record1.setBm(dbrzcjcs.getBm());
				record1.setJgxtlb(jgxtlb);
				try {
					db.getConnection();
					db.setSchema(dbConpro.getSchema());
					db.setTb_name(dbrzcjcs.getBm());
					sax.setTree(db.getCLRootChild(jgxtlb, azdm));
					if (dbrzcjcs.getClqsrq() == null || dbrzcjcs.getClqsrq().equals("")) {
						if (dbrzcjcs.getSjczd() == null || dbrzcjcs.getSjczd().equals("")
								|| dbrzcjcs.getSjczd().equals("*")) {
							db.setTimeFied("rowid");
						} else {
							db.setTimeFied(dbrzcjcs.getSjczd());
						}
						db.setDate("");
					} else {
						if (dbrzcjcs.getSjczd() == null || dbrzcjcs.getSjczd().equals("")
								|| dbrzcjcs.getSjczd().equals("*")) {
							db.setTimeFied("rowid");
						} else {
							db.setTimeFied(dbrzcjcs.getSjczd());
						}
						db.setDate(dbrzcjcs.getClqsrq().replace("-", "").replace(":", "").replace(" ", "").replace(".0",
								""));
					}
					db.setPre(start);
					db.setEnd(end);
					db.setRownum(start + 1);
					clsjkddb.setSjkbh(new BigDecimal(taskID));
					clsjkddb.setGxsj(getTime());
					if (!model.equals("cc")) {
						clsjkddb.setSjkstart(new BigDecimal(start));
						clsjkddb.setSjkend(new BigDecimal(end));
						System.out.println("断点记录");
						startmap = db.executedd(db.getSql(2));
						clsjkddb.setSjcq(startmap.get(db.getTimeFied().toLowerCase()));
						db.setRownum(end);
						endmap = db.executedd(db.getSql(2));
						clsjkddb.setSjcz(endmap.get(db.getTimeFied().toLowerCase()));
					}
					clsjkddbService.saveOrupdate(clsjkddb);
					if (dbrzcjcs.getClgltj() != null && !dbrzcjcs.getClgltj().equals("")) {
						db.setWhere(dbrzcjcs.getClgltj());
					}
					int zdwjdx = new Integer(rzcjqjcs.getMrz()) * 1024 * 1024;
					sax.setClsjwj(record1);
					sax.setClsjkdd(clsjkddb);
					sax.setDbConpro(dbConpro);
					sax.setClsjwjbService(clsjwjbService);
					sax.setClsjkddbService(clsjkddbService);
					sax.setDbconProService(dbconProService);
					sax.setRownum(start);
					while (db.getSux() < db.getEnd()) {
						db.setPreAndSux1();
						resultSet = db.getResultSet(db.getSql(1));
						sax.createXMLDatalist(resultSet, zdwjdx, wjm, db.getPre(), db.getTimeFied(), db);
						resultSet = null;
						db.getResultSet().close();
						db.getStmt().close();
					}
					sax.saxClend(db.getTimeFiedType(), db.getTimeFied());
					clsjkddb = sax.getClsjkdd();
					// 存量数据断点表
					clsjkddb.setWcbj("1");
					clsjkddb.setSjcz(sax.getSjcz());
					clsjkddb.setGxsj(getTime());
					clsjkddbService.updateByExampleSelective(clsjkddb);
					// 存量数据处理状态
					Clsjclzt clsjclzt = new Clsjclzt();
					clsjclzt.setBm(dbrzcjcs.getBm());
					clsjclzt.setJgxtlb(jgxtlb);
					Clsjclzt clrecord = clsjclztService.selectByExample(clsjclzt).get(0);
					clsjkddb.setWcbj("0");
					List<Clsjkddb> clsjklist = clsjkddbService.selectByWcbj(clsjkddb);
					if (null != clsjklist && !clsjklist.isEmpty()) {
						clsjclzt.setCjzt("1");
					} else {
						clsjclzt.setCjwcsj(getTime());
						clsjclzt.setCjzt("2");
					}
					clsjclzt.setGxsj(getTime());
					clsjclzt.setZjqdsj(getTime());
					clsjclzt.setCjwjs(new BigDecimal(clsjwjbService.countclsjwjByJGXGLBAndBM(clsjclzt.getJgxtlb(),clsjclzt.getBm())));
					if (model.equals("end")) {
						clsjclzt.setZhwjm(sax.getF().getName());
					}
					Clsjwjb clwjrecord = new Clsjwjb();
					clwjrecord.setBm(dbrzcjcs.getBm());
					clwjrecord.setJgxtlb(jgxtlb);
					BigDecimal clwjsjzl = clsjwjbService.sumSJZL(clwjrecord );
					clsjclzt.setCjsjzl(clwjsjzl);
					clsjclztService.updateByExampleSelective(clsjclzt);
					sax.setF(null);
				} catch (Exception e) {
					job.setJobStatus("NORMAL");
					try {
						schedulerJobService.saveOrUpdate(job);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					e.printStackTrace();
				} finally {
					// 关闭连接
					db.closeDB();
				}
			}
		};
	}

	/**
	 * 多线程模式 存量主体，任务中的线程主体内容
	 */
	public void cltaskD(int size, Dbrzcjcs dbrzcjcs) {

		// 如果一开始存量数据块断点表
		// 存量数据处理状态
		Clsjclzt clsjclzt = new Clsjclzt();
		clsjclzt.setCjzt("1");
		clsjclzt.setSbzt("0");
		clsjclzt.setBm(dbrzcjcs.getBm());
		clsjclzt.setJgxtlb(dbConpro.getJgxtlb());
		clsjclzt.setCjsjzl(new BigDecimal(0));
		clsjclzt.setSjzl(new BigDecimal(size));
		clsjclzt.setCcqdsj(getTime());
		clsjclzt.setRkzt("0");
		clsjclztService.saveOrupdate(clsjclzt);
		// 任务主体
		Rzcjqjcs record = new Rzcjqjcs();
		rzcjqjcs = null;
		record.setGjz("CLSJKZDZ");
		rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
		if (rzcjqjcs.getMrz() == null) {
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(dbConpro.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("CLTASK:" + "连接参数刷新失败  原因：此任务存量单个数据库最大值为空");
			execeptionService.insertSelective(exeception);
			return;
		}
		int sizeOfRow = new Integer(rzcjqjcs.getMrz());
		rzcjqjcs = null;
		record.setGjz("CLSJKLJZDZ");
		rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
		if (rzcjqjcs.getMrz() == null) {
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(dbConpro.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("CLTASK:" + "连接参数刷新失败  原因：此任务存量单个数据库最大值为空");
			execeptionService.insertSelective(exeception);
			return;
		}
		// 线程池分好了
		int start = 0;
		int end = 0;
		int count = size / sizeOfRow;
		// 将剩余连接数获取；
		int thread = count + 1;
		int zdljs = new Integer(rzcjqjcs.getMrz());
		if (thread > zdljs) {
			thread = zdljs;
			if (thread * sizeOfRow > 400000) {
				thread = 8;
			}
		}
		rzcjqjcs = null;
		record.setGjz("RZJXWJZDZ");
		rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
		if (rzcjqjcs.getMrz() == null) {
			job.setJobStatus("NORMAL");
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(dbConpro.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("CLTASK:" + "连接参数刷新失败  原因：此任务存量任务 日志解析文件最大值为空");
			execeptionService.insertSelective(exeception);
			return;
		}
		ThreadPool threadPool = new ThreadPool(thread); // 创建一个此表剩余可连接的线程数目工作线程的线程池。
		if (size > sizeOfRow) {
			Clsjkddb clsjkddb = new Clsjkddb();
			for (int i = 0; i <= count; i++) {
				if (end < size) {
					if (end + sizeOfRow < size) {
						start = i * sizeOfRow;
						end = start + sizeOfRow;
					} else {
						start = i * sizeOfRow;
						// 总行数了
						end = size;
					}
					// 存量数据块断点表
					clsjkddb.setBm(dbrzcjcs.getBm());
					clsjkddb.setJgxtlb(dbConpro.getJgxtlb());
					clsjkddb.setGxsj(getTime());
					clsjkddb.setSjkbh(new BigDecimal(i));
					clsjkddb.setWcbj("0");
					clsjkddb.setSjkstart(new BigDecimal(start));
					clsjkddb.setSjkend(new BigDecimal(end));
					clsjkddbService.saveOrupdate(clsjkddb);
					if (end == size) {
						threadPool.execute(createTask(i, start, end, dbrzcjcs, "end", ""));
					} else {
						threadPool.execute(createTask(i, start, end, dbrzcjcs, "", ""));
					}
				}
			}
		} else {
			threadPool.execute(createTask(1, start, size, dbrzcjcs, "end", ""));
		}
		threadPool.waitFinish(); // 等待所有任务执行完毕
		threadPool.closePool(); // 关闭线程池
		return;

	}

	public List<Dbrzcjcs> getDbrzcjcs() {
		return dbrzcjcs;
	}

	public void setDbrzcjcs(List<Dbrzcjcs> dbrzcjcs) {
		this.dbrzcjcs = dbrzcjcs;
	}

	public Rzcjqjcs getRzcjqjcs() {
		return rzcjqjcs;
	}

	public void setRzcjqjcs(Rzcjqjcs rzcjqjcs) {
		this.rzcjqjcs = rzcjqjcs;
	}

	public Dbconpro getDbconpro() {
		return dbConpro;
	}

	public void setDbconpro(Dbconpro dbConpro) {
		this.dbConpro = dbConpro;
	}

	/**
	 * 拥有时分秒的Date
	 * 
	 * @return
	 */
	public Timestamp getTime() {
		Date utilDate = new Date();// util.Date
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}
}
