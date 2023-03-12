package com.pidev.welend.services;

import com.pidev.welend.entities.Consultation;

import java.util.List;

public interface consultationService {
    public Consultation addConsultation(Consultation cons);
    public Consultation updateConsultation(Consultation cons);
    public List<Consultation> getAllConsultation();
    public Consultation getConsultationByID(Integer consultationID);
    public void deleteConsultation(Integer consultationID);
}