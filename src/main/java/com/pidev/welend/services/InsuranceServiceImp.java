package com.pidev.welend.services;


import com.pidev.welend.entities.*;
import com.pidev.welend.repos.AccountRepo;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;

import com.pidev.welend.repos.TransactionRepo;
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
    AccountRepo accountRepo;
    TransactionRepo transactionRepo;

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

        return (endYear - startYear) * 12 + (endMonth - startMonth);
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
    public static boolean sameMonthAndYear(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int month2 = cal2.get(Calendar.MONTH);
        int year2 = cal2.get(Calendar.YEAR);

        return (month1 == month2 && year1 == year2);
    }
    @Scheduled(cron = "* * * * * *")
    public void checkInsuranceTransactionPayments() {
        try {
        List<Account> accounts = accountRepo.findAll();
        for (Account account : accounts) {
            try {
            List<Transaction> transactions = transactionRepo.findTransactionByAccount_AccountID(account.getAccountID());
            List<insurance> insurances = insuranceRepo.findByAccount_AccountID(account.getAccountID());
            for (Transaction transaction : transactions) {
                if (transaction.getTransactionType() == transactionType.INSURANCEPAYMENT) {
                    for (insurance insurance : insurances){
                        try {
                            List<insuranceTransaction> insuranceTransactions = insuranceTransactionRepo.findByInsurance_InsuranceID(insurance.getInsuranceID());
                            for (insuranceTransaction insuranceTransaction : insuranceTransactions) {
                                if (insuranceTransaction != null && sameMonthAndYear(insuranceTransaction.getTransactionDate(), transaction.getTransactionDate())) {
                                    if (insuranceTransaction.getAmount() == transaction.getAmount()) {
                                        insuranceTransaction.setStatusTransaction("SETTLED");
                                        insuranceTransactionRepo.save(insuranceTransaction);
                                    } else if (insuranceTransaction.getAmount() > transaction.getAmount()) {
                                        insuranceTransaction.setStatusTransaction("NOTFULLYSETTLED");
                                        insuranceTransactionRepo.save(insuranceTransaction);
                                    }
                                }
                            }
                        }catch (Exception e){
                            System.out.println("Error while finding insurancesTransactions: " + e.getMessage());

                        }
                    }
                }
            }
            }catch (Exception e){
                System.out.println("Error while finding insurances or transactions: " + e.getMessage());

            }
        }
        }catch (Exception e){
            System.out.println("Error while finding accounts: " + e.getMessage());
        }
    }


}
