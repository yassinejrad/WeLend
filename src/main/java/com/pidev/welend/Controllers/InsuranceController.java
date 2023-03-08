package com.pidev.welend.Controllers;

import com.pidev.welend.entities.insurance;
import com.pidev.welend.services.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;
    @PostMapping("/add")
    public insurance addInsurance(@RequestBody insurance i){

        return insuranceService.addInsurance(i);
    }
    @PostMapping("/update")
    public insurance updateInsurance(@RequestBody insurance i){

        return insuranceService.updateInsurance(i);
    }
    @DeleteMapping ("/delete/{id}")
    public void deleteInsurance(@PathVariable("id") Integer insuranceID){
        insuranceService.deleteInsurance(insuranceID);
    }
    @GetMapping("/getAll")
    public List<insurance> getAllInsurance(){
        return insuranceService.getAllInsurance();
    }
    @GetMapping("/getByID/{id}")
    public insurance getInsuranceById(@PathVariable("id") Integer insuranceID){
        return insuranceService.getInsuranceById(insuranceID);
    }
    @GetMapping("/calculateInterestByYear{id}")
    public HashMap<insurance, Double> calculateInterestByYear(@PathVariable("id") Integer insuranceID){
        return insuranceService.calculateInterestByYear(insuranceID);
    }
    @GetMapping("/calculateInterestByInsurance")
    public HashMap<insurance, Double> calculateInterestByInsurance(){
        return insuranceService.calculateInterestByinsurance();
    }
    @GetMapping("/renewInsurance/{id}")
    public void renewInsurance(@PathVariable("id") Integer insuranceID){
         insuranceService.renewInsurance(insuranceID);
    }
    @PostMapping("/addInsuranceAndTransaction")
    public void createInsuranceAndTransactions(@RequestBody insurance i){
         insuranceService.createInsuranceAndTransactions(i);
    }
}
