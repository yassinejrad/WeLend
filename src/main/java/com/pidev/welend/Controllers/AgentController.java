package com.pidev.welend.controllers;


import com.pidev.welend.entities.Agent;
import com.pidev.welend.entities.Users;
import com.pidev.welend.entities.UsersType;
import com.pidev.welend.services.AgentService;
import com.pidev.welend.services.UsersService;
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
    @Autowired
    UsersService usersService;


    @PostMapping("/add")
    public Agent addAgent(@RequestBody Agent a){
        Users user = new Users();
        user.setEmail(a.getEmail());
        user.setPwd(a.getPwd());
        switch (a.getAgentType()){
            case ADMIN:user.setRole(UsersType.ADMIN);
            case CONSULTANT:user.setRole(UsersType.CONSULTANT);
        }
       usersService.addUser(user);
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
