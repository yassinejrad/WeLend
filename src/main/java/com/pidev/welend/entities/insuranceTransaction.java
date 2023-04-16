package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table( name = "InsuranceTransaction")
public class insuranceTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceTransactionID")
    private Integer insuranceTransactionID;
    private double amount;
    @Enumerated(EnumType.STRING)
    private insuranceTransactionStatus insuranceTransactionStatus;
    private String Description;
    private Date insuranceTransactionDate;
    @ManyToOne insurance insurance;
	public Integer getInsuranceTransactionID() {
		return insuranceTransactionID;
	}
	public void setInsuranceTransactionID(Integer insuranceTransactionID) {
		this.insuranceTransactionID = insuranceTransactionID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public insuranceTransactionStatus getInsuranceTransactionStatus() {
		return insuranceTransactionStatus;
	}
	public void setInsuranceTransactionStatus(insuranceTransactionStatus insuranceTransactionStatus) {
		this.insuranceTransactionStatus = insuranceTransactionStatus;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getInsuranceTransactionDate() {
		return insuranceTransactionDate;
	}
	public void setInsuranceTransactionDate(Date insuranceTransactionDate) {
		this.insuranceTransactionDate = insuranceTransactionDate;
	}
	public insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(insurance insurance) {
		this.insurance = insurance;
	}
    
}
