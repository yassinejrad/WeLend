package com.pidev.welend.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Insurance")
public class insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insuranceID")
    private Integer insuranceID;
    private String insuranceDescription;
    private Date startDate;
    private Date endDate;
    @ManyToOne Account account;
    @OneToOne insuranceType insuranceType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Set<insuranceTransaction> insuranceTransactions;
}
