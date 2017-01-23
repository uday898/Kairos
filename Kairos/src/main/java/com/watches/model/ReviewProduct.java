package com.watches.model;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviewproduct")
public class ReviewProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name="watchid")
	private Watch watch;

	private Date reviewdate;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Suppliers supplier;
	
	private double srating;
	
	private String review;
	
	private double rating;
	
	private String title;
	
	

	public Suppliers getSupplier() {
		return supplier;
	}

	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}

	public double getSrating() {
		return srating;
	}

	public void setSrating(double srating) {
		this.srating = srating;
	}

	public Date getReviewdate() {
		return reviewdate;
	}

	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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

	


	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

}
