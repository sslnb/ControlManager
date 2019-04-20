package com.arshiner.dao;

import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.RzcjqjcsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RzcjqjcsMapper {
    int countByExample(RzcjqjcsExample example);

    int deleteByExample(RzcjqjcsExample example);

    int insert(Rzcjqjcs record);

    int insertSelective(Rzcjqjcs record);

    List<Rzcjqjcs> selectByExample(RzcjqjcsExample example);

    int updateByExampleSelective(@Param("record") Rzcjqjcs record, @Param("example") RzcjqjcsExample example);

    int updateByExample(@Param("record") Rzcjqjcs record, @Param("example") RzcjqjcsExample example);
    
    /*无参数分页*/
    List<Rzcjqjcs> selAllRzcjqjcs(@Param("before") int before, @Param("after") int after);
    int countRzcjqjcs();



}