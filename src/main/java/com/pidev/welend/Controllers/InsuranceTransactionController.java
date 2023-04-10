package com.pidev.welend.Controllers;

import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.services.InsuranceTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/insuranceTransaction")
public class InsuranceTransactionController {
    @Autowired
    InsuranceTransactionService insuranceTransactionService;
    @PostMapping("/add")
    public insuranceTransaction addInsuranceTransaction(@RequestBody insuranceTransaction i){
        return insuranceTransactionService.addInsuranceTransaction(i);
    }
    @PutMapping("/update")
    public insuranceTransaction updateInsuranceTransaction(@RequestBody insuranceTransaction i){
        return insuranceTransactionService.updateInsuranceTransaction(i);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteInsuranceTransaction(@PathVariable("id") Integer insuranceTransactionID){
        insuranceTransactionService.deleteInsuranceTransaction(insuranceTransactionID);
    }
    @GetMapping("/getAll")
    public List<insuranceTransaction> getAllInsurance(){
        return insuranceTransactionService.getAllInsuranceTransaction();
    }
    @GetMapping("/getByID/{id}")
    public insuranceTransaction getInsuranceTransactionById(@PathVariable("id") Integer insuranceTransactionID){
        return insuranceTransactionService.getInsuranceTransactionById(insuranceTransactionID);
    }
    @GetMapping("/getByInsuranceID/{id}")
    public List<insuranceTransaction> getInsuranceTransactionByInsuranceID(@PathVariable("id") Integer insuranceID){
        return insuranceTransactionService.getInsuranceTransactionByInsuranceID(insuranceID);
    }

    @GetMapping("/checkAllUnpaidInsuranceTransactionByYear/{id}/{year}")
    public HashMap<Integer, String> checkAllUnpaidInsuranceTransactionByYear(@PathVariable("id") Integer insuranceID,@PathVariable("year") Integer year){
        return insuranceTransactionService.checkAllUnpaidInsuranceTransactionByYear(insuranceID,year);
    }
    @GetMapping("/getAllInsuranceTransactionPendingByInsurance/{insuranceID}")
    public List<insuranceTransaction> getAllInsuranceTransactionPendingByInsurance(@PathVariable("insuranceID") Integer insuranceID){
        return insuranceTransactionService.getAllInsuranceTransactionPendingByInsurance(insuranceID);
    }
    @GetMapping("/getAllInsuranceTransactionNotfullySetteledByInsurance/{insuranceID}")
    public List<insuranceTransaction> getAllInsuranceTransactionNotfullysetteledByInsurance(@PathVariable("insuranceID") Integer insuranceID){
        return insuranceTransactionService.getAllInsuranceTransactionNotfullysetteledByInsurance(insuranceID);
    }
    @GetMapping("/getAllInsuranceTransactionSettledByInsurance/{insuranceID}")
    public List<insuranceTransaction> getAllInsuranceTransactionSettledByInsurance(@PathVariable("insuranceID") Integer insuranceID){
        return insuranceTransactionService.getAllInsuranceTransactionSettledByInsurance(insuranceID);

    }
    @GetMapping("/getAllInsuranceTransactionByAccountID/{accountID}")
    public List<insuranceTransaction> getAllInsuranceTransactionByAccountID(@PathVariable("accountID") Integer accountID){
        return insuranceTransactionService.getAllInsuranceTransactionByAcountID(accountID);
    }
}
