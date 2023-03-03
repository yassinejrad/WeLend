package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.util.Date;


@Entity
@Table( name = "LoanType")
public class LoanType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LoanTypeID")
    private Integer LoanTypeID;
    private String LoanTypeName;
    private Duration duration;
    private Float Value;

    @Enumerated(EnumType.STRING)
    private LoanTerm LoanTerm;

    @OneToOne
    private Loan loan;


}



