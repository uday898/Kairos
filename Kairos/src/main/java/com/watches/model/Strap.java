package com.watches.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="strap")
public class Strap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="strapid")
	private int strapid;
	
	@Column(name="strapmaterial")
	private String StrapMaterial;
	
	@OneToMany(mappedBy="strap",cascade=CascadeType.ALL)
	@JsonIgnore
	List <Watch> watches;
	public int getStrapid() {
		return strapid;
	}
	public void setStrapid(int strapid) {
		this.strapid = strapid;
	}
	public String getStrapMaterial() {
		return StrapMaterial;
	}
	public void setStrapMaterial(String strapMaterial) {
		StrapMaterial = strapMaterial;
	}
	public List<Watch> getWatches() {
		return watches;
	}
	public void setWatches(List<Watch> watches) {
		this.watches = watches;
	}
	
}
