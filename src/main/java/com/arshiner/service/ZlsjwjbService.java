package com.arshiner.service;

import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Zlsjwjb;

import java.math.BigDecimal;
import java.util.List;


public interface ZlsjwjbService {
	int countByExample();
	int countByExample(Zlsjwjb record);

	int deleteByExample(Zlsjwjb record);

	int insert(Zlsjwjb record);

	int insertSelective(Zlsjwjb record);

	List<Zlsjwjb> selectByExample(Zlsjwjb record);
	List<Zlsjwjb> selectByWjm(Zlsjwjb record);
	String selectSYwjm(String jgxtlb,String oldZl);
	//文件状态
	List<Zlsjwjb> selectwjzt(Zlsjwjb record);
	//文件状态
	List<Zlsjwjb> selectwjzt1(Zlsjwjb record);
	//文件重传
	List<Zlsjwjb> selectChongchuan(Zlsjwjb record);

	int updateByExampleSelective(Zlsjwjb record);

	int updateByExample(Zlsjwjb record);
	int updateByWjzt(Zlsjwjb record);
	/* 自定义 */
	List<Zlsjwjb> selAllZlsjwjb(int before, int after);

	int countZlsjwjb();

	List<Zlsjwjb> selZlsjwjbByParam(int before, int after, String param1);

	int countZlsjwjbByParam(String param1);

	List<Zlsjwjb> selectByZCSB(Zlsjwjb zlsjwj);

	BigDecimal countZlwjs(String jgxtlb);
	BigDecimal countZlwjscs(String jgxtlb);
	BigDecimal countZZInsert(String jgxtlb);

	BigDecimal countZUpdate(String jgxtlb);

	BigDecimal countZDelete(String jgxtlb);
	void saveOrupdate(Zlsjwjb zlsjwjb);
	List<Zlsjwjb> selectByYCSB(Zlsjwjb zlsjwj);
	int reNameWjm(String old, Zlsjwjb record);
	String selectSYwjm0(String jgxtlb,String like,String zlwjm);
	//新增0415
	int deleteBywjmBIG(String wjm , String jgxtlb);
	List<Zlsjwjb> selectOrderByWjm(Zlsjwjb record);
}
