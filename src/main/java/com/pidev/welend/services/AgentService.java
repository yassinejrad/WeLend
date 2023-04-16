package com.pidev.welend.services;


import java.util.List;

import com.pidev.welend.entities.Agent;

public interface AgentService {
    public Agent addAgent(Agent a );
    public Agent updateAgent(Agent a);
    public List<Agent> getAllAgent();
    public Agent getAgentById(Integer agentID);
    public void deleteAgent(Integer agentId);
}
