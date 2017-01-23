package com.watches.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.Authorities;
import com.watches.model.Cart;
import com.watches.model.Customer;
import com.watches.model.ShippingAddress;
import com.watches.model.Users;


@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
@Autowired
private SessionFactory sessionFactory;

public SessionFactory getSessionFactory() {
	return sessionFactory;
}



public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}



	public void addCustomer(Customer customer) {
		System.out.println("adding customer in dao");
		Session session=sessionFactory.openSession();
		//customer - has users, billingaddress, shippingaddress
		//insert the users , billingaddress, shippingaddress
		customer.getUsers().setEnabled(true);
		
		ShippingAddress shippingAddress=new ShippingAddress();
		shippingAddress.setApartmentNumber(customer.getBillingAddress().getApartmentNumber());
		shippingAddress.setCountry(customer.getBillingAddress().getCountry());
		shippingAddress.setCity(customer.getBillingAddress().getCity());
		shippingAddress.setState(customer.getBillingAddress().getState());
		shippingAddress.setStreetName(customer.getBillingAddress().getStreetName());
		shippingAddress.setZipcode(customer.getBillingAddress().getZipcode());
		
		customer.setShippingAddress(shippingAddress);
		
		
		Authorities authorities=new Authorities();//transient - heapmemory 
		String username=customer.getUsers().getUsername();
		authorities.setUsername(username);
		authorities.setAuthorities("ROLE_USER");
		
		Cart cart = new Cart();//new cart
	    //It is to set CartId for Customer table
		customer.setCart(cart);//set the cart to the customer
		//if we omit this statement, then it will insert null for customerid in cart
		//to set the customerid in cart table
		cart.setGrandTotal(0);
		cart.setCustomer(customer); 
		session.save(customer); 
		session.save(authorities); //persistent
		session.flush();
		session.close();
		
	}
	
	public void Editprofile(Customer customer) {
		Session ss = sessionFactory.openSession();
		ss.update(customer);
		ss.flush();
		ss.close();
	}



	public List<Customer> getAllCustomers() {
		Session session=sessionFactory.openSession();
		List<Customer> customerList=session.createQuery("from Customer").list();
		//select * from customer 
		//list of records.list() // into list of customer objects
		return customerList;
	}



	public Customer getCustomerByUsername(String username) {
		Session session=sessionFactory.openSession();
		//using username - get users details
		Query query=session.createQuery("from Users where username=?");
		query.setString(0, username);
		Users users=(Users)query.uniqueResult();
		
		//From users get Customer details
		
		Customer customer=users.getCustomer();
		session.flush();
		session.close();
		return customer;
		
		
	}	
}
