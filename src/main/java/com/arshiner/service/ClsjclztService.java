package com.arshiner.service;

import com.arshiner.model.Clsjclzt;

import java.util.List;


/**
 * 存量数据处理状态
 * @author 士林
 *
 */
public interface ClsjclztService {
    int countByExample();
    int deleteBylikeJgxtlb(Clsjclzt record);

    int insert(Clsjclzt record);

    int insertSelective(Clsjclzt record);

    List<Clsjclzt> selectByExample(Clsjclzt record);
    List<Clsjclzt> selectByZT(Clsjclzt record);
    List<Clsjclzt> selectByCJZT(Clsjclzt record);
    List<Clsjclzt> selectByRKZT(Clsjclzt record);

    int updateByExampleSelective(Clsjclzt record);

    int updateByExample(Clsjclzt record);
    void saveOrupdate(Clsjclzt record);

    /*自定义*/
    /*无参数分页*/
    List<Clsjclzt> selAllClsjclzt(int before,  int after);

    int countClsjclzt();
    /**
     * 已采集量
     * @return
     */
    int sumycjcjl(String jgxtlb);
    int countSJZL(String jgxtlb);
    int countWJZL(String jgxtlb);
    
    /*有参数查询*/
    List<Clsjclzt> selClsjclztByParam(int before, int after,String param1,String param2);

    int countClsjclztByParam(String param1,String param2);
	List<Clsjclzt> selectByCJWCZT(Clsjclzt record);
	List<Clsjclzt> selectByCJZTStatus(Clsjclzt record);
	List<Clsjclzt> selectBysbzt(Clsjclzt clsjclzt);
	List<Clsjclzt> selectByJgxtlb(Clsjclzt clzt);
	/*后添加*/
	/*添加方法,用于查询当前数据量*/
	int selSjlByBm(String bm,String jbxtlb);
}
