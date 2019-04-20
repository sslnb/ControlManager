package com.arshiner.quartz.service;

import java.math.BigDecimal;

import com.arshiner.model.ScheduleJob;
/**
 * 
 * @author 士林
 *
 */
public interface ScheduleJobInService {

    int insert(ScheduleJob scheduleJob);

    int insertSelective(ScheduleJob scheduleJob);

    ScheduleJob selectByJobNameAngJobGroup(String jobName, String groupName);

    ScheduleJob selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKey(ScheduleJob scheduleJob);

    int updateByExample(ScheduleJob scheduleJob);

    int deleteByPrimaryKey(BigDecimal id);

    int deleteByJobNameAndJobGroup(String jobName, String jobGroup);

  //count数
    int countJob();

}
