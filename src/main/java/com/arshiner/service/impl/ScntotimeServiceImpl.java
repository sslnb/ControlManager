package com.arshiner.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.ScntotimeMapper;
import com.arshiner.model.Scntotime;
import com.arshiner.model.ScntotimeExample;
import com.arshiner.service.ScntotimeService;
@Service("scntotimeService")
public class ScntotimeServiceImpl implements ScntotimeService{

	@Autowired
	ScntotimeMapper scntotimeMapper;
	@Override
	public int countByExample(Scntotime record) {
		// TODO Auto-generated method stub
		ScntotimeExample example = new ScntotimeExample();
		return scntotimeMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Scntotime record) {
		// TODO Auto-generated method stub
		ScntotimeExample example = new ScntotimeExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return 9;
	}

	@Override
	public int insert(Scntotime record) {
		// TODO Auto-generated method stub
		ScntotimeExample example = new ScntotimeExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return scntotimeMapper.insertSelective(record);
	}

	@Override
	public int insertSelective(Scntotime record) {
		// TODO Auto-generated method stub
		return scntotimeMapper.insertSelective(record);
	}

	@Override
	public List<Scntotime> selectByExample(Scntotime record) {
		// TODO Auto-generated method stub
		ScntotimeExample example = new ScntotimeExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andTimeEqualTo(record.getTime());
		return scntotimeMapper.selectByExample(example);
	}
	public Timestamp getTime() {
		Date utilDate = new Date();// util.Date
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}
	@Override
	public int updateByExampleSelective(Scntotime record) {
		// TODO Auto-generated method stub
		ScntotimeExample example = new ScntotimeExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return scntotimeMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExample(Scntotime record) {
		// TODO Auto-generated method stub
		ScntotimeExample example = new ScntotimeExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return scntotimeMapper.updateByExample(record, example);
	}

	@Override
	public void saveOrupdate(Scntotime record) {
		// TODO Auto-generated method stub
		List<Scntotime> scnlist = selectByExample(record);
		if (scnlist==null||scnlist.isEmpty()) {
			insert(record);
		}else{
			updateByExampleSelective(record);
		}
	}
	
}
