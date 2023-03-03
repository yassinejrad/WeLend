package com.pidev.welend.repos;

import com.pidev.welend.entities.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LoanTansactionRepo extends CrudRepository<LoanTransaction,Integer> {
}
