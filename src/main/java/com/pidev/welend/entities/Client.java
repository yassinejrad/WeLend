package com.pidev.welend.entities;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table( name = "Client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clientID")
    private Integer clientID;
    private String UserName;
    private Date birthDate;
    private long phoneNum;
    private String adress;
    private String email;
    private String employement;
    private Float income;
    private Float expenses;
    private String pwd;
    private Integer score;

@Enumerated(EnumType.STRING)
    private statusLog statuslog;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Reclaim> reclaims;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Account> accounts;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private  Set<Consultation> consultations;

}
