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
@Table( name = "Consultation")
public class Consultation implements Serializable {
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
