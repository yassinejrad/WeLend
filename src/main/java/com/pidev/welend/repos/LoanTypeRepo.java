package com.pidev.welend.repos;

import com.pidev.welend.entities.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LoanTypeRepo extends JpaRepository<LoanType,Integer> {
}
