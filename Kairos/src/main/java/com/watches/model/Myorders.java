package com.watches.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name="Myorders")
@Entity
public class Myorders {
	
	@Id
	  private String orderId;
	
	private int quantity;
	
	private double price;
	
	private String w_s_id;
	
	private boolean reviewed;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	private double totalprice;
	
	private Date orderdate;
	
	@ManyToOne
	@JoinColumn(name="watchid")
	private Watch watch;

	
	
	public boolean isReviewed() {
		return reviewed;
	}

	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
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

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	
	
	
	
	
}
