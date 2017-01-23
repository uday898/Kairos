package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.watches.dao.CustomerDao;
import com.watches.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerdao;

	public CustomerDao getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}

	public void addCustomer(Customer customer) {
		customerdao.addCustomer(customer);
		
	}

	public List<Customer> getAllCustomers() {
		return customerdao.getAllCustomers();
	}
	public Customer getCustomerByUsername (String username){
	    return customerdao.getCustomerByUsername(username);
	}

	public void Editprofile(Customer customer) {
		customerdao.Editprofile(customer);
		
	}

	

}
