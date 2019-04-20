package com.arshiner.dao;

import com.arshiner.model.Ddlsjsjb;
import com.arshiner.model.DdlsjsjbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DdlsjsjbMapper {
    int countByExample(DdlsjsjbExample example);

    int deleteByExample(DdlsjsjbExample example);

    int insert(Ddlsjsjb record);

    int insertSelective(Ddlsjsjb record);

    List<Ddlsjsjb> selectByExample(DdlsjsjbExample example);

    int updateByExampleSelective(@Param("record") Ddlsjsjb record, @Param("example") DdlsjsjbExample example);

    int updateByExample(@Param("record") Ddlsjsjb record, @Param("example") DdlsjsjbExample example);
    /*无参数分页*/
    List<Ddlsjsjb> selAllDdlsjsj(@Param("before") int before, @Param("after") int after);

    int countDdlsjsj();

    /*有参数查询*/
    List<Ddlsjsjb> selDdlsjsjByParam(@Param("before") int before, @Param("after") int after,@Param("param1")String param1,@Param("param2")String param2,@Param("param3")String param3);

    int countDdlsjsjByParam(@Param("param1")String param1,@Param("param2")String param2,@Param("param3")String param3);

}