package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.CustomerOrderDao;
import com.watches.model.Cart;
import com.watches.model.CartItem;
import com.watches.model.CustomerOrder;
import com.watches.model.Myorders;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
	 @Autowired
	    private CustomerOrderDao customerOrderDao;

	    @Autowired
	    private CartService cartService;

	    public void addCustomerOrder(CustomerOrder customerOrder){
	        customerOrderDao.addCustomerOrder(customerOrder);
	    }

	    public double getCustomerOrderGrandTotal(int cartId){
	        double grandTotal = 0;
	        Cart cart = cartService.getCartByCartId(cartId);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (CartItem item : cartItems){
	            grandTotal += item.getTotalprice();
	        }

	        return grandTotal;
	    }

		public List<Myorders> orders(int customerId) {
			
			return customerOrderDao.orders(customerId);
		}

		public Myorders myorder(String orderId) {
			
			return customerOrderDao.myorder(orderId);
		}

}
