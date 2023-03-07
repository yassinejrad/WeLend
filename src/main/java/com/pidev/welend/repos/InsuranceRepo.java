package com.pidev.welend.repos;

import com.pidev.welend.entities.Account;
import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepo extends JpaRepository<insurance,Integer> {
    List<insurance> findByAccount_AccountID(Integer accountID);
}
