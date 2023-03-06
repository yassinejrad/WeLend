package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Loan;
import com.pidev.welend.services.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping("/add")
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.addLoan(loan);
    }
    @PutMapping("/update")
    public Loan loan(@RequestBody Loan loan)
    {
        return  loanService.updateLoan(loan);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLoan(@PathVariable("id") Integer LoanID)
    {
        loanService.deleteLoan(LoanID);
    }
    @GetMapping("/getAll")
    public List<Loan> getAllLoans()
    {
        return loanService.getAllLoans();
    }
    @GetMapping("/getByID/{id}")

    public Loan getByLoan(@PathVariable("id") Integer LoanID )
        {
            return loanService.getLoanById(LoanID);
        }
    @PostMapping("/loan/calculate-interest")
    public double calculateInterest(@RequestBody Loan loan) {
        return loanService.calculateInterest(loan);
    }




}
