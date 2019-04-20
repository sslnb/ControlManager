package com.arshiner.service.impl;



import com.arshiner.dao.ZlsjwjbMapper;
import com.arshiner.model.Zlsjwjb;
import com.arshiner.model.ZlsjwjbExample;
import com.arshiner.service.ZlsjwjbService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 增量数据文件表
 * @author 士林
 *
 */
@Service(value = "zlsjwjbService")
public class ZlsjwjbServiceImpl implements ZlsjwjbService {

    @Resource
    private ZlsjwjbMapper zlsjwjbMapper;

	@Override
	public int countByExample() {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		return zlsjwjbMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Zlsjwjb record) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andWjmEqualTo(record.getWjm());
		return zlsjwjbMapper.deleteByExample(example);
	}

	@Override
	public int insert(Zlsjwjb record) {
		// TODO Auto-generated method stub
		return zlsjwjbMapper.insert(record);
	}

	@Override
	public int insertSelective(Zlsjwjb record) {
		// TODO Auto-generated method stub
		return zlsjwjbMapper.insertSelective(record);
	}

	@Override
	public List<Zlsjwjb> selectByExample(Zlsjwjb record) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		example.setOrderByClause("gxsj desc");
		 return zlsjwjbMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Zlsjwjb record) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria()
    	.andWjmEqualTo(record.getWjm());
		  return zlsjwjbMapper.updateByExampleSelective(record,example);
	}

	@Override
	public int updateByExample(Zlsjwjb record) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria()
		.andWjmEqualTo(record.getWjm());
		 return zlsjwjbMapper.updateByExampleSelective(record,example);
	}
	@Override
	public int reNameWjm(String old,Zlsjwjb record) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria()
		.andWjmEqualTo(old);
		return zlsjwjbMapper.updateByExampleSelective(record,example);
	}

	@Override
	public List<Zlsjwjb> selAllZlsjwjb(int before, int after) {
		return zlsjwjbMapper.selAllZlsjwjb(before, after);
	}

	@Override
	public int countZlsjwjb() {
		return zlsjwjbMapper.countZlsjwjb();
	}

	@Override
	public List<Zlsjwjb> selZlsjwjbByParam(int before, int after, String param1) {
		return zlsjwjbMapper.selZlsjwjbByParam(before, after, param1);
	}

	@Override
	public int countZlsjwjbByParam(String param1) {
		return zlsjwjbMapper.countZlsjwjbByParam(param1);
	}

	@Override
	public List<Zlsjwjb> selectByYCSB(Zlsjwjb zlsjwj) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(zlsjwj.getJgxtlb())
		.andWjztEqualTo(zlsjwj.getWjzt()).andSbztEqualTo(zlsjwj.getSbzt()).andBmEqualTo(zlsjwj.getBm());
		example.setOrderByClause("gxsj desc");
		 return zlsjwjbMapper.selectByExample(example);
	}
	@Override
	public List<Zlsjwjb> selectByZCSB(Zlsjwjb zlsjwj) {
		// TODO Auto-generated method stub
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(zlsjwj.getJgxtlb())
		.andWjztEqualTo(zlsjwj.getWjzt()).andSbztEqualTo(zlsjwj.getSbzt());
		example.setOrderByClause("gxsj desc");
		return zlsjwjbMapper.selectByExample(example);
	}

	@Override
	public BigDecimal countZlwjs(String jgxtlb) {
		// TODO Auto-generated method stub
		return zlsjwjbMapper.countZlwjs(jgxtlb);
	}

	@Override
	public BigDecimal countZZInsert(String jgxtlb) {
		// TODO Auto-generated method stub
		return zlsjwjbMapper.countZZInsert(jgxtlb);
	}

	@Override
	public BigDecimal countZUpdate(String jgxtlb) {
		// TODO Auto-generated method stub
		return zlsjwjbMapper.countZUpdate(jgxtlb);
	}

	@Override
	public BigDecimal countZDelete(String jgxtlb) {
		// TODO Auto-generated method stub
		return zlsjwjbMapper.countZDelete(jgxtlb);
	}

	@Override
	public int countByExample(Zlsjwjb record) {
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return zlsjwjbMapper.countByExample(example);
	}

	@Override
	public BigDecimal countZlwjscs(String jgxtlb) {
		return zlsjwjbMapper.countZlwjscs(jgxtlb);
	}

	@Override
	public List<Zlsjwjb> selectwjzt(Zlsjwjb zlsjwj) {
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(zlsjwj.getJgxtlb()).andWjztEqualTo(zlsjwj.getWjzt()).andBmEqualTo(zlsjwj.getBm());
		example.setOrderByClause("gxsj desc");
		 return zlsjwjbMapper.selectByExample(example);
	}

	@Override
	public void saveOrupdate(Zlsjwjb zlsjwjb) {
		List<Zlsjwjb> zlwjlist = selectByWjm(zlsjwjb);
		if (zlwjlist==null||zlwjlist.isEmpty()) {
			zlsjwjbMapper.insertSelective(zlsjwjb);
		}else{
			updateByExample(zlsjwjb);
		}
	}

	@Override
	public List<Zlsjwjb> selectByWjm(Zlsjwjb record) {
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andWjmEqualTo(record.getWjm());
		example.setOrderByClause("gxsj desc");
		return zlsjwjbMapper.selectByExample(example);
	}

	@Override
	public List<Zlsjwjb> selectChongchuan(Zlsjwjb record) {
		ZlsjwjbExample example = new  ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andWjztEqualTo(record.getWjzt());
		example.setOrderByClause("gxsj desc");
		 return zlsjwjbMapper.selectByExample(example);
	}

	@Override
	public String selectSYwjm(String jgxtlb,String oldZl) {
		return zlsjwjbMapper.selectSYwjm(jgxtlb,oldZl);
	}

	@Override
	public String selectSYwjm0(String jgxtlb,String like,String zlwjm) {
		return zlsjwjbMapper.selectSYwjm0(jgxtlb,like,zlwjm);
	}

	@Override
	public int deleteBywjmBIG(String wjm, String jgxtlb) {
		ZlsjwjbExample example = new ZlsjwjbExample();
		example.createCriteria().andJgxtlbEqualTo(jgxtlb).andWjmGreaterThanOrEqualTo(wjm);
		zlsjwjbMapper.deleteByExample(example);
		return 0;
	}
}
