package com.arshiner.service;

import com.arshiner.model.Cjrjxt;

import java.util.List;


/**
 * @Author: MDK
 * @Description: TODO
 * @Date: 2018-10-24 10:10
 * @Version: 1.0
 */
public interface CjrjxtService {
    int countByExample();

    int deleteByExample(Cjrjxt record);

    int insert(Cjrjxt record);

    int insertSelective(Cjrjxt record);

    List<Cjrjxt> selectByExample();

    int updateByExampleSelective(Cjrjxt record);

    int updateByExample(Cjrjxt record);

	List<Cjrjxt> selectByExample(Cjrjxt record);
}
