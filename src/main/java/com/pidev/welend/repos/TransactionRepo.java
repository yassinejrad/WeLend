package com.pidev.welend.repos;


import com.pidev.welend.entities.Transaction;
import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
    List<Transaction> findTransactionByAccount_AccountID(Integer accountID);
}
