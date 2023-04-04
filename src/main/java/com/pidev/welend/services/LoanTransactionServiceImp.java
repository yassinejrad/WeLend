package com.pidev.welend.services;


import com.pidev.welend.entities.LoanTransaction;

import com.pidev.welend.repos.LoanTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTransactionServiceImp implements LoanTransactionService {
    @Autowired
    LoanTransactionRepo loanTransactionRepo;

    @Override
    public LoanTransaction addLoanTransaction(LoanTransaction l) {
        return loanTransactionRepo.save(l);
    }

    @Override
    public LoanTransaction updateLoanTransaction(LoanTransaction l) {
        return loanTransactionRepo.save(l);
    }


    @Override
    public List<LoanTransaction> getAllLoanTransactions() {
        return loanTransactionRepo.findAll();

    }

    @Override
    public LoanTransaction getLoanTransactionById(Integer loanTransactionID) {
        return loanTransactionRepo.findById(loanTransactionID).orElse(null);
    }

    @Override
    public void deleteLoanTransaction(Integer loanTransactionID) {
        loanTransactionRepo.deleteById(loanTransactionID);
    }
}
