package com.pidev.welend.services;


import com.pidev.welend.entities.insurance;
import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImp implements InsuranceService{

    @Autowired
    InsuranceRepo insuranceRepo;
    InsuranceTransactionRepo insuranceTransactionRepo;

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

    @Override
    public double calculateInterest(Integer insuranceId) {
        insurance insurance = insuranceRepo.findById(insuranceId).orElseThrow(null);
        Float interestRate = insurance.getIntresetRate();
        List<insuranceTransaction> transactions = insuranceTransactionRepo.findByInsurance_InsuranceID(insuranceId);
        double totalInterest = 0.0;
        for (insuranceTransaction transaction : transactions) {
            Float transactionInterest = (transaction.getAmount() * interestRate) / 100;
            totalInterest += transactionInterest;
        }
        return totalInterest;
    }




}
