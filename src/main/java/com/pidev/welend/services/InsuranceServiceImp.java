package com.pidev.welend.services;


import com.pidev.welend.entities.insurance;
import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
        double interestRate = insurance.getIntresetRate();
        List<insuranceTransaction> transactions = insuranceTransactionRepo.findByInsurance_InsuranceID(insuranceId);
        double totalInterest = 0.0;
        for (insuranceTransaction transaction : transactions) {
            double transactionInterest = (transaction.getAmount() * interestRate) / 100;
            totalInterest += transactionInterest;
        }
        return totalInterest;
    }
    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    @Override
    public void renewInsurance(Integer insuranceID) {
        insurance insurance = insuranceRepo.findById(insuranceID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        if ( currentDate.compareTo(insurance.getEndDate())<0) {
            System.out.println("Cannot renew insurance as it has not expired yet.");
        }

        int renewalCount = insurance.getRenewalCount() + 1;
        double interestRate = insurance.getIntresetRate();
        double originalInterestRate = interestRate + ((renewalCount / 5) * -0.1 * interestRate);
        if (renewalCount % 5 == 0 && interestRate > originalInterestRate/2) {
            interestRate = interestRate*0.9;

        }

        Date endDate = convertLocalDateToDate(LocalDate.now().plusYears(1));
        insurance.setEndDate(endDate);
        insurance.setIntresetRate(interestRate);
        insurance.setRenewalCount(renewalCount);

        System.out.println("Insurance renewed successfully with an interest rate of " + interestRate
                + " and an end date of " + endDate + ". Original interest rate was " + originalInterestRate + ".");

    }


}
