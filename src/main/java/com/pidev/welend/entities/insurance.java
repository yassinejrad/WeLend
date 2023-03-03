package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Insurance")
public class insurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceID")
    private Integer insuranceID;
    private String insuranceDescription;
    private Date startDate;
    private Date endDate;
    @ManyToOne Account account;
    @OneToOne
    private insuranceType insuranceType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Set<insuranceTransaction> insuranceTransactions;
}
