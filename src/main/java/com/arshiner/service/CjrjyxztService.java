package com.arshiner.service;

import com.arshiner.model.Cjrjyxzt;

import java.util.List;


/**
 * @Author: MDK
 * @Description: TODO
 * @Date: 2018-10-24 10:20
 * @Version: 1.0
 */
public interface CjrjyxztService {
    int countByExample();

    int deleteByExample(Cjrjyxzt record);

    int insert(Cjrjyxzt record);

    int insertSelective(Cjrjyxzt record);

    List<Cjrjyxzt> selectByExample(Cjrjyxzt record);

    int updateByExampleSelective(Cjrjyxzt record);

    int updateByExample(Cjrjyxzt record);

	void saveOrupdate(Cjrjyxzt cjrjyxzt);
}
