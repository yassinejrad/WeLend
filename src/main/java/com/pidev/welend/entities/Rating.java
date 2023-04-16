package com.pidev.welend.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "rating")
public class Rating {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	  private Integer rate;
	  @OneToOne
	private Client client;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Client getClient() {
		return client;
	}
	public Rating() {
		super();
	}
	public Rating(Integer id, Integer rate, Client client) {
		super();
		this.id = id;
		this.rate = rate;
		this.client = client;
	}
	public Rating(Integer rate, Client client) {
		super();
		this.rate = rate;
		this.client = client;
	}
	
	  
	  
}
