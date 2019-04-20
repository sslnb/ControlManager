package com.arshiner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.AgentMapper;
import com.arshiner.model.Agent;
import com.arshiner.model.AgentExample;
import com.arshiner.service.AgentService;
@Service("agentService")
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentMapper agentMapper;
	@Override
	public int countByExample(Agent record) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return agentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Agent record) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return agentMapper.deleteByExample(example);
	}

	@Override
	public int insert(Agent record) {
		// TODO Auto-generated method stub
		return agentMapper.insertSelective(record);
	}

	@Override
	public int insertSelective(Agent record) {
		// TODO Auto-generated method stub
		return agentMapper.insertSelective(record);
	}

	@Override
	public List<Agent> selectByExample(Agent record) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return agentMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Agent record) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return agentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Agent record) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return agentMapper.updateByExample(record, example);
	}

	@Override
	public List<Agent> selectByJgxtlbAndKIP(Agent record) {
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andKipEqualTo(record.getKip());
		return agentMapper.selectByExample(example);
	}
	
	@Override
	public void saveOrupdate(Agent record) {
		List<Agent> list = selectByJgxtlbAndKIP(record);
		if (null==list||list.isEmpty()) {
			insertSelective(record);
		}else{
			updateByExampleSelective(record);
		}
	}

	@Override
	public List<Agent> selectByStatus(Agent record) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb())
		.andStaiusEqualTo("1");
		return agentMapper.selectByExample(example);
	}

	
	
	
	@Override
	public List<Agent> selectByDbJG(String jgxtlb) {
		// TODO Auto-generated method stub
		AgentExample example = new AgentExample();
		example.createCriteria().andJgxtlbLike(jgxtlb+"%");
		return agentMapper.selectByExample(example);
	}

	@Override
	public List<Agent> selAgentByPage(int before, int after) {
		
		return agentMapper.selAgentByPage(before, after);
	}

	@Override
	public Object countAgent() {
		// TODO Auto-generated method stub
		return agentMapper.countAgent();
	}



}
