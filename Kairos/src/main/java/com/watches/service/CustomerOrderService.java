package com.watches.service;

import java.util.List;

import com.watches.model.CustomerOrder;
import com.watches.model.Myorders;

public interface CustomerOrderService {
	 void addCustomerOrder(CustomerOrder customerOrder);

	    double getCustomerOrderGrandTotal(int cartId);
	    List <Myorders> orders(int customerId);
	    public Myorders myorder(String orderId);

}
