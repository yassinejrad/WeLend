package com.pidev.welend.services;

import com.pidev.welend.entities.Loan;
import com.pidev.welend.entities.LoanTransaction;

import java.util.List;

public interface LoanService {
    public Loan addLoan(Loan a );
    public Loan updateLoan(Loan a);
    public List<Loan> getAllLoans();
    public Loan getLoanById(Integer LoanID);
    public void deleteLoan(Integer LoanID);
    public double calculateInterest(Loan loan);

    public List<LoanTransaction> generatePaymentSchedule(Loan loan);


}
