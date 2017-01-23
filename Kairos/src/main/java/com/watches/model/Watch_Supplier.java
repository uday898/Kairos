package com.watches.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Watch_Suppliers")
public class Watch_Supplier implements Serializable {

@Id
private String w_S_id;

@Column(name="watchid")
private String watchid;

@Column(name="sid")
private String sid;

@Column(name="price")
private double price;

private int stock;


public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getW_S_id() {
	return w_S_id;
}
public void setW_S_id(String w_S_id) {
	this.w_S_id = w_S_id;
}
public String getWatchid() {
	return watchid;
}
public void setWatchid(String watchid) {
	this.watchid = watchid;
}

public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
