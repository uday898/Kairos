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
@Table(name="displaytype")
public class DisplayType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="typeid")
	private int typeid;
	
	@Column(name="type")
	private String typeName;
	
	@OneToMany(mappedBy="displaytype",cascade=CascadeType.ALL)
	@JsonIgnore
	List <Watch> watches;
	
	
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
	
		this.typeid = typeid;
	}
	
	public List<Watch> getWatches() {
		return watches;
	}
	public void setWatches(List<Watch> watches) {
		this.watches = watches;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
