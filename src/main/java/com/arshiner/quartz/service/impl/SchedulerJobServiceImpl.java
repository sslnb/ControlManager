package com.arshiner.quartz.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arshiner.dao.ScheduleJobMapper;
import com.arshiner.model.ScheduleJob;
import com.arshiner.quartz.job.ZLTask;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.quartz.service.SchedulerJobService;

import com.arshiner.quartz.util.ApplicationContextUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 任务状态 1，NORMAL 添加任务过后，进入等待 2，START 任务执行中 3，RESUM 重启 4，COMPLETE 完成 5，PAUSED 停止
 * 
 * @author 士林
 *
 */
@Service("schedulerJobService")
public class SchedulerJobServiceImpl implements SchedulerJobService {

	private static final Logger logger = Logger.getLogger(SchedulerJobServiceImpl.class);
	@Autowired
	Scheduler scheduler;
	@Autowired
	ScheduleJobInService scheduleJobInService;

	@Autowired
	ScheduleJobMapper scheduleJobMapper;

	/**
	 * 批量更新所有任务
	 * 
	 * @param jobMap
	 *            job集合
	 */
	public void updateAll(List<ScheduleJob> jobMap) {
		for (ScheduleJob scheduleJob : jobMap) {
			try {
				// 更新单个任务
				updateJobCronSchedule(scheduleJob);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ScheduleJob> selAllScheduleJob(int before, int after) {
		List<ScheduleJob> jobList = new ArrayList<>();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyGroup();
		try {
			Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
			for (JobKey key : jobKeys) {
				List<? extends Trigger> triggers = scheduler.getTriggersOfJob(key);
				for (Trigger trigger : triggers) {
					ScheduleJob scheduleJob = getScheduleJobByJobNameAndGroup(scheduler, key, trigger);
					jobList.add(scheduleJob);
				}
			}
		} catch (SchedulerException e) {
			logger.error("[SchedulerJobServiceImpl] get the jobKeys is error:{}", e);
			// e.printStackTrace();
		}
		return jobList;
	}

	/**
	 * 获取所有的任务
	 * 
	 * @return
	 */
	@Override
	public List<ScheduleJob> getAllScheduleJob() {
		List<ScheduleJob> jobList = new ArrayList<>();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyGroup();
		try {
			Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
			for (JobKey key : jobKeys) {
				List<? extends Trigger> triggers = scheduler.getTriggersOfJob(key);
				for (Trigger trigger : triggers) {
					ScheduleJob scheduleJob = getScheduleJobByJobNameAndGroup(scheduler, key, trigger);
					jobList.add(scheduleJob);
				}
			}
		} catch (SchedulerException e) {
		}
		return jobList;
	}

	/**
	 * 获取所有运行中的任务
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	@Override
	public List<ScheduleJob> getAllRunningJob() throws SchedulerException {
		List<JobExecutionContext> executionJobList = scheduler.getCurrentlyExecutingJobs();
		List<ScheduleJob> jobList = new ArrayList<>();
		for (JobExecutionContext jobExecutionContext : executionJobList) {
			JobDetail jobDetail = jobExecutionContext.getJobDetail();
			JobKey jobKey = jobDetail.getKey();
			Trigger trigger = jobExecutionContext.getTrigger();
			ScheduleJob scheduleJob = getScheduleJob(scheduler, jobKey, trigger);
			jobList.add(scheduleJob);
		}
		return jobList;
	}

	/**
	 * 更新新的任务或者添加一个新的任务
	 * 
	 * @param scheduleJob
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void saveOrUpdate(ScheduleJob scheduleJob) throws Exception {
		System.out.println(scheduleJob.getJobName() + "group" + scheduleJob.getJobGroup());
		if (scheduleJobInService.selectByJobNameAngJobGroup(scheduleJob.getJobName(),
				scheduleJob.getJobGroup()) != null) {
			if (scheduler.getJobDetail(JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup())) == null) {
				checkNotNull(scheduleJob);
				if (StringUtils.isBlank(scheduleJob.getCronExpression())) {
					throw new Exception("[SchedulerJobServiceImpl] CronExpression不能为空");
				}
				scheduleJob.setJobStatus("NORMAL");
				Object object = ApplicationContextUtil.getBean(scheduleJob.getBeanName());
				Class cls = object.getClass();
				cls.newInstance();
				JobDetail jobDetail = JobBuilder.newJob(cls)
						.withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).build();
				jobDetail.getJobDataMap().put("scheduleJob", scheduleJob);
				CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
						.cronSchedule(scheduleJob.getCronExpression());
				CronTrigger cronTrigger = TriggerBuilder.newTrigger()
						.withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup())
						.withSchedule(cronScheduleBuilder).build();
				scheduler.scheduleJob(jobDetail, cronTrigger);
				return;
			} else {
				System.out.println("已存在JOBNAME = " + scheduleJob.getJobName() + "进行更新");
				updateJob(scheduleJob);
				return;
			}
		} else {
			addJob(scheduleJob);
		}
	}

	/**
	 * 停止运行任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 * @throws SchedulerException
	 */
	public void pauseJob(String jobName, String jobGroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		ScheduleJob scheduleJob = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
		scheduler.pauseJob(jobKey);
		if (scheduleJob.getJobStatus().equals("START")) {
			ZLTask.isRun.set(false);
		}
		scheduleJob.setJobStatus("PAUSED");
		scheduleJobInService.updateByExample(scheduleJob);
	}

	public void pauseJobByComplete(String jobName, String jobGroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		ScheduleJob scheduleJob = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
		scheduler.pauseJob(jobKey);
		scheduleJob.setJobStatus("COMPLETE");
		scheduleJobInService.updateByExample(scheduleJob);
	}

	/**
	 * 删除一个任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 * @throws SchedulerException
	 */
	public void deleteJob(String jobName, String jobGroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		scheduleJobInService.deleteByJobNameAndJobGroup(jobName, jobGroup);
		scheduler.deleteJob(jobKey);

	}

	/**
	 * 运行一个任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 * @throws SchedulerException
	 */
	public void runOneJob(String jobName, String jobGroup) throws Exception {
		ScheduleJob scheduleJob = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
		scheduleJob.setJobStatus("NORMAL");
		updateJobCronSchedule(scheduleJob);
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 重启一个任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 * @throws SchedulerException
	 */
	public void resumeJob(String jobName, String jobGroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		ScheduleJob scheduleJob = scheduleJobInService.selectByJobNameAngJobGroup(jobName, jobGroup);
		scheduleJob.setJobStatus("RESUM");
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 添加任务
	 * 
	 * @param scheduleJob
	 * @throws Exception
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addJob(ScheduleJob scheduleJob) throws Exception {
		checkNotNull(scheduleJob);
		if (StringUtils.isBlank(scheduleJob.getCronExpression())) {
			throw new Exception("[SchedulerJobServiceImpl] CronExpression不能为空");
		}
		scheduleJob.setJobStatus("NORMAL");
		Object object = ApplicationContextUtil.getBean(scheduleJob.getBeanName());
		Class cls = object.getClass();
		cls.newInstance();
		JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup())
				.build();
		jobDetail.getJobDataMap().put("scheduleJob", scheduleJob);
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).withSchedule(cronScheduleBuilder)
				.build();
		scheduler.scheduleJob(jobDetail, cronTrigger);
		scheduleJobInService.insertSelective(scheduleJob);
	}

	/**
	 * 更新一个任务
	 * 
	 * @param scheduleJob
	 * @throws Exception
	 */
	@Override
	public  void updateJobCronSchedule(ScheduleJob scheduleJob) throws Exception {
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		jobDetail.getJobDataMap().put("scheduleJob", scheduleJob);
		TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		// 按照新的Trigger重新设置job并执行1111111111
		cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder)
				.build();
		scheduler.rescheduleJob(triggerKey, cronTrigger);
		scheduleJobInService.updateByExample(scheduleJob);
	}
	/**
	 * 更新一个任务
	 * @param scheduleJob
	 * @throws Exception
	 */
	@Override
	public synchronized  void updateJob(ScheduleJob scheduleJob) {
		scheduleJobInService.updateByExample(scheduleJob);
	}

	/**
	 * 判断一个任务是否为空
	 * 
	 * @param scheduleJob
	 */
	@Override
	public void checkNotNull(ScheduleJob scheduleJob) {
		if (scheduleJob == null) {
			throw new IllegalStateException("scheduleJob is null,Please check it");
		}
		if (scheduleJob.getJobName() == null || scheduleJob.getJobName().equals("")) {
			throw new IllegalStateException("the jobName of scheduleJob is null,Please check it");
		}
		if (scheduleJob.getJobGroup() == null || scheduleJob.getJobGroup().equals("")) {
			throw new IllegalStateException("the jobGroup of scheduleJob is null,Please check it");
		}
		if (scheduleJob.getBeanName() == null || scheduleJob.getBeanName().equals("")) {
			throw new IllegalStateException("the BeanName of scheduleJob is null,Please check it");
		}

	}

	private ScheduleJob getScheduleJobByJobNameAndGroup(Scheduler schedule, JobKey jobKey, Trigger trigger) {
		ScheduleJob scheduleJob1 = null;
		try {
			ScheduleJob scheduleJob = new ScheduleJob();
			JobDetail jobDetail = scheduler.getJobDetail(jobKey);
			scheduleJob = (ScheduleJob) jobDetail.getJobDataMap().get("scheduleJob");
			scheduleJob.setJobName(jobKey.getName());
			scheduleJob.setJobGroup(jobKey.getGroup());
			scheduleJob1 = scheduleJobInService.selectByJobNameAngJobGroup(scheduleJob.getJobName(),
					scheduleJob.getJobGroup());
			if (trigger instanceof CronTrigger) {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				scheduleJob.setCronExpression(cronTrigger.getCronExpression());
			}
		} catch (Exception e) {
			logger.error("[SchedulerJobServiceImpl] method getScheduleJob get JobDetail error:{}", e);
		}
		return scheduleJob1;
	}

	private ScheduleJob getScheduleJob(Scheduler schedule, JobKey jobKey, Trigger trigger) {
		ScheduleJob scheduleJob = new ScheduleJob();
		try {
			JobDetail jobDetail = scheduler.getJobDetail(jobKey);
			scheduleJob = (ScheduleJob) jobDetail.getJobDataMap().get("scheduleJob");
			Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			scheduleJob.setJobStatus(triggerState.name());
			scheduleJob.setJobName(jobKey.getName());
			scheduleJob.setJobGroup(jobKey.getGroup());
			if (trigger instanceof CronTrigger) {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				scheduleJob.setCronExpression(cronTrigger.getCronExpression());
			}
		} catch (Exception e) {
			logger.error("[SchedulerJobServiceImpl] method getScheduleJob get JobDetail error:{}", e);
		}
		return scheduleJob;
	}

	/*
	 * All任务
	 */
	@Override
	public List<ScheduleJob> selAllJobInfo() {
		return scheduleJobMapper.selAllJobInfo();
	}

	@Override
	public int countJobInfo() {
		return scheduleJobMapper.countJobInfo();
	}

	/*
	 * 正在运行Job
	 */
	@Override
	public List<ScheduleJob> selRunJobInfo(int before, int after) {
		return scheduleJobMapper.selRunJobInfo(before, after);
	}

	@Override
	public int countRunJobInfo() {
		return scheduleJobMapper.countRunJobInfo();
	}

	@Override
	public int countJob() {
		return scheduleJobInService.countJob();
	}

}
