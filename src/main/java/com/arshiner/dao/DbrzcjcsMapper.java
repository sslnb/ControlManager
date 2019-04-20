package com.arshiner.dao;

import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.DbrzcjcsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbrzcjcsMapper {
    int countByExample(DbrzcjcsExample example);

    int deleteByExample(DbrzcjcsExample example);

    int insert(Dbrzcjcs record);

    int insertSelective(Dbrzcjcs record);

    List<Dbrzcjcs> selectByExample(DbrzcjcsExample example);

    int updateByExampleSelective(@Param("record") Dbrzcjcs record, @Param("example") DbrzcjcsExample example);

    int updateByExample(@Param("record") Dbrzcjcs record, @Param("example") DbrzcjcsExample example);
    /*无参数分页*/
    List<Dbrzcjcs> selAllSingleTable(@Param("before") int before, @Param("after") int after);

    int countSingleTable();

    /*有参数查询*/
    List<Dbrzcjcs> selSingTabByParam(@Param("before") int before, @Param("after") int after,@Param("param1")String param1);

    int countSingleTableByParam(@Param("param1") String param1);
}