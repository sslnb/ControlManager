package com.arshiner.dao;

import com.arshiner.model.Clsjkddb;
import com.arshiner.model.ClsjkddbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClsjkddbMapper {
    int countByExample(ClsjkddbExample example);

    int deleteByExample(ClsjkddbExample example);

    int insert(Clsjkddb record);

    int insertSelective(Clsjkddb record);

    List<Clsjkddb> selectByExample(ClsjkddbExample example);

    int updateByExampleSelective(@Param("record") Clsjkddb record, @Param("example") ClsjkddbExample example);

    int updateByExample(@Param("record") Clsjkddb record, @Param("example") ClsjkddbExample example);
}