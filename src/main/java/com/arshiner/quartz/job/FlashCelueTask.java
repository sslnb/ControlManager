package com.arshiner.quartz.job;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.SocketException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arshiner.common.ConfigFile;
import com.arshiner.common.ConfigManager;
import com.arshiner.common.FilePathName;
import com.arshiner.common.FtpUtils;
import com.arshiner.common.JDBCUtil;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.SysResource;
import com.arshiner.common.SystemInfo;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.common.XMLFileName;
import com.arshiner.model.Agent;
import com.arshiner.model.Cjrjxt;
import com.arshiner.model.Cjrjyxzt;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.Clsjkddb;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Exeception;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.ScheduleJob;
import com.arshiner.model.Sjcjqktjb;
import com.arshiner.model.Totalsysinfo;
import com.arshiner.model.Zlsjddb;
import com.arshiner.model.Zlsjwjb;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.AgentService;
import com.arshiner.service.CjrjyxztService;
import com.arshiner.service.ClsjclztService;
import com.arshiner.service.ClsjkddbService;
import com.arshiner.service.ClsjwjbService;
import com.arshiner.service.DbconProService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.DdlsjsjbService;
import com.arshiner.service.ExeceptionService;
import com.arshiner.service.RzcjqjcsService;
import com.arshiner.service.SjcjqktjbService;
import com.arshiner.service.TotalsysinfoService;
import com.arshiner.service.ZlsjddbService;
import com.arshiner.service.ZlsjwjbService;

/**
 * 刷新,并根据数据字段值 添加增量任务，和存量任务
 * 
 * @author 士林
 *
 */
@Service("FlashCelueTask")
public class FlashCelueTask {
	private static final Logger logger = Logger.getLogger(FlashCelueTask.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	SimpleDateFormat tj = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat startEpoch = new SimpleDateFormat("MM/dd/YYYY::HH:mm:ss");
	Date time = new Date();
	ScheduleJob job = null;
	ConfigManager config = new ConfigManager(ConfigManager.babh);
	public static ConcurrentHashMap<String, Integer> dbrzcjcssize = new ConcurrentHashMap<>();
	TestRestSafeOutAccess rsoa = TestRestSafeOutAccess.getInstance();
	@Autowired
	ExeceptionService execeptionService;
	/**
	 * 单表日志采集参数
	 */
	private List<Dbrzcjcs> dbrzcjcs1;
	private List<Agent> agent;
	/**
	 * 连接参数
	 */
	private List<Dbconpro> dbConpro;
	/**
	 * 单表日志采集参数
	 */
	@Autowired
	DbrzcjcsService dbrzcjcsService;
	/**
	 * 日志采集全局参数
	 */
	@Autowired
	RzcjqjcsService rzcjqjcsService;
	/**
	 * 任务处理的服务层
	 */
	@Autowired
	SchedulerJobService schedulerJobService;
	XMLFileName xmlfilename = XMLFileName.getInstance();
	@Autowired
	ScheduleJobInService scheduleJobInService;
	/**
	 * 数据库连接参数配置
	 */
	@Autowired
	DbconProService dbconProService;
	@Autowired
	AgentService agentService;
	/**
	 * 采集软件运行状态
	 */
	@Autowired
	CjrjyxztService cjrjyxztService;
	/**
	 * 存量数据处理状态
	 */
	@Autowired
	ClsjclztService clsjclztService;
	/**
	 * 存量数据文件表
	 */
	@Autowired
	ClsjwjbService clsjwjbService;
	/**
	 * 存量数据块断点表
	 */
	@Autowired
	ClsjkddbService clsjkddbService;
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
	/**
	 * DDL数据审计表
	 */
	@Autowired
	DdlsjsjbService ddlsjsjbService;
	@Autowired
	SjcjqktjbService sjcjqktjbService;
	@Autowired
	TotalsysinfoService totalSysinfoService;
	/**
	 * 任务是否正在执行标记 ：false--未执行； true--正在执行； 默认未执行
	 */
	static AtomicBoolean isRun = new AtomicBoolean(false);

	public void executeF() throws JobExecutionException {
		logger.info("策略更新任务----------------------------:{}" + sdf.format(getTime()));
		synchronized (isRun) {
			if (isRun.get()) {
				return;
			}
			isRun.set(true);
		}
		get();
		// 上报心跳
		if (null == TestRestSafeOutAccess.agxtip || TestRestSafeOutAccess.agxtip.equals("")) {
			return;
		}
		Cjrjxt xt = new Cjrjxt();
		Totalsysinfo sysinfo = new Totalsysinfo();
		HashMap<String, Object> heartInfo = SystemInfo.getHeartInfo();
		sysinfo.setCpu(new Double(heartInfo.get("cpu").toString().replace("%", "")).intValue());
		sysinfo.setDev(new Double(heartInfo.get("dev").toString().replace("%", "")).intValue());
		sysinfo.setJvm(new Double(heartInfo.get("jvm").toString().replace("%", "")).intValue());
		sysinfo.setMem(new Double(heartInfo.get("mem").toString().replace("%", "")).intValue());
		sysinfo.setInstime(time.getHours() + "");
		totalSysinfoService.saveOrupdate(sysinfo);
		xt.setBabh(config.properties.getProperty("babh"));
		xt.setCpusyl(new BigDecimal(new Double(heartInfo.get("cpu").toString().replace("%", "")).intValue()));
		xt.setNcsyl(new BigDecimal(new Double(heartInfo.get("mem").toString().replace("%", "")).intValue()));
		xt.setCpsyl(new BigDecimal(new Double(heartInfo.get("cpu").toString().replace("%", "")).intValue()));
		xt.setXtfz(new BigDecimal(new Double(heartInfo.get("swap").toString().replace("%", "")).intValue()));
		xt.setSbrq(sdf.format(getTime()));
		xt.setGxsj(getTime());
		List<Cjrjxt> xtlist = new ArrayList<>();
		xtlist.add(xt);
		// 5.采集软件心跳状态上报接口
		// 1. 每次运行时获取策略信息
		try {
			queryQJparams();
			rsoa.writeHeartBeat(JsonToObject.ListconsvertToJSON(xtlist));
			xtlist = null;
			sysinfo = null;
			flashCanshu();
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("策略刷新：" + e1);
		}
		isRun.set(false);
	}

	/**
	 * 策略刷新 -Djava.io.tmpdir=tomcat
	 * 
	 * @param job
	 * @throws Exception
	 */
	public void flashCanshu() throws Exception {
		logger.info("策略更新任务------从交管系统中访问获取更新参数");
		/**
		 * 连接参数获取
		 */
		dbConpro = dbconProService.selectByExample();
		// 遍历
		if (dbConpro.isEmpty()) {
			logger.info(dbConpro.size());
			return;
		}
		Rzcjqjcs rzcjqjcs = null;
		for (Dbconpro dbconpro2 : dbConpro) {
			// 如果安管代码和交管系统类别不为空或空字符
			logger.info(dbconpro2.getJgxtlb());
			if (dbconpro2.getJgxtlb().length() < 2) {
				logger.info("FlashCelueTask      ----  策略刷新    日志采集全局参数  交管系统类别错误： " + dbconpro2.getJgxtlb());
				continue;
			}
			Dbrzcjcs dbrecord = new Dbrzcjcs();
			// 交管系统类别
			dbrecord.setJgxtlb(dbconpro2.getJgxtlb().substring(0, 2));
			Agent asd = new Agent();
			asd.setJgxtlb(dbconpro2.getJgxtlb());
			agent = agentService.selectByExample(asd);
			dbrzcjcs1 = dbrzcjcsService.selectByJgxtlb(dbrecord);
			if (dbrzcjcs1.isEmpty()) {
				logger.info("FlashCelueTask      ----  策略刷新    获取单表日志采集参数为空  交管系统类别错误： " + dbconpro2.getJgxtlb());
				continue;
			}
			alterAlivedb(dbconpro2, dbrzcjcs1);
			List<String> dbbmlist = new ArrayList<>();
			for (Iterator<Dbrzcjcs> iterator = dbrzcjcs1.iterator(); iterator.hasNext();) {
				Dbrzcjcs dbrzcjcs = (Dbrzcjcs) iterator.next();
				dbbmlist.add(dbrzcjcs.getBm());
			}
			// 同步单表参数和任务，以及策略
			List<ScheduleJob> joblist = schedulerJobService.getAllScheduleJob();
			for (Iterator<ScheduleJob> iterator = joblist.iterator(); iterator.hasNext();) {
				ScheduleJob jobc = (ScheduleJob) iterator.next();
				if (jobc.getJobName().equals("FlashCelueTaskJobName")) {
					continue;
				}
				if (jobc.getJgxtlb().equals(dbconpro2.getJgxtlb()) && jobc.getJobGroup().equals("CLTASK")) {
					if (!dbbmlist.contains(jobc.getBm())) {
						try {
							// 删除存量任务
							schedulerJobService.pauseJob(jobc.getJobName(), jobc.getJobGroup());
							schedulerJobService.deleteJob(jobc.getJobName(), jobc.getJobGroup());
							// 必须删除断点和存量状态表，存量启不启动
							// 看存量断点是否有，增量是否异常采集看存量状态是否完成,也要删除存量文件表
							Clsjkddb cldd = new Clsjkddb();
							cldd.setJgxtlb(dbconpro2.getJgxtlb());
							cldd.setBm(jobc.getBm());
							clsjkddbService.deleteByBMandJGXTLB(cldd);
							Clsjclzt clzt = new Clsjclzt();
							clzt.setBm(jobc.getBm());
							clzt.setJgxtlb(dbconpro2.getJgxtlb());
							clsjclztService.deleteBylikeJgxtlb(clzt);
							Clsjwjb clwj = new Clsjwjb();
							clwj.setBm(jobc.getBm());
							clwj.setJgxtlb(dbconpro2.getJgxtlb());
							clsjwjbService.deleteByBMandJGXTLB(clwj);
						} catch (SchedulerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							logger.error(e);
						}
					}
				}
			}
			// 单表同步
			querySingleParams(dbconpro2);
			Rzcjqjcs record = new Rzcjqjcs();
			// 增量任务
			job = null;
			job = new ScheduleJob();
			job.setJobGroup("ZLTASK");
			job.setJobName(dbconpro2.getJgxtlb() + "ZLTASK");
			try {
				ScheduleJob job1 = scheduleJobInService.selectByJobNameAngJobGroup(job.getJobName(), job.getJobGroup());
				if (job1 == null) {
					job1 = new ScheduleJob();
					job1.setJobGroup("ZLTASK");
					job1.setJobName(dbconpro2.getJgxtlb() + "ZLTASK");
				}
				job1.setBeanName("ZLTASK");
				job1.setAdzm(dbconpro2.getAzdm());
				job1.setJgxtlb(dbconpro2.getJgxtlb());
				record.setGjz("ZLCJZQ");
				rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
				job1.setCronExpression("* */" + rzcjqjcs.getMrz() + " * * * ? ");
				schedulerJobService.saveOrUpdate(job1);
			} catch (Exception e) {
				logger.error("策略刷新时添加增量任务出错" + "======ZLTASK FlashCelueTask" + e);
				e.printStackTrace();
			}
			// 存量任务添加
			record.setGjz("CLRWQDSJ");
			rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
			StringBuffer sb = new StringBuffer();
			if (rzcjqjcs == null) {
				sb.append("0");
			} else {
				sb.append(rzcjqjcs.getMrz());
			}
			sb.append("-");
			record.setGjz("CLRWJSSJ");
			rzcjqjcs = rzcjqjcsService.selectByGjz(record).get(0);
			if (rzcjqjcs == null) {
				sb.append("8");
			} else {
				sb.append(new Integer(rzcjqjcs.getMrz()) - 1);
			}
			if (dbrzcjcs1.size() == 0) {
				return;
			}
			// 策略更新
			for (int i = 0; i < dbrzcjcs1.size(); i++) {
				Dbrzcjcs dbrzcjcs = (Dbrzcjcs) dbrzcjcs1.get(i);
				if (!dbconpro2.getAzdm().equals("") && dbconpro2.getAzdm() != null
						|| !dbconpro2.getJgxtlb().equals("") && dbconpro2.getJgxtlb() != null) {
					// 获取 需要添加的job参数和信息
					// 判断，单表日志全局参数 此表中是否有 交管系统类别 和日志解析参数中是否有此类别
					if (dbrzcjcs != null && rzcjqjcs != null) {
						// 判断是否采集存量任务
						if (!dbrzcjcs.getClcjbj().equals("0")) {
							// 存量任务
							job = null;
							job = new ScheduleJob();
							job.setJobGroup("CLTASK");
							job.setJobName(dbconpro2.getJgxtlb() + dbrzcjcs.getBm() + "CLTASK");
							try {
								ScheduleJob job1 = scheduleJobInService.selectByJobNameAngJobGroup(job.getJobName(),
										job.getJobGroup());
								if (job1 == null) {
									job1 = new ScheduleJob();
									job1.setBeanName("CLTASK");
									job1.setJobGroup("CLTASK");
									job1.setJobName(dbconpro2.getJgxtlb() + dbrzcjcs.getBm() + "CLTASK");
								}
								job1.setBeanName("CLTASK");
								job1.setAdzm(dbconpro2.getAzdm());
								job1.setJgxtlb(dbconpro2.getJgxtlb());
								job1.setBm(dbrzcjcs.getBm());
								logger.info("存量任务的周期" + sb.toString());
								job1.setCronExpression("*/10 * " + sb.toString() + " * * ?");
								// 111111
								schedulerJobService.saveOrUpdate(job1);
							} catch (Exception e) {
								e.printStackTrace();
								logger.info("策略刷新时添加存量任务出错" + "======CLTASK FlashCelueTask");
							}
						}
					}
				}
				// 上报开关 关闭
				sb(dbconpro2.getJgxtlb(), dbrzcjcs.getBm(), dbconpro2);
			}
		}
	}

	/**
	 * 修改Alivedbconf文件,需要以完整的jgxtlb/ip作为节点，则需要将日志采集全局参数引入作为参数
	 * 
	 * @param record
	 * @param dbrecord
	 */
	public void alterAlivedb(Dbconpro record, List<Dbrzcjcs> dbrecord) {
		synchronized (dbrzcjcssize) {
			if (!dbrzcjcssize.containsKey(record.getJgxtlb())) {
				dbrzcjcssize.put(record.getJgxtlb(), dbrecord.size());
			}
		}
		try {
			StringBuffer buffer = new StringBuffer(FilePathName.ROOT);// 项目上级目录
			buffer.append(record.getJgxtlb());// 节点目录 /jgxtlb
			buffer.append(FilePathName.FileSepeartor);// /jgxtlb/
			logger.info(buffer.toString());
			File file = new File(buffer.toString());
			if (!file.exists()) {
				file.mkdir();
				logger.info("FlashCelueTask ----创建目录" + buffer.toString());
			}
			File rzjx = new File(buffer.toString() + FilePathName.RZJXWJPath);
			if (!rzjx.exists()) {
				rzjx.mkdirs();
				logger.info("FlashCelueTask ----创建目录" + buffer.toString() + FilePathName.RZJXWJPath);
			}
			File cldir = new File(buffer.toString() + FilePathName.CLStanbyPath);
			if (!cldir.exists()) {
				cldir.mkdirs();
				logger.info("FlashCelueTask ----创建目录" + buffer.toString() + FilePathName.CLStanbyPath);
			}
			File zldir = new File(buffer.toString() + FilePathName.ZLStanbyPath);
			if (!zldir.exists()) {
				zldir.mkdirs();
				logger.info("FlashCelueTask ----创建目录" + buffer.toString() + FilePathName.ZLStanbyPath);
			}
			File zldid = new File(buffer.toString() + FilePathName.ZLDIDPath);
			if (!zldid.exists()) {
				zldid.mkdirs();
				logger.info("FlashCelueTask ----创建目录" + buffer.toString() + FilePathName.ZLDIDPath);
			}
			File cldid = new File(buffer.toString() + FilePathName.CLDIDPath);
			if (!cldid.exists()) {
				cldid.mkdirs();
				logger.info("FlashCelueTask ----创建目录" + buffer.toString() + FilePathName.CLDIDPath);
			}
			String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
			Integer num = 1;
			if (record.getAgentype() == null) {
				num = 1;
			} else {
				num = record.getAgentype().intValue();
			}
			String type = "p2p";
			if (num > 1) {
				type = "rac";
			}
			int local = 1;

			for (int j = 0; j < agent.size(); j++) {
				Agent agent1 = agent.get(j);
				System.out.println("agent--------------------------" + "--" + agent.size() + "--" + agent1.getKip());
				String jd = buffer.toString() + agent1.getKip() + FilePathName.FileSepeartor;
				// 4,拷贝alivedb.conf,capture.out和capture到节点目录中
				// 5,创建目录
				local = local + j;
				try {
					File capturedir = new File(jd + "capture");
					if (!capturedir.exists()) {
						capturedir.mkdirs();
						FilePathName.copyDir(FilePathName.ROOT + "capture", jd + "capture");
						logger.info("FlashCelueTask ----创建目录" + jd + "capture");
					}
					File capture = new File(jd + "capture.out");
					if (!capture.exists()) {
						// 更精细的是从哪个时间点开始采集增量
						FilePathName.copyFile(FilePathName.ROOT + "capture.out", jd + "capture.out");
						logger.info("FlashCelueTask ----创建目录" + jd + "capture.out");
					}
					File logdir = new File(jd + "log" + FilePathName.FileSepeartor);
					if (!logdir.exists()) {
						logdir.mkdirs();
						logger.info("FlashCelueTask ----创建目录" + jd + "log");
					}
					File alivedb = new File(jd + "Alivedb.conf");
					if (!alivedb.exists()) {
						alivedb.createNewFile();
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Port", "9888");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Password", "admin");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Type", type);
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Local", "Server" + local);
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Access_ip", "127.0.0.1");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "LogLevel", "0");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Mode", "0");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "RunningMode", "3");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Hostid", "");
						if (null == record.getStartepoch()) {
						} else {
							ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "StartEpoch",
									startEpoch.format(record.getStartepoch()));
						}
						ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "Logging", "false");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "Option", "Redo_type", "File");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "Option", "Capture_interval", "5");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "Option", "Apply_interval", "5");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "Option", "Transfer_interval", "5");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "Option", "Apply_delay", "1");
						ConfigFile.setIniValue(jd + "Alivedb.conf", "Option", "Capture_mode", "0");
						// 进行判断
						for (int i = 1; i <= num; i++) {
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "Oracle_instance",
									record.getSid());
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "Oracle_account",
									record.getUsername());
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "Oracle_password",
									record.getPassword());
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "Oracle_port", record.getPort());
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "Log_pool",
									buffer.toString().replace(FilePathName.FileSepeartor,
											FilePathName.FileSepeartor + FilePathName.FileSepeartor)
											+ FilePathName.RZJXWJPath);
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "File_flag", str[i - 1]);
							ConfigFile.setIniValue(jd + "Alivedb.conf", "Server" + i, "Sql_type", "1");
						}

						ConfigFile.setIniValue(jd + "Alivedb.conf", "User1", "Name", record.getSchema().toUpperCase());
						ConfigFile.setIniValue(jd + "Alivedb.conf", "User1", "Type", "include");
						String bm = "";
						for (int i = 0; i < dbrecord.size(); i++) {
							if (i == 0) {
								bm = dbrecord.get(i).getBm();
							} else {
								bm = dbrecord.get(i).getBm() + "," + bm;
							}
						}
						ConfigFile.setIniValue(jd + "Alivedb.conf", "User1", "Tables", bm.toUpperCase());
					} else {
						if (dbrzcjcssize.get(record.getJgxtlb()) != dbrecord.size()) {
							String jobName = record.getJgxtlb() + "ZLTASK";
							String jobGroup = "ZLTASK";
							ScheduleJob job = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
							if (dbrecord.size() == 0) {
								// 2，停止所有capture
								for (Iterator<Agent> iterator = agent.iterator(); iterator.hasNext();) {
									Agent agent11 = (Agent) iterator.next();
									String pid = JsonToObject.StringconsvertToJSONObject(job.getPid())
											.getString(agent11.getKip());
									if (SysResource.checkProcess(pid)) {
										SysResource.stopProcess(pid);
									}
								}
								logger.info("停止所有capture" + jobName);
								schedulerJobService.deleteJob(jobName, jobGroup);
								logger.info("删除此增量任务" + jobName);
							} else {
								// 2，停止所有capture
								schedulerJobService.pauseJob(jobName, jobGroup);
								logger.info("停止增量任务=======" + jobName);
								for (Iterator<Agent> iterator = agent.iterator(); iterator.hasNext();) {
									Agent agent11 = (Agent) iterator.next();
									String pid = JsonToObject.StringconsvertToJSONObject(job.getPid())
											.getString(agent11.getKip());
									if (SysResource.checkProcess(pid)) {
										SysResource.stopProcess(pid);
									}
								}
								logger.info("停止所有的capture--=====");
								String bm = "";
								ConfigFile.setIniValue(jd + "Alivedb.conf", "User1", "Tables", bm.toUpperCase());
								for (int i = 0; i < dbrecord.size(); i++) {
									if (i == 0) {
										bm = dbrecord.get(i).getBm();
									} else {
										bm = dbrecord.get(i).getBm() + "," + bm;
									}
								}
								ConfigFile.setIniValue(jd + "Alivedb.conf", "User1", "Tables", bm.toUpperCase());
								logger.info("重置Alivedb.conf 表名----" + bm.toUpperCase());
								schedulerJobService.runOneJob(jobName, jobGroup);
								logger.info("重启此增量任务" + jobName);
							}
							synchronized (dbrzcjcssize) {
								dbrzcjcssize.put(record.getJgxtlb(), dbrecord.size());
							}
						}
					}
				} catch (IOException e) {
					logger.info("创建节点失败： 目录或文件不存在");
					Exeception exeception = new Exeception();
					exeception.setJgxtlb(record.getJgxtlb());
					exeception.setJobname(job.getJobName());
					exeception.setCreatetime(getTime());
					exeception.setDesciption(
							"安管代码  ： " + record.getAzdm() + "  交管系统类别:" + record.getJgxtlb() + "创建节点失败： 目录或文件不存在");
					execeptionService.insertSelective(exeception);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("创建节点失败： 目录或文件不存在");
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(record.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption(
					"安管代码  ： " + record.getAzdm() + "  交管系统类别:" + record.getJgxtlb() + "创建节点失败： 目录或文件不存在");
			execeptionService.insertSelective(exeception);
		}
	}

	// 1.日志采集全局参数查询接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void queryQJparams() throws Exception {
		String jkid = "81Q01";
		String UTF8Json = "[{}]";
		String result = TestRestSafeOutAccess.writeObjectRds(TestRestSafeOutAccess.jklb, TestRestSafeOutAccess.jkxlh,
				jkid, TestRestSafeOutAccess.babh, TestRestSafeOutAccess.mac, UTF8Json);
		if (result.equals("")) {
			return;
		} else {
			logger.info("获取参数失败： ");
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			if (map.get("code").equals("0")) {
				return;
			}
			data = map.get("data").toString();
			if (map.get("code").toString().equals("1") && !data.equals("") && !data.equals("null")) {
				// STR 转 jsonArray
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Rzcjqjcs record;
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								record = (Rzcjqjcs) JsonToObject.mapToObject(map3, Rzcjqjcs.class);
								// 插入
								rzcjqjcsService.saveorupdate(record);
							}
						}
					}
				}
				logger.info("全局参数刷新成功");
			} else {
				logger.info(map.get("message"));
				logger.info("获取全局参数失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * 清楚已经采集的归档
	 * 
	 * @param filepath
	 *            归档路径
	 */
	public void qcgd(String filepath) {

	}

	/**
	 * 刷新备案编号
	 */
	public void get() {
		String ip = config.properties.getProperty("agxtip");
		String port = config.properties.getProperty("agxtport");
		String jkxlh = config.properties.getProperty("jkxlh");
		String babh = config.properties.getProperty("babh");
		String mac = config.properties.getProperty("mac");
		if (!ip.equals("") && ip != null) {
			TestRestSafeOutAccess.agxtip = ip;
		}
		if (!port.equals("") && port != null) {
			TestRestSafeOutAccess.agxtport = port;
		}
		if (!jkxlh.equals("") && jkxlh != null) {
			TestRestSafeOutAccess.jkxlh = jkxlh;
		}
		if (!babh.equals("") && babh != null) {
			TestRestSafeOutAccess.babh = babh;
		}
		if (!mac.equals("") && mac != null) {
			TestRestSafeOutAccess.mac = mac;
		}
	}

	public Cjrjyxzt getCjrjyxzt() {

		return null;
	}

	public FtpUtils getFtp(Dbconpro record) {
		FtpUtils ftp = new FtpUtils();
		Rzcjqjcs record1 = new Rzcjqjcs();
		record1.setGjz("FSIP");
		Rzcjqjcs rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
		if (rzcjqjcs.getMrz() == null) {
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(record.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP IP 为空");
			execeptionService.insertSelective(exeception);
			return null;
		} else {
			ftp.setHostname(rzcjqjcs.getMrz());
		}
		rzcjqjcs = null;
		record1.setGjz("FSUSER");
		rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
		if (rzcjqjcs.getMrz() == null) {
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(record.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP USER为空");
			execeptionService.insertSelective(exeception);
			return null;
		} else {
			ftp.setUsername(rzcjqjcs.getMrz());
			logger.info(rzcjqjcs.getMrz());
		}
		rzcjqjcs = null;
		record1.setGjz("FSUSERPASS");
		rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
		if (rzcjqjcs.getMrz() == null) {
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(record.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP 密码为空");
			execeptionService.insertSelective(exeception);
			return null;
		} else {
			ftp.setPassword(rzcjqjcs.getMrz());
			logger.info(rzcjqjcs.getMrz());
		}
		rzcjqjcs = null;
		record1.setGjz("FSPORT");
		rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
		if (rzcjqjcs.getMrz() == null) {
			Exeception exeception = new Exeception();
			exeception.setCreatetime(getTime());
			exeception.setJgxtlb(record.getJgxtlb());
			exeception.setJobname(job.getJobName());
			exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP 端口为空");
			execeptionService.insertSelective(exeception);
			return null;
		} else {
			ftp.setPort(new Integer(rzcjqjcs.getMrz()));
		}
		return ftp;
	}

	// 增量文件传输 分两块，1，异常传输：存量没采完 2：正常传输 ：存量采完了
	@SuppressWarnings("null")
	public void zlchuanshu(Clsjclzt clzt, FtpUtils ftp, Dbconpro record) {
		Zlsjwjb zlsjwj = new Zlsjwjb();
		zlsjwj.setJgxtlb(record.getJgxtlb());
		zlsjwj.setWjzt("1");
		zlsjwj.setSbzt("0");
		zlsjwj.setBm("0");
		List<Zlsjwjb> zlwjlist = zlsjwjbService.selectwjzt(zlsjwj);
		String absolutpath = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor
				+ FilePathName.ZLStanbyPath + FilePathName.FileSepeartor;
		if (zlwjlist != null || !zlwjlist.isEmpty()) {
			Rzcjqjcs record1 = new Rzcjqjcs();
			record1.setGjz("ZLSCML");
			Rzcjqjcs rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
			if (rzcjqjcs.getMrz() == null) {
				Exeception exeception = new Exeception();
				exeception.setCreatetime(getTime());
				exeception.setJgxtlb(record.getJgxtlb());
				exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP 存量上传路径为空");
				execeptionService.insertSelective(exeception);
				return;
			} else {
				ftp.setFtpDir(rzcjqjcs.getMrz());
			}
			try {
				for (Iterator<Zlsjwjb> iterator = zlwjlist.iterator(); iterator.hasNext();) {
					Zlsjwjb zlsjwjb = (Zlsjwjb) iterator.next();
					ftp.initFtpClient();
					ftp.uploadFile(ftp.getFtpDir(), zlsjwjb.getWjm(), absolutpath + zlsjwjb.getWjm());
					zlsjwjb.setScfwqsj(getTime());
					zlsjwjb.setGxsj(getTime());
					zlsjwjb.setWjzt("2");
					String sywjm = zlsjwjbService.selectSYwjm(record.getJgxtlb(), zlsjwjb.getWjm());
					if (null != sywjm && !sywjm.equals("")) {
						zlsjwjb.setSywjm(sywjm);
					} else {
						zlsjwjb.setSywjm("begin");
					}
					zlsjwjbService.updateByExample(zlsjwjb);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (clzt.getCjzt().equals("2")) {
			// 异常模式
			zlsjwj.setBm(clzt.getBm());
			List<Zlsjwjb> zlwjlist1 = zlsjwjbService.selectwjzt(zlsjwj);
			String absolutpath1 = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor
					+ FilePathName.ZLStanbyPath + FilePathName.FileSepeartor;
			if (zlwjlist1 != null && !zlwjlist1.isEmpty()) {
				Rzcjqjcs record1 = new Rzcjqjcs();
				record1.setGjz("ZLSCML");
				Rzcjqjcs rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
				if (rzcjqjcs.getMrz() == null) {
					Exeception exeception = new Exeception();
					exeception.setCreatetime(getTime());
					exeception.setJgxtlb(record.getJgxtlb());
					exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP 存量上传路径为空");
					execeptionService.insertSelective(exeception);
					return;
				} else {
					ftp.setFtpDir(rzcjqjcs.getMrz());
				}
				try {
					for (Iterator<Zlsjwjb> iterator = zlwjlist1.iterator(); iterator.hasNext();) {
						Zlsjwjb zlsjwjb = (Zlsjwjb) iterator.next();
						ftp.initFtpClient();
						File file = new File(absolutpath + zlsjwjb.getWjm());
						String oldZl = zlsjwjb.getWjm();
						File fil1 = new File(getZLXMLName(record));
						file.renameTo(fil1);
						zlsjwjb.setWjm(fil1.getName());
						file = null;
						fil1 = null;
						ftp.uploadFile(ftp.getFtpDir(), zlsjwjb.getWjm(), absolutpath1 + zlsjwjb.getWjm());
						zlsjwjb.setScfwqsj(getTime());
						String sywjm = zlsjwjbService.selectSYwjm(record.getJgxtlb(), zlsjwjb.getWjm());
						if (null != sywjm && !sywjm.equals("")) {
							zlsjwjb.setSywjm(sywjm);
						} else {
							zlsjwjb.setSywjm("begin");
						}
						zlsjwjb.setGxsj(getTime());
						zlsjwjb.setWjzt("2");
						zlsjwjbService.reNameWjm(oldZl, zlsjwjb);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String getNextZLXMLName(Dbconpro dbConpro, Integer num) {
		if (dbConpro.getJgxtlb() != null && !dbConpro.getJgxtlb().equals("")) {
			StringBuffer str = new StringBuffer();
			// 文件路径
			str.append(dbConpro.getAzdm()).append(dbConpro.getJgxtlb()).append(xmlfilename.getXmlFileName("zl", num));
			return str.toString();
		}
		return "0";
	}

	/**
	 * 上报完更新此记录并记录此纪录更新为1已上报 jgxtlb,bm 获取单表，全局参数 清理已采集的日志
	 * 
	 * @param dbconpro2
	 * @throws IOException
	 * @throws SocketException
	 */
	public void sb(String jgxtlb, String bm, Dbconpro dbconpro2) throws SocketException, IOException {
		Clsjclzt record = new Clsjclzt();
		record.setJgxtlb(jgxtlb);
		record.setBm(bm);
		String absolutpath = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor
				+ FilePathName.ZLDIDPath + FilePathName.FileSepeartor;
		String oldpath = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor + FilePathName.ZLStanbyPath
				+ FilePathName.FileSepeartor;
		List<Clsjclzt> cllist = clsjclztService.selectByCJZT(record);
		if (cllist == null || cllist.isEmpty()) {
			return;
		}
		int zl = 0;
		int scs = 0;
		int dcs = 0;
		StringBuffer buffer = new StringBuffer(FilePathName.ROOT);// 项目上级目录
		buffer.append(record.getJgxtlb());// 节点目录 /ip
		buffer.append(FilePathName.FileSepeartor);// /ip/
		// 判断此表的存量是否完成，如果完成，上报存量并上报增量
		for (Iterator<Clsjclzt> iterator = cllist.iterator(); iterator.hasNext();) {
			Clsjclzt clsjclzt = (Clsjclzt) iterator.next();
			// 可以上报，获取存量文件表所有当前表名和交管系统类别的数据
			Clsjwjb clwjrecord = new Clsjwjb();
			clwjrecord.setBm(bm);
			clwjrecord.setJgxtlb(jgxtlb);
			clwjrecord.setWjzt("2");
			clwjrecord.setSbzt("0");
			// 上报存量文件
			List<Clsjwjb> clwjlist = clsjwjbService.selectByrkzt(clwjrecord);
			clwjrecord.setSbzt("2");
			// 查询已上报的存量文件状态
			List<Clsjwjb> clwjl = clsjwjbService.selectByrkzt(clwjrecord);
			Clsjkddb clsjkddb = new Clsjkddb();
			clsjkddb.setBm(bm);
			clsjkddb.setJgxtlb(jgxtlb);
			clsjkddb.setWcbj("1");
			clsjkddb.setSbzt("0");
			rsoa.setClsjwjbService(clsjwjbService);
			rsoa.setDbrzcjcsService(dbrzcjcsService);
			rsoa.setRzcjqjcsService(rzcjqjcsService);
			rsoa.setZlsjwjbService(zlsjwjbService);
			try {
				// 存量文件反馈接口
				rsoa.queryOldDataFileStatus(JsonToObject.ListconsvertToJSON(clwjl), oldpath, absolutpath);
				if (clwjlist == null || clwjlist.isEmpty()) {
				} else {
					rsoa.buildOldFilenameJson(JsonToObject.ListconsvertToJSON(clwjlist));
					for (Clsjwjb clsjwjb : clwjlist) {
						clsjwjb.setSbzt("2");
						clsjwjbService.updateByExampleSelective(clsjwjb);
					}
				}
				// 8.存量数据块断点写入接口
				List<Clsjkddb> clddlist1 = clsjkddbService.selectBysbzt(clsjkddb);
				if (clddlist1 == null || clddlist1.isEmpty()) {
				} else {
					rsoa.buildOldDataBrkinfoJson(JsonToObject.ListconsvertToJSON(clddlist1));
					for (Clsjkddb clsjkddb2 : clddlist1) {
						clsjkddb2.setSbzt("2");
						clsjkddbService.updateByExample(clsjkddb2);
					}
				}
				// 7.存量数据处理状态写入接口
				if (!clsjclzt.getSbzt().equals("2")) {
					clsjclzt.setSbzt("0");
					List<Clsjclzt> clcjclztlist = clsjclztService.selectBysbzt(clsjclzt);
					if (clcjclztlist == null || clcjclztlist.isEmpty()) {
					} else {
						// 上报存量状态
						logger.info("上报此存量数据处理状态");
						rsoa.buildOldDataStatusinfoJson(JsonToObject.ListconsvertToJSON(clcjclztlist));
						for (Clsjclzt clsjclzt2 : clcjclztlist) {
							if (clsjclzt2.getCjzt().equals("1")) {
								clsjclzt2.setSbzt("0");
							} else {
								clsjclzt2.setSbzt(clsjclzt2.getCjzt());
							}
							clsjclztService.updateByExample(clsjclzt2);
						}
					}
					clcjclztlist = null;
				}
				clddlist1 = null;
				// 上报数据采集软件运行状态
				Cjrjyxzt cjrjyxzt = new Cjrjyxzt();
				cjrjyxzt.setBabh(config.properties.getProperty("babh"));
				cjrjyxzt.setJgxtlb(jgxtlb);
				// ftp连接状态
				FtpUtils ftp = getFtp(dbconpro2);
				if (ftp.initFtpClient()) {
					cjrjyxzt.setFwqljzt("1");
					cjrjyxzt.setFwqcwms("");
				} else {
					cjrjyxzt.setFwqljzt("0");
					cjrjyxzt.setFwqcwms("文件服务器连接失败");
				}
				// 目标数据库连接状态
				JDBCUtil db = new JDBCUtil(dbconpro2.getUsername(), dbconpro2.getPassword(), dbconpro2.getIp(),
						dbconpro2.getPort(), dbconpro2.getSid());
				boolean flag = db.getConnection();
				if (flag) {
					cjrjyxzt.setSjkljzt("1");
					db.closeDB();
					cjrjyxzt.setSjkcwms("");
				} else {
					db = null;
					cjrjyxzt.setSjkljzt("0");
					cjrjyxzt.setSjkcwms(dbconpro2.getUsername() + dbconpro2.getPassword() + dbconpro2.getIp()
							+ dbconpro2.getPort() + dbconpro2.getSid() + "目标数据库连接失败");
				}
				// Agent状态
				Agent agent = new Agent();
				agent.setJgxtlb(jgxtlb);
				agent.setStaius("1");
				if (!agentService.selectByStatus(agent).isEmpty()) {
					cjrjyxzt.setKhdzt("1");
					cjrjyxzt.setKhdcwms("");
				} else {
					cjrjyxzt.setKhdcwms("Agent连接失败");
					cjrjyxzt.setKhdzt("0");
				}
				cjrjyxzt.setClyxzt("1");
				cjrjyxzt.setZlyxzt("1");
				cjrjyxzt.setGxsj(getTime());
				cjrjyxzt.setZxrzmlzt("1");
				cjrjyxzt.setGdrzmlzt("1");
				cjrjyxztService.saveOrupdate(cjrjyxzt);
				List<Cjrjyxzt> yxlist = cjrjyxztService.selectByExample(cjrjyxzt);
				// 上报数据采集情况统计表
				Sjcjqktjb sjcjqk = new Sjcjqktjb();
				sjcjqk.setBabh(config.properties.getProperty("babh"));
				sjcjqk.setJgxtlb(jgxtlb);
				sjcjqk.setTjrq(tj.format(getTime()));
				scs = clsjclztService.sumycjcjl(jgxtlb);
				zl = clsjclztService.countSJZL(jgxtlb);
				sjcjqk.setClcjl(new BigDecimal(scs));
				sjcjqk.setCldcjl(new BigDecimal(zl - scs));
				zl = clsjwjbService.countclsjwjByJGXGLB(jgxtlb).intValue();
				scs = clsjwjbService.countclsjwjsclByJGXGLB(jgxtlb).intValue();
				sjcjqk.setClwjs(new BigDecimal(zl));
				sjcjqk.setClwjscs(new BigDecimal(scs));
				sjcjqk.setClwjdcs(new BigDecimal(zl - scs));
				if (zlsjwjbService.countZUpdate(jgxtlb) != null) {
					zl = zlsjwjbService.countZUpdate(jgxtlb).intValue();
				} else {
					zl = 0;
				}
				if (zlsjwjbService.countZZInsert(jgxtlb) != null) {
					dcs = zlsjwjbService.countZZInsert(jgxtlb).intValue();
				} else {
					dcs = 0;
				}
				if (zlsjwjbService.countZDelete(jgxtlb) != null) {
					scs = zlsjwjbService.countZDelete(jgxtlb).intValue();
				} else {
					scs = 0;
				}
				sjcjqk.setZlcjl(new BigDecimal(zl + dcs + scs));
				sjcjqk.setInsertl(new BigDecimal(dcs));
				sjcjqk.setUpdatel(new BigDecimal(zl));
				sjcjqk.setDeletel(new BigDecimal(scs));
				if (zlsjwjbService.countZlwjs(jgxtlb) != null) {
					zl = zlsjwjbService.countZlwjs(jgxtlb).intValue();
				} else {
					zl = 0;
				}
				if (zlsjwjbService.countZlwjscs(jgxtlb) != null) {
					scs = zlsjwjbService.countZlwjscs(jgxtlb).intValue();
				} else {
					scs = 0;
				}
				sjcjqk.setZlwjs(new BigDecimal(zl));
				sjcjqk.setZlwjscs(new BigDecimal(scs));
				sjcjqk.setZlwjdcs(new BigDecimal(zl - scs));
				// ddl和seqc的獲取方式
				sjcjqk.setSeqc(zlsjddbService.selectNewSeq(dbconpro2.getJgxtlb()));
				sjcjqk.setDdll(new BigDecimal(ddlsjsjbService.countByExample()));
				List<Sjcjqktjb> sjcjqklist = new ArrayList<>();
				sjcjqklist.add(sjcjqk);
				// 增量文件传输
				flasjClstatus(clsjclzt, ftp, dbconpro2);
				// 存量文件传输
				chuanshu(ftp, dbconpro2);
				ftp.logout();
				ftp = null;
				// 13.数据采集情况统计信息写入接口
				logger.info("数据采集情况统计信息写入接口");
				rsoa.buildGatherStatisticsJson(JsonToObject.ListconsvertToJSON(sjcjqklist));
				// 6.采集软件运行状态写入接口
				logger.info("采集软件运行状态写入接口");
				rsoa.buildTaskStatusJson(JsonToObject.ListconsvertToJSON(yxlist));

			} catch (Exception e1) {
				e1.printStackTrace();
				Exeception exeception = new Exeception();
				exeception.setCreatetime(getTime());
				exeception.setDesciption("访问接口失败");
				execeptionService.insertSelective(exeception);
				logger.info("策略更新任务------访问接口失败");
			}
		}
	}

	/**
	 * 传输文件
	 * 
	 * @throws Exception
	 */
	public void chuanshu(FtpUtils ftp, Dbconpro record) throws Exception {
		Clsjwjb clwj = new Clsjwjb();
		clwj.setWjzt("1");
		clwj.setJgxtlb(record.getJgxtlb());
		List<Clsjwjb> cswj = clsjwjbService.selectByWjzt(clwj);
		String absolutpath = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor
				+ FilePathName.CLStanbyPath + FilePathName.FileSepeartor;
		try {
			if (cswj != null && !cswj.isEmpty()) {
				Rzcjqjcs record1 = new Rzcjqjcs();
				record1.setGjz("CLSCML");
				Rzcjqjcs rzcjqjcs = rzcjqjcsService.selectByGjz(record1).get(0);
				if (rzcjqjcs.getMrz() == null) {
					Exeception exeception = new Exeception();
					exeception.setCreatetime(getTime());
					exeception.setJgxtlb(record.getJgxtlb());
					exeception.setJobname(job.getJobName());
					exeception.setDesciption("FTPTASK:" + "连接参数刷新失败  原因：此任务FTP 存量上传路径为空");
					execeptionService.insertSelective(exeception);
					return;
				} else {
					ftp.setFtpDir(rzcjqjcs.getMrz());
				}
				for (int i = 0; i < cswj.size(); i++) {
					Clsjwjb clsjwjb = cswj.get(i);
					ftp.initFtpClient();
					ftp.uploadFile(ftp.getFtpDir(), clsjwjb.getWjm(), absolutpath + clsjwjb.getWjm());
					clsjwjb.setScfwqsj(getTime());
					clsjwjb.setWjzt("2");
					clsjwjbService.updateByExample(clsjwjb);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * 按照表名来进行上报 刷新存量采集状态完成能够足以上报并
	 * 1，将增量文件上报，此处只上报异常情况文件，2，增量断点上报，3，ddl数据上报，4增量文件上传
	 */
	public void flasjClstatus(Clsjclzt clzt, FtpUtils ftp, Dbconpro record) {
		// 此时此交管系统类别中没有未采集完成的
		// 1,增量文件list获取
		Zlsjwjb zlsjwj = new Zlsjwjb();
		zlsjwj.setJgxtlb(record.getJgxtlb());
		zlsjwj.setWjzt("2");
		zlsjwj.setSbzt("0");
		zlsjwj.setBm(clzt.getBm());
		Zlsjddb zlsjdd = new Zlsjddb();
		zlsjdd.setJgxtlb(record.getJgxtlb());
		try {
			List<Zlsjddb> zlsjddlist = zlsjddbService.selectBysbzt(zlsjdd);
			if (zlsjddlist == null || zlsjddlist.isEmpty()) {
			} else {
				rsoa.buildNewDataBrkinfoJson(JsonToObject.ListconsvertToJSON(zlsjddlist));
			}
			// sbzt 2
			zlsjwj.setSbzt("2");
			// 查询
			List<Zlsjwjb> zlwjlist1 = zlsjwjbService.selectByZCSB(zlsjwj);
			String absolutpath = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor
					+ FilePathName.ZLDIDPath + FilePathName.FileSepeartor;
			String oldpath = FilePathName.ROOT + record.getJgxtlb() + FilePathName.FileSepeartor
					+ FilePathName.ZLStanbyPath + FilePathName.FileSepeartor;
			rsoa.queryNewDataFileStatus(JsonToObject.ListconsvertToJSON(zlwjlist1), oldpath, absolutpath);
			// 上传FTP
			zlchuanshu(clzt, ftp, record);
			// sbzt 0 bm
			// 上报异常
			zlsjwj.setSbzt("0");
			if (clzt.getCjzt().equals("2")) {
				List<Zlsjwjb> zlwjlist = zlsjwjbService.selectByYCSB(zlsjwj);
				if (zlwjlist == null || zlwjlist.isEmpty()) {
				} else {
					rsoa.buildNewFilenameJson(JsonToObject.ListconsvertToJSON(zlwjlist));
					for (Zlsjwjb zlsjwjb1 : zlwjlist) {
						zlsjwjb1.setSbzt("2");
						zlsjwjbService.updateByExampleSelective(zlsjwjb1);
					}
				}
			}
			// 上报正常
			zlsjwj.setBm("0");
			List<Zlsjwjb> zlwjlist2 = zlsjwjbService.selectByYCSB(zlsjwj);
			if (zlwjlist2 == null || zlwjlist2.isEmpty()) {
			} else {
				rsoa.buildNewFilenameJson(JsonToObject.ListconsvertToJSON(zlwjlist2));
				for (Zlsjwjb zlsjwjb : zlwjlist2) {
					zlsjwjb.setSbzt("2");
					zlsjwjbService.updateByExampleSelective(zlsjwjb);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
	}

	public List<Dbconpro> getDbConpro() {
		return dbConpro;
	}

	public void setDbConpro(List<Dbconpro> dbConpro) {
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

	// 2.日志采集单表参数查询接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void querySingleParams(Dbconpro dbconpro) throws Exception {
		String jkid = "81Q02";
		String UTF8Json = "[{}]";
		String result = TestRestSafeOutAccess.writeObjectRds(TestRestSafeOutAccess.jklb, TestRestSafeOutAccess.jkxlh,
				jkid, TestRestSafeOutAccess.babh, TestRestSafeOutAccess.mac, UTF8Json);
		if (!result.equals("")) {
		} else {
			logger.info("获取参数失败： ");
			return;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		logger.info(map.get("code"));
		String data = "";
		data = (String) map.get("data");
		if (data == null) {
			return;
		}
		if (map.get("code").toString().equals("1") && !data.equals("") && !data.equals("null")) {
			// STR 转 jsonArray

			JSONArray myJsonArray = JSONArray.parseArray(data);
			List<Map<String, Object>> mapListJson = (List) myJsonArray;
			Dbrzcjcs record;
			List<Dbrzcjcs> dbrzcjcslist = new ArrayList<>();
			for (Map<String, Object> map2 : mapListJson) {
				for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
					Entry<String, Object> entry = it.next();
					if (entry.getKey().equals("list")) {
						List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
						for (Map<String, Object> map3 : listmap) {
							record = (Dbrzcjcs) JsonToObject.mapToObject(map3, Dbrzcjcs.class);
							if (dbconpro.getJgxtlb().substring(0, 2).equals(record.getJgxtlb())) {
								dbrzcjcslist.add(record);
							}
							dbrzcjcsService.saveorupdate(record);
						}
					}
				}
			}
			// 同步单表参数
			dbrzcjcsService.deleteNotIn(dbrzcjcslist, dbconpro.getJgxtlb().substring(0, 2));
			logger.info("单表参数刷新成功");
		} else if (map.get("code").toString().equals("0")) {
			logger.info("单表获取参数失败");
		} else if (map.get("code").toString().equals("2")) {
			logger.info("单表获取参数失败");
		}
	}

	/**
	 * 
	 * 增量XML文件名获取
	 * 
	 * @return
	 */
	public String getZLXMLName(Dbconpro dbConpro) {

		if (dbConpro.getJgxtlb() != null && !dbConpro.getJgxtlb().equals("")) {
			StringBuffer str = new StringBuffer(FilePathName.ROOT);
			// 文件路径
			str.append(dbConpro.getJgxtlb()).append(FilePathName.FileSepeartor).append(FilePathName.ZLStanbyPath)
					.append(FilePathName.FileSepeartor).append(dbConpro.getAzdm()).append(dbConpro.getJgxtlb())
					.append(xmlfilename.getXmlFileName("zl", dbConpro.getJgxtlb()));
			// 更新增量个数
			dbConpro.setZlnum(new BigDecimal(XMLFileName.zlcountMap.get(dbConpro.getJgxtlb())));
			dbconProService.updateByExampleSelective(dbConpro);
			return str.toString();
		}
		return "0";
	}

}
