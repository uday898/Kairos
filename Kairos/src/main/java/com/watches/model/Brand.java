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
@Table(name="brand")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@Column(name="brandid")
private int brandid;

@Column(name="Brand")
private String brandName;

@OneToMany(mappedBy="brand",cascade=CascadeType.ALL)
@JsonIgnore
List <Watch> watches;

public List<Watch> getWatches() {
	return watches;
}
public void setWatches(List<Watch> watches) {
	this.watches = watches;
}
public int getBrandid() {
	return brandid;
}
public void setBrandid(int brandid) {
	this.brandid = brandid;
}
public String getBrandName() {
	return brandName;
}
public void setBrandName(String brandName) {
	this.brandName = brandName;
}



}


