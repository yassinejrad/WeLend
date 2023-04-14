package com.pidev.welend.Controllers;


import com.pidev.welend.entities.LoanScoreWeights;
import com.pidev.welend.services.LoanScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan_application")
@CrossOrigin(origins = "http://localhost:4200")
public class LoanScoringController {
    @Autowired
    private LoanScoringService loanScoringService;

    @PostMapping("/loanscore")
    public ResponseEntity<String> submitLoanScoreWeights(@RequestBody LoanScoreWeights loanScoreWeights) {
        int loanScore = loanScoringService.calculateLoanScore(loanScoreWeights);

        if (loanScoringService.isLoanApproved(loanScore)) {
            return ResponseEntity.ok("Loan application approved");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Loan application denied");
        }
    }

}
