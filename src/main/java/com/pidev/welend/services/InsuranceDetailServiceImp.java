package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceDetail;
import com.pidev.welend.repos.InsuranceDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
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
    public List<insuranceDetail> getInsuranceDetailByInsuranceID(Integer insuranceID) {
        return insuranceDetailRepo.findAllByInsurance_InsuranceID(insuranceID);
    }

    @Override
    public void deleteInsuranceDetail(Integer insuranceDetailID) {
        insuranceDetailRepo.deleteById(insuranceDetailID);

    }
    @Override
    public HashMap<Integer, Double> calculateAverageAmountSpentOnAccidents(int year) {
        HashMap<Integer, Double> result = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        List<insuranceDetail> insuranceDetails = getAllInsuranceDetail();
        Calendar calendar = Calendar.getInstance();
        for (insuranceDetail detail : insuranceDetails) {
            calendar.setTime(detail.getAccidentDate());
            int accidentYear = calendar.get(Calendar.YEAR);
            if (accidentYear == year) {
                int accidentMonth = calendar.get(Calendar.MONTH);
                double insuredAmount = detail.getInsuredAmount();
                if (result.containsKey(accidentMonth)) {
                    double totalAmount = result.get(accidentMonth) + insuredAmount;
                    int count = counts.getOrDefault(accidentMonth, 0) + 1;
                    result.put(accidentMonth, totalAmount);
                    counts.put(accidentMonth, count);
                } else {
                    result.put(accidentMonth, insuredAmount);
                    counts.put(accidentMonth, 1);
                }
            }
        }
        for (int month = 1; month <= 12; month++) {
            if (result.containsKey(month)) {
                double totalAmount = result.get(month);
                int count = counts.getOrDefault(month, 0);
                double averageAmount = (count > 0) ? (totalAmount / count) : 0.0;
                result.put(month, averageAmount);
            } else {
                result.put(month, 0.0);
            }
        }
        return result;
    }

    @Override
    public List<insuranceDetail> getAllInsuranceDetailByAcountID(Integer accountID) {
        return insuranceDetailRepo.findAllByInsurance_Account_AccountID(accountID);
    }
}
