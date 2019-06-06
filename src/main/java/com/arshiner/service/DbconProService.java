package com.arshiner.service;

import java.util.List;


import com.arshiner.model.Dbconpro;
import org.apache.ibatis.annotations.Param;

public interface DbconProService {

    int countByExample();

    int deleteByExample(Dbconpro record);

    int insert(Dbconpro record);

    int insertSelective(Dbconpro record);

    List<Dbconpro> selectByExample(Dbconpro record);
    List<Dbconpro> selectByExample();
    List<Dbconpro> selectByLikeJgxtlb(String jgxtlb);


    /*全部*/
    List<Dbconpro> selAimsData(@Param("before") int before, @Param("after") int after);

    /*count数*/
    int countAimsData();

    List<Dbconpro> selAimsDataByParam(int before,int after,String param1,String param2);

    int countByParam(String param1,String param2);

    /*添加*/
    int insAimsData(Dbconpro dbconpro);

    /*修改*/
    int updAimsData(Dbconpro dbconpro);

    int updateByExampleSelective(Dbconpro record);

    int updateByExample(Dbconpro record);
}
