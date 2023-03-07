package com.pidev.welend.controllers;

import com.pidev.welend.entities.Agent;
import com.pidev.welend.services.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    AgentService agentService;
    @PostMapping("/add")
    public Agent addAgent(@RequestBody Agent a){
        return agentService.addAgent(a);
    }
    @PutMapping("/update")
    public Agent updateAgent(@RequestBody Agent a){
        return agentService.updateAgent(a);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAgent(@PathVariable("id") Integer agentID){
        agentService.deleteAgent(agentID);
    }
    @GetMapping("/getAll")
    public List<Agent> getAllAgent(){
        return agentService.getAllAgent();
    }
    @GetMapping("/getByID/{id}")
    public Agent getByAgent(@PathVariable("id") Integer agentID)
    {
        return agentService.getAgentById(agentID);
    }


}
