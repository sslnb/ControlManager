package com.arshiner.service;

import java.util.List;


import com.arshiner.model.Agent;

public interface AgentService {
	  int countByExample(Agent record);

	    int deleteByExample(Agent record);

	    int insert(Agent record);

	    int insertSelective(Agent record);

	    List<Agent> selectByExample(Agent record);
	    List<Agent> selectByJgxtlbAndKIP(Agent record);
	    List<Agent> selectByDbJG(String jgxtlb);
	    
	    int updateByExampleSelective(Agent record);

	    int updateByExample(Agent record);
	    void saveOrupdate(Agent record);
	    
	    List<Agent> selectByStatus(Agent record);

		List<Agent> selAgentByPage(int before, int after);

		Object countAgent();
}
