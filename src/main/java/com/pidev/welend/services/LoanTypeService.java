package com.pidev.welend.services;

import com.pidev.welend.entities.LoanType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoanTypeService {
    public LoanType addLoanType(LoanType a );
    public LoanType updateLoanType(LoanType a);
    public List<LoanType> getAllLoanTypes();
    public LoanType getLoanTypeById(Integer LoanTypeID);
    public void deleteLoanType(Integer LoanTypeID);
}
