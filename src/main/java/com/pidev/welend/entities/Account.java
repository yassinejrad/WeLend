package com.pidev.welend.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table( name = "Account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountID")
    private Integer accountID;
@Enumerated(EnumType.STRING)
    private  accountType accountType;
@Enumerated(EnumType.STRING)
    private statusAccount statusAccount;
    private Date openDate;
    private float credit ;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "account")//esm lattribut moush lclass
    private Set<Transaction> transactions;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private Set<insurance> insurances;
    @ManyToOne Client client;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private Set<Notification> notifications;



}
