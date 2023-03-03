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

/*    private final LoanRepo loanRepo;
    public LoanServiceImp(LoanRepo loanRepo){
        super();
        this.loanRepo = loanRepo;
    }


    private static final Logger l = LogManager.getLogger(LoanServiceImp.class);

    @Override
    public Loan addLoan(Loan loan) {
        l.info("In addLoan : " + loan);
        Loan loan1 = loanRepo.save(loan);
        l.info("Out of addLoan : " + loan1);
        return loan1;
    }

    @Override
    public Loan addOrUpdateLoan(Loan loan) {
        l.info("In addOrUpdateLoan : " + loan);
        Loan loan1 = loanRepo.save(loan);
        l.info("Out of addOrUpdateLoan : " + loan);
        return loan1;
    }

    @Override
    public void deleteLoanById(Integer LoanID) {
        l.info("In deleteLoanByIdById : " + LoanID);
        loanRepo.deleteById(LoanID);
        l.info("Out of deleteLoanByIdById : " + LoanID);
    }

    @Override
    public Loan getLoanById(Integer LoanID) {
        l.info("In getLoanByIdById id : " + LoanID);
        Loan loan1 = loanRepo.findById(LoanID).get();
        l.info("Loan returned : " + loan1);
        return loan1;
    }

    @Override
    public List<Loan> getAllLoans() {
        l.info("In getAllLoans : ");
        List<Loan> loans = (List<Loan>) loanRepo.findAll();
        for(Loan loan1 : loans){
            l.debug("Loan +++ : " + loan1);
        }
        l.info("Out of getAllLoans : ");
        return loans;
    }

    @Override
    public Loan AddLoan(Loan loan) {
        return null;
    }

    @Override
    public Integer updateLoan(Loan loan) {
        return null;
    }

    @Override
    public void DeleteLoan(Integer LoanID) {

    }

    @Override
    public Loan FindLoanById(Integer LoanID) {
        return null;
    }

      /*@Override
    public List<Loan> getAllLoans() {
        return LoanRepo.findAll();
    }

    @Override
    public Loan AddLoan(Loan loan) {
        return null;
    }

    @Override
    public Integer updateLoan(Loan loan) {
        LoanRepo.save(loan);
        return loan.get;
    }

    @Override
    public void DeleteLoan(Integer LoanID) {
        LoanRepo.deleteById(LoanID);

    }

    @Override
    public Loan FindLoanById(Integer LoanID) {
        Loan loan = LoanRepo.findById(LoanID).get();
        return loan;

    }*/


}



