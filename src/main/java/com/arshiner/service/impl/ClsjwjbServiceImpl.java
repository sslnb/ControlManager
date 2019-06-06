package com.arshiner.service.impl;

import com.arshiner.dao.ClsjwjbMapper;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.ClsjwjbExample;
import com.arshiner.service.ClsjwjbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
/**
 * 存量数据文件表
 * @author 士林
 *
 */
@Service("clsjwjbService")
public class ClsjwjbServiceImpl implements ClsjwjbService {

    @Resource
    private ClsjwjbMapper clsjwjbMapper;

    @Override
    public int countByExample() {
    	ClsjwjbExample example = new ClsjwjbExample();
        return clsjwjbMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Clsjwjb record) {
    	ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb()).andWjmEqualTo(record.getWjm());
        return clsjwjbMapper.deleteByExample(example);
    }
    @Override
    public int deleteByBMandJGXTLB(Clsjwjb record) {
    	ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andBmEqualTo(record.getBm())
    	.andJgxtlbEqualTo(record.getJgxtlb());
    	return clsjwjbMapper.deleteByExample(example);
    }

    @Override
    public int insert(Clsjwjb record) {
        return clsjwjbMapper.insert(record);
    }

    @Override
    public int insertSelective(Clsjwjb record) {
        return clsjwjbMapper.insertSelective(record);
    }

    @Override
    public List<Clsjwjb> selectByExample(Clsjwjb record) {
    	ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
        return clsjwjbMapper.selectByExample(example);
    }
    @Override
    public List<Clsjwjb> selectOrderbyWJM(Clsjwjb record) {
    	ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andWjmLessThanOrEqualTo(record.getWjm());
    	return clsjwjbMapper.selectByExample(example);
    }

    /**
     * 通过文件名，交管系统类别修改
     */
    @Override
    public int updateByExampleSelective(Clsjwjb record) {
    	ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andWjmEqualTo(record.getWjm());
        return clsjwjbMapper.updateByExampleSelective(record, example);
    }
    
    @Override
    public int updateByExample(Clsjwjb record) {
    	ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andWjmEqualTo(record.getWjm());
        return clsjwjbMapper.updateByExampleSelective(record, example);
    }


    @Override
    public List<Clsjwjb> selAllClsjwjb(int before, int after) {
        return clsjwjbMapper.selAllClsjwjb(before, after);
    }

    @Override
    public int countClsjwjb() {
        return clsjwjbMapper.countClsjwjb();
    }

    @Override
    public List<Clsjwjb> selClsjwjbByParam(int before, int after, String param1,String param2) {
        return clsjwjbMapper.selClsjwjbByParam(before, after, param1,param2);
    }

    @Override
    public int countClsjwjbByParam(String param1,String param2) {
        return countClsjwjbByParam(param1,param2);
    }


    @Override
	public void saveOrupdate(Clsjwjb record) {
    	List<Clsjwjb> clwjlist = selectByWJm(record);
		if (clwjlist.isEmpty()||clwjlist==null) {
			insertSelective(record);
		}else{
			updateByExampleSelective(record);
		}
	}

    /**
     * 等于6的重采重传
     */
	@Override
	public List<Clsjwjb> selectByWjzt(Clsjwjb record) {
		ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
    	.andWjztEqualTo(record.getWjzt());
    	example.setOrderByClause("gxsj desc");
		return clsjwjbMapper.selectByExample(example);
	}


	@Override
	public BigDecimal countclsjwjByJGXGLB(String jgxtlb) {
		return clsjwjbMapper.countclsjwjByJGXGLB(jgxtlb);
	}
	
	@Override
	public int countclsjwjByJGXGLBAndBM(String jgxtlb,String bm) {
		ClsjwjbExample clwj = new ClsjwjbExample();
		clwj.createCriteria().andBmEqualTo(bm).andJgxtlbEqualTo(jgxtlb);
		return clsjwjbMapper.countByExample(clwj);
	}

	@Override
	public BigDecimal countclsjwjsclByJGXGLB(String jgxtlb) {
		return clsjwjbMapper.countclsjwjsclByJGXGLB(jgxtlb);
	}

	@Override
	public BigDecimal sumSJZL(Clsjwjb record) {
		// TODO Auto-generated method stub
		return clsjwjbMapper.sumSJZL(record.getJgxtlb(), record.getBm());
	}

	@Override
	public List<Clsjwjb> selectByWJm(Clsjwjb record) {
		// TODO Auto-generated method stub
		ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andWjmEqualTo(record.getWjm());
    	return clsjwjbMapper.selectByExample(example);
	}

	@Override
	public List<Clsjwjb> selectByrkzt(Clsjwjb record) {
		ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
    	.andWjztEqualTo(record.getWjzt()).andSbztEqualTo(record.getSbzt());
		return clsjwjbMapper.selectByExample(example);
	}

	@Override
	public int deleteBylikeJgxtlb(Clsjwjb record) {
		ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbLike(record.getJgxtlb()+"%");
        return clsjwjbMapper.deleteByExample(example);
	}

	@Override
	public int updateByWjzt(Clsjwjb record) {
		ClsjwjbExample example = new ClsjwjbExample();
    	example.createCriteria().andWjmLessThanOrEqualTo(record.getWjm()).andJgxtlbEqualTo(record.getJgxtlb());
        return clsjwjbMapper.updateByExampleSelective(record, example);
	}

}
