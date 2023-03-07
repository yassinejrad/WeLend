package com.pidev.welend.services;


import com.pidev.welend.entities.Loan;

import com.pidev.welend.entities.LoanTransaction;
import com.pidev.welend.repos.LoanRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // aide à la journalisation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.lang.String;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImp implements LoanService {
    LoanRepo loanRepo;
   // @Autowired
    //NotificationService notificationService;

    public Loan addLoan(Loan l) {
        return loanRepo.save(l);
    }

    public Loan updateLoan(Loan l) {
        return loanRepo.save(l);
    }



    @Override
    public List<Loan> getAllLoans() {
        return (List<Loan>) loanRepo.findAll();

    }

    @Override
    public Loan getLoanById(Integer LoanID) {

        return loanRepo.findById(LoanID).orElse(null);
    }

   /* public Loan getLoanByID(Integer LoanID) {
        return loanRepo.findById(LoanID).orElse(null);
    }*/

    @Override
    public void deleteLoan(Integer LoanID) {
        loanRepo.deleteById(LoanID);
    }
    public double calculateInterest(Loan loan) {
        double monthlyInterestRate = loan.getInterestRate() / 12 / 100;
        double totalInterest = loan.getLoanAmount() * monthlyInterestRate * loan.getDurationInMonths();
        return totalInterest;
    }

    public List<LoanTransaction> generatePaymentSchedule(Loan loan) {
        List<LoanTransaction> loanTransactions = new ArrayList<>();
        double monthlyInterestRate = loan.getInterestRate() / 12 / 100;
        double monthlyPayment = loan.getLoanAmount() * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -loan.getDurationInMonths()));
        LocalDate loanTransactionDate = LocalDate.now();
        for (int i = 0; i < loan.getDurationInMonths(); i++) {
            loanTransactionDate = loanTransactionDate.plusMonths(1);
            LoanTransaction loanTransaction = new LoanTransaction(monthlyPayment, loanTransactionDate, "UNPAID");
            loanTransactions.add(loanTransaction);
        }
        return loanTransactions;
    }


}



