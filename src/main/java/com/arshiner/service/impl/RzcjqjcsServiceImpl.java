package com.arshiner.service.impl;

import com.arshiner.dao.RzcjqjcsMapper;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.RzcjqjcsExample;
import com.arshiner.service.RzcjqjcsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志采集全局参数表
 * @author 士林
 *
 */
@Service("rzcjqjcsService")
public class RzcjqjcsServiceImpl implements RzcjqjcsService {

    @Resource
    private RzcjqjcsMapper rzcjqjcsMapper;


    @Override
    public int countByExample() {
    	RzcjqjcsExample example = new RzcjqjcsExample();
        return rzcjqjcsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Rzcjqjcs record) {
    	RzcjqjcsExample example = new RzcjqjcsExample();
        return rzcjqjcsMapper.deleteByExample(example);
    }

    @Override
    public int insert(Rzcjqjcs record) {
        return rzcjqjcsMapper.insert(record);
    }

    @Override
    public int insertSelective(Rzcjqjcs record) {
        return rzcjqjcsMapper.insertSelective(record);
    }

    @Override
    public List<Rzcjqjcs> selectByExample(Rzcjqjcs record) {
    	RzcjqjcsExample example = new RzcjqjcsExample();
        return rzcjqjcsMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Rzcjqjcs record) {
    	RzcjqjcsExample example = new RzcjqjcsExample();
    	example.createCriteria().andGjzEqualTo(record.getGjz().trim()).andCsmcEqualTo(record.getCsmc().trim());
        return rzcjqjcsMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Rzcjqjcs record) {
    	RzcjqjcsExample example = new RzcjqjcsExample();
        return rzcjqjcsMapper.updateByExample(record, example);
    }

    @Override
    public List<Rzcjqjcs> selAllRzcjqjcs(int before, int after) {
        return rzcjqjcsMapper.selAllRzcjqjcs(before, after);
    }

    @Override
    public int countRzcjqjcs() {
        return rzcjqjcsMapper.countRzcjqjcs();
    }


    /**
     * 通过关键字查询
     * @param record
     * @return
     */
	@Override
	public List<Rzcjqjcs> selectByGjz(Rzcjqjcs record) throws NullPointerException {
		RzcjqjcsExample example = new RzcjqjcsExample();
		example.createCriteria().andGjzEqualTo(record.getGjz());
		return rzcjqjcsMapper.selectByExample(example);
	}
	/**
	 * 通过关键字查询
	 * @param record
	 * @return
	 */
	@Override
	public List<Rzcjqjcs> selectByCsmc(Rzcjqjcs record) {
		RzcjqjcsExample example = new RzcjqjcsExample();
		example.createCriteria().andGjzEqualTo(record.getGjz().trim()).andMrzEqualTo(record.getMrz().trim());
		return rzcjqjcsMapper.selectByExample(example);
	}

	@Override
	public void saveorupdate(Rzcjqjcs record) {
		List<Rzcjqjcs>  rzlist = selectByCsmc( record);
		if (null!=rzlist&&!rzlist.isEmpty()) {
			updateByExampleSelective(record);
		}else{
			insertSelective(record);
		}
	}

	@Override
	public List<Rzcjqjcs> selectByGjzandLikeJgxtlb(Rzcjqjcs record) {
		RzcjqjcsExample example = new RzcjqjcsExample();
		example.createCriteria().andGjzEqualTo(record.getGjz()).andMrzLike(record.getMrz()+"%");
		return rzcjqjcsMapper.selectByExample(example);
	}
	
	
	
}
