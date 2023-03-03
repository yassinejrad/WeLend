package com.pidev.welend.services;

import com.pidev.welend.entities.LoanType;
import com.pidev.welend.repos.LoanTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTypeServiceImp implements LoanTypeService{
    LoanTypeRepo loanTypeRepo;
    @Override
    public LoanType addLoanType(LoanType loanType) {
        return loanTypeRepo.save(loanType);
    }

    @Override
    public LoanType updateLoanType(LoanType loanType) {
        return loanTypeRepo.save(loanType);
    }

    @Override
    public List<LoanType> getAllLoanTypes() {
        return (List<LoanType>) loanTypeRepo.findAll();
    }

    @Override
    public LoanType getLoanTypeById(Integer LoanTypeID) {
        return loanTypeRepo.findById(LoanTypeID).orElse(null);
    }

    @Override
    public void deleteLoanType(Integer LoanTypeID) {
        loanTypeRepo.deleteById((LoanTypeID));

    }
}
