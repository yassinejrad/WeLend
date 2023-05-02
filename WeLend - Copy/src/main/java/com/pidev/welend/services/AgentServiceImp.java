package com.pidev.welend.services;

import com.pidev.welend.entities.Agent;
import com.pidev.welend.repos.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImp implements  AgentService{
    @Autowired
    AgentRepo agentRepo;


    @Override
    public Agent addAgent(Agent a) {
        return agentRepo.save(a);
    }
    public Agent updateAgent(Agent a)
    {
        return agentRepo.save((a));
    }

    @Override
    public List<Agent> getAllAgent() {
        return agentRepo.findAll();
    }

    @Override
    public Agent getAgentById(Integer agentID) {
        return agentRepo.findById(agentID).orElse(null);
    }

    @Override
    public void deleteAgent(Integer agentId) {
        agentRepo.deleteById(agentId);
    }
}
