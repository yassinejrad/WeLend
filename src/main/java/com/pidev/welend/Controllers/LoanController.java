package com.pidev.welend.Controllers;

import com.pidev.welend.entities.Loan;
import com.pidev.welend.entities.LoanTransaction;
import com.pidev.welend.services.LoanExcelExportService;
import com.pidev.welend.services.LoanService;
import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/loan")
@CrossOrigin(origins = "http://localhost:4200")
public class LoanController {
    //@Autowired
    LoanService loanService;

    @PostMapping("/add")
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.addLoan(loan);
    }
    @PutMapping("/update")
    public Loan updateloan(@RequestBody Loan loan)
    {
        return  loanService.updateLoan(loan);
    }
    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public void deleteLoan(@PathVariable("id") Integer loanID)
    {
        loanService.deleteLoan(loanID);
    }
    @GetMapping("/getAll")
    //@ResponseBody
    public List<Loan> getAllLoans()
    {
        return loanService.getAllLoans();
    }
    @GetMapping("/getByID/{id}")

    public Loan getByLoan(@PathVariable("id") Integer loanID )
        {
            return loanService.getLoanById(loanID);
        }
    @PostMapping("/calculate-interest")
    public HashMap<String,Double>calculateInterest(){
        return loanService.calculateInterest();
    }

    /* public double calculateInterest(@RequestBody Loan loan) {
        return loanService.calculateInterest(loan);
    }*/

   @GetMapping("/getAllByLoanAmount/{loan_amount}")
   @ResponseBody
   public List<Loan>getAllByLoanAmount(@PathVariable("loan_amount") Double loan_amount){
       return loanService.getAllByLoanAmount(loan_amount);
   }

    @PostMapping("/generate_payment_schedule")
    public List<LoanTransaction> generatePaymentSchedule(@RequestBody Loan loan) {
        return loanService.generatePaymentSchedule(loan);
    }

    @GetMapping("/{loanId}/account-credit")
    public ResponseEntity<Float> getAccountCreditByLoanId(@PathVariable Integer loanId) {
        float accountCredit = loanService.findAccountCreditByLoanId(loanId);
        return ResponseEntity.ok(accountCredit);
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=loans_   " + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Loan> loanList = loanService.getAllLoans();

        LoanExcelExportService excelExporter = new LoanExcelExportService(loanList);

        excelExporter.export(response);
    }


}
