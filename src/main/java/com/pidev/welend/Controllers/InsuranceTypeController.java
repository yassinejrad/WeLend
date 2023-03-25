package com.pidev.welend.Controllers;


import com.pidev.welend.entities.insuranceTransaction;
import com.pidev.welend.entities.insuranceType;
import com.pidev.welend.services.InsuranceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/insuranceType")
public class InsuranceTypeController {
    @Autowired
    InsuranceTypeService insuranceTypeService;
    @PostMapping("/add")
    public insuranceType addInsuranceType(@RequestBody insuranceType i){
        return insuranceTypeService.addInsuranceType(i);
    }
    @PostMapping("/update")
    public insuranceType updateInsuranceType(@RequestBody insuranceType i){
        return insuranceTypeService.updateInsuranceType(i);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteInsuranceType(@PathVariable("id") Integer insuranceID){
        insuranceTypeService.deleteInsuranceType(insuranceID);
    }
    @GetMapping("/getAll")
    public List<insuranceType> getAllInsuranceType(){
        return insuranceTypeService.getAllInsuranceType();
    }
    @GetMapping("/getByID/{id}")
    public insuranceType getInsuranceTypeById(@PathVariable("id") Integer insuranceID){
        return insuranceTypeService.getInsuranceTypeById(insuranceID);
    }


}
