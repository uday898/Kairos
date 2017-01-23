package com.watches.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="suppliers")
public class Suppliers implements Serializable {
	
	@Id
	@Column(name="sid")
	private String sid;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="rating")
	private double rating;
	
	
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Column(name="supp_desc")
	private String supp_desc;
	
	@ManyToMany(mappedBy="suppliers")
	@JsonIgnore()
	private List <Watch> watches;
	
	

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Watch> getWatches() {
		return watches;
	}

	public void setWatches(List<Watch> watches) {
		this.watches = watches;
	}

	public String getSupp_desc() {
		return supp_desc;
	}

	public void setSupp_desc(String supp_desc) {
		this.supp_desc = supp_desc;
	}

	
}
