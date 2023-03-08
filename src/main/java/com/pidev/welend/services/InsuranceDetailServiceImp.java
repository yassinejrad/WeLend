package com.pidev.welend.services;

import com.pidev.welend.entities.insuranceDetail;
import com.pidev.welend.repos.InsuranceDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteInsuranceDetail(Integer insuranceDetailID) {
        insuranceDetailRepo.deleteById(insuranceDetailID);

    }
    @Override
    public HashMap<Integer, Double> calculateAverageAmountSpentOnAccidents(int year) {
        HashMap<Integer, Double> result = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        try{
            List<insuranceDetail> insuranceDetails = getAllInsuranceDetail();
            for (insuranceDetail detail : insuranceDetails) {
                if (detail.getAccidentDate().getYear() == year) {
                    int month = detail.getAccidentDate().getMonth();
                    double insuredAmount = detail.getInsuredAmount();
                    if (result.containsKey(month)) {
                        double totalAmount = result.get(month) + insuredAmount;
                        int count = counts.getOrDefault(month, 0) + 1;
                        result.put(month, totalAmount);
                        counts.put(month, count);
                    } else {
                        result.put(month, insuredAmount);
                        counts.put(month, 1);
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
        }catch(Exception e){
            System.out.println("Error while finding insuranceDetail: " + e.getMessage());
        }
        return result;
    }

}
