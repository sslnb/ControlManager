package com.arshiner.service;

import com.arshiner.model.Rzcjqjcs;

import java.util.List;



public interface RzcjqjcsService {
    int countByExample();

    int deleteByExample(Rzcjqjcs record);

    int insert(Rzcjqjcs record);

    int insertSelective(Rzcjqjcs record);

    List<Rzcjqjcs> selectByExample(Rzcjqjcs record);
    /**
     * 通过关键字查询
     * @param record
     * @return
     */
    List<Rzcjqjcs>  selectByGjz(Rzcjqjcs record);
    List<Rzcjqjcs>  selectByGjzandLikeJgxtlb(Rzcjqjcs record);
    int updateByExampleSelective(Rzcjqjcs record);

    int updateByExample(Rzcjqjcs record);

    /*无参数分页*/
    List<Rzcjqjcs> selAllRzcjqjcs(int before, int after);
    
    int countRzcjqjcs();
    //save or update
    void saveorupdate(Rzcjqjcs record);

	List<Rzcjqjcs> selectByCsmc(Rzcjqjcs record) throws NullPointerException;
}
