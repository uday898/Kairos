package com.watches.dao;

import java.util.List;

import com.watches.model.Customer;

public interface CustomerDao {
	public abstract void addCustomer(Customer customer);
	public abstract List<Customer> getAllCustomers();
	public abstract Customer getCustomerByUsername(String username);
	public abstract void Editprofile(Customer customer);
	
}
