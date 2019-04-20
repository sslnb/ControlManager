package com.arshiner.dao;

import com.arshiner.model.ScheduleJob;
import com.arshiner.model.ScheduleJobExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleJobMapper {
    int countByExample(ScheduleJobExample example);

    int deleteByExample(ScheduleJobExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(ScheduleJob record);

    int insertSelective(ScheduleJob record);

    List<ScheduleJob> selectByExample(ScheduleJobExample example);

    ScheduleJob selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") ScheduleJob record, @Param("example") ScheduleJobExample example);

    int updateByExample(@Param("record") ScheduleJob record, @Param("example") ScheduleJobExample example);

    int updateByPrimaryKeySelective(ScheduleJob record);

    int updateByPrimaryKey(ScheduleJob record);


    /*正在运行任务*/
    List<ScheduleJob> selAllJobInfo();
    int countJobInfo();
    /*正在运行任务*/
    List<ScheduleJob> selRunJobInfo(@Param("before") int before,@Param("after")int after);
    int countRunJobInfo();

}