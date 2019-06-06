package com.arshiner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.HdsjcjxxbMapper;
import com.arshiner.model.Hdsjcjxxb;
import com.arshiner.model.HdsjcjxxbExample;
import com.arshiner.service.HdsjcjxxbService;
@Service("hdsjcjxxbService")
public class HdsjcjxxbServiceImpl implements HdsjcjxxbService {

	@Autowired
	HdsjcjxxbMapper  hdsjcjxxbMapper;
	/**
	 * 根据核对批号进行查询一共有多少核对记录
	 */
	@Override
	public int countByExample(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andHdphEqualTo(record.getHdph());
		return hdsjcjxxbMapper.countByExample(example);
	}

	/**
	 * 根据核对批号进行删除记录
	 */
	@Override
	public int deleteByExample(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andJlztEqualTo(record.getJlzt());
		return hdsjcjxxbMapper.deleteByExample(example);
	}

	
	@Override
	public int insert(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		return hdsjcjxxbMapper.insert(record);
	}

	@Override
	public int insertSelective(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		return hdsjcjxxbMapper.insertSelective(record);
	}
	
	/**
	 * 根据核对批号HDPH来进行查询
	 */
	@Override
	public List<Hdsjcjxxb> selectByExample(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andHdphEqualTo(record.getHdph());
		return hdsjcjxxbMapper.selectByExample(example);
	}
	/**
	 * sbzt不等完成标记等 才查询
	 */
	@Override
	public List<Hdsjcjxxb> selectBySbzt(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andSbztEqualTo(record.getSbzt()).andClwcbjEqualTo(record.getClwcbj());
		return hdsjcjxxbMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andHdphEqualTo(record.getHdph()).andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm());
		return hdsjcjxxbMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Hdsjcjxxb record) {
		// TODO Auto-generated method stub
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andHdphEqualTo(record.getHdph()).andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm());
		return hdsjcjxxbMapper.updateByExampleSelective(record, example);
	}
	/**
	 * 根据核对批号进行查询
	 * @param record
	 */
	@Override
	public void saveOrupdate(Hdsjcjxxb record){
		List<Hdsjcjxxb> list =selectByExample(record);
		if (null!=list&&!list.isEmpty()) {
			updateByExampleSelective(record);
		}else{
			insertSelective(record);
		}
	}

	@Override
	public List<Hdsjcjxxb> selectByAllByCjBj(Hdsjcjxxb record) {
		HdsjcjxxbExample example=  new HdsjcjxxbExample();
		example.createCriteria().andCjbjEqualTo(record.getCjbj());
		return hdsjcjxxbMapper.selectByExample(example);
	}
}
