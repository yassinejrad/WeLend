package com.pidev.welend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pidev.welend.repos.consultationRepo;
import com.pidev.welend.entities.Consultation;

import java.util.List;
@Service
public class consultationServiceImp implements consultationService {
 @Autowired
 consultationRepo consultationrepo;
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
    public List<Consultation> ConsultationCalender() {
        return null;
    }

    @Override
    public List<Consultation> ClientSurveys() {
        return null;
    }


}

