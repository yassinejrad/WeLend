package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table( name = "LoanTransaction")
public class LoanTransaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LoanTransactionID")
    private Integer LoanTransactionID;
    private double LoanTransactionAmount;
    private Date LoanTransactionDate;

    @ManyToOne
    Loan loan;
}
