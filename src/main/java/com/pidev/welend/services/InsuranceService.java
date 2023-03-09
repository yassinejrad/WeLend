package com.pidev.welend.services;


import com.pidev.welend.entities.insurance;

import java.util.HashMap;
import java.util.List;

public interface InsuranceService {
    public insurance addInsurance(insurance i);
    public insurance updateInsurance(insurance i);
    public List<insurance> getAllInsurance();
    public insurance getInsuranceById(Integer insuranceID);
    public void deleteInsurance(Integer insuranceId);
    public HashMap<insurance, Double> calculateInterestByYear(Integer year);
    public HashMap<insurance, Double> calculateInterestByinsurance();
    public void renewInsurance(Integer insuranceID);
    public void createInsuranceAndTransactions(insurance insurance);

}
