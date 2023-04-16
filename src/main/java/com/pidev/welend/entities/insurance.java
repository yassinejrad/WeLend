package com.pidev.welend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Insurance")
@JsonIgnoreProperties({"insuranceTransactions", "insuranceDetails"})
public class insurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceID")
    private Integer insuranceID;
    private String insuranceDescription;
    private Date startDate;
    private Date endDate;
    private Integer renewalCount;
    private double intresetRate;
    private double amount;


    @ManyToOne Account account;
    @OneToOne
    private insuranceType insuranceType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Set<insuranceTransaction> insuranceTransactions;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Set<insuranceDetail> insuranceDetails;
	public Integer getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(Integer insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getInsuranceDescription() {
		return insuranceDescription;
	}
	public void setInsuranceDescription(String insuranceDescription) {
		this.insuranceDescription = insuranceDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getRenewalCount() {
		return renewalCount;
	}
	public void setRenewalCount(Integer renewalCount) {
		this.renewalCount = renewalCount;
	}
	public double getIntresetRate() {
		return intresetRate;
	}
	public void setIntresetRate(double intresetRate) {
		this.intresetRate = intresetRate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public insuranceType getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(insuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}
	public Set<insuranceTransaction> getInsuranceTransactions() {
		return insuranceTransactions;
	}
	public void setInsuranceTransactions(Set<insuranceTransaction> insuranceTransactions) {
		this.insuranceTransactions = insuranceTransactions;
	}
	public Set<insuranceDetail> getInsuranceDetails() {
		return insuranceDetails;
	}
	public void setInsuranceDetails(Set<insuranceDetail> insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}
    
}
