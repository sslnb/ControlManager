package com.arshiner.service.impl;

import com.arshiner.dao.BabhMapper;
import com.arshiner.model.Babh;
import com.arshiner.model.BabhExample;
import com.arshiner.service.BaBhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mdk
 * @Date: 15:30 2018/12/21
 * @Description: (类描述)
 */
@Service("baBhService")
public class BaBhServiceImpl implements BaBhService {

    @Autowired
    private BabhMapper babhMapper;

    @Override
    public List<Babh> selAllBaBh(int before, int after) {
        return babhMapper.selAllBaBh(before, after);
    }

    @Override
    public int countBaBh() {
        return babhMapper.countBaBh();
    }

    @Override
    public int insBaBhInfo(Babh babh) {
        return babhMapper.insert(babh);
    }

	@Override
	public int countByExample(Babh record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除所有备案编号记录
	 * @return
	 */
	@Override
	public int deleteByExample() {
		// TODO Auto-generated method stub
		return babhMapper.deleteByExample(null);
	}

	@Override
	public int insert(Babh record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Babh record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Babh> selectByExample(Babh record) {
		// TODO Auto-generated method stub
		BabhExample example = new BabhExample();
		return babhMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Babh record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Babh record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void saveOrupdate(Babh babh) {
		// TODO Auto-generated method stub
		
	}
}
