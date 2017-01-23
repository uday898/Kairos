package com.watches.model;

import java.io.Serializable;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="watch")
public class Watch implements Serializable {
@Id
@Column(name="watchid")
private String watchid;

private String watchName;
  
@ManyToMany(cascade = {CascadeType.ALL})
@JoinTable(name="WATCH_SUPPLIERS", 
			joinColumns={@JoinColumn(name="WATCHID")}, 
			inverseJoinColumns={@JoinColumn(name="SID")})
@JsonIgnore
private List<Suppliers> suppliers;


@ManyToOne
@JoinColumn(name="brandid")
private Brand brand;

@ManyToOne
@JoinColumn(name="strapid")
private Strap strap;

@ManyToOne
@JoinColumn(name="typeid")
private DisplayType displaytype;

@ManyToOne
@JoinColumn(name="gid")
private IdealFor idealfor;

@Transient
private MultipartFile Imagefile;
public MultipartFile getImagefile() {
	return Imagefile;
}
public void setImagefile(MultipartFile imagefile) {
	Imagefile = imagefile;
}

public String getWatchid() {
	return watchid;
}
public void setWatchid(String watchid) {
	this.watchid = watchid;
}

public String getWatchName() {
	return watchName;
}
public void setWatchName(String watchName) {
	this.watchName = watchName;
}
public Brand getBrand() {
	return brand;
}
public void setBrand(Brand brand) {
	this.brand = brand;
}
public Strap getStrap() {
	return strap;
}
public void setStrap(Strap strap) {
	this.strap = strap;
}
public DisplayType getDisplaytype() {
	return displaytype;
}
public void setDisplaytype(DisplayType displaytype) {
	this.displaytype = displaytype;
}
public IdealFor getIdealfor() {
	return idealfor;
}
public void setIdealfor(IdealFor idealfor) {
	this.idealfor = idealfor;
}

public List<Suppliers> getSuppliers() {
	return suppliers;
}
public void setSuppliers(List<Suppliers> suppliers) {
	this.suppliers = suppliers;
}

private static final long serialVersionUID = 1L;
}
