package com.arshiner.dao;

import com.arshiner.model.Babh;
import com.arshiner.model.BabhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BabhMapper {
    int countByExample(BabhExample example);

    int deleteByExample(BabhExample example);

    int insert(Babh record);

    int insertSelective(Babh record);

    List<Babh> selectByExample(BabhExample example);

    int updateByExampleSelective(@Param("record") Babh record, @Param("example") BabhExample example);

    int updateByExample(@Param("record") Babh record, @Param("example") BabhExample example);
    
    List<Babh> selAllBaBh(@Param("before") int before, @Param("after") int after);

    int countBaBh();
}