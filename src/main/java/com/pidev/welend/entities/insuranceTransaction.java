package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "InsuranceTransaction")
public class insuranceTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceTransactionID")
    private Integer insuranceTransactionID;
    private Float amount;
    private Date transactionDate;

    public Integer getInsuranceTransactionID() {
        return insuranceTransactionID;
    }

    public Float getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getDescription() {
        return Description;
    }

    private String Description;
    @ManyToOne insurance insurance;
}
