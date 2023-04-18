package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Client;
import com.pidev.welend.entities.Users;
import com.pidev.welend.entities.UsersType;
import com.pidev.welend.services.ClientService;
import com.pidev.welend.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientservice;

    @Autowired
    UsersService usersService;
    
    @Autowired
	PasswordEncoder encoder;
    @PostMapping("/add")
    public Client addClient(@RequestBody Client c){
        Users user = new Users();
        user.setEmail(c.getEmail());
        user.setPassword(c.getPwd());
        user.setUsername(c.getUserName());
        user.setRole(UsersType.CLIENT);
        c.setPwd(encoder.encode(c.getPwd()));
        usersService.addUser(user);
        return clientservice.addClient(c);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client c){
        return clientservice.updateClient(c);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") Integer clientID){
        clientservice.deleteClient(clientID);
    }
    @GetMapping("/getAll")
    public List<Client> getALLClient(){
        return clientservice.getAllClient();
    }
    @GetMapping("/getByID/{id}")
    public Client getByClient(@PathVariable("id") Integer clientID)
    {
        return clientservice.getClientById(clientID);
    }

    @GetMapping("/NotificationBeforeConsultation/{id}")
    public Client NotificationBeforeConsultation(@PathVariable("id") Integer clientID)
    {
        return clientservice.NotificationBeforeConsultation(clientID);
    }

    @GetMapping("/NotificationAfterConsultation/{id}")
    public Client NotificationAfterConsultation(@PathVariable("id") Integer clientID)
    {
        return clientservice.NotificationAfterConsultation(clientID);
    }

    @GetMapping("/BankScorring/{id}")
    public String BankScoring(@PathVariable("id") Integer clientID)
    {
        return clientservice.BankScoring(clientID);
    }


}

