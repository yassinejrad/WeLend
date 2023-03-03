package com.pidev.welend.entities;

import javax.persistence.*;

@Entity
@Table( name = "InsuranceType")
public class insuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceTypeID")
    private String name;
    private Float value;
    private String Description;
    private Float monthlyFees;
}
