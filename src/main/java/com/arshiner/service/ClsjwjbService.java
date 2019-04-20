package com.arshiner.service;

import com.arshiner.model.Clsjwjb;

import java.math.BigDecimal;
import java.util.List;


public interface ClsjwjbService {
    int countByExample();

    int deleteByExample(Clsjwjb record);

    int insert(Clsjwjb record);

    int insertSelective(Clsjwjb record);

    List<Clsjwjb> selectByExample(Clsjwjb record);
    
    List<Clsjwjb> selectByWJm(Clsjwjb record);

    int updateByExampleSelective(Clsjwjb record);

    int updateByExample(Clsjwjb record);

    /*自定义*/
    List<Clsjwjb> selAllClsjwjb(int before,int after);

    int countClsjwjb();

    BigDecimal countclsjwjByJGXGLB(String jgxtlb);
    int countclsjwjByJGXGLBAndBM(String jgxtlb,String bm);
    BigDecimal countclsjwjsclByJGXGLB(String jgxtlb);

    /*多条件查询*/
    List<Clsjwjb> selClsjwjbByParam(int before,int after,String param1,String param2);

    int countClsjwjbByParam(String param1,String param2);

	void saveOrupdate(Clsjwjb record1);
	List<Clsjwjb> selectByWjzt(Clsjwjb record);
	
	List<Clsjwjb> selectByrkzt(Clsjwjb record);
	BigDecimal sumSJZL(Clsjwjb record);

	int deleteBylikeJgxtlb(Clsjwjb wjb);

	int deleteByBMandJGXTLB(Clsjwjb record);
	
}
