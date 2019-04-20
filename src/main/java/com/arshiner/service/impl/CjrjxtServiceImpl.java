package com.arshiner.service.impl;

import com.arshiner.model.Cjrjxt;
import com.arshiner.model.CjrjxtExample;
import com.arshiner.service.CjrjxtService;

import com.arshiner.dao.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 采集软件心跳表
 * @author 士林
 *
 */
@Service("cjrjxtService")
public class CjrjxtServiceImpl implements CjrjxtService {

    @Resource
    private  CjrjxtMapper cjrjxtMapper;

    @Override
    public int countByExample() {
    	CjrjxtExample example = new CjrjxtExample();
        return cjrjxtMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(Cjrjxt record) {
    	CjrjxtExample example = new CjrjxtExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh());
        return cjrjxtMapper.deleteByExample(example);
    }

    @Override
    public int insert(Cjrjxt record) {
        return cjrjxtMapper.insert(record);
    }

    @Override
    public int insertSelective(Cjrjxt record) {
    	
        return insertSelective(record);
    }


    @Override
    public int updateByExampleSelective(Cjrjxt record) {
    	CjrjxtExample example = new CjrjxtExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh());
        return cjrjxtMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Cjrjxt record) {
    	CjrjxtExample example = new CjrjxtExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh());
        return cjrjxtMapper.updateByExample(record,example);
    }
	@Override
	public List<Cjrjxt> selectByExample(Cjrjxt record) {
		// TODO Auto-generated method stub
		CjrjxtExample example = new CjrjxtExample();
		return cjrjxtMapper.selectByExample(example);
	}
	@Override
	public List<Cjrjxt> selectByExample() {
		// TODO Auto-generated method stub
		CjrjxtExample example = new CjrjxtExample();
		return cjrjxtMapper.selectByExample(example);
	}
}
