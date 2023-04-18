package com.pidev.welend.services;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.pidev.welend.entities.Account;
import com.pidev.welend.entities.Client;
import com.pidev.welend.entities.Consultation;
import com.pidev.welend.entities.Transaction;
import com.pidev.welend.repos.AccountRepo;
import com.pidev.welend.repos.ClientRepo;
import com.pidev.welend.repos.consultationRepo;

import net.bytebuddy.asm.Advice.Local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    consultationRepo consultationRepository;
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    AccountRepo AccountRepository;

    @Override
    public Client addClient(Client c) {
        return clientRepo.save(c);
    }

    public Client updateClient(Client c) {
        return clientRepo.save((c));
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClientById(Integer clientID) {
        return clientRepo.findById(clientID).orElse(null);
    }

    @Override
    public void deleteClient(Integer clientID) {
        clientRepo.deleteById(clientID);
    }

    @Override
    public Client NotificationBeforeConsultation(Integer clientID) {
        Client c = clientRepo.getById(clientID);
        List<Consultation> lc = consultationRepository.findByClient(c);

        LocalDate currentDate = LocalDate.now();
        LocalDate dateBeforeOneDay = currentDate.plusDays(1);
        Date date = Date.from(dateBeforeOneDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("today date" + date);

        for (Consultation consultation : lc) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(consultation.getDate());
            calendar.set(Calendar.HOUR_OF_DAY, 0); // set hour to midnight
            calendar.set(Calendar.MINUTE, 0); // set minute to zero
            calendar.set(Calendar.SECOND, 0); // set second to zero
            calendar.set(Calendar.MILLISECOND, 0);
            if (calendar.getTime().compareTo(date) == 0) {
                System.out.println("consdate" + consultation.getDate());
                emailSenderService.sendEmail(c.getEmail(), "NotificationBeforeConsultation",
                        "don't forget tomorrow is your consultation");

            }
        }
        return c;
    }

    @Override
    public Client NotificationAfterConsultation(Integer clientID) {
        Client c = clientRepo.getById(clientID);
        List<Consultation> lc = consultationRepository.findByClient(c);

        LocalDate currentDate = LocalDate.now();
        LocalDate dateBeforeOneDay = currentDate.minusDays(1);
        Date date = Date.from(dateBeforeOneDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("today date" + date);

        for (Consultation consultation : lc) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(consultation.getDate());
            calendar.set(Calendar.HOUR_OF_DAY, 0); // set hour to midnight
            calendar.set(Calendar.MINUTE, 0); // set minute to zero
            calendar.set(Calendar.SECOND, 0); // set second to zero
            calendar.set(Calendar.MILLISECOND, 0);
            if (calendar.getTime().compareTo(date) == 0) {
                System.out.println("consdate" + consultation.getDate());
                emailSenderService.sendEmail(c.getEmail(), "NotificationAfterConsultation",
                        "here is your consultation conclusion");

            }
        }
        return c;
    }

    @Override
    public String BankScoring(Integer clientID) {
        Client c = clientRepo.getById(clientID);
        float somme=0;  
        List<Account> la=AccountRepository.findByClient(c);
        for (Account account : la) {
            for (Transaction transaction : account.getTransactions()) {
              somme=+transaction.getAmount();

            }
        }
        System.out.println("somme"+somme);
        if(somme==0){
            return "Zero transaction found ";
        }
        if(somme<=250){
            return "normal Client and your transaction somme is : " +somme;
        }
        else if(250>somme && somme<=1500){
            return "important client and your transaction somme is : " +somme;
        }
        else {
            return "vip client and your transaction somme is : " +somme;
        }

        
    }

}
