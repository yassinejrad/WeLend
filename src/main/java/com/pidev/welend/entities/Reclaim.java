package com.pidev.welend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table( name = "Reclaim")
public class Reclaim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reclaimID")
    private Integer reclaimID;
    private String Description;
    private String response;
    @ManyToOne
	@JsonIgnore
    private Agent agent;

@Enumerated(EnumType.STRING)
    private ReclaimStatus reclaimstatus;
    @Enumerated(EnumType.STRING)
    private reclaimType reclaimType;
    @ManyToOne Client client;
	public Integer getReclaimID() {
		return reclaimID;
	}
	public void setReclaimID(Integer reclaimID) {
		this.reclaimID = reclaimID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public ReclaimStatus getReclaimstatus() {
		return reclaimstatus;
	}
	public void setReclaimstatus(ReclaimStatus reclaimstatus) {
		this.reclaimstatus = reclaimstatus;
	}
	public reclaimType getReclaimType() {
		return reclaimType;
	}
	public void setReclaimType(reclaimType reclaimType) {
		this.reclaimType = reclaimType;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
    
    
}
