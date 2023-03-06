package com.pidev.welend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pidev.welend.entities.insuranceTransaction;

import java.util.List;

public interface InsuranceTransactionRepo extends JpaRepository<insuranceTransaction,Integer> {
    List<insuranceTransaction> findByInsurance_InsuranceID(Integer InsuranceID);
}
