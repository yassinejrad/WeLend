package com.pidev.welend.services;


import com.pidev.welend.entities.Loan;

import com.pidev.welend.repos.LoanRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // aide à la journalisation
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LoanServiceImp implements LoanService {
    LoanRepo loanRepo;

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
        double monthlyInterestRate = loan.getInterestRate() / 12 / 100; // convert annual interest rate to monthly
        double totalInterest = loan.getLoanAmount() * monthlyInterestRate * loan.getDurationInMonths();
        return totalInterest;
    }


}



