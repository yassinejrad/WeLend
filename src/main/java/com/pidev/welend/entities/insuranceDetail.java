package com.pidev.welend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "InsuranceDetail")
public class insuranceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceDetailID")
    private Integer insuranceDetailID;
    private Float insuredAmount;
    private Date accidentDate;
    private String accidentLocation;
    private String description;
    @ManyToOne insurance insurance;

}
