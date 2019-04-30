package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.common.ConfigFile;
import com.arshiner.common.ConfigManager;
import com.arshiner.common.FilePathName;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.SysResource;
import com.arshiner.model.Agent;
import com.arshiner.model.ScheduleJob;
import com.arshiner.model.Zlsjddb;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.quartz.util.Message;
import com.arshiner.service.AgentService;
import com.arshiner.service.ClsjclztService;
import com.arshiner.service.ScntotimeService;
import com.arshiner.service.ZlsjddbService;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author 士林
 *
 */
@RequestMapping("/jobController")
@Controller
public class JobController {
	private static final Logger logger = LoggerFactory.getLogger(JobController.class);

	// 任务的服务层
	@Autowired
	private SchedulerJobService schedulerJobService;
	@Autowired
	ScheduleJobInService scheduleJobInService;
	@Autowired
	ScntotimeService scntotimeService;
	@Autowired
	AgentService agentService;
	@Autowired
	ZlsjddbService zlsjddbService;
	@Autowired
	ClsjclztService clsjclztService;
	
	/*
	 * 查询所有任务(分页)
	 */
	@ResponseBody
	@RequestMapping(value = "/selAllScheduleJob",produces = "text/plain;charset=utf-8")
	public Object selAllScheduleJob(@RequestParam("page") String page1, @RequestParam("limit") String limit1) {
		int page = Integer.valueOf(page1);
		int limit = Integer.valueOf(limit1);
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<ScheduleJob> jobList = schedulerJobService.selAllScheduleJob(before, after);
		/*需要增加存量 任务任务当前采集到的数据量,增量解析到的当前scn号显示*/
		if (jobList.size()==0){
			//证明为空,不进行操作
			System.out.println("无可用信息...");
		}else{
			for (int i = 0; i<jobList.size();i++){
				if (jobList.get(i).getJobGroup().equals("ZLTASK")){
					//增量任务时,根据交管系统类别,查询当前增量的scn号
					String jgxtlb_zl = jobList.get(i).getJgxtlb();
					String addInfo = zlsjddbService.selScnByJgxt(jgxtlb_zl);	//得到scn号,放入List集合中,标识zlScn
					if (null==addInfo||"".equals(addInfo)) {
						addInfo="";
					}
					/*数据库中需要添加字段,暂定(可以选用没有用处的空列)*/
					jobList.get(i).setDescription(addInfo);
				}else if (jobList.get(i).getJobGroup().equals("CLTASK")){
					//存量任务,查询当前采集到的数据量(根据)
					String jgxtlb_cl = jobList.get(i).getJgxtlb();
					String bm = jobList.get(i).getBm();
					Integer zlSjl = clsjclztService.selSjlByBm(bm,jgxtlb_cl);
					if (null==zlSjl) {
						zlSjl=0;
					}
					jobList.get(i).setDescription(String.valueOf(zlSjl));
				}else{
					jobList.get(i).setDescription("无此类信息");
				}
			}
		}
		/*
		 * for (int i = 0; i<jobList.size();i++){
		 * System.out.println(jobList.get(i).getId());
		 *//*
			 * if(jobList.get(i).getId()==jobList.get(i+1).getId()){
			 * jobList.remove(i+1); }
			 *//*
			 * }
			 */
		HashMap<String, Object> jobInfoMap = new HashMap<String, Object>();
		jobInfoMap.put("code", 0);
		jobInfoMap.put("msg", "");
		jobInfoMap.put("count", schedulerJobService.countJob());
		Object arry = JSONArray.toJSON(jobList);
		jobInfoMap.put("data", arry);
		return JSONArray.toJSONString(jobInfoMap);
	}
	
	/**
	 * 获取所有的任务
	 * 
	 * @return
	 */
	@RequestMapping("/getAllJobs")
	@ResponseBody
	public Object getAllJobs() {
		logger.info("[JobController] the method:getAllJobs! the url path:------------/getAllJobs----------------");
		List<ScheduleJob> jobList = schedulerJobService.getAllScheduleJob();
		logger.info("[JobController] the method:getAllJobs is execution over ");
		return jobList;
	}
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy::HH:mm:ss");
	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 重新采集任务，需要修改 1, 需传输 jobName和jobGroup, 2,需删除所解析出来的日志文件 ,recovery.inf 清空
	 * 3，清空capture.out 4,设置Alivedb.conf配置文件 5,删除增量断点表此条记录
	 */
	@RequestMapping("/retake")
	@ResponseBody
	public Object retake(@RequestParam("jgxtlb") String jgxtlb, @RequestParam("jobName") String jobName,
			@RequestParam("jobGroup") String jobGroup, @RequestParam("dataVals") String dataVals) {
		HashMap<String, Object> retakeMap = new HashMap<String, Object>();
		StringBuffer buffer = new StringBuffer(FilePathName.ROOT);// 项目上级目录
		if (jobGroup.equals("ZLTASK")) {
			ScheduleJob job = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
			buffer.append(job.getJgxtlb());// 节点目录 /jgxtlb
			buffer.append(FilePathName.FileSepeartor);// /jgxtlb/
			try {
				Date date = time.parse(dataVals);
				//1,停止增量任务
				pauseJob(jobName, jobGroup);
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
					// 删除recovery
					recovery = new File(jd + "recovery.inf");
					if (recovery.exists()) {
						recovery.delete();// 判断是否为true
					}
					File rzjxwj = new File(buffer.toString()+FilePathName.RZJXWJPath+FilePathName.FileSepeartor);
					if (null!=rzjxwj.listFiles()) {
						SysResource.deleteDir(rzjxwj);
					}
					ConfigFile.setIniValue(jd + "Alivedb.conf", "System", "StartEpoch",
							format.format(date));
				}
				//启动此增量任务
				runJob(jobName, jobGroup);
				//成功
				retakeMap.put("code",1);
			} catch (Exception e) {
				//失败
				e.printStackTrace();
	    		retakeMap.put("code",0);
			}
		}

		return JSONArray.toJSONString(retakeMap);
	}

	/*
	 * 用户查询任务总量,已完成数量,未完成数量(√)
	 */
	@ResponseBody
	@RequestMapping("/getCount")
	public Object getCount() {
	   HashMap<String, Object> countMap = new HashMap<String, Object>();
	   int completedCount = 0; // 已完成任务
	   int normalCount = 0; // 未完成任务
	   int startCount = 0; // 运行中任务
	   int pauseCount = 0; // 已停止任务
	   List<ScheduleJob> jobList = schedulerJobService.getAllScheduleJob();
	   for (int i = 0; i < jobList.size(); i++) {
	      ScheduleJob scheduleJob = jobList.get(i);// 获取每一个Example对象
	      if (scheduleJob.getJobStatus().equals("COMPLETE")) {
	         completedCount+=1;
	      } else if (scheduleJob.getJobStatus().equals("START")) {
	         startCount+=1;
	      } else if (scheduleJob.getJobStatus() .equals("NORMAL") ) {
	         normalCount+=1;
	      } else if (scheduleJob.getJobStatus().equals("PAUSE")) {
	         pauseCount+=1;
	      }
	   }
	   countMap.put("totalCount", jobList.size());
	   countMap.put("completedCount", completedCount);
	   countMap.put("startCount", startCount);
	   countMap.put("normalCount", normalCount);
	   countMap.put("pauseCount", pauseCount);
	   return JSONArray.toJSONString(countMap);
	}

	public Timestamp getTime(Date utilDate) {
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}

	/*
	 * 批量执行启动(前端返回两个集合,存入jobName jobGroup)
	 */
	@ResponseBody
	@RequestMapping("/runListJob")
	public Object runListJob(List<String> jobList, List<String> jobTwoList) {
		HashMap<String, Object> jobMap = new HashMap<String, Object>();
		for (int i = 0; i < jobList.size(); i++) {
			Object pd = runJob(jobList.get(i), jobTwoList.get(i));
			if (pd == "true") {
				jobMap.put("jobPd", "true");
			} else {
				jobMap.put("jobPd", "false");
			}
		}
		return JSONArray.toJSONString(jobMap);
	}

	/*
	 * 批量执行停止(前端返回两个集合,存入jobName jobGroup)
	 */
	@ResponseBody
	@RequestMapping("/pauseListJob")
	public Object pauseListJob(List<String> jobList, List<String> jobTwoList) {
		HashMap<String, Object> jobMap = new HashMap<String, Object>();
		for (int i = 0; i < jobList.size(); i++) {
			Object pd = pauseJob(jobList.get(i), jobTwoList.get(i));
			
			if (pd == "true") {
				jobMap.put("jobPd", "true");
			} else {
				jobMap.put("jobPd", "false");
			}
		}
		return JSONArray.toJSONString(jobMap);
	}

	/**
	 * 获取正在执行的任务列表(分页)
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/selRunJobInfo")
	@ResponseBody
	public Object selRunJobInfo(@RequestParam("page") String page1, @RequestParam("limit") String limit1) {
		int page = Integer.valueOf(page1);
		int limit = Integer.valueOf(limit1);
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<ScheduleJob> jobList = schedulerJobService.selRunJobInfo(before, after);
		HashMap<String, Object> jobRunInfo = new HashMap<String, Object>();
		jobRunInfo.put("code", 0);
		jobRunInfo.put("msg", "");
		jobRunInfo.put("count", schedulerJobService.countRunJobInfo());
		Object arry = JSONArray.toJSON(jobList);
		jobRunInfo.put("data", arry);
		return JSONArray.toJSONString(jobRunInfo);
	}

	/**
	 * 获取正在执行的任务列表
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	@RequestMapping("/getRunJob")
	@ResponseBody
	public Object getAllRunningJob() throws SchedulerException {
		logger.info("[JobController] the method:getAllRunningJob! the url path:------------/getRunJob----------------");
		List<ScheduleJob> jobList = schedulerJobService.getAllRunningJob();
		logger.info("[JobController] the method:getAllRunningJob is execution over ");
		HashMap<String, Object> jobRunInfo = new HashMap<String, Object>();
		jobRunInfo.put("code", 0);
		jobRunInfo.put("msg", "");
		jobRunInfo.put("count", jobList.size());
		Object arry = JSONArray.toJSON(jobList);
		jobRunInfo.put("data", arry);
		return JSONArray.toJSONString(jobRunInfo);
	}

	/**
	 * 更新或者添加一个任务
	 * 
	 * @param scheduleJob
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public Object addOrUpdateJob(@ModelAttribute ScheduleJob scheduleJob) {
		logger.info("[JobController] the method addOrUpdateJob is start URL path:/addJob, the param:{}", scheduleJob);
		Message message = Message.failure();
		try {
			schedulerJobService.saveOrUpdate(scheduleJob);
			message = Message.success();
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			logger.error("[JobController] addOrUpdateJob is failure in method:addOrUpdateJob！");
		}
		return message;
	}

	/**
	 * 运行一个任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 */
	@RequestMapping("/runOneJob")
	@ResponseBody
	public Object runJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
		logger.info("[JobController] the url path:------------/runOneJob----------------");
		HashMap<String, Object> jobDisc = new HashMap<String, Object>();
		Message message = Message.failure();
		try {
			schedulerJobService.runOneJob(jobName, jobGroup);
			message = Message.success();
			jobDisc.put("jobpd", "true");
		} catch (Exception e) {
			message.setMsg(e.getMessage());
			jobDisc.put("jobpd", "false");
			logger.error("[JobController] runOnejob is failure in method:runJob");
		}
		// return message;
		return JSONArray.toJSONString(jobDisc);
	}

	/**
	 * 停止一个定时任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 */
	@RequestMapping("/pauseJob")
	@ResponseBody
	public Object pauseJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
		logger.info("[JobController] the url path:------------/runOneJob----------------");
		HashMap<String, Object> jobDisc = new HashMap<String, Object>();
		Message message = Message.failure();
		try {
			if (jobGroup.equals("ZLTASK")) {
				ScheduleJob job = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
				try {
					Agent agent = new Agent();
					agent.setJgxtlb(job.getJgxtlb());
					String captureout = "";
					String alivedb = "";
					String pid = "";
					List<Agent> agentlist = agentService.selectByExample(agent);
					for (Iterator<Agent> iterator = agentlist.iterator(); iterator.hasNext();) {
						Agent agent1 = (Agent) iterator.next();
						captureout = "";
						pid = JsonToObject.StringconsvertToJSONObject(job.getPid()).getString(agent1.getKip());
						if (SysResource.checkProcess(pid)) {
							SysResource.stopProcess(pid);
						}

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			schedulerJobService.pauseJob(jobName, jobGroup);
			message = Message.success();
			jobDisc.put("jobpd", "true");
		} catch (SchedulerException e) {
			message.setMsg(e.getMessage());
			jobDisc.put("jobpd", "false");
			logger.error("[JobController] pauseJob is failure in method:pauseJob");
		}
		// return message;
		return JSONArray.toJSONString(jobDisc);
	}

	/**
	 * 删除一个定时任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	@RequestMapping("/deleteJob")
	@ResponseBody
	public Object deleteJob(String jobName, String jobGroup) {
		logger.info("[JobController] the url path:------------/runOneJob----------------");
		Message message = Message.failure();
		try {
			if (jobGroup.equals("ZLTASK")) {
				ScheduleJob job = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
				try {
					Agent agent = new Agent();
					agent.setJgxtlb(job.getJgxtlb());
					List<Agent> agentlist = agentService.selectByExample(agent);
					for (Iterator<Agent> iterator = agentlist.iterator(); iterator.hasNext();) {
						Agent agent1 = (Agent) iterator.next();
						String pid = JsonToObject.StringconsvertToJSONObject(job.getPid()).getString(agent1.getKip());
						if (SysResource.checkProcess(pid)) {
							SysResource.stopProcess(pid);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			schedulerJobService.deleteJob(jobName, jobGroup);
			message = Message.success();
		} catch (SchedulerException e) {
			message.setMsg(e.getMessage());
			logger.error("[JobController] deleteJob is failre in method: deleteJob!");
		}
		return message;
	}

	/**
	 * 重启一个定时任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/resumeJob")
	public Object resumeJob(String jobName, String jobGroup) {
		logger.info("[JobController] the url path:------------/resumeJob----------------");
		Message message = Message.failure();
		try {
			if (jobGroup.equals("ZLTASK")) {
				ScheduleJob job = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
				try {
					Agent agent = new Agent();
					agent.setJgxtlb(job.getJgxtlb());
					List<Agent> agentlist = agentService.selectByExample(agent);
					for (Iterator<Agent> iterator = agentlist.iterator(); iterator.hasNext();) {
						Agent agent1 = (Agent) iterator.next();
						String pid = JsonToObject.StringconsvertToJSONObject(job.getPid()).getString(agent1.getKip());
						if (SysResource.checkProcess(pid)) {
							SysResource.stopProcess(pid);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			schedulerJobService.resumeJob(jobName, jobGroup);
			message = Message.success();
		} catch (SchedulerException e) {
			message.setMsg(e.getMessage());
			logger.error("[JobController] resumeJob is failre in method: resumeJob!");
		}
		return message;
	}

}
