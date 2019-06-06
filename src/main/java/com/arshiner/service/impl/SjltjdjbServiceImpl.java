package com.arshiner.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.SjltjdjbMapper;
import com.arshiner.model.Sjltjdjb;
import com.arshiner.model.SjltjdjbExample;
import com.arshiner.service.SjltjdjbService;
@Service("sjltjdjbService")
public class SjltjdjbServiceImpl implements SjltjdjbService {

	private static final Logger logger = Logger.getLogger(SjltjdjbServiceImpl.class);	
	@Autowired
	SjltjdjbMapper sjltjdjbMapper;
	@Override
	public int countByExample(Sjltjdjb record) {
		SjltjdjbExample example =new SjltjdjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return sjltjdjbMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Sjltjdjb record) {
		// TODO Auto-generated method stub
		SjltjdjbExample example =new SjltjdjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return  sjltjdjbMapper.deleteByExample(example);
	}

	@Override
	public int insert(Sjltjdjb record) {
		return sjltjdjbMapper.insertSelective(record);
	}

	@Override
	public int insertSelective(Sjltjdjb record) {
		// TODO Auto-generated method stub
		return sjltjdjbMapper.insertSelective(record);
	}

	/**
	 * 根据KBBH JGXTLB  BM  查询
	 */
	@Override
	public List<Sjltjdjb> selectByExample(Sjltjdjb record) {
		// TODO Auto-generated method stub
		SjltjdjbExample example =new SjltjdjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return sjltjdjbMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Sjltjdjb record) {
		// TODO Auto-generated method stub
		SjltjdjbExample example =new SjltjdjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return sjltjdjbMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Sjltjdjb record) {
		SjltjdjbExample example =new SjltjdjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return sjltjdjbMapper.updateByExampleSelective(record, example);
	}

	@Override
	public void saveOrupdate(Sjltjdjb record) {
		// TODO Auto-generated method stub
		List<Sjltjdjb> list = selectByExample(record);
		if (null!=list&&!list.isEmpty()) {
			updateByExampleSelective(record);
		}else{
			insertSelective(record);
		}
	}

}
