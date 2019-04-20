package com.arshiner.dao;

import com.arshiner.model.Cjrjxt;
import com.arshiner.model.CjrjxtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CjrjxtMapper {
    int countByExample(CjrjxtExample example);

    int deleteByExample(CjrjxtExample example);

    int insert(Cjrjxt record);

    int insertSelective(Cjrjxt record);

    List<Cjrjxt> selectByExample(CjrjxtExample example);

    int updateByExampleSelective(@Param("record") Cjrjxt record, @Param("example") CjrjxtExample example);

    int updateByExample(@Param("record") Cjrjxt record, @Param("example") CjrjxtExample example);
}