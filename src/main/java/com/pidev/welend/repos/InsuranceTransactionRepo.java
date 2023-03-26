package com.pidev.welend.repos;

import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pidev.welend.entities.insuranceTransaction;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface InsuranceTransactionRepo extends JpaRepository<insuranceTransaction,Integer> {

    List<insuranceTransaction> findByInsurance_InsuranceID(Integer InsuranceID);
    List<insuranceTransaction> findAllByInsurance_InsuranceID(Integer InsuranceID);
    //List<insuranceTransaction> findAllByInsurance_InsuranceIDAndInsuranceTransactionDate_Year(int insuranceId, int year);
    @Query(value = "SELECT * FROM insurance_transaction " +
            "WHERE insurance_insuranceid = ?1 " +
            "AND YEAR(insurance_transaction_date) = ?2", nativeQuery = true)
    List<insuranceTransaction> findAllByInsurance_InsuranceIDAndInsuranceTransactionDate_Year(int insuranceId, int year);

    List<insuranceTransaction> findAllByInsurance_Account_AccountID(int accountID);

}
