package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceDetail;
import com.pidev.welend.repos.InsuranceDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceDetailServiceImp implements InsuranceDetailService{
    @Autowired
    InsuranceDetailRepo insuranceDetailRepo;
    @Override
    public insuranceDetail addInsuranceDetail(insuranceDetail insuranceDetail) {
        return insuranceDetailRepo.save(insuranceDetail);
    }

    @Override
    public insuranceDetail updateInsuranceDetail(insuranceDetail i) {
        return insuranceDetailRepo.save(i);
    }

    @Override
    public List<insuranceDetail> getAllInsuranceDetail() {
        return insuranceDetailRepo.findAll();
    }

    @Override
    public insuranceDetail getInsuranceDetailById(Integer insuranceDetailID) {
        return insuranceDetailRepo.findById(insuranceDetailID).orElse(null);
    }

    @Override
    public void deleteInsuranceDetail(Integer insuranceDetailID) {
        insuranceDetailRepo.deleteById(insuranceDetailID);

    }
}
