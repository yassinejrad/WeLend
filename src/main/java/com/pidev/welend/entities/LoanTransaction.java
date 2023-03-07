package com.pidev.welend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "LoanTransaction")
public class LoanTransaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LoanTransactionID")
    private Integer LoanTransactionID;
    private double LoanTransactionAmount;
    private LocalDate LoanTransactionDate;
    private LoanStatus Status;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    @ManyToOne
    Loan loan;

    public LoanTransaction(double monthlyPayment, LocalDate loanTransactionDate, String unpaid) {
    }
}
