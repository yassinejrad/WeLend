package com.pidev.welend.services;


import com.pidev.welend.entities.insuranceDetail;

import java.util.List;

public interface InsuranceDetailService {
    public insuranceDetail addInsuranceDetail(insuranceDetail insuranceDetail);
    public insuranceDetail updateInsuranceDetail(insuranceDetail i);
    public List<insuranceDetail> getAllInsuranceDetail();
    public insuranceDetail getInsuranceDetailById(Integer insuranceDetailID);
    public void deleteInsuranceDetail(Integer insuranceDetailID);
   // public double calculateAverageAmountSpentOnAccidents(int month, int year);
}
