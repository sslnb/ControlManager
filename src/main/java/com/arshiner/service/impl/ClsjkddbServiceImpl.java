package com.arshiner.service.impl;

import com.arshiner.dao.ClsjkddbMapper;
import com.arshiner.model.Clsjkddb;
import com.arshiner.model.ClsjkddbExample;
import com.arshiner.service.ClsjkddbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 存量数据块断点表
 * @author 士林
 *
 */
@Service("clsjkddbService")
public class ClsjkddbServiceImpl implements ClsjkddbService {

    @Autowired
    private ClsjkddbMapper clsjkddbMapper;

    @Override
    public int countByExample() {
    	ClsjkddbExample example = new ClsjkddbExample();
        return clsjkddbMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Clsjkddb record) {
    	ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm()).andSjkbhEqualTo(record.getSjkbh());
        return clsjkddbMapper.deleteByExample(example);
    }
    @Override
    public int deleteByBMandJGXTLB(Clsjkddb record) {
    	ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
    	return clsjkddbMapper.deleteByExample(example);
    }

    @Override
    public int insert(Clsjkddb record) {
        return clsjkddbMapper.insert(record);
    }

    @Override
    public int insertSelective(Clsjkddb record) {
        return clsjkddbMapper.insertSelective(record);
    }

    @Override
    public List<Clsjkddb> selectBybmAndJGXTLB(Clsjkddb record) {
    	ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb());
        return clsjkddbMapper.selectByExample(example);
    }

    /**
     * 完成标记
     * @param record
     * @return
     */
    @Override
    public List<Clsjkddb> selectByWcbj(Clsjkddb record) {
    	ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb())
    	.andWcbjEqualTo(record.getWcbj());
        return clsjkddbMapper.selectByExample(example);
    }

    @Override
    public synchronized int updateByExampleSelective(Clsjkddb record) {
    	ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb()).andSjkbhEqualTo(record.getSjkbh());
        return clsjkddbMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Clsjkddb record) {
    	ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb()).andSjkbhEqualTo(record.getSjkbh());
        return clsjkddbMapper.updateByExample(record, example);
    }

    @Override
	public void saveOrupdate(Clsjkddb record) {
    	List<Clsjkddb> ddlist = selectBybmAndJgxtlbAndsjkbh(record);
    	if (ddlist.isEmpty()||ddlist==null) {
			insertSelective(record);
		}else{
			updateByExampleSelective(record);
		}
	}

	@Override
	public List<Clsjkddb> selectBysbzt(Clsjkddb clsjkddb) {
		ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(clsjkddb.getBm())
    	.andJgxtlbEqualTo(clsjkddb.getJgxtlb()).andWcbjEqualTo(clsjkddb.getWcbj()).andSbztEqualTo(clsjkddb.getSbzt());
		return clsjkddbMapper.selectByExample(example);
	}

	@Override
	public List<Clsjkddb> selectBybmAndJgxtlbAndsjkbh(Clsjkddb record) {
		// TODO Auto-generated method stub
		ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb()).andSjkbhEqualTo(record.getSjkbh());
    	return clsjkddbMapper.selectByExample(example);
	}

	@Override
	public int deleteBylikeJgxtlb(Clsjkddb record) {
		ClsjkddbExample example = new ClsjkddbExample();
    	example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbLike(record.getJgxtlb()+"%");
        return clsjkddbMapper.deleteByExample(example);
	}
}
