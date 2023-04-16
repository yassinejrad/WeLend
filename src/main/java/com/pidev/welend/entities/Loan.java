package com.pidev.welend.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    //List<LoanTransaction> RepaymentSchedule;




    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    @ManyToOne
    Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
    private Set<LoanTransaction> loanTransactions;

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

	public Integer getLoanID() {
		return loanID;
	}

	public void setLoanID(Integer loanID) {
		this.loanID = loanID;
	}

	public Integer getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Integer loanNumber) {
		this.loanNumber = loanNumber;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	public String getCollaterals() {
		return collaterals;
	}

	public void setCollaterals(String collaterals) {
		this.collaterals = collaterals;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<LoanTransaction> getLoanTransactions() {
		return loanTransactions;
	}

	public void setLoanTransactions(Set<LoanTransaction> loanTransactions) {
		this.loanTransactions = loanTransactions;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
    

}
