package com.pidev.welend.repos;

import com.pidev.welend.entities.Account;
import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InsuranceRepo extends JpaRepository<insurance,Integer> {
    List<insurance> findByAccount_AccountID(Integer accountID);
    //List<insurance> findAllByEndDate_Year(int year);
    @Query(value = "SELECT * FROM insurance WHERE YEAR(end_date) = :year", nativeQuery = true)
    List<insurance> findAllByEndDate_Year(@Param("year") int year);
}
