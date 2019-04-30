package com.arshiner.service.impl;

import com.arshiner.dao.ClsjclztMapper;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.ClsjclztExample;
import com.arshiner.service.ClsjclztService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 存量数据处理状态表
 * 
 * @author 士林
 *
 */
@Service("clsjclztService")
public class ClsjclztServiceImpl implements ClsjclztService {

	@Autowired
	private ClsjclztMapper clsjclztMapper;

	@Override
	public int countByExample() {
		ClsjclztExample example = new ClsjclztExample();
		return clsjclztMapper.countByExample(example);
	}


	@Override
	public int insert(Clsjclzt record) {
		return clsjclztMapper.insert(record);
	}

	@Override
	public int insertSelective(Clsjclzt record) {
		return clsjclztMapper.insertSelective(record);
	}

	@Override
	public List<Clsjclzt> selectByExample(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		return clsjclztMapper.selectByExample(example);
	}
	@Override
	public synchronized int updateByExampleSelective(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		clsjclztMapper.updateByExampleSelective(record, example);
		return 1;
	}
	@Override
	public int updateByExample(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		return clsjclztMapper.updateByExampleSelective(record, example);
	}

    @Override
    public List<Clsjclzt> selAllClsjclzt(int before, int after) {
        return clsjclztMapper.selAllClsjclzt(before, after);
    }

    @Override
    public int countClsjclzt() {
        return clsjclztMapper.countClsjclzt();
    }

    @Override
    public List<Clsjclzt> selClsjclztByParam(int before, int after, String param1, String param2) {
        return clsjclztMapper.selClsjclztByParam(before, after, param1, param2);
    }

    @Override
    public int countClsjclztByParam(String param1, String param2) {
        return clsjclztMapper.countClsjclztByParam(param1, param2);
    }

	@Override
	public void saveOrupdate(Clsjclzt record) {
		if (selectByExample(record).isEmpty()) {
			insertSelective(record);
		}else{
			updateByExampleSelective(record);
		}
	}

	@Override
	public List<Clsjclzt> selectByZT(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb())
		.andCjztEqualTo("0");
		
		return clsjclztMapper.selectByExample(example);
	}

	@Override
	public int sumycjcjl(String jgxtlb) {
		
		return clsjclztMapper.countCJL(jgxtlb);
	}

	@Override
	public int countSJZL(String jgxtlb) {
		return clsjclztMapper.countSJZL(jgxtlb);
	}

	@Override
	public int countWJZL(String jgxtlb) {
		// TODO Auto-generated method stub
		return clsjclztMapper.countWJZL(jgxtlb);
	}

	/**
	 * 查询采集完成标记为已完成且入库状态为为未入库状态0
	 */
	@Override
	public List<Clsjclzt> selectByCJWCZT(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andCjztEqualTo(record.getCjzt())
		.andJgxtlbEqualTo(record.getJgxtlb());
		return clsjclztMapper.selectByExample(example);
	}

	@Override
	public int deleteBylikeJgxtlb(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbLike(record.getJgxtlb()+"%");
		return clsjclztMapper.deleteByExample(example);
	}

	/**
	 * 采集状态
	 */
	@Override
	public List<Clsjclzt> selectByCJZT(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria()
		.andJgxtlbEqualTo(record.getJgxtlb())
		.andBmEqualTo(record.getBm());
		List<Clsjclzt> list = clsjclztMapper.selectByExample(example);
		if (list==null) {
			return new ArrayList<Clsjclzt>();
		}else{
			return list;
		}
	}
	/**
	 * 采集状态
	 */
	@Override
	public List<Clsjclzt> selectByCJZTStatus(Clsjclzt record) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andCjztNotEqualTo("2")
		.andJgxtlbEqualTo(record.getJgxtlb());
		List<Clsjclzt> list = clsjclztMapper.selectByExample(example);
		if (list==null) {
			return new ArrayList<Clsjclzt>();
		}else{
			return list;
		}
	}

	@Override
	public List<Clsjclzt> selectByRKZT(Clsjclzt record) {
		return null;
	}

	@Override
	public List<Clsjclzt> selectBysbzt(Clsjclzt clsjclzt) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andBmEqualTo(clsjclzt.getBm()).andJgxtlbEqualTo(clsjclzt.getJgxtlb()).andCjztEqualTo(clsjclzt.getCjzt()).andSbztEqualTo(clsjclzt.getSbzt());
		return clsjclztMapper.selectByExample(example);
	}


	@Override
	public List<Clsjclzt> selectByJgxtlb(Clsjclzt clzt) {
		ClsjclztExample example = new ClsjclztExample();
		example.createCriteria().andJgxtlbEqualTo(clzt.getJgxtlb());
		return clsjclztMapper.selectByExample(example);
	}
	@Override
	public Integer selSjlByBm(String bm, String jgxtlb) {
		return clsjclztMapper.selSjlByBm(bm,jgxtlb);
	}

}
