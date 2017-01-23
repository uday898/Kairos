package com.watches.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="statistics")
public class Statistics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stats;
	
	
	private String watchid;


	private String sid;

	private int soldout;

	public int getStats() {
		return stats;
	}

	public void setStats(int stats) {
		this.stats = stats;
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

	public int getSoldout() {
		return soldout;
	}

	public void setSoldout(int soldout) {
		this.soldout = soldout;
	}
	
	
	
	
	
	

}
