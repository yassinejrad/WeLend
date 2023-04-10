package com.pidev.welend.Controllers;


import com.pidev.welend.services.LoanTypeService;
import com.pidev.welend.entities.LoanType;
import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import java.lang.String;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/loantype")
public class LoanTypeController {
    //@Autowired
    LoanTypeService  loanTypeService;

    @PostMapping("/add")
    public LoanType addLoanType(@RequestBody LoanType loanType)
    {
        return loanTypeService.addLoanType(loanType);
    }
    @PutMapping("/update")
    public LoanType updateLoanType(@RequestBody LoanType loanType)
    {
        return loanTypeService.updateLoanType(loanType);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLoanType(@PathVariable("id") Integer LoanTypeID)
    {
        loanTypeService.deleteLoanType(LoanTypeID);
    }
    @GetMapping("/getAll")
    public List<LoanType> getLoanTypes()
    {
        return loanTypeService.getAllLoanTypes();
    }
    @GetMapping("/getByID/{id}")
    public LoanType getByLoanType(@PathVariable("id") Integer LoanTypreID)
    {
        return loanTypeService.getLoanTypeById(LoanTypreID);
    }
}
