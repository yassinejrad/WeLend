package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;

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

}
