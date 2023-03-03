package com.pidev.welend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "InsuranceTransaction")
public class insuranceTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceTransactionID")
    private Integer insuranceTransactionID;
    private Float amount;
    private Date transactionDate;
    private String Description;
    @ManyToOne insurance insurance;
}
