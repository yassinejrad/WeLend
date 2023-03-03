package com.pidev.welend.services;


import com.pidev.welend.entities.LoanTransaction;
import com.pidev.welend.repos.LoanTansactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTransactionServiceImp implements LoanTransactionService {
    LoanTansactionRepo loanTansactionRepo;

    @Override
    public LoanTransaction addLoanTransaction(LoanTransaction lt) {
        return loanTansactionRepo.save(lt);
    }

    @Override
    public LoanTransaction updateLoanTransaction(LoanTransaction lt) {
        return loanTansactionRepo.save(lt);
    }


    @Override
    public List<LoanTransaction> getAllLoanTransactions() {
        return (List<LoanTransaction>) loanTansactionRepo.findAll();

    }

    @Override
    public LoanTransaction getLoanTransactionById(Integer LoanTransactionID) {
        return loanTansactionRepo.findById(LoanTransactionID).orElse(null);
    }

    @Override
    public void deleteLoanTransaction(Integer LoanTransactionID) {
        loanTansactionRepo.deleteById(LoanTransactionID);
    }
}
