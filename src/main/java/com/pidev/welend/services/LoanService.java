package com.pidev.welend.services;

import com.pidev.welend.entities.Loan;
import com.pidev.welend.entities.LoanTransaction;


import java.util.HashMap;
import java.util.List;

public interface LoanService {
    Loan addLoan(Loan a );
     Loan updateLoan(Loan a);
     List<Loan>getAllLoans();
     Loan getLoanById(Integer loanID);
     void deleteLoan(Integer loanID);
    List<Loan> getAllLoansByAccountID(Integer accountID);
    List<Loan> getAllByLoanAmount(double loan_amount);
     float findAccountCreditByLoanId(Integer loanId);
     HashMap<String,Double> calculateInterest();

    //calcul du taux d'interet par mois
   // HashMap<String,Double> calculateInterest();

     List<LoanTransaction> generatePaymentSchedule(Loan loan);
   //public void envoyerRappelPaiement()throws MessagingException, UnsupportedEncodingException;






}
