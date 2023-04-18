package com.pidev.welend.services;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.pidev.welend.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.welend.repos.AgentRepo;
import com.pidev.welend.repos.consultationRepo;
import com.pidev.welend.entities.Agent;
import com.pidev.welend.entities.Consultation;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pidev.welend.repos.ClientRepo;

@Service
public class consultationServiceImp implements consultationService {
 @Autowired
 consultationRepo consultationrepo;
 @Autowired
 AgentRepo agentRepo;
    @Autowired
    private ClientRepo clientRepo;

    public Consultation addConsultation(Consultation cons) {
        return consultationrepo.save(cons);
    }

    public Consultation updateConsultation(Consultation cons)
    {
        return consultationrepo.save(cons);
    }

    @Override
    public List<Consultation> getAllConsultation() {
        return consultationrepo.findAll();
    }

    @Override
    public Consultation getConsultationByID(Integer consultationID) {
        return consultationrepo.findById(consultationID).orElse(null);}

    @Override
    public void deleteConsultation(Integer consultationID) {consultationrepo.deleteById(consultationID);}

    @Override
    public List<Date> ConsultationCalender(Integer agentID) {
        Agent agent=agentRepo.findById(agentID).get();
        List<Date> allDates= new ArrayList<>();
      // return "you have Consultation with ID" +agent.getConsultation().getConsultationID()+" in"+agent.getConsultation().getDate();

        List<Consultation> lc=agent.getConsultations();
        System.out.println("lc size"+lc.size());
        for (Consultation cons :lc ) {

            allDates.add(cons.getDate());

        }
        return allDates;
        
    }






}

