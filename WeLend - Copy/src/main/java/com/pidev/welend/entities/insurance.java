package com.pidev.welend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Insurance")
@JsonIgnoreProperties({"insuranceTransactions", "insuranceDetails"})
public class insurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceID")
    private Integer insuranceID;
    private String insuranceDescription;
    private Date startDate;
    private Date endDate;
    private Integer renewalCount;
    private double intresetRate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private insuranceStatus insuranceStatus;

    @ManyToOne Account account;
    @OneToOne
    private insuranceType insuranceType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Set<insuranceTransaction> insuranceTransactions;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Set<insuranceDetail> insuranceDetails;
}
