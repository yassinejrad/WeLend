package com.pidev.welend.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.welend.entities.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {

}
