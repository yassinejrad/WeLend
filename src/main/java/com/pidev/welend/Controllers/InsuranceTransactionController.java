package com.pidev.welend.Controllers;

import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.services.InsuranceTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/update")
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
}
