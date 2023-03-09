package com.pidev.welend.repos;

import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pidev.welend.entities.insuranceTransaction;

import java.util.HashMap;
import java.util.List;

public interface InsuranceTransactionRepo extends JpaRepository<insuranceTransaction,Integer> {

    List<insuranceTransaction> findByInsurance_InsuranceID(Integer InsuranceID);
    List<insuranceTransaction> findAllByInsurance_InsuranceID(Integer InsuranceID);
    List<insuranceTransaction> findAllByInsurance_InsuranceIDAndInsuranceTransactionDate_Year(Integer InsuranceID);


}
