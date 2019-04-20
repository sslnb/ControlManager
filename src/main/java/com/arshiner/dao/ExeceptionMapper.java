package com.arshiner.dao;

import com.arshiner.model.Exeception;
import com.arshiner.model.ExeceptionExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExeceptionMapper {
    int countByExample(ExeceptionExample example);

    int deleteByExample(ExeceptionExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Exeception record);

    int insertSelective(Exeception record);

    List<Exeception> selectByExample(ExeceptionExample example);

    Exeception selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Exeception record, @Param("example") ExeceptionExample example);

    int updateByExample(@Param("record") Exeception record, @Param("example") ExeceptionExample example);

    int updateByPrimaryKeySelective(Exeception record);

    int updateByPrimaryKey(Exeception record);

    List<Exeception> selAllExeception(@Param("before") int before, @Param("after") int after);

    int countExeception();

    List<Exeception> haveSelExeception(@Param("before") int before, @Param("after") int after,@Param("sel_1") String sel_1);

    int haveCountExeception(@Param("sel_1") String sel_1);
}