package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceDetail;
import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.repos.InsuranceDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    /*
    @Override
    public HashMap<> calculateAverageAmountSpentOnAccidents(int year) {
        double totalAmount = 0.0;
        int count = 0;
        List<insuranceDetail> insuranceDetails = getAllInsuranceDetail();
        for (insuranceDetail detail : insuranceDetails) {
            if (detail.getAccidentDate().getMonth() == month && detail.getAccidentDate().getYear() == year) {
                totalAmount += detail.getInsuredAmount();
                count++;
            }
        }
        return (count > 0) ? (totalAmount / count) : 0.0;
    }*/
}
