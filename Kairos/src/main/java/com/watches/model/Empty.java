package com.watches.model;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empty")
public class Empty {

		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int reviewId;
		
		
		
		private double srating;
		
		private String review;
		
		private double rating;
		
		private Clob title;

		public int getReviewId() {
			return reviewId;
		}

		public void setReviewId(int reviewId) {
			this.reviewId = reviewId;
		}

		public double getSrating() {
			return srating;
		}

		public void setSrating(double srating) {
			this.srating = srating;
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

		public Clob getTitle() {
			return title;
		}

		public void setTitle(Clob title) {
			this.title = title;
		}
		
		

		
	
}
