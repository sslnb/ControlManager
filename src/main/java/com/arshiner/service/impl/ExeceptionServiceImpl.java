package com.arshiner.service.impl;

import com.arshiner.dao.ExeceptionMapper;
import com.arshiner.model.Exeception;
import com.arshiner.model.ExeceptionExample;
import com.arshiner.service.ExeceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author mdk
 * @Date: 10:09 2018/12/3
 * @Description: (类描述)
 */

@Service(value = "execeptionService")
public class ExeceptionServiceImpl implements ExeceptionService {

    @Autowired
    private ExeceptionMapper execeptionMapper;

    @Override
    public List<Exeception> selAllExeception(int before, int after) {
        return execeptionMapper.selAllExeception(before, after);
    }

    @Override
    public int countExeception() {
        return execeptionMapper.countExeception();
    }


	@Override
	public int deleteByExample(Exeception record) {
		// TODO Auto-generated method stub
		ExeceptionExample example = new ExeceptionExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return execeptionMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return execeptionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Exeception record) {
		// TODO Auto-generated method stub
		return execeptionMapper.insertSelective(record);
	}

	@Override
	public int insertSelective(Exeception record) {
		// TODO Auto-generated method stub
		return execeptionMapper.insertSelective(record);
	}

	@Override
	public List<Exeception> selectByExample(Exeception record) {
		// TODO Auto-generated method stub
		ExeceptionExample example = new ExeceptionExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return execeptionMapper.selectByExample(example);
	}

	@Override
	public Exeception selectByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return execeptionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Exeception record) {
		// TODO Auto-generated method stub
		ExeceptionExample example = new ExeceptionExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return execeptionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Exeception record) {
		// TODO Auto-generated method stub
		ExeceptionExample example = new ExeceptionExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return execeptionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public List<Exeception> haveSelExeception(int before, int after,String sel_1) {
		return execeptionMapper.haveSelExeception(before,after,sel_1);
	}

	@Override
	public int haveCountExeception(String sel_1) {
		return execeptionMapper.haveCountExeception(sel_1);
	}
}
