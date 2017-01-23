package com.watches.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vw1 {
	@Id
	private String w_s_id;
	private String watchid;
	private String watchName;
	private double price;
	private String brand;
	private String sname;
	private int gid;
	private double rating;
	private String sid;
	private int stock;
	
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getW_s_id() {
		return w_s_id;
	}
	public void setW_s_id(String w_s_id) {
		this.w_s_id = w_s_id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	
	
}
