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
}
