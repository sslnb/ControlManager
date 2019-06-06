package com.arshiner.service;

import com.arshiner.model.Exeception;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author mdk
 * @Date: 10:09 2018/12/3
 * @Description: (类描述)
 */
public interface ExeceptionService {

    int deleteByExample(Exeception record);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Exeception record);

    int insertSelective(Exeception record);

    List<Exeception> selectByExample(Exeception record);

    Exeception selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(Exeception record);

    int updateByExample(Exeception record);

    List<Exeception> selAllExeception(int before,int after);

    int countExeception();

    List<Exeception> haveSelExeception(int before,int after,String sel_1);

    int haveCountExeception(String sel_1);
    
    void saveOrupdate(Exeception record);

}
