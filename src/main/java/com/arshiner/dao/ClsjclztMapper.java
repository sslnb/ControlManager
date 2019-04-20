package com.arshiner.dao;

import com.arshiner.model.Clsjclzt;
import com.arshiner.model.ClsjclztExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClsjclztMapper {
    int countByExample(ClsjclztExample example);

    int deleteByExample(ClsjclztExample example);

    int insert(Clsjclzt record);

    int insertSelective(Clsjclzt record);

    List<Clsjclzt> selectByExample(ClsjclztExample example);

    int updateByExampleSelective(@Param("record") Clsjclzt record, @Param("example") ClsjclztExample example);

    int updateByExample(@Param("record") Clsjclzt record, @Param("example") ClsjclztExample example);
    /*自定义*/
    /*无参数分页*/
    List<Clsjclzt> selAllClsjclzt(@Param("before") int before, @Param("after") int after);

    int countClsjclzt();
    int countCJL(@Param("jgxtlb")String jgxtlb);
    int countSJZL(@Param("jgxtlb")String jgxtlb);
    int countWJZL(@Param("jgxtlb")String jgxtlb);
   
    /*有参数查询*/
    List<Clsjclzt> selClsjclztByParam(@Param("before") int before, @Param("after") int after,@Param("param1")String param1,@Param("param2")String param2);

    int countClsjclztByParam(@Param("param1")String param1,@Param("param2")String param2);
}