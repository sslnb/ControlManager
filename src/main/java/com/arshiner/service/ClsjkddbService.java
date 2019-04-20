package com.arshiner.service;

import com.arshiner.model.Clsjkddb;

import java.util.List;


/**
 * 存量数据块断点表
 * @author 士林
 *
 */
public interface ClsjkddbService {
    int countByExample();

    int deleteByExample(Clsjkddb record);
    
    int deleteBylikeJgxtlb(Clsjkddb record);

    int insert(Clsjkddb record);

    int insertSelective(Clsjkddb record);

    List<Clsjkddb> selectBybmAndJGXTLB(Clsjkddb record);
    List<Clsjkddb> selectBybmAndJgxtlbAndsjkbh(Clsjkddb record);

    List<Clsjkddb> selectByWcbj(Clsjkddb record);

    int updateByExampleSelective(Clsjkddb record);

    int updateByExample(Clsjkddb record);
    void saveOrupdate(Clsjkddb record);

	List<Clsjkddb> selectBysbzt(Clsjkddb clsjkddb);

	int deleteByBMandJGXTLB(Clsjkddb record);
}
