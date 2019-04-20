package com.arshiner.service;

import com.arshiner.model.Dbrzcjcs;

import java.util.List;
import java.util.Map;


public interface DbrzcjcsService {
    int countByExample();

    int deleteByExample(Dbrzcjcs record);
    int deleteNotIn(List<Dbrzcjcs>  record ,String jgxtlb);

    int insert(Dbrzcjcs record);

    int insertSelective(Dbrzcjcs record);

    List<Dbrzcjcs> selectByExample(Dbrzcjcs record);
    List<Dbrzcjcs> selectByBMANDJGXTLB(Dbrzcjcs record);
    
    int updateByExampleSelective(Dbrzcjcs record);

    int updateByExample(Dbrzcjcs record);
     List<Dbrzcjcs> selectByJgxtlb(Dbrzcjcs record);

    /*无参数分页*/
    List<Dbrzcjcs> selAllSingleTable(int before, int after);

    int countSingleTable();

    /*有参数查询*/
    List<Dbrzcjcs> selSingTabByParam(int before, int after,String param1);

    int countSingleTableByParam(String param1);
  //save or update
    boolean saveorupdate(Dbrzcjcs record);
}
