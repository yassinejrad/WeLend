package com.pidev.welend.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LoanID")
    private Integer LoanID;
    private Integer LoanNumber;
    private double LoanAmount;
    private String LoanStatus;
    private float IntrestRate;
    private String Collaterals;   

    @ManyToOne
    Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
    private Set<LoanTransaction> LoanTransactions;

    @OneToOne
    private LoanType loanType;

}
