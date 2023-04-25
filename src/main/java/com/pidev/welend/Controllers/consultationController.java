package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Consultation;
import com.pidev.welend.services.consultationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Consultation")
public class consultationController {
    @Autowired
    consultationService consultationservice;
    @PostMapping("/add")
    public Consultation addConsultation(@RequestBody Consultation cons) {return consultationservice.addConsultation(cons);}
    @PutMapping("/update")
    public Consultation updateConsultation(@RequestBody Consultation cons){return consultationservice.updateConsultation(cons);}
    @DeleteMapping("/delete/{id}")
    public void deleteConsultation(@PathVariable("id") Integer consultationID)
    {
        consultationservice.deleteConsultation(consultationID);}
    @GetMapping("/getAll")
    public List<Consultation> getAllConsultation()
    {
        return consultationservice.getAllConsultation();
    }
    @GetMapping("/getById/{id}")
    public Consultation getByConsultation(@PathVariable("id") Integer consultationID)
    {
        return consultationservice.getConsultationByID(consultationID);
    }
    @GetMapping("/ConsultationCalender/{id}")
    public List<Date> ConsultationCalender(@PathVariable("id") Integer agentID)
    {
        return consultationservice.ConsultationCalender(agentID);
    }

    

}

