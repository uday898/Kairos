package com.watches.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Users implements Serializable{	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int userId;

@NotEmpty(message="Username cannot be Empty")
private String username;


@NotEmpty(message="password cannot be Empty")
private String password;

private boolean enabled;

@OneToOne(mappedBy="users")
private Customer customer;


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
private static final long serialVersionUID = 1L;
}
