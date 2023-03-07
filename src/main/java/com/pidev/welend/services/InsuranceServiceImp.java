package com.pidev.welend.services;


import com.pidev.welend.entities.insurance;
import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
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
    public static int calculateDurationInMonths(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        int startYear = startCalendar.get(Calendar.YEAR);
        int startMonth = startCalendar.get(Calendar.MONTH);

        int endYear = endCalendar.get(Calendar.YEAR);
        int endMonth = endCalendar.get(Calendar.MONTH);

        int monthsBetween = (endYear - startYear) * 12 + (endMonth - startMonth);

        return monthsBetween;
    }

    @Override
    public void createInsuranceAndTransactions(insurance insurance) {
        // Calculate the duration in months
        int durationInMonths = calculateDurationInMonths(insurance.getStartDate(), insurance.getEndDate());

        // Save the insurance object
        insuranceRepo.save(insurance);

        // Calculate the transaction amount
        double transactionAmount = insurance.getAmount() / durationInMonths;

        // Create a transaction object for each month in the duration
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(insurance.getStartDate());

        for (int i = 0; i < durationInMonths; i++) {
            // Create the transaction object
            insuranceTransaction transaction = new insuranceTransaction();
            transaction.setInsuranceTransactionID(insurance.getInsuranceID());
            transaction.setAmount(transactionAmount);
            transaction.setTransactionDate(calendar.getTime());
            transaction.setDescription("Payment : " + i);
            transaction.setStatusTransaction("PENDING");
            insuranceTransactionRepo.save(transaction);
            calendar.add(Calendar.MONTH, 1);
        }
    }

    @Override
    public void renewInsurance(Integer insuranceID) {
        insurance insurance = insuranceRepo.findById(insuranceID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        if ( currentDate.compareTo(insurance.getEndDate())<0) {
            System.out.println("Cannot renew insurance as it has not expired yet.");
        }else {

            int renewalCount = insurance.getRenewalCount() + 1;
            double interestRate = insurance.getIntresetRate();
            double originalInterestRate = interestRate + ((renewalCount / 5) * 0.1 );
            if (renewalCount % 5 == 0 && interestRate > originalInterestRate/2) {
                interestRate = interestRate*0.9;

            }

            Date endDate = convertLocalDateToDate(LocalDate.now().plusYears(1));
            insurance.setEndDate(endDate);
            Date datetest=insurance.getEndDate();
            System.out.println(datetest);
            insurance.setIntresetRate(interestRate);
            insurance.setRenewalCount(renewalCount);
            createInsuranceAndTransactions(insurance);

            System.out.println("Insurance renewed successfully with an interest rate of " + interestRate
                    + " and an end date of " + endDate + ". Original interest rate was " + originalInterestRate + ".");
        }
    }
    
}
