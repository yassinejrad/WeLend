package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Entity
@Table( name = "agent")
public class Agent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agentID")
    private Integer agentID;
    @Size(min = 2, max = 50, message = "Le nom doit être entre 2 et 50 caractères")
    private String UserName;

    @Past(message = "La date de naissance doit être antérieure à la date actuelle")
    private Date birthDate;

    @Pattern(regexp = "\\d{8}", message = "Le numéro de téléphone doit être composé de 8 chiffres")
    private long phoneNum;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "agent")
    private Set<Reclaim> reclaims;

    @Pattern(regexp = "^\\d+\\s[A-z]+\\s[A-z]+",
            message = "L'adresse doit être au format '<numéro> <rue> <ville>'")
    private String adress;

    @Column(unique = true)
    @Email(message = "L'email doit être valide")
    private String email;

    @DecimalMax(value = "99999.99", message = "Les dépenses ne peuvent pas dépasser 99999,99")
    private BigDecimal expenses;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Le mot de passe doit contenir au moins 8 caractères, une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial")
    private String pwd;


    @Enumerated(EnumType.STRING)
    private agentType agentType;
    @ManyToOne Consultation consultation;
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
	public agentType getAgentType() {
		return agentType;
	}
	public void setAgentType(agentType agentType) {
		this.agentType = agentType;
	}
	public Integer getAgentID() {
		return agentID;
	}
	public void setAgentID(Integer agentID) {
		this.agentID = agentID;
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
	public BigDecimal getExpenses() {
		return expenses;
	}
	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
    
    

}
