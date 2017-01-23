package com.watches.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="wishlist")
public class WishList {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	  private int wishId;
	
	private double price;
	
	private String w_s_id;
	
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	
	private Date wishdate;
	
	@ManyToOne
	@JoinColumn(name="watchid")
	private Watch watch;

	
	public int getWishId() {
		return wishId;
	}

	public void setWishId(int wishId) {
		this.wishId = wishId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getW_s_id() {
		return w_s_id;
	}

	public void setW_s_id(String w_s_id) {
		this.w_s_id = w_s_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getWishdate() {
		return wishdate;
	}

	public void setWishdate(Date wishdate) {
		this.wishdate = wishdate;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	
	

}
