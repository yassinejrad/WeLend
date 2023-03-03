package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Agent")
public class Agent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agentID")
    private Integer agentID;
    private String UserName;
    private Date birthDate;
    private long phoneNum;
    private String adress;
    private String email;
    private Float expenses;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private agentType agentType;
    @ManyToOne Consultation consultation;

}
