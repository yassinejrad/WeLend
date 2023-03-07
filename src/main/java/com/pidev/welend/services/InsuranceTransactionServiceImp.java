package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.repos.InsuranceTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InsuranceTransactionServiceImp implements InsuranceTransactionService{

    @Autowired
    InsuranceTransactionRepo insuranceTransactionRepo;
    @Override
    public insuranceTransaction addInsuranceTransaction(insuranceTransaction i) {
        return insuranceTransactionRepo.save(i);
    }

    @Override
    public insuranceTransaction updateInsuranceTransaction(insuranceTransaction i) {
        return insuranceTransactionRepo.save(i);
    }

    @Override
    public List<insuranceTransaction> getAllInsuranceTransaction() {

        return insuranceTransactionRepo.findAll();
    }

    @Override
    public insuranceTransaction getInsuranceTransactionById(Integer insuranceTransactionID) {
        return insuranceTransactionRepo.findById(insuranceTransactionID).orElse(null);
    }

    @Override
    public void deleteInsuranceTransaction(Integer insuranceTransactionId) {
        insuranceTransactionRepo.deleteById(insuranceTransactionId);
    }


    @Override
    public List<insuranceTransaction> getInsuranceTransactionByInsuranceID(Integer insuranceID) {
        return insuranceTransactionRepo.findByInsurance_InsuranceID(insuranceID);
    }

}
