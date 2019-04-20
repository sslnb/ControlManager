package com.arshiner.service.impl;

import com.arshiner.dao.DdlsjsjbMapper;
import com.arshiner.model.Ddlsjsjb;
import com.arshiner.model.DdlsjsjbExample;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.service.DdlsjsjbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DDL数据审计表
 * 
 * @author 士林
 *
 */
@Service("ddlsjsjbService")
public class DdlsjsjbServiceImpl implements DdlsjsjbService {

	@Resource
	private DdlsjsjbMapper ddlsjsjbMapper;

	@Override
	public int countByExample() {
		DdlsjsjbExample example = new DdlsjsjbExample();
		return ddlsjsjbMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Ddlsjsjb record) {
		DdlsjsjbExample example = new DdlsjsjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andOrauserEqualTo(record.getOrauser());
		return ddlsjsjbMapper.deleteByExample(example);
	}

	@Override
	public int insert(Ddlsjsjb record) {
		return ddlsjsjbMapper.insert(record);
	}

	@Override
	public int insertSelective(Ddlsjsjb record) {
		return ddlsjsjbMapper.insertSelective(record);
	}

	@Override
	public List<Ddlsjsjb> selectByJGXTLBAndORAUSER(Ddlsjsjb record) {
		DdlsjsjbExample example = new DdlsjsjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andOrauserEqualTo(record.getOrauser());
		return ddlsjsjbMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Ddlsjsjb record) {
		DdlsjsjbExample example = new DdlsjsjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andOrauserEqualTo(record.getOrauser());
		return ddlsjsjbMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Ddlsjsjb record) {
		DdlsjsjbExample example = new DdlsjsjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andOrauserEqualTo(record.getOrauser());
		return ddlsjsjbMapper.updateByExample(record, example);
	}

	@Override
	public List<Ddlsjsjb> selAllDdlsjsj(int before, int after) {
		return ddlsjsjbMapper.selAllDdlsjsj(before, after);
	}

	@Override
	public int countDdlsjsj() {
		return ddlsjsjbMapper.countDdlsjsj();
	}

	@Override
	public List<Ddlsjsjb> selDdlsjsjByParam(int before, int after, String param1, String param2, String param3) {
		return ddlsjsjbMapper.selDdlsjsjByParam(before, after, param1, param2, param3);
	}

	@Override
	public int countDdlsjsjByParam(String param1, String param2, String param3) {
		return ddlsjsjbMapper.countDdlsjsjByParam(param1, param2, param3);
	}

	@Override
	public List<Ddlsjsjb> selectBysbzt(Ddlsjsjb ddlsjsj) {
		DdlsjsjbExample example = new DdlsjsjbExample();
		example.createCriteria().andJgxtlbEqualTo(ddlsjsj.getJgxtlb()).andSbztEqualTo(ddlsjsj.getSbzt());
		return ddlsjsjbMapper.selectByExample(example);
	}

	@Override
	public List<Ddlsjsjb> selectByJGXTLB(Ddlsjsjb record) {
		DdlsjsjbExample example = new DdlsjsjbExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andScnEqualTo(record.getScn());
		return ddlsjsjbMapper.selectByExample(example);
	}

	@Override
	public void saveorupdate(Ddlsjsjb record) {
		List<Ddlsjsjb> rzlist = selectByJGXTLB(record);
		if (null != rzlist && !rzlist.isEmpty()) {
			updateByExampleSelective(record);
		} else {
			insertSelective(record);
		}
	}
}
