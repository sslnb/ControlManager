package com.arshiner.dao;

import com.arshiner.model.Agent;
import com.arshiner.model.AgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentMapper {
    int countByExample(AgentExample example);

    int deleteByExample(AgentExample example);

    int insert(Agent record);

    int insertSelective(Agent record);

    List<Agent> selectByExample(AgentExample example);

    int updateByExampleSelective(@Param("record") Agent record, @Param("example") AgentExample example);

    int updateByExample(@Param("record") Agent record, @Param("example") AgentExample example);

    List<Agent> selAgentByPage(@Param("before")int before,@Param("after")int after);
    int countAgent();
}