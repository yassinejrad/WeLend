package com.pidev.welend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table( name = "Account")

@JsonIgnoreProperties({"insurances", "transactions","notifications"})

public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountID")
    private Integer accountID;
@Enumerated(EnumType.STRING)
    private  accountType accountType;
@Enumerated(EnumType.STRING)
    private statusAccount statusAccount;
    private Date openDate;
    private float credit ;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "account")//esm lattribut moush lclass
    private Set<Transaction> transactions;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private Set<insurance> insurances;
    @ManyToOne Client client;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private Set<Notification> notifications;
	public Integer getAccountID() {
		return accountID;
	}
	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}
	public accountType getAccountType() {
		return accountType;
	}
	public void setAccountType(accountType accountType) {
		this.accountType = accountType;
	}
	public statusAccount getStatusAccount() {
		return statusAccount;
	}
	public void setStatusAccount(statusAccount statusAccount) {
		this.statusAccount = statusAccount;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Set<insurance> getInsurances() {
		return insurances;
	}
	public void setInsurances(Set<insurance> insurances) {
		this.insurances = insurances;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}



}
