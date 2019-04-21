package com.arshiner.service.impl;

import com.arshiner.dao.ZlsjddbMapper;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.Zlsjddb;
import com.arshiner.model.ZlsjddbExample;
import com.arshiner.service.ZlsjddbService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 增量数据断点表
 * @author 士林
 *
 */
@Service(value = "zlsjddbService")
public class ZlsjddbServiceImpl implements ZlsjddbService {

    @Resource
    private ZlsjddbMapper zlsjddbMapper;

    @Override
    public int countByExample() {
    	ZlsjddbExample example =new ZlsjddbExample();
        return zlsjddbMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Zlsjddb record) {
    	ZlsjddbExample example =new ZlsjddbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
        return zlsjddbMapper.deleteByExample(example);
    }

    @Override
    public int insert(Zlsjddb record) {
        return zlsjddbMapper.insert(record);
    }

    @Override
    public int insertSelective(Zlsjddb record) {
        return zlsjddbMapper.insertSelective(record);
    }

    @Override
    public List<Zlsjddb> selectByExample(Zlsjddb record) {
    	ZlsjddbExample example =new ZlsjddbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
        return zlsjddbMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Zlsjddb record) {
    	ZlsjddbExample example =new ZlsjddbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
        return zlsjddbMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Zlsjddb record) {
    	ZlsjddbExample example =new ZlsjddbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
    	.andScnEqualTo(record.getScn());
        return zlsjddbMapper.updateByExample(record, example);
    }

	@Override
	public List<Zlsjddb> selectBysbzt(Zlsjddb record) {
		ZlsjddbExample example =new ZlsjddbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
        return zlsjddbMapper.selectByExample(example);
	}

	@Override
	public void saveOrupdate(Zlsjddb zlsjddb) {
		// TODO Auto-generated method stub
		List<Zlsjddb> zlddlist = selectByExample(zlsjddb);
		if (zlddlist==null||zlddlist.isEmpty()) {
			insertSelective(zlsjddb);
		}else{
			updateByExampleSelective(zlsjddb);
		}
	}

	@Override
	public BigDecimal selectNewSeq(String jgxtlb) {
		return zlsjddbMapper.selectNewseq(jgxtlb);
	}
	@Override
	public String selScnByJgxt(String jgxtlb) {
		return zlsjddbMapper.selScnByJgxt(jgxtlb);
	}

}
