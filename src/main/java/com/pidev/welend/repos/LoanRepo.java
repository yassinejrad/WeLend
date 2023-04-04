package com.pidev.welend.repos;

import com.pidev.welend.entities.Loan;
import com.pidev.welend.entities.LoanStatus;
import com.pidev.welend.entities.insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepo extends JpaRepository<Loan,Integer> {
    @Query(value="SELECT * FROM loan WHERE loan_amount=?1",nativeQuery=true)
    public List<Loan> getAllByLoanAmount(double loan_amount);

    @Query("SELECT l.account.credit FROM Loan l WHERE l.loanID = :loanId")
    float findAccountCreditByLoanId(@Param("loanId") Integer loanId);

    @Query("SELECT l FROM Loan l WHERE l.account.accountID = :accountId")
    List<Loan> findLoansByAccountId(@Param("accountId") Integer accountId);
    List<Loan> findAllByAccount_AccountID(Integer accountID);

   // List<Loan> findByDatePaiementBeforeAndStatut(LocalDate date, LoanStatus loanStatus);



}
