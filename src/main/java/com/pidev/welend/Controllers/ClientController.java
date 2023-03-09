package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Client;
import com.pidev.welend.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientservice;
    @PostMapping("/add")
    public Client addClient(@RequestBody Client c){
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


}

