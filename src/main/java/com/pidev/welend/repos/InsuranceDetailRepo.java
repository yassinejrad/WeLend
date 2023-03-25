package com.pidev.welend.repos;

import com.pidev.welend.entities.insuranceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceDetailRepo extends JpaRepository<insuranceDetail,Integer> {
     List<insuranceDetail> findAllByInsurance_InsuranceID(Integer insuranceID);
     List<insuranceDetail> findAllByInsurance_Account_AccountID(Integer accountID);

}
