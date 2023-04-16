package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table( name = "InsuranceType")
public class insuranceType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceTypeID")
    private Integer insuranceTypeID;
    private String name;
    private Float value;
    private String Description;
    private Float monthlyFees;
	public Integer getInsuranceTypeID() {
		return insuranceTypeID;
	}
	public void setInsuranceTypeID(Integer insuranceTypeID) {
		this.insuranceTypeID = insuranceTypeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Float getMonthlyFees() {
		return monthlyFees;
	}
	public void setMonthlyFees(Float monthlyFees) {
		this.monthlyFees = monthlyFees;
	}
    
    

}
