 package com.watches.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watches.model.Cart;
import com.watches.model.Customer;
import com.watches.model.CustomerOrder;
import com.watches.model.Myorders;
import com.watches.service.CartService;
import com.watches.service.CustomerOrderService;
import com.watches.service.CustomerService;

@Controller
public class OrderController implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;
    
    
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartByCartId(cartId);
        //UPDATE CARTID FOR CUSTOMERORDER - SET CARTID
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        //SET CUSTOMERID
        customerOrder.setCustomer(customer);
        //SET BILLINGADDRESSID
        customerOrder.setBillingAddress(customer.getBillingAddress());
        //SET SHIPPINGADDRESSID
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId="+ cartId;
		
	    }
    
    
    @RequestMapping("/Myorders")
    public String myorder(Model model){
    	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username= user.getUsername();
        Customer customer= customerService.getCustomerByUsername(username);
        int customerId =customer.getCustomerId();
        List <Myorders> orders=customerOrderService.orders(customerId);
        model.addAttribute("orders",orders);
    return "order";	
    }

    
    
    
	}



