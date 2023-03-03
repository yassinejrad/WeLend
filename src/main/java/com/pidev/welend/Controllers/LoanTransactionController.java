package com.pidev.welend.Controllers;


import com.pidev.welend.entities.LoanTransaction;
import com.pidev.welend.services.LoanTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/loantransaction")
public class LoanTransactionController {
    @Autowired
    LoanTransactionService loanTransactionService;
    @PostMapping("/add")
    public LoanTransaction addLoanTransaction(@RequestBody LoanTransaction loanTransaction )
    {
        return loanTransactionService.addLoanTransaction(loanTransaction);
    }
    @PutMapping("/update")
    public LoanTransaction updateLoanTransaction(@RequestBody LoanTransaction loanTransaction)
    {
        return loanTransactionService.updateLoanTransaction(loanTransaction);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteLoanTransaction(@PathVariable("id") Integer LoanTransactionID )
    {
        loanTransactionService.deleteLoanTransaction(LoanTransactionID);
    }
    @GetMapping("/getAll")
    public List<LoanTransaction> getAllLoanTransactions()
    {
        return loanTransactionService.getAllLoanTransactions();
    }
    @GetMapping("/getByID/{id}")
    public LoanTransaction getByLoanTransaction(@PathVariable("id") Integer LoanTransactionID)
    {
        return loanTransactionService.getLoanTransactionById(LoanTransactionID);    }
}
