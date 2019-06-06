package com.arshiner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.HdsjwjxxbMapper;
import com.arshiner.model.Hdsjwjxxb;
import com.arshiner.model.HdsjwjxxbExample;
import com.arshiner.service.HdsjwjxxbService;
@Service("hdsjwjxxbService")
public class HdsjwjxxbServiceImpl implements HdsjwjxxbService {

	@Autowired
	HdsjwjxxbMapper  hdsjwjxxbMapper;
	
	@Override
	public int countByExample(Hdsjwjxxb record) {
		// TODO Auto-generated method stub
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andHdphEqualTo(record.getHdph())
		.andJgxtlbEqualTo(record.getJgxtlb()).andBmEqualTo(record.getBm());
		return hdsjwjxxbMapper.countByExample(example);
	}

	/**
	 * 根据文件名进行删除
	 */
	@Override
	public int deleteByExample(Hdsjwjxxb record) {
		// TODO Auto-generated method stub
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andWjmEqualTo(record.getWjm());
		return hdsjwjxxbMapper.deleteByExample(example);
	}
		
	@Override
	public int insert(Hdsjwjxxb record) {
		// TODO Auto-generated method stub
		return hdsjwjxxbMapper.insert(record);
	}

	@Override
	public int insertSelective(Hdsjwjxxb record) {
		// TODO Auto-generated method stub
		return hdsjwjxxbMapper.insertSelective(record);
	}

	/**
	 * 根据文件名进行查询
	 */
	@Override
	public List<Hdsjwjxxb> selectByExample(Hdsjwjxxb record) {
		// TODO Auto-generated method stub
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andWjmEqualTo(record.getWjm());
		return hdsjwjxxbMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Hdsjwjxxb record) {
		// TODO Auto-generated method stub
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andWjmEqualTo(record.getWjm());
		return hdsjwjxxbMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Hdsjwjxxb record) {
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andWjmEqualTo(record.getWjm());
		return hdsjwjxxbMapper.updateByExampleSelective(record, example);
	}
	
	@Override
	public void saveOrupdate(Hdsjwjxxb record){
		List<Hdsjwjxxb> list = selectByExample(record);
		if (null!=list&&!list.isEmpty()) {
			updateByExampleSelective(record);
		}else{
			insertSelective(record);
		}
	}

	@Override
	public List<Hdsjwjxxb> selectBywjzt(Hdsjwjxxb record) {
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andWjztEqualTo(record.getWjzt()).andHdphEqualTo(record.getHdph()).andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		return hdsjwjxxbMapper.selectByExample(example);
	}
	@Override
	public List<Hdsjwjxxb> selectByAllwjzt(Hdsjwjxxb record) {
		HdsjwjxxbExample  example = new HdsjwjxxbExample();
		example.createCriteria().andWjztEqualTo(record.getWjzt()).andSbztEqualTo(record.getSbzt());
		return hdsjwjxxbMapper.selectByExample(example);
	}
}
