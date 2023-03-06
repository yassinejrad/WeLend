package com.pidev.welend.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LoanID")
    private Integer LoanID;
    private Integer LoanNumber;
    private double LoanAmount;
    private String LoanStatus;
    private float InterestRate;
    private int durationInMonths;
    private String
    ;


    @ManyToOne
    Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
    private Set<LoanTransaction> LoanTransactions;

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    @OneToOne
    private LoanType loanType;

}
