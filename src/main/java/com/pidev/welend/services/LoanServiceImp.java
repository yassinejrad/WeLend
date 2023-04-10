package com.pidev.welend.services;


import com.pidev.welend.entities.Loan;

import com.pidev.welend.entities.LoanStatus;
import com.pidev.welend.entities.LoanTransaction;
import com.pidev.welend.entities.insurance;
import com.pidev.welend.repos.LoanRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.lang.String;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service

public class LoanServiceImp implements LoanService {
    @Autowired
     LoanRepo loanRepo;
   @Autowired
    NotificationService notificationService;
   @Autowired
   EmailSenderService emailSenderService;

    public Loan addLoan(Loan a) {
        return loanRepo.save(a);
    }

    public Loan updateLoan(Loan a) {
        return loanRepo.save(a);
    }


    @Override
    public List<Loan> getAllLoansByAccountID(Integer accountID){
        return loanRepo.findAllByAccount_AccountID(accountID);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepo.findAll();

    }
    @Override
    public  List<Loan> getAllByLoanAmount(double loan_amount){
        return loanRepo.getAllByLoanAmount(loan_amount);
    }

    @Override
    public Loan getLoanById(Integer loanID) {

        return loanRepo.findById(loanID).orElse(null);
    }

   /* public Loan getLoanByID(Integer LoanID) {
        return loanRepo.findById(LoanID).orElse(null);
    }*/

    @Override
    public void deleteLoan(Integer loanID) {
        loanRepo.deleteById(loanID);
    }

    //calcul du taux d'interet par mois
    @Override
    public HashMap<String,Double> calculateInterest(){
        List<Loan>loans = loanRepo.findAll();
        HashMap<String, Double> result = new HashMap<>();
        for(Loan loan: loans) {
            System.out.println(loan.getLoanID());
            double totalInterest=0.0;
            double monthlyInterestRate = loan.getInterestRate() / 12 / 100;
            totalInterest = loan.getLoanAmount() * monthlyInterestRate * loan.getDurationInMonths();
        }
        return result ;
    }
   /*public double calculateInterest(Loan loan)
   {
        double monthlyInterestRate = loan.getInterestRate() / 12 / 100;
        double totalInterest = loan.getLoanAmount() * monthlyInterestRate * loan.getDurationInMonths();
        return totalInterest;
    }

   */


    //genere automatiquement le les paiement prévu

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

    public float findAccountCreditByLoanId(Integer loanId) {
        return loanRepo.findAccountCreditByLoanId(loanId);
    }

    /*@Scheduled(cron = "0 0 0 * * *")
    public void envoyerRappelPaiement() throws MessagingException, UnsupportedEncodingException {
        LocalDate today = LocalDate.now();
        List<Loan> loans = loanRepo.findByDatePaiementBeforeAndStatut(today, LoanStatus.PAID);

        for (Loan loan : loans) {  //chronoUnit te7seb days entre 2 dates
            String message = "Bonjour " + loan.getClient().getUserName() + ",\n"
                    + "Nous vous rappelons que le paiement pour votre prêt d'un montant de " + loan.getLoanAmount()
                    + " est en retard de " + ChronoUnit.DAYS.between(loan.getDatePaiement(),today) + " jours. Veuillez effectuer le paiement dès que possible.\n"
                    + "Cordialement,\nL'équipe de la microfinance.";

            emailSenderService.envoyerEmail(loan.getAccount().getClient().getEmail(), "Rappel de paiement de prêt en retard", message);
            loan.setLoanStatus(LoanStatus.DELAY);
            loanRepo.save(loan);
        }
    }*/


}



