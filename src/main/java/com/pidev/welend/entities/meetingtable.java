package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "meetingtable")
public class meetingtable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meetingtableID")
    private Integer meetingtableID;

    private Date startmeeting;
    private Date endmeeting;
    private Integer duration ;

    @ManyToOne Client client;
    @ManyToOne Agent agent;
}