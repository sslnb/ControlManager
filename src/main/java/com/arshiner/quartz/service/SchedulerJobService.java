package com.arshiner.quartz.service;

import org.quartz.SchedulerException;

import com.arshiner.model.ScheduleJob;

import java.util.List;

/**
 * 
 * @author 士林
 *
 */
public interface SchedulerJobService {
    List<ScheduleJob> selAllScheduleJob(int before,  int after);

    List<ScheduleJob> getAllScheduleJob();

    void checkNotNull(ScheduleJob scheduleJob);

    List<ScheduleJob> getAllRunningJob() throws SchedulerException;
    void saveOrUpdate(ScheduleJob scheduleJob) throws Exception;

    public void pauseJob(String jobName, String jobGroup) throws SchedulerException;

    public void deleteJob(String jobName, String jobGroup) throws SchedulerException;

    public void runOneJob(String jobName, String jobGroup) throws Exception;

    public void resumeJob(String jobName, String jobGroup) throws SchedulerException;

    public void pauseJobByComplete(String jobName, String jobGroup) throws SchedulerException;


	//count数
    int countJob();

    /*ALl任务*/
    List<ScheduleJob> selAllJobInfo();
    int countJobInfo();

    /*正在运行任务*/
    List<ScheduleJob> selRunJobInfo(int before,int after);
    int countRunJobInfo();

	void updateJobCronSchedule(ScheduleJob scheduleJob) throws Exception;

	void updateJob(ScheduleJob scheduleJob);



}
