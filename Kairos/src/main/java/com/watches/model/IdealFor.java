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
@Table(name="Idealfor")
public class IdealFor implements Serializable {
	@Id
	@Column(name="Gid")
	private int gid;
	
	
	@Column(name="idealfor")
	private String idealforName;
	
	@OneToMany(mappedBy="idealfor",cascade=CascadeType.ALL)
	@JsonIgnore
	List <Watch> watches;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	public List<Watch> getWatches() {
		return watches;
	}
	public void setWatches(List<Watch> watches) {
		this.watches = watches;
		
	}
	
	
	public String getIdealforName() {
		return idealforName;
	}
	public void setIdealforName(String idealforName) {
		this.idealforName = idealforName;
	}


	private static final long serialVersionUID = 1L;
}
