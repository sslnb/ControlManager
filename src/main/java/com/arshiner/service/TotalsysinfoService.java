package com.arshiner.service;

import com.arshiner.model.Totalsysinfo;

import java.util.List;


/**
 * @author Enernity
 * @date 2019-01-28  14:40
 */
public interface TotalsysinfoService {

	/*数据集合*/
	List<Totalsysinfo> allInfo();

	/*新增*/
	int insSysInfo(Totalsysinfo totalSysInfo);
	
	int insertSelective(Totalsysinfo record);

    List<Totalsysinfo> selectByExample(Totalsysinfo record);

    int updateByExampleSelective(Totalsysinfo record);
    
    void saveOrupdate(Totalsysinfo record);
}
