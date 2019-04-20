package com.arshiner.dao;

import com.arshiner.model.Zlsjddb;
import com.arshiner.model.ZlsjddbExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlsjddbMapper {
    int countByExample(ZlsjddbExample example);

    int deleteByExample(ZlsjddbExample example);

    int insert(Zlsjddb record);

    int insertSelective(Zlsjddb record);

    List<Zlsjddb> selectByExample(ZlsjddbExample example);

    int updateByExampleSelective(@Param("record") Zlsjddb record, @Param("example") ZlsjddbExample example);

    int updateByExample(@Param("record") Zlsjddb record, @Param("example") ZlsjddbExample example);
    
   //
   BigDecimal selectNewseq(@Param("jgxtlb") String jgxtlb);
}