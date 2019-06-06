package com.arshiner.quartz.job;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.arshiner.common.ConfigManager;
import com.arshiner.common.FilePathName;
import com.arshiner.common.FtpUtils;
import com.arshiner.common.HdsjSaxCreate;
import com.arshiner.common.JDBCUtil;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.XMLFileName;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Hdsjcjxxb;
import com.arshiner.model.Hdsjwjxxb;
import com.arshiner.model.Sjltjjg;
import com.arshiner.rds_big_jk.Hdsjjk;
import com.arshiner.service.HdsjcjxxbService;
import com.arshiner.service.HdsjwjxxbService;
import com.arshiner.service.SjltjdjbService;
import com.arshiner.service.SjltjjgService;

/**
 * 非xml配置需要添加@Service和@EnableScheduling
 * @author Administrator
 *
 */
@Service
@EnableScheduling
public class HdsjTask extends FlashCelueTask{
	private static final Logger logger = Logger.getLogger(HdsjTask.class);	
	public static AtomicBoolean isRun = new AtomicBoolean(false);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	ConfigManager config = new ConfigManager(ConfigManager.babh);
	@Autowired
	HdsjcjxxbService hdsjcjxxbService;
	@Autowired
	SjltjjgService  sjltjjgService;
	@Autowired
	HdsjwjxxbService hdsjwjxxbService;
	@Autowired
	SjltjdjbService sjltjdjbService;
	XMLFileName xmlfilename = XMLFileName.getInstance();
	@Async
	@Scheduled(cron="0 */2 * * * ?")
	public void Hdsjmain(){
		synchronized (isRun) {
			if (isRun.get()) {
				return;
			}
			isRun.set(true);
		}
		//start
		get();
		logger.info("核对功能接口  --整合"+ sdf.format(getTime()));
		Hdsjjk  hdjk = new Hdsjjk();
		hdjk.setHdsjcjxxbService(hdsjcjxxbService);
		hdjk.setHdsjwjxxbService(hdsjwjxxbService);
		hdjk.setSjltjdjbService(sjltjdjbService);
		hdjk.setSjltjjgService(sjltjjgService);
		try {
			hdjk.queryHdsjcjxxb();
			//采集文件状态反馈
			Hdsjcjxxb  xxb = new Hdsjcjxxb();
			Hdsjwjxxb wjxx = new Hdsjwjxxb();
			xxb.setCjbj("1");
			FtpUtils ftp = getFtp();
			List<Hdsjcjxxb> xxblist = hdsjcjxxbService.selectByAllByCjBj(xxb);//获取采集标记为1的核对数据信息
			for (Iterator<Hdsjcjxxb> iterator = xxblist.iterator(); iterator.hasNext();) {
				Hdsjcjxxb hdsjcjxxb = (Hdsjcjxxb) iterator.next();
				List<Dbconpro> dblist = dbconProService.selectByLikeJgxtlb(hdsjcjxxb.getJgxtlb());
				if (null!=dblist&&!dblist.isEmpty()) {
					for (Iterator<Dbconpro> iterator2 = dblist.iterator(); iterator2.hasNext();) {
						Dbconpro dbconpro = (Dbconpro) iterator2.next();
						XMLFileName.reHdfile(dbconpro.getJgxtlb());
						if (!hdsjcjxxb.getClwcbj().equals("1")&&hdsjcjxxb.getCjbj().equals("1")) {
							cjhdsj(dbconpro, hdsjcjxxb,ftp,"");
						}
						wjxx.setWjzt("2");
						wjxx.setBm(hdsjcjxxb.getBm());
						wjxx.setHdph(hdsjcjxxb.getHdph());
						wjxx.setJgxtlb(hdsjcjxxb.getJgxtlb());
						wjxx.setSbzt("0");
						List<Hdsjwjxxb> wjlist =hdsjwjxxbService.selectByAllwjzt(wjxx);//文件写入接口
						if (null!=wjlist&&!wjlist.isEmpty()) {
							logger.info("文件信息写入表"+JsonToObject.ListconsvertToJSON(wjlist));
							hdjk.buildhdsjwjxr(JsonToObject.ListconsvertToJSON(wjlist));
							for (Iterator<Hdsjwjxxb> iterator1 = wjlist.iterator(); iterator1.hasNext();) {
								Hdsjwjxxb hdsjwjxxb = (Hdsjwjxxb) iterator1.next();
								hdsjwjxxb.setSbzt("2");
								hdsjwjxxbService.updateByExample(hdsjwjxxb);
							}
						}
						wjxx.setSbzt("2");
						wjlist = hdsjwjxxbService.selectByAllwjzt(wjxx);
						if (null!=wjlist&&!wjlist.isEmpty()) {
							hdjk.querywjztcx(JsonToObject.ListconsvertToJSON(wjlist));
						}
						wjxx.setWjzt("5");
						wjlist = hdsjwjxxbService.selectBywjzt(wjxx);//重传
						String standyfilename = FilePathName.ROOT + dbconpro.getJgxtlb() + FilePathName.FileSepeartor
								+ FilePathName.HDML + FilePathName.FileSepeartor;
						if (null!=wjlist&&!wjlist.isEmpty()) {
							File file = null;
							for (Iterator<Hdsjwjxxb> iterator1 = wjlist.iterator(); iterator1.hasNext();) {
								Hdsjwjxxb hdsjwjxxb = (Hdsjwjxxb) iterator1.next();
								file = new File(standyfilename + hdsjwjxxb.getWjm());
								logger.info(standyfilename+ hdsjwjxxb.getWjm());
								if (file.exists()) {
									logger.info(standyfilename+"----------1111111111111");
									logger.info("文件存在"+standyfilename + hdsjwjxxb.getWjm());
									hdsjwjxxb.setWjzt("2");
									hdsjwjxxb.setSbzt("0");
									hdsjwjxxb.setScfwqsj(getTime());
									ftp.initFtpClient();
									ftp.uploadFile(ftp.getFtpDir(), file.getName(), file.getAbsolutePath());
								}else{
									logger.info("文件不存在"+standyfilename + hdsjwjxxb.getWjm());
									hdsjwjxxb.setWjzt("2");
									hdsjwjxxb.setSbzt("0");
									cjhdsj(dbconpro, hdsjcjxxb, ftp,standyfilename + hdsjwjxxb.getWjm());
								}
								hdsjwjxxbService.updateByExample(hdsjwjxxb);
							}
						}
						wjxx.setWjzt("6");
						wjlist = hdsjwjxxbService.selectBywjzt(wjxx);//重采
						if (null!=wjlist&&!wjlist.isEmpty()) {
							for (Iterator<Hdsjwjxxb> iterator1 = wjlist.iterator(); iterator1.hasNext();) {
								Hdsjwjxxb hdsjwjxxb = (Hdsjwjxxb) iterator1.next();
								hdsjwjxxb.setWjzt("2");
								hdsjwjxxb.setSbzt("0");
								cjhdsj(dbconpro, hdsjcjxxb, ftp,standyfilename + hdsjwjxxb.getWjm());
								hdsjwjxxbService.updateByExample(hdsjwjxxb);
							}
						}
					}
				}
			}
			Sjltjjg  jg = new Sjltjjg();
			jg.setSbzt("0");
			List<Sjltjjg> jglist = sjltjjgService.selectBySbzt(jg);
			if (null!=jglist&&!jglist.isEmpty()) {
				logger.info("统计信息写入接口"+JsonToObject.ListconsvertToJSON(jglist));
				hdjk.buildhdsjtjjg(JsonToObject.ListconsvertToJSON(jglist));//数据量统计结果
				for (Iterator<Sjltjjg> iterator = jglist.iterator(); iterator.hasNext();) {
					Sjltjjg sjltjjg = (Sjltjjg) iterator.next();
					sjltjjg.setSbzt("2");
					sjltjjgService.updateByExample(sjltjjg);
				}
			}
			xxb.setSbzt("0");
			xxb.setClwcbj("1");
			List<Hdsjcjxxb> xlist = hdsjcjxxbService.selectBySbzt(xxb);
			if (null!=xlist&&!xlist.isEmpty()) {
				for (Iterator<Hdsjcjxxb> iterator = xlist.iterator(); iterator.hasNext();) {
					Hdsjcjxxb hdsjcjxxb2 = (Hdsjcjxxb) iterator.next();
					hdsjcjxxb2.setSbzt("2");
					hdsjcjxxbService.updateByExample(hdsjcjxxb2);
				}
				hdjk.bulidhdsjcl(JsonToObject.ListconsvertToJSON(xlist));
			}
			xxb.setJlzt("0");
			hdsjcjxxbService.deleteByExample(xxb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//end
		isRun.set(false);
	}
	
	public void cjhdsj(Dbconpro dbconpro,Hdsjcjxxb hdsjcjxxb,FtpUtils ftp,String wjm1) throws Exception{
		ResultSet resultSet = null;
		JDBCUtil db = new JDBCUtil(dbconpro.getUsername(), dbconpro.getPassword(), dbconpro.getIp(),
				dbconpro.getPort(), dbconpro.getServicename());
		db.getConnection();
		HdsjSaxCreate  hdsjcreate = new HdsjSaxCreate();
		db.setTb_name(hdsjcjxxb.getBm());
		db.setSchema(dbconpro.getSchema().toUpperCase());
		db.setTimeFied(hdsjcjxxb.getSjczd());
		String where="";
		if (db.getTimeFiedType().equals("VARCHAR2")) {
			 where = "to_char(to_date(t."+hdsjcjxxb.getSjczd()+",'yyyyMMddhh24miss'),'yyyyMMdd')='"+hdsjcjxxb.getSjcrq()+"'";
		}else{
			 where = "to_char(t."+hdsjcjxxb.getSjczd()+",'yyyyMMdd')='"+hdsjcjxxb.getSjcrq()+"'";
		}
		String sql = "select "+hdsjcjxxb.getZjzd()+" from "
		+dbconpro.getSchema().toUpperCase()+"."+hdsjcjxxb.getBm()+" t where "+where;
		System.out.println(sql);
		resultSet = db.getResultSet(sql);
		TreeMap<String, Object>  tree=db.getCLRootChild(dbconpro.getJgxtlb(), dbconpro.getAzdm());
		tree.put("ora_type", "verf");
		tree.put("hdph", hdsjcjxxb.getHdph());//核对文件的头部
		hdsjcreate.setTree(tree);
		String wjm="";
		if (wjm1.equals("")) {
			wjm=getXMLName(dbconpro);
		}else{
			wjm=wjm1;
		}
		hdsjcreate.createXMLHead(wjm);
		hdsjcreate.createXMLTitle(tree);
		int size =hdsjcreate.createXMLDatalist1(resultSet,hdsjcjxxb.getSjczd());
		resultSet=null;
		Sjltjjg  jg = new Sjltjjg();
		jg.setHdph(hdsjcjxxb.getHdph());
		jg.setBm(hdsjcjxxb.getBm());
		jg.setJgxtlb(dbconpro.getJgxtlb());
		jg.setTjrq(hdsjcjxxb.getSjcrq());
		jg.setTjsl(new BigDecimal(size));
		jg.setGxsj(getTime());
		jg.setZsazdm(dbconpro.getAzdm());
		jg.setSbzt("0");
		sjltjjgService.saveOrupdate(jg);//保存统计结果
		ftp.initFtpClient();
		ftp.uploadFile(ftp.getFtpDir(), hdsjcreate.getF().getName(), wjm);
		Hdsjwjxxb  wjxxb = new Hdsjwjxxb();
		wjxxb.setHdph(hdsjcjxxb.getHdph());
		wjxxb.setBm(hdsjcjxxb.getBm());
		wjxxb.setJgxtlb(dbconpro.getJgxtlb());
		wjxxb.setWjm(hdsjcreate.getF().getName());
		FileInputStream fis = new FileInputStream(wjm);
		wjxxb.setMd5(DigestUtils.md5Hex(fis));
		fis.close();
		wjxxb.setWjdx(new BigDecimal(hdsjcreate.getF().length()/1024));
		wjxxb.setSlj(new BigDecimal(size));
		wjxxb.setSjcrq(hdsjcjxxb.getSjcrq());
		wjxxb.setWjzt("2");
		wjxxb.setScsj(getTime());
		wjxxb.setScfwqsj(getTime());
		wjxxb.setCwzt("0");
		wjxxb.setSbzt("0");
		hdsjwjxxbService.saveOrupdate(wjxxb);
		hdsjcjxxb.setClwcbj("1");
		hdsjcjxxbService.updateByExampleSelective(hdsjcjxxb);
	}
	public String getXMLName(Dbconpro dbconpro) {
		if (dbconpro.getJgxtlb() != null && !dbconpro.getJgxtlb().equals("")) {
			
			StringBuffer str = new StringBuffer(FilePathName.ROOT);
			// 文件路径
			str.append(dbconpro.getJgxtlb()).append(FilePathName.FileSepeartor).append(FilePathName.HDML)
			.append(FilePathName.FileSepeartor);
			if (!XMLFileName.hdNameMap.get(dbconpro.getJgxtlb()).isEmpty()) {
				str.append(xmlfilename.getXmlFileName("hd", dbconpro.getJgxtlb()));
			}else{
				str.append(FilePathName.FileSepeartor).append(dbconpro.getAzdm()).append(dbconpro.getJgxtlb())
				.append(xmlfilename.getXmlFileName("hd", dbconpro.getJgxtlb()));
			}
			return str.toString();
		}

		return null;
	}
	
	
	
	
}
