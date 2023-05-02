package com.pidev.welend.services;

//import com.pidev.welend.entities.Loan;
import com.pidev.welend.entities.LoanTransaction;

import java.util.List;

public interface LoanTransactionService {
    LoanTransaction addLoanTransaction(LoanTransaction l);

    LoanTransaction updateLoanTransaction(LoanTransaction l);

    List<LoanTransaction> getAllLoanTransactions();
     LoanTransaction getLoanTransactionById(Integer loanTransactionID);
    void deleteLoanTransaction(Integer loanTransactionID);
}
