package com.arshiner.service.impl;

import com.arshiner.dao.TotalsysinfoMapper;
import com.arshiner.model.Totalsysinfo;
import com.arshiner.model.TotalsysinfoExample;
import com.arshiner.service.TotalsysinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Enernity
 * @date 2019-01-28  14:41
 */
@Service(value = "totalSysinfoService")
public class TotalSysInfoServiceImpl implements TotalsysinfoService {

	@Resource
	private TotalsysinfoMapper totalSysInfoMapper;


	@Override
	public List<Totalsysinfo> allInfo() {
		return totalSysInfoMapper.allInfo();
	}

	@Override
	public int insSysInfo(Totalsysinfo totalSysInfo) {
		return totalSysInfoMapper.insertSelective(totalSysInfo);
	}

	@Override
	public int insertSelective(Totalsysinfo record) {
		// TODO Auto-generated method stub
		return totalSysInfoMapper.insertSelective(record);
	}

	@Override
	public List<Totalsysinfo> selectByExample(Totalsysinfo record) {
		TotalsysinfoExample example = new TotalsysinfoExample();
		example.createCriteria().andInstimeEqualTo(record.getInstime());
		return totalSysInfoMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Totalsysinfo record) {
		// TODO Auto-generated method stub
		TotalsysinfoExample example = new TotalsysinfoExample();
		example.createCriteria().andInstimeEqualTo(record.getInstime());
		return totalSysInfoMapper.updateByExampleSelective(record, example);
	}

	@Override
	public void saveOrupdate(Totalsysinfo record) {
		List<Totalsysinfo> sysinfos = selectByExample(record);
		if (sysinfos!=null&&!sysinfos.isEmpty()) {
			updateByExampleSelective(record);
		}else{
			insertSelective(record);
		}
	}
}
