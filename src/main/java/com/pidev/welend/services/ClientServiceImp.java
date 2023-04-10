package com.pidev.welend.services;

import com.pidev.welend.entities.Client;
import com.pidev.welend.entities.ClientType;
import com.pidev.welend.entities.Transaction;
import com.pidev.welend.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class ClientServiceImp implements  ClientService{


    @Autowired
    ClientRepo clientRepo;


    @Override
    public Client addClient(Client c ) {return clientRepo.save(c);}
    public Client updateClient(Client c) {return clientRepo.save((c));}

    @Override
    public List<Client> getAllClient() {return clientRepo.findAll();}

    @Override
    public Client getClientById(Integer clientID) {return clientRepo.findById(clientID).orElse(null);}

    @Override
    public void deleteClient(Integer clientID) {
        clientRepo.deleteById(clientID);
    }

}

