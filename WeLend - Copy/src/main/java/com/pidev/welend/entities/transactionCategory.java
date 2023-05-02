package com.pidev.welend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="transactionCategory")
public class transactionCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionCategoryID")
    private Integer transactionCategoryID;
    private String name;
    private float maxAmount;
    private String description;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "transactionCategory")
    private Set<Transaction> transactions;
}
