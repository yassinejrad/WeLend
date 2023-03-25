package com.pidev.welend.services;

import com.pidev.welend.entities.insurance;
import com.pidev.welend.entities.insuranceTransaction;

import java.util.HashMap;
import java.util.List;

public interface InsuranceTransactionService {
    public insuranceTransaction addInsuranceTransaction(insuranceTransaction i);
    public insuranceTransaction updateInsuranceTransaction(insuranceTransaction i);
    public List<insuranceTransaction> getAllInsuranceTransaction();
    public insuranceTransaction getInsuranceTransactionById(Integer insuranceTransactionID);
    public void deleteInsuranceTransaction(Integer insuranceTransactionId);
    public List<insuranceTransaction> getInsuranceTransactionByInsuranceID(Integer insuranceID);
    public HashMap<insuranceTransaction, String> checkAllUnpaidInsuranceTransactionByYear(Integer insuranceID,Integer year);
    List<insuranceTransaction> getAllInsuranceTransactionPendingByInsurance(Integer insuranceID);
    List<insuranceTransaction> getAllInsuranceTransactionNotfullysetteledByInsurance(Integer insuranceID);
    List<insuranceTransaction> getAllInsuranceTransactionSettledByInsurance(Integer insuranceID);
    List<insuranceTransaction> getAllInsuranceTransactionByAcountID(Integer accountID);
}
