package com.pidev.welend.services;

import com.pidev.welend.entities.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(Client c );
        public Client updateClient(Client c);
        public List<Client> getAllClient();
        public Client getClientById(Integer clientID);
        public void deleteClient(Integer clientID);
        public Client NotificationBeforeConsultation (Client c);
        public Client NotificationAfterConsultation (Client c);
        public List<Client> BankScoring();
}
