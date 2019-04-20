package com.arshiner.quartz.job;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.common.ConfigFile;
import com.arshiner.common.ConfigManager;
import com.arshiner.common.FilePathName;
import com.arshiner.common.JDBCUtil;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.RedisHct;
import com.arshiner.common.SAXCreate;
import com.arshiner.common.SysResource;
import com.arshiner.common.SystemInfo;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.common.XMLFileName;
import com.arshiner.model.Agent;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Ddlsjsjb;
import com.arshiner.model.Exeception;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.ScheduleJob;
import com.arshiner.model.Zlsjddb;
import com.arshiner.model.Zlsjwjb;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.AgentService;
import com.arshiner.service.AsessionService;
import com.arshiner.service.ClsjclztService;
import com.arshiner.service.DbconProService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.DdlsjsjbService;
import com.arshiner.service.ExeceptionService;
import com.arshiner.service.RzcjqjcsService;
import com.arshiner.service.ScntotimeService;
import com.arshiner.service.ZlsjddbService;
import com.arshiner.service.ZlsjwjbService;

import srv.LogToOraRecord;
import srv.OraDMLObject;
import srv.OraTransObject;

/**
 * 
 * 正常模式 增量表名 为0 异常模式表名为表名
 * 
 * @author 士林
 *
 */
@Service("ZLTASK")
public class ZLTask implements Job{
	public static AtomicBoolean isRun = new AtomicBoolean(false);
	private static final Logger logger = Logger.getLogger(ZLTask.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	StringBuffer buffer = new StringBuffer(FilePathName.ROOT);//
	XMLFileName xmlfilename = XMLFileName.getInstance();
	ScheduleJob job = new ScheduleJob();
	String jgxtlb = "";
	String azdm = "";
	LogToOraRecord log2orarec;
	/**
	 * 任务是否正在执行标记 ：false--未执行； true--正在执行； 默认未执行
	 */
	/**
	 * 日志采集全局参数
	 */
	private Rzcjqjcs rzcjqjcs;
	/**
	 * 连接参数
	 */
	private Dbconpro dbConpro;
	/**
	 * 单表参数
	 */
	List<Dbrzcjcs> dbrzcjcslist = new ArrayList<>();
	/**
	 * 异常捕获
	 */
	@Autowired
	ExeceptionService execeptionService;
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
	 * scnTotime
	 */
	@Autowired
	ScntotimeService scntotimeService;
	/**
	 * 增量数据文件表
	 */
	@Autowired
	ZlsjwjbService zlsjwjbService;
	/**
	 * 增量断点表
	 */
	@Autowired
	ZlsjddbService zlsjddbService;
	@Autowired
	DdlsjsjbService ddlsjsjbService;
	/**
	 * 存量文件状态
	 */
	@Autowired
	ClsjclztService clsjclztService;
	/**
	 * schedulejob 表的service层
	 */
	@Autowired
	ScheduleJobInService scheduleJobInService;
	@Autowired
	SchedulerJobService schedulerJobService;
	@Autowired
	AgentService agentService;
	List<Agent> agent;
	@Autowired
	AsessionService asessionService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		synchronized (this) {
			if (isRun.get()) {
				return;
			} else {
				isRun.set(true);
			}
		}
		logger.info("增量任务" + sdf.format(getTime()));
		ScheduleJob job1 = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		logger.info("----------------------------------:{}" + sdf.format(getTime()));
		job = scheduleJobInService.selectByJobNameAngJobGroup(job1.getJobName(), job1.getJobGroup());
		// 1. 每次运行时获取策略信息
		job.setJobStatus("START");
		schedulerJobService.updateJob(job);
		// 如果job完成，过滤掉
		if (job.getJobStatus().equals("PAUSED")) {
			try {
				schedulerJobService.pauseJob(job.getJobName(), job.getJobGroup());
			} catch (SchedulerException e) {
				logger.info("增量任务更新异常");
			}
			return;
		}
		try {
			flashCanshu();
			//重置增量文件顺序
			XMLFileName.reZlfile(job.getJgxtlb());
			Agent agent1 = new Agent();
			agent1.setJgxtlb(job.getJgxtlb());
			agent = agentService.selectByExample(agent1);
			agent1 = null;
			// 统一StringBuffer路径
			buffer.append(dbConpro.getJgxtlb());// ip
			buffer.append(FilePathName.FileSepeartor);// ip/
			runCapture();
			flasholdFileInfo(buffer.toString() + FilePathName.RZJXWJPath + FilePathName.FileSepeartor);
			/**
			 * 文件重传
			 */
			Zlsjwjb zlsjwj = new Zlsjwjb();
			zlsjwj.setJgxtlb(job.getJgxtlb());
			zlsjwj.setWjzt("5");
			String standyfilename = FilePathName.ROOT + dbConpro.getJgxtlb() + FilePathName.FileSepeartor
					+ FilePathName.ZLStanbyPath + FilePathName.FileSepeartor;
			File file = null;
			List<Zlsjwjb> zlwjlist = zlsjwjbService.selectChongchuan(zlsjwj);
			if (zlwjlist != null && !zlwjlist.isEmpty()) {
				for (int i = 0; i < zlwjlist.size(); i++) {
					if (zlwjlist.size() >= 0) {
						zlsjwj = zlwjlist.get(i);
						file = new File(standyfilename + zlsjwj.getWjm());
						if (file.exists()) {
							zlsjwj.setWjzt("1");
							zlsjwj.setSbzt("0");
							zlsjwjbService.updateByExampleSelective(zlsjwj);
						} else {
							retake(job.getJgxtlb(), job.getJobName(), job.getJobGroup(), zlsjwj.getScnq().longValue());
							//删除增量表中的文件大于等于重采的文件名
							zlsjwjbService.deleteBywjmBIG(zlsjwj.getWjm(), job.getJgxtlb());
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		job.setJobStatus("NORMAL");
		schedulerJobService.updateJob(job);
		isRun.set(false);
	}

	/**
	 * 异步执行capture
	 */
	public  void runCapture() {
		String pid = "";
		Map<String, Object> pidmap;
		pid = job.getPid();
		logger.info("pid:----------------------" + pid);
		if (pid == null) {
			pid = "";
		}
		logger.info("增量任务" + job.getJobName() + "pid :" + pid);
		if (!pid.equals("") && pid != null) {
			pidmap = JsonToObject.StringconsvertToJSONObject(pid);
		} else {
			pidmap = new HashMap<>();
		}
		// 设置系统名称
		SysResource.setGs_os(SystemInfo.getOS_Name());
		for (Agent agent2 : agent) {
			String jd = buffer.toString() + agent2.getKip() + FilePathName.FileSepeartor;
			if (pidmap.size() == 0) {
				String capturePid = SysResource.startProcess(jd + "capture" + FilePathName.FileSepeartor,
						jd + "capture" + FilePathName.FileSepeartor + SysResource.captureName);
				pidmap.put(agent2.getKip(), capturePid);
				logger.info("更新成功");
			} else if (!SysResource.checkProcess(pidmap.get(agent2.getKip()).toString())) {
				// 2. 需要启动capture解析日志文件,并获取进程号放入job中
				String capturePid = SysResource.startProcess(jd + "capture" + FilePathName.FileSepeartor,
						jd + "capture" + FilePathName.FileSepeartor + SysResource.captureName);
				pidmap.put(agent2.getKip(), capturePid);
			} else {
				continue;
			}
		}
		job.setPid(JsonToObject.MapconsvertToJson(pidmap).toJSONString());
		schedulerJobService.updateJob(job);
		logger.info("更新成功");
	}

	/**
	 * 策略刷新
	 * 
	 * @param job
	 */
	public void flashCanshu() {
		/**
		 * 连接参数获取
		 */
		Dbconpro dbconpro = new Dbconpro();
		dbconpro.setJgxtlb(job.getJgxtlb());
		dbConpro = dbconProService.selectByExample(dbconpro).get(0);
		Dbrzcjcs dbrecord = new Dbrzcjcs();
		dbrecord.setJgxtlb(dbConpro.getJgxtlb().substring(0, 2));
		dbrzcjcslist = dbrzcjcsService.selectByJgxtlb(dbrecord);
	}

	/**
	 * 16->10
	 * 
	 * @param str
	 * @return
	 */
	public static Long HexToTen(String str) {
		return Long.parseLong(str.replace("0x", "").replace(".", ""), 16);
	}

	/**
	 * 330->00000330
	 * 
	 * @param str
	 * @return
	 */
	public static String padLeft(String s, int length) {
		byte[] bs = new byte[length];
		byte[] ss = s.getBytes();
		Arrays.fill(bs, (byte) (48 & 0xff));
		System.arraycopy(ss, 0, bs, length - ss.length, ss.length);
		return new String(bs);
	}

	/**
	 * 10->16
	 * 
	 * @param n
	 * @return
	 */
	public static String TenToHex(Long n) {
		String a;
		a = Long.toHexString(n);
		StringBuilder sb = new StringBuilder(padLeft(a, 12).toUpperCase());
		a = sb.insert(4, '.').insert(0, "0x").toString();
		return a;
	}

	/**
	 * 刷目录
	 * 
	 * @param filepath
	 * @param dbrzcjcs
	 */
	public  void flasholdFileInfo(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) {
			// 异常
			return;
		} else {
			File[] filelist = file.listFiles();
			if (filelist.length == 0) {
				return;
			}
		}

		Zlsjddb zlsjddb1 = new Zlsjddb();
		zlsjddb1.setJgxtlb(dbConpro.getJgxtlb());
		List<Zlsjddb> zlddlist = zlsjddbService.selectByExample(zlsjddb1);
		String scn = "0x0000.00000000";
		if (zlddlist != null) {
			if (!zlddlist.isEmpty()) {
				if (zlddlist.get(0).getScn() != null) {
					scn = TenToHex(zlddlist.get(0).getScn().longValue());
				}
			}
		}
		log2orarec = new LogToOraRecord();
		log2orarec.setDbrzcjcslist(dbrzcjcslist);
		log2orarec.setDb(dbConpro);
		RedisHct.bmhc = new LinkedHashMap<>();
		log2orarec.setDdlsjsjbService(ddlsjsjbService);
		log2orarec.LogToOraRecord(agent.size(), scn, filepath);// 初始化2站点
		log2orarec.getOraRecord().setType("2"); // 增量为2
		log2orarec.getOraRecord().setXtlb(job.getJgxtlb()); // 用参数替代
		log2orarec.getOraRecord().setAzdm(job.getAdzm()); // 设置安装代码
		analysisLogFile();
	}

	/**
	 * 需要知道，如何封装的
	 * 
	 * @param sfile
	 */
	// 每个日志文件调用一次该方法，获取一个或者多个OraXMLObject
	public void analysisLogFile() {
		// 循环调用，获取日志数据并排序装载到outoraobj.getOraRecord()中
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
			exeception.setDesciption("ZLTASK:" + "连接参数刷新失败  原因：此任务存量任务 日志解析文件最大值为空");
			execeptionService.insertSelective(exeception);
			return;
		}
		Integer size = new Integer(rzcjqjcs.getMrz()) * 1024 * 1024;
		/**
		 * 对sax设置参数
		 */
		SAXCreate sax = new SAXCreate();
		sax.setDbConpro(dbConpro);
		sax.wjzdz = size;
		sax.setDbconProService(dbconProService);
		sax.setZlsjddbService(zlsjddbService);
		sax.setZlsjwjbService(zlsjwjbService);
		sax.setAsessionService(asessionService);
		sax.setDbrzcjcsService(dbrzcjcsService);
		sax.setClsjclztService(clsjclztService);
		LinkedHashMap<String, Clsjclzt> ztmap = new LinkedHashMap<>();
		LinkedHashMap<String, Dbrzcjcs> dbmap = new LinkedHashMap<>();
		Dbrzcjcs dbrzcs = new Dbrzcjcs();
		dbrzcs.setJgxtlb(dbConpro.getJgxtlb().substring(0, 2));
		List<Dbrzcjcs> dblist = dbrzcjcsService.selectByJgxtlb(dbrzcs);
		for (Iterator<Dbrzcjcs> iterator = dblist.iterator(); iterator.hasNext();) {
			Dbrzcjcs dbrzcjcs2 = (Dbrzcjcs) iterator.next();
			dbmap.put(dbrzcjcs2.getBm(), dbrzcjcs2);
		}
		Clsjclzt clzt = new Clsjclzt();
		clzt.setJgxtlb(dbConpro.getJgxtlb());
		List<Clsjclzt> clsjlist = clsjclztService.selectByJgxtlb(clzt);
		for (Iterator<Clsjclzt> iterator = clsjlist.iterator(); iterator.hasNext();) {
			Clsjclzt clsjclzt = iterator.next();
			ztmap.put(clsjclzt.getBm(), clsjclzt);
		}
		sax.setDbmap(dbmap);
		sax.setZtmap(ztmap);
		// 每一次Next 装一个事务多个DML
		String stopScn = "";
		boolean flag = false;
		// 如果新增一张表之后 事务中全是 这张表的记录操作，万一内存爆了怎么办
		logger.info("11111111111111111111111111111111111111111111111111111111111111");
		while (log2orarec.getNextOraRecord()) {
			logger.info("222222222222222222222222222222222222222222222222");
			if (log2orarec.getCurrentSCN().equals(stopScn)) {
				break;
			}
			logger.info("**********************************事务" + ":" + log2orarec.getCurrentSCN() + " 日志文件:"
					+ log2orarec.getCurrentLogfile());
			if (!log2orarec.getCurrentLogfile().equals("")) {
				// 过滤条件
				flag = sax.createXMLTransactionList(log2orarec, size, log2orarec.getOraRecord());
			}
			if (flag) {
				log2orarec.getOraRecord().resetOraRecord();
			}
			stopScn = log2orarec.getCurrentSCN();
		}
		if (sax.isDocumentStatus()) {
			try {
				if (sax.getIndmlnum() != 0) {
					sax.createZLXMLEnd(log2orarec.getOraRecord());
				}else{
					logger.info("Sax------reset");
					sax.reset();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int num =0;
		if (null != RedisHct.bmhc && !RedisHct.bmhc.isEmpty()) {
			for (Iterator<Entry<String, LinkedHashMap<OraTransObject, List<OraDMLObject>>>> it = RedisHct.bmhc
					.entrySet().iterator(); it.hasNext();) {
				num++;
				Map.Entry<String, LinkedHashMap<OraTransObject, List<OraDMLObject>>> entry = it.next();
				logger.info("1111111111111111111111111"+entry.getKey()+"异常文件装入XML"+num);
				sax.createYCXMLTransactionList(entry.getKey(), log2orarec.getOraRecord(), entry.getValue());
				if (sax.isDocumentStatus()) {
					try {
						sax.createYCZLXMLEnd(entry.getKey(), log2orarec.getOraRecord());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error(e);
						logger.error("增量采集异常模式出错 RedisHct.bmhc："+e);
					}
				}
				it.remove();
			}
		}
		log2orarec.getOraRecord().resetOraRecord();
		log2orarec = null;
		sax = null;
		RedisHct.bmhc = null;
	}
	/**
	 * 每个日志文件调用一次该方法，获取一个或者多个OraXMLObject
	 * 
	 * @param sfile
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public Timestamp getTime(Date utilDate) {
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}
	public Rzcjqjcs getRzcjqjcs() {
		return rzcjqjcs;
	}

	public void setRzcjqjcs(Rzcjqjcs rzcjqjcs) {
		this.rzcjqjcs = rzcjqjcs;
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
	
	
	/**
	 * 从此文件开始重新解析然后重新排序此方法暂时用不到
	 * @param jgxtlb
	 * @param jobName
	 * @param jobGroup
	 * @param scn
	 */
	public void retake( String jgxtlb, String jobName,String jobGroup,long scn) {
		StringBuffer buffer = new StringBuffer(FilePathName.ROOT);// 项目上级目录
		if (jobGroup.equals("ZLTASK")) {
			ScheduleJob job = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
			buffer.append(job.getJgxtlb());// 节点目录 /jgxtlb
			buffer.append(FilePathName.FileSepeartor);// /jgxtlb/
			try {
				//1,停止增量任务
				Zlsjddb zlsjddb = new Zlsjddb();
				zlsjddb.setJgxtlb(jgxtlb);
				zlsjddbService.deleteByExample(zlsjddb);
				String jd = "";
				String pid = "";
				Agent agent = new Agent();
				agent.setJgxtlb(job.getJgxtlb());
				List<Agent> agentlist = agentService.selectByExample(agent);
				//2，停止所有capture
				for (Iterator<Agent> iterator = agentlist.iterator(); iterator.hasNext();) {
					Agent agent1 = (Agent) iterator.next();
					pid = JsonToObject.StringconsvertToJSONObject(job.getPid()).getString(agent1.getKip());
					if (SysResource.checkProcess(pid)) {
						SysResource.stopProcess(pid);
					}
				}
				File recovery;
				for (Agent agent1 : agentlist) {
					jd = buffer.toString() + agent1.getKip() + FilePathName.FileSepeartor;
					//清空capture。out
					ConfigManager out = new ConfigManager(jd + "capture.out");
					out.configGetAndSet("Last_log_SCN", "", jd + "capture.out");
					out.configGetAndSet("Last_log", "", jd + "capture.out");
					out.configGetAndSet("Last_stamp", "", jd + "capture.out");
					out.configGetAndSet("Last_redo", "", jd + "capture.out");
					out.configGetAndSet("Last_write_SCN", "", jd + "capture.out");
					//查询此scn的时间
					JDBCUtil jdbc = new JDBCUtil(dbConpro.getUsername(), dbConpro.getPassword(),
							dbConpro.getIp(), dbConpro.getPort(), dbConpro.getSid());
					
					String sql = "select to_char(scn_to_timestamp(" + scn + "),'yyyy-mm-dd hh24:mi:ss') scn from dual";
					Map<String, Object> scn1 = null;
					String Alivedbscn ="";
					try {
						jdbc.getConnection();
						scn1 = jdbc.executeQuery(sql, null).get(0);
						SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy::HH:mm:ss");
						Alivedbscn = format.format(sdf.parse(scn1.get("scn").toString()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						jdbc.closeDB();
					}
					//设置Alivedb.conf
					File alivedb = new File(jd + "Alivedb.conf");
					ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "StartEpoch", Alivedbscn);
					// 删除recovery
					recovery = new File(jd + "recovery.inf");
					if (recovery.exists()) {
						recovery.delete();// 判断是否为true
					}
					File rzjxwj = new File(buffer.toString()+FilePathName.RZJXWJPath+FilePathName.FileSepeartor);
					if (null!=rzjxwj.listFiles()) {
						SysResource.deleteDir(rzjxwj);
					}
				}
			} catch (Exception e) {
				//失败
				e.printStackTrace();
			}
		}
	}
}
