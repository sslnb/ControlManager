package com.arshiner.dao;

import com.arshiner.model.Zlsjwjb;
import com.arshiner.model.ZlsjwjbExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlsjwjbMapper {
    int countByExample(ZlsjwjbExample example);

    int deleteByExample(ZlsjwjbExample example);

    int insert(Zlsjwjb record);

    int insertSelective(Zlsjwjb record);

    List<Zlsjwjb> selectByExample(ZlsjwjbExample example);

    int updateByExampleSelective(@Param("record") Zlsjwjb record, @Param("example") ZlsjwjbExample example);

    int updateByExample(@Param("record") Zlsjwjb record, @Param("example") ZlsjwjbExample example);
    /*自定义*/
    List<Zlsjwjb> selAllZlsjwjb(@Param("before")int before, @Param("after")int after);

    int countZlsjwjb();

    List<Zlsjwjb> selZlsjwjbByParam(@Param("before")int before,@Param("after")int after,@Param("param1")String param1);

    int countZlsjwjbByParam(@Param("param1")String param1);
    
    String selectSYwjm0(@Param("jgxtlb")String jgxtlb,@Param("like")String like,@Param("zlwjm")String zlwjm);
    BigDecimal countZlwjscs(@Param("jgxtlb")String jgxtlb);
    BigDecimal countZlwjs(@Param("jgxtlb")String jgxtlb);
    BigDecimal countZZInsert(@Param("jgxtlb")String jgxtlb);
    BigDecimal countZUpdate(@Param("jgxtlb")String jgxtlb);
    BigDecimal countZDelete(@Param("jgxtlb")String jgxtlb);

	String selectSYwjm(@Param("jgxtlb")String jgxtlb, @Param("oldZl")String oldZl);
}