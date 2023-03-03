package com.pidev.welend.services;

import com.pidev.welend.entities.Loan;
import com.pidev.welend.entities.LoanTransaction;

import java.util.List;

public interface LoanTransactionService {
    LoanTransaction addLoanTransaction(LoanTransaction lt);

    LoanTransaction updateLoanTransaction(LoanTransaction lt);

    public List<LoanTransaction> getAllLoanTransactions();
    public LoanTransaction getLoanTransactionById(Integer LoanTransactionID);
    public void deleteLoanTransaction(Integer LoanTransactionID);
}
