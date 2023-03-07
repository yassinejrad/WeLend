package com.pidev.welend.repos;

import com.pidev.welend.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepo extends JpaRepository<Loan,Integer> {
    /*void deleteById(Integer loanID) {
    }
   /* static void deleteById(Long loanID) {
    }*/
}
