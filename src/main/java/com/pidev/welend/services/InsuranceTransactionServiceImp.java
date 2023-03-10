package com.pidev.welend.services;

import com.pidev.welend.entities.insurance;
import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.entities.insuranceTransactionStatus;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceTransactionServiceImp implements InsuranceTransactionService{

    @Autowired
    InsuranceTransactionRepo insuranceTransactionRepo;
    @Autowired
    InsuranceRepo insuranceRepo;
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
    @Override
    public HashMap<insuranceTransaction, Integer> checkAllUnpaidInsuranceTransactionByYear(Integer insuranceID){
        HashMap<insuranceTransaction, Integer> result = new HashMap<>();
        insurance insurance=insuranceRepo.findById(insuranceID).orElse(null);
        try {
            List<insuranceTransaction> insuranceTransactions = insuranceTransactionRepo.findAllByInsurance_InsuranceIDAndInsuranceTransactionDate_Year(insuranceID.intValue(),insurance.getEndDate().getYear());
            for (insuranceTransaction insuranceTransaction : insuranceTransactions){
                if (insuranceTransaction.getInsuranceTransactionStatus() == insuranceTransactionStatus.PENDING){
                    result.put(insuranceTransaction,insuranceTransaction.getInsuranceTransactionDate().getMonth());
                }
            }
        }catch (Exception e){
            System.out.println("Error while finding insurancesTransactions: " + e.getMessage());
        }

        return result;
    }


}
