package com.pidev.welend.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="consultationID")
    private Integer consultationID;
    private Date date;
    private String topic;
    private String location;
    @Enumerated(EnumType.STRING)
    private consultationStatus consultationStatus;
    @Enumerated(EnumType.STRING)
    private consultationLocation consultationLocation;
    @ManyToOne Client client;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultation")
    private Set<Agent> agents;
}
