package com.pidev.welend.services;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.pidev.welend.entities.insurance;
import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.entities.insuranceTransactionStatus;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.*;


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
        return insuranceTransactionRepo.findAllByInsurance_InsuranceID(insuranceID);
    }
    @Override
    public HashMap<insuranceTransaction, String> checkAllUnpaidInsuranceTransactionByYear(Integer insuranceID,Integer year){
        HashMap<insuranceTransaction, String> result = new HashMap<>();
        insurance insurance=insuranceRepo.findById(insuranceID).orElse(null);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(insurance.getEndDate());
        int insuranceMonth = calendar.get(Calendar.MONTH);
        try {
            List<insuranceTransaction> insuranceTransactions = insuranceTransactionRepo.findAllByInsurance_InsuranceIDAndInsuranceTransactionDate_Year(insuranceID,year);
            for (insuranceTransaction insuranceTransaction : insuranceTransactions){
                if (insuranceTransaction.getInsuranceTransactionStatus() == insuranceTransactionStatus.PENDING){
                    result.put(insuranceTransaction,insuranceMonth+"/"+year);
                }
            }
        }catch (Exception e){
            System.out.println("Error while finding insurancesTransactions: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<insuranceTransaction> getAllInsuranceTransactionPendingByInsurance(Integer insuranceID) {
        List<insuranceTransaction> result = new ArrayList<>();
        try {
            List<insuranceTransaction> transactions = insuranceTransactionRepo.findAllByInsurance_InsuranceID(insuranceID);
            for (insuranceTransaction transaction : transactions) {
                if (transaction.getInsuranceTransactionStatus() == insuranceTransactionStatus.PENDING) {
                    result.add(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Error while finding insurancesTransactions: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<insuranceTransaction> getAllInsuranceTransactionNotfullysetteledByInsurance(Integer insuranceID) {
        List<insuranceTransaction> result = new ArrayList<>();
        try {
            List<insuranceTransaction> transactions = insuranceTransactionRepo.findAllByInsurance_InsuranceID(insuranceID);
            for (insuranceTransaction transaction : transactions) {
                if (transaction.getInsuranceTransactionStatus() == insuranceTransactionStatus.NOTFULLYSETTELED) {
                    result.add(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Error while finding insurancesTransactions: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<insuranceTransaction> getAllInsuranceTransactionSettledByInsurance(Integer insuranceID) {
        List<insuranceTransaction> result = new ArrayList<>();
        try {
            List<insuranceTransaction> transactions = insuranceTransactionRepo.findAllByInsurance_InsuranceID(insuranceID);

            for (insuranceTransaction transaction : transactions) {
                if (transaction.getInsuranceTransactionStatus() == insuranceTransactionStatus.SETTLED) {
                    result.add(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Error while finding insurancesTransactions: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<insuranceTransaction> getAllInsuranceTransactionByAcountID(Integer accountID) {
        return insuranceTransactionRepo.findAllByInsurance_Account_AccountID(accountID);
    }


}
