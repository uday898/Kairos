package com.watches.dao;

import java.util.List;

import com.watches.model.CustomerOrder;
import com.watches.model.Myorders;

public interface CustomerOrderDao {
	void addCustomerOrder(CustomerOrder customerOrder);
	List <Myorders> orders(int customerId);
	public Myorders myorder(String orderId);
}
