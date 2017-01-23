package com.watches.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.watches.model.Cart;

import com.watches.model.Customer;
import com.watches.service.CartService;
import com.watches.service.CustomerService;

@Controller
public class CartController {

	@Autowired
	private CustomerService customerservice;
	@Autowired 
	private CartService cartservice;
	
	
	@RequestMapping("/cart")
	public String getcartId(Model model){
		User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username= user.getUsername();
		Customer customer =customerservice.getCustomerByUsername(username);
		Cart cart=customer.getCart();
		int cartId=cart.getCartId();
		model.addAttribute("cartId",cartId);
		return "cart";
	}

	
@RequestMapping("/cart/getCart/{cartId}")
public @ResponseBody Cart getCartItems(@PathVariable(value="cartId") int cartId){
	return cartservice.getCartByCartId(cartId);
}


}
