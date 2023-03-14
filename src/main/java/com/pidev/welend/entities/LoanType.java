package com.pidev.welend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "LoanType")
public class LoanType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="loanTypeID")
    private Integer loanTypeID;
    private String loanTypeName;
   // private Duration duration;
    private Float value;

    @Enumerated(EnumType.STRING)
    private LoanTerm LoanTerm;

    @OneToOne
    private Loan loan;


}



