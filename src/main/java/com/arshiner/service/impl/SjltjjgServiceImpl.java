package com.arshiner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.SjltjjgMapper;
import com.arshiner.model.Sjltjjg;
import com.arshiner.model.SjltjjgExample;
import com.arshiner.service.SjltjjgService;
@Service("sjltjjgService")
public class SjltjjgServiceImpl implements SjltjjgService {

	
	@Autowired
	SjltjjgMapper  sjltjjgMapper;
	
	@Override
	public int countByExample(Sjltjjg record) {
		SjltjjgExample example = new SjltjjgExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return sjltjjgMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Sjltjjg record) {
		SjltjjgExample example = new SjltjjgExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm()).andHdphEqualTo(record.getHdph());
		return sjltjjgMapper.deleteByExample(example);
	}

	@Override
	public int insert(Sjltjjg record) {
		// TODO Auto-generated method stub
		return sjltjjgMapper.insertSelective(record);
	}

	@Override
	public int insertSelective(Sjltjjg record) {
		// TODO Auto-generated method stub
		return sjltjjgMapper.insertSelective(record);
	}

	@Override
	public List<Sjltjjg> selectByExample(Sjltjjg record) {
		// TODO Auto-generated method stub
		SjltjjgExample example = new SjltjjgExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm());
		return sjltjjgMapper.selectByExample(example);
	}
	@Override
	public List<Sjltjjg> selectBySbzt(Sjltjjg record) {
		// TODO Auto-generated method stub
		SjltjjgExample example = new SjltjjgExample();
		example.createCriteria().andSbztEqualTo(record.getSbzt());
		return sjltjjgMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Sjltjjg record) {
		// TODO Auto-generated method stub
		SjltjjgExample example = new SjltjjgExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm());
		return sjltjjgMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(Sjltjjg record) {
		// TODO Auto-generated method stub
		SjltjjgExample example = new SjltjjgExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm());
		return sjltjjgMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int saveOrupdate(Sjltjjg record) {
		List<Sjltjjg> jglist = selectByExample(record);
		if (null!=jglist&&!jglist.isEmpty()) {
			
			updateByExampleSelective(record);
		} else {
			System.out.println("jglist:---"+jglist);
			insertSelective(record);
		}
		return 0;
	}

}
