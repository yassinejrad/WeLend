package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table( name = "Transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionID")
    private Integer transactionID;
    @ManyToOne Account account;
    private Integer reciever;
    @Enumerated(EnumType.STRING)
    private transactionType transactionType;
    @Enumerated(EnumType.STRING)
    private transactionStatus transactionStatus;
    @Enumerated(EnumType.STRING)
    private  transactionMethod transactionMethod;
    private String transactionPurpose;
    private float exchangeRate;
    private float amount;
    private String currency;
    private float fees;
    private Date transactionDate;
    @ManyToOne transactionCategory transactionCategory;
	public Integer getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Integer getReciever() {
		return reciever;
	}
	public void setReciever(Integer reciever) {
		this.reciever = reciever;
	}
	public transactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(transactionType transactionType) {
		this.transactionType = transactionType;
	}
	public transactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(transactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public transactionMethod getTransactionMethod() {
		return transactionMethod;
	}
	public void setTransactionMethod(transactionMethod transactionMethod) {
		this.transactionMethod = transactionMethod;
	}
	public String getTransactionPurpose() {
		return transactionPurpose;
	}
	public void setTransactionPurpose(String transactionPurpose) {
		this.transactionPurpose = transactionPurpose;
	}
	public float getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public transactionCategory getTransactionCategory() {
		return transactionCategory;
	}
	public void setTransactionCategory(transactionCategory transactionCategory) {
		this.transactionCategory = transactionCategory;
	}



}
