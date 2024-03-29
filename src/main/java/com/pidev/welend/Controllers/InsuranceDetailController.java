package com.pidev.welend.Controllers;

import com.pidev.welend.entities.insuranceDetail;
import com.pidev.welend.services.InsuranceDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/insuranceDetail")
@CrossOrigin(origins = "http://localhost:4200")
public class InsuranceDetailController {
    @Autowired
    InsuranceDetailService insuranceDetailService;
    @PostMapping("/add")
    public insuranceDetail addInsuranceDetail(@RequestBody insuranceDetail i){
        return insuranceDetailService.addInsuranceDetail(i);
    }
    @PutMapping("/update")
    public insuranceDetail updateInsuranceDetail(@RequestBody insuranceDetail i){
        return insuranceDetailService.updateInsuranceDetail(i);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteInsuranceDetail(@PathVariable("id") Integer insuranceDetailID){
        insuranceDetailService.deleteInsuranceDetail(insuranceDetailID);
    }
    @GetMapping("/getAll")
    public List<insuranceDetail> getAllInsuranceDetail(){

        return insuranceDetailService.getAllInsuranceDetail();
    }
    @GetMapping("/getByID/{id}")
    public insuranceDetail getInsuranceDetailById(@PathVariable("id") Integer insuranceDetailID){
        return insuranceDetailService.getInsuranceDetailById(insuranceDetailID);
    }
    @GetMapping("/getByInsuranceID/{id}")
    public List<insuranceDetail> getInsuranceDetailByInsuranceID(@PathVariable("id") Integer insuranceID){
        return insuranceDetailService.getInsuranceDetailByInsuranceID(insuranceID);
    }
    @GetMapping("/getAverageAmountSpent/{year}")
    public HashMap<Integer, Double> calculateAverageAmountSpentOnAccidents(@PathVariable("year") Integer year){
        return insuranceDetailService.calculateAverageAmountSpentOnAccidents(year);
    }
    @GetMapping("/getAllInsuranceDetailByAccountID/{accountID}")
    public List<insuranceDetail> getAllInsuranceDetailByAccountID(@PathVariable("accountID") Integer accountID){
        return insuranceDetailService.getAllInsuranceDetailByAcountID(accountID);
    }

}
