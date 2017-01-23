package com.watches.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class CartItem implements Serializable {	

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int cartItemId;

private int quantity;

private String w_s_id;
private double price;

private double totalprice;

@ManyToOne
@JoinColumn(name="watchid")
private Watch watch;


@ManyToOne
@JoinColumn(name="cartid")
@JsonIgnore
private Cart cart;


public String getW_s_id() {
	return w_s_id;
}
public void setW_s_id(String w_s_id) {
	this.w_s_id = w_s_id;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getCartItemId() {
	return cartItemId;
}
public double getTotalprice() {
	return totalprice;
}
public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}
public void setCartItemId(int cartItemId) {
	this.cartItemId = cartItemId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Watch getWatch() {
	return watch;
}
public void setWatch(Watch watch) {
	this.watch = watch;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
private static final long serialVersionUID = 1L;

}
