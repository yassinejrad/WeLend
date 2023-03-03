package com.pidev.welend.services;


import com.pidev.welend.entities.insurance;
import com.pidev.welend.repos.InsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImp implements InsuranceService{

    @Autowired
    InsuranceRepo insuranceRepo;

    @Override
    public insurance addInsurance(insurance i) {
        return insuranceRepo.save(i);
    }
    public insurance updateInsurance(insurance i)
    {
        return insuranceRepo.save(i);
    }

    @Override
    public List<insurance> getAllInsurance() {
        return insuranceRepo.findAll();
    }

    @Override
    public insurance getInsuranceById(Integer insuranceID) {
        return insuranceRepo.findById(insuranceID).orElse(null);
    }

    @Override
    public void deleteInsurance(Integer insuranceId) {
        insuranceRepo.deleteById(insuranceId);
    }
}
