package com.pidev.welend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pidev.welend.entities.insuranceTransaction;

public interface InsuranceTransactionRepo extends JpaRepository<insuranceTransaction,Integer> {
}
