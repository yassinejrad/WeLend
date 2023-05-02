package com.pidev.welend.repos;

import com.pidev.welend.entities.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTransactionRepo extends JpaRepository<LoanTransaction,Integer> {
}
