package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionID")
    private Integer transactionID;
    @ManyToOne Account account;
    private Integer reciever;
    @Enumerated(EnumType.STRING)
    private transactionType transactionType;
    @Enumerated(EnumType.STRING)
    private transactionStatus transactionStatus;
    @Enumerated(EnumType.STRING)
    private  transactionMethod transactionMethod;
    private String transactionPurpuse;
    private float exchangeRate;
    private float amount;
    private String currency;
    private float fees;
    private Date transactionDate;
    @ManyToOne transactionCategory transactionCategory;



}
