package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceTransaction;

import java.util.List;

public interface InsuranceTransactionService {
    public insuranceTransaction addInsuranceTransaction(insuranceTransaction i);
    public insuranceTransaction updateInsuranceTransaction(insuranceTransaction i);
    public List<insuranceTransaction> getAllInsuranceTransaction();
    public insuranceTransaction getInsuranceTransactionById(Integer insuranceTransactionID);
    public void deleteInsuranceTransaction(Integer insuranceTransactionId);
    public List<insuranceTransaction> getInsuranceTransactionByInsuranceID(Integer insuranceID);
}
