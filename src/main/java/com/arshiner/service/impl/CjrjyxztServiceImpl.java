package com.arshiner.service.impl;

import com.arshiner.dao.CjrjyxztMapper;
import com.arshiner.model.Cjrjyxzt;
import com.arshiner.model.CjrjyxztExample;
import com.arshiner.service.CjrjyxztService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 采集软件运行状态表
 * @author 士林
 *
 */
@Service("cjrjyxztService")
public class CjrjyxztServiceImpl implements CjrjyxztService {

    @Resource
    private CjrjyxztMapper cjrjyxzMapper;

	@Override
	public int countByExample() {
		// TODO Auto-generated method stub
		CjrjyxztExample example = new CjrjyxztExample();
		return cjrjyxzMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Cjrjyxzt record) {
		// TODO Auto-generated method stub
		CjrjyxztExample example = new CjrjyxztExample();
		example.createCriteria()
		.andJgxtlbEqualTo(record.getJgxtlb());
		return cjrjyxzMapper.deleteByExample(example);
	}

	@Override
	public int insert(Cjrjyxzt record) {
		// TODO Auto-generated method stub
		return cjrjyxzMapper.insert(record);
	}

	@Override
	public int insertSelective(Cjrjyxzt record) {
		// TODO Auto-generated method stub
		return cjrjyxzMapper.insertSelective(record);
	}

	@Override
	public List<Cjrjyxzt> selectByExample(Cjrjyxzt record) {
		// TODO Auto-generated method stub
		CjrjyxztExample example = new CjrjyxztExample();
		example.createCriteria()
		.andJgxtlbEqualTo(record.getJgxtlb());
		return cjrjyxzMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Cjrjyxzt record) {
		// TODO Auto-generated method stub
		CjrjyxztExample example = new CjrjyxztExample();
		example.createCriteria()
		.andJgxtlbEqualTo(record.getJgxtlb());
		return cjrjyxzMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Cjrjyxzt record) {
		// TODO Auto-generated method stub
		CjrjyxztExample example = new CjrjyxztExample();
		example.createCriteria()
		.andJgxtlbEqualTo(record.getJgxtlb());
		return cjrjyxzMapper.updateByExampleSelective(record, example);
	}

	@Override
	public void saveOrupdate(Cjrjyxzt cjrjyxzt) {	
		if (selectByExample(cjrjyxzt).isEmpty()) {
			insertSelective(cjrjyxzt);
		}else{
			updateByExampleSelective(cjrjyxzt);
		}
		
	}

}
