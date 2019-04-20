package com.arshiner.dao;

import com.arshiner.model.Dbconpro;
import com.arshiner.model.DbconproExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbconproMapper {
    int countByExample(DbconproExample example);

    int deleteByExample(DbconproExample example);

    int insert(Dbconpro record);

    int insertSelective(Dbconpro record);

    List<Dbconpro> selectByExample(DbconproExample example);



    int updateByExampleSelective(@Param("record") Dbconpro record, @Param("example") DbconproExample example);

    int updateByExample(@Param("record") Dbconpro record, @Param("example") DbconproExample example);


    List<Dbconpro> selAllDbconnpro(@Param("before") int before, @Param("after") int after);

    /*全部*/
    List<Dbconpro> selAimsData(@Param("before") int before, @Param("after") int after);

    /*count数*/
    int countAimsData();

    //模糊
    List<Dbconpro> selAimsDataByParam(@Param("before") int before, @Param("after") int after,@Param("param1")String param1,@Param("param2")String param2);

    //模糊Count
    int countByParam(@Param("param1")String param1,@Param("param2")String param2);

    /*添加*/
    int insAimsData(Dbconpro dbconpro);

    /*修改*/
    int updAimsData(Dbconpro dbconpro);

}