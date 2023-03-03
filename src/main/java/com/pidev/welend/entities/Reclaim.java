package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Reclaim")
public class Reclaim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reclaimID")
    private Integer reclaimID;
    private Integer ClientId;
    private String Description;
    private Integer AgentId;

@Enumerated(EnumType.STRING)
    private ReclaimStatus reclaimstatus;
    @Enumerated(EnumType.STRING)
    private reclaimType reclaimType;
    @ManyToOne Client client;
}
