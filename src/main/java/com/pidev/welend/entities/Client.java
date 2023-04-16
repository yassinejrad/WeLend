package com.pidev.welend.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table( name = "Client")
@JsonIgnoreProperties("accounts")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clientID")
    private Integer clientID;
    private String UserName;
    private Date birthDate;
    private long phoneNum;
    private String adress;
    @Column(unique = true)
    private String email;
    private String employement;
    private Float income;
    private Float expenses;
    private String pwd;
    private Integer score;

@Enumerated(EnumType.STRING)
    private statusLog statuslog;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Reclaim> reclaims;
@OneToOne(cascade = CascadeType.ALL,mappedBy = "client")
private Rating rate;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Account> accounts;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private  Set<Consultation> consultations;

@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Loan> loans;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public Integer getClientID() {
	return clientID;
}

public void setClientID(Integer clientID) {
	this.clientID = clientID;
}

public String getUserName() {
	return UserName;
}

public void setUserName(String userName) {
	UserName = userName;
}

public Date getBirthDate() {
	return birthDate;
}

public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}

public long getPhoneNum() {
	return phoneNum;
}

public void setPhoneNum(long phoneNum) {
	this.phoneNum = phoneNum;
}

public String getAdress() {
	return adress;
}

public void setAdress(String adress) {
	this.adress = adress;
}

public String getEmployement() {
	return employement;
}

public void setEmployement(String employement) {
	this.employement = employement;
}

public Float getIncome() {
	return income;
}

public void setIncome(Float income) {
	this.income = income;
}

public Float getExpenses() {
	return expenses;
}

public void setExpenses(Float expenses) {
	this.expenses = expenses;
}

public Integer getScore() {
	return score;
}






}
