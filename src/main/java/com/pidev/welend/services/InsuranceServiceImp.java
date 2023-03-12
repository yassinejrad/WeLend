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
import java.util.*;
import java.util.stream.Collectors;


@Service
public class InsuranceServiceImp implements InsuranceService{

    @Autowired
    InsuranceRepo insuranceRepo;
    @Autowired
    InsuranceTransactionRepo insuranceTransactionRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
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
    public List<insurance> getAllInsurancesByAccountID(Integer accountID){
        return insuranceRepo.findAllByAccount_AccountID(accountID);
    }
    @Override
    public HashMap<String, Double> calculateInterestByYear(Integer year) {
        HashMap<String, Double> result = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        try {
            List<insurance> insurances = insuranceRepo.findAll();
            for (insurance insurance : insurances) {
                System.out.println(insurance.getInsuranceID());
                calendar.setTime(insurance.getEndDate());
                int insuranceYear = calendar.get(Calendar.YEAR);
                System.out.println(insuranceYear);
                System.out.println(insurance.getInsuranceID());
                List<insuranceTransaction> transactions = insuranceTransactionRepo.findAllByInsurance_InsuranceIDAndInsuranceTransactionDate_Year(insurance.getInsuranceID(),insuranceYear);
                System.out.println("transactionlist "+transactions);
                double interestRate = insurance.getIntresetRate();
                double totalInterest = 0.0;
                for (insuranceTransaction transaction : transactions) {
                    System.out.println(transaction.getDescription());
                    double transactionInterest = (transaction.getAmount() * interestRate);
                    totalInterest += transactionInterest;
                }
                result.put("Insurance N : "+insurance.getInsuranceID()+" Type : "+insurance.getInsuranceType().getName(), totalInterest);
            }
        }catch (Exception e){
            System.out.println("Error while finding insurances : " + e.getMessage());
        }
        System.out.println(result);

        return result;
    }
    @Override
    public HashMap<String, Double> calculateInterestByinsurance() {
        List<insurance> insurances = insuranceRepo.findAll();
        HashMap<String, Double> result = new HashMap<>();
        for (insurance insurance : insurances) {
            List<insuranceTransaction> transactions = insuranceTransactionRepo.findAllByInsurance_InsuranceID(insurance.getInsuranceID());
            double interestRate = insurance.getIntresetRate();
            double totalInterest = 0.0;
            for (insuranceTransaction transaction : transactions) {
                double transactionInterest = (transaction.getAmount() * interestRate);
                totalInterest += transactionInterest;
            }
            result.put("Insurance N : "+insurance.getInsuranceID()+" Type : "+insurance.getInsuranceType().getName(), totalInterest);
        }
        return result;
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
    public void createInsuranceAndTransactions(insurance insurance,Date date) {
        // Calculate the duration in months
        int durationInMonths = calculateDurationInMonths(date, insurance.getEndDate());

        // Save the insurance object
        insurance.setStartDate(date);
        insuranceRepo.save(insurance);

        // Calculate the transaction amount
        double transactionAmount = insurance.getAmount() / durationInMonths;

        // Create a transaction object for each month in the duration
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(durationInMonths);

        for (int i = 0; i < durationInMonths; i++) {
            System.out.println(i);
            // Create the transaction object
            insuranceTransaction transaction = new insuranceTransaction();
            transaction.setInsurance(insurance);
            transaction.setAmount(transactionAmount);
            transaction.setInsuranceTransactionDate(calendar.getTime());
            int j=i+1;
            transaction.setDescription("Payment N : " + j +" For the insurance " + insurance.getInsuranceType().getName());
            transaction.setInsuranceTransactionStatus(insuranceTransactionStatus.PENDING);
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


            insurance.setIntresetRate(interestRate);
            insurance.setRenewalCount(renewalCount);
            System.out.println(currentDate);
            Date endDate = convertLocalDateToDate(LocalDate.now().plusYears(1));
            insurance.setEndDate(endDate);
            Date datetest=insurance.getEndDate();
            System.out.println(datetest);
            createInsuranceAndTransactions(insurance,currentDate);

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
    //@Scheduled(cron = "* * * * * *")
    public void checkInsuranceTransactionPayments() {
        try {
        List<Account> accounts = accountRepo.findAll();
        for (Account account : accounts) {
            try {
                System.out.println(account.getAccountID());
                List<Transaction> transactions = transactionRepo.findTransactionByAccount_AccountID(account.getAccountID());
                List<insurance> insurances = insuranceRepo.findAllByAccount_AccountID(account.getAccountID());
                for (Transaction transaction : transactions) {
                    if (transaction.getTransactionType() == transactionType.INSURANCEPAYMENT) {
                        for (insurance insurance : insurances){
                            try {
                                List<insuranceTransaction> insuranceTransactions = insuranceTransactionRepo.findAllByInsurance_InsuranceID(insurance.getInsuranceID());
                                for (insuranceTransaction insuranceTransaction : insuranceTransactions) {
                                    if ( sameMonthAndYear(insuranceTransaction.getInsuranceTransactionDate(), transaction.getTransactionDate())) {
                                        System.out.println(insuranceTransaction.getInsuranceTransactionID()+" STATUS "+insuranceTransaction.getInsuranceTransactionStatus());
                                        if (insuranceTransaction.getAmount() < transaction.getAmount()) {
                                            insuranceTransaction.setInsuranceTransactionStatus(insuranceTransactionStatus.SETTLED);
                                            insuranceTransactionRepo.save(insuranceTransaction);
                                            System.out.println(insuranceTransaction.getInsuranceTransactionID()+" STATUS "+insuranceTransaction.getInsuranceTransactionStatus());
                                        } else if (insuranceTransaction.getAmount() > transaction.getAmount()) {
                                            insuranceTransaction.setInsuranceTransactionStatus(insuranceTransactionStatus.NOTFULLYSETTELED);
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
    @Override
    public HashMap<String, Double> calculateInterestByinsuranceType() {
        List<insurance> insurances = insuranceRepo.findAll();
        List<String> insuranceTypeName = insurances.stream()
                    .map(insurance -> insurance.getInsuranceType().getName())
                    .distinct()
                    .collect(Collectors.toList());
        HashMap<String, Double> result = new HashMap<>();
        for (String insuranceType : insuranceTypeName){
            double totalInterest = 0.0;
            for (insurance insurance : insurances) {
                if (Objects.equals(insurance.getInsuranceType().getName(), insuranceType)){
                    List<insuranceTransaction> transactions = insuranceTransactionRepo.findAllByInsurance_InsuranceID(insurance.getInsuranceID());
                    double interestRate = insurance.getIntresetRate();
                    for (insuranceTransaction transaction : transactions) {
                        double transactionInterest = (transaction.getAmount() * interestRate);
                        totalInterest += transactionInterest;
                    }
                }
            }
            result.put(insuranceType, totalInterest);
        }
        return result;
    }


}
