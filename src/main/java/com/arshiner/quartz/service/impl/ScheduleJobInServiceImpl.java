package com.arshiner.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.ScheduleJobMapper;
import com.arshiner.model.ScheduleJob;
import com.arshiner.model.ScheduleJobExample;
import com.arshiner.quartz.service.ScheduleJobInService;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author 士林
 *
 */
@Service("scheduleJobInService")
public class ScheduleJobInServiceImpl implements ScheduleJobInService {

    @Autowired
    ScheduleJobMapper scheduleJobMapper;

    @Override
    public int insert(ScheduleJob scheduleJob) {
        int id = scheduleJobMapper.insertSelective(scheduleJob);
        return id;
    }

    @Override
    public int insertSelective(ScheduleJob scheduleJob) {
        int id = scheduleJobMapper.insertSelective(scheduleJob);
        return id;
    }
    @Override
    public synchronized  ScheduleJob selectByJobNameAngJobGroup(String jobName, String groupName) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobGroupEqualTo(groupName).andJobNameEqualTo(jobName);
        List<ScheduleJob> list = scheduleJobMapper.selectByExample(scheduleJobExample);
        if (null!=list&&!list.isEmpty()){
            return list.get(0);
        }else{
        	return null;
        }
    }

    @Override
    public ScheduleJob selectByPrimaryKey(BigDecimal id) {
        return scheduleJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ScheduleJob scheduleJob) {
        return scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob);
    }

    @Override
    public int updateByExample(ScheduleJob scheduleJob) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobNameEqualTo(scheduleJob.getJobName()).andJobGroupEqualTo(scheduleJob.getJobGroup());
        return scheduleJobMapper.updateByExample(scheduleJob, scheduleJobExample);
    }
    @Override
    public int deleteByPrimaryKey(BigDecimal id) {
        return scheduleJobMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int deleteByJobNameAndJobGroup(String jobName, String jobGroup) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobGroupEqualTo(jobGroup).andJobNameEqualTo(jobName);
        return scheduleJobMapper.deleteByExample(scheduleJobExample);
    }

    @Override
    public int countJob() {
        return scheduleJobMapper.countByExample(null);
    }
}
