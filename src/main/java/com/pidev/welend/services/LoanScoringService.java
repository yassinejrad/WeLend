package com.pidev.welend.services;


import com.pidev.welend.entities.LoanScoreWeights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoanScoringService {
    @Autowired
    private LoanScoreWeights loanScoreWeights;

    @Value("${loan.approval.threshold}")
    private int loanApprovalThreshold;

    public int calculateLoanScore(LoanScoreWeights loanScoreWeights) {
        int creditScore = (int) loanScoreWeights.getCreditScore();
        double income = loanScoreWeights.getIncome();
        double debtToIncome = loanScoreWeights.getDebtToIncome();
        int employmentHistory = (int) loanScoreWeights.getEmploymentHistory();

        double score = (loanScoreWeights.getCreditScore() * creditScore) +  //bech najmou ne7sbou score bel poids mta3 kol we7d
                (loanScoreWeights.getIncome() * income) +                   //eli 7atinehom fel application properties
                (loanScoreWeights.getDebtToIncome() * debtToIncome) +
                (loanScoreWeights.getEmploymentHistory() * employmentHistory);

        return (int) score;

    }

    public boolean isLoanApproved(int loanScore) {
        return loanScore >= loanApprovalThreshold; // ta3melek check kenou true wala false
    }
}
