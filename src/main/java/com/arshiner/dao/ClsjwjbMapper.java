package com.arshiner.dao;

import com.arshiner.model.Clsjwjb;
import com.arshiner.model.ClsjwjbExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClsjwjbMapper {
    int countByExample(ClsjwjbExample example);

    int deleteByExample(ClsjwjbExample example);

    int insert(Clsjwjb record);

    int insertSelective(Clsjwjb record);

    List<Clsjwjb> selectByExample(ClsjwjbExample example);

    int updateByExampleSelective(@Param("record") Clsjwjb record, @Param("example") ClsjwjbExample example);

    int updateByExample(@Param("record") Clsjwjb record, @Param("example") ClsjwjbExample example);
    /*自定义*/
    List<Clsjwjb> selAllClsjwjb(@Param("before")int before,@Param("after")int after);
    int countClsjwjb();

    BigDecimal countclsjwjByJGXGLB(@Param("jgxtlb")String jgxtlb);
    BigDecimal countclsjwjsclByJGXGLB(@Param("jgxtlb")String jgxtlb);

    List<Clsjwjb> selClsjwjbByParam(@Param("before")int before,@Param("after")int after,@Param("param1")String param1,@Param("param2")String param2);
    int countClsjwjbByParam(@Param("param1")String param1,@Param("param2")String param2);

    BigDecimal sumSJZL(@Param("record")String jgxtlb, @Param("bm")String bm);
}