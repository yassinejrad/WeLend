package com.pidev.welend.services;


import com.pidev.welend.entities.insurance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface InsuranceService {
    public insurance addInsurance(insurance i);
    public insurance updateInsurance(insurance i);
    public List<insurance> getAllInsurance();
    public insurance getInsuranceById(Integer insuranceID);
    public void deleteInsurance(Integer insuranceId);
    public HashMap<String, Double> calculateInterestByYear(Integer year);
    public HashMap<String, Double> calculateInterestByinsurance();
    public void renewInsurance(Integer insuranceID);
    public void createInsuranceAndTransactions(insurance insurance, Date date);
    public List<insurance> getAllInsurancesByAccountID(Integer accountID);
    public HashMap<String, Double> calculateInterestByinsuranceType();

}
