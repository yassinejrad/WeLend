package com.pidev.welend.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    @Column(name="loanID")
    private Integer loanID;
    private Integer loanNumber;
    private double loanAmount;
    //private LoanStatus Status;
    private float interestRate;
    private int durationInMonths;
    private String collaterals;
    private LocalDate datePaiement;
    //List<LoanTransaction> RepaymentSchedule;




    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    @ManyToOne
    Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
    private List<LoanTransaction> loanTransactions = new ArrayList<>();

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    @OneToOne
    private LoanType loanType;
    @ManyToOne
    Client client;


    public void addLoanTransaction(LoanTransaction loanTransaction) {
        this.loanTransactions.add(loanTransaction);
        loanTransaction.setLoan(this);
    }

}
