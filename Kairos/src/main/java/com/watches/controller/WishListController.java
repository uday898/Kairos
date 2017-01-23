package com.watches.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.watches.model.Cart;
import com.watches.model.CartItem;
import com.watches.model.Customer;
import com.watches.model.Myorders;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.model.WishList;
import com.watches.service.CartItemService;
import com.watches.service.CartService;
import com.watches.service.CustomerService;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;
import com.watches.service.WishListService;

@Controller
public class WishListController {
	
	@Autowired	
	private CustomerService customerService;
	@Autowired
	private WatchService watchservice;
	@Autowired
	private WishListService wishListService;

	
	
	@RequestMapping("/wishit/{w_s_id}")
	//@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public String addcItem(@PathVariable(value="w_s_id")String wsid,Model model){
		
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerService.getCustomerByUsername(username);
	    
	    Vw1 view =watchservice.getrecord(wsid);
	    Date date =new Date();
	    Watch watch=watchservice.getWatchById(view.getWatchid());	
	   
	    WishList Item =new WishList();
	    Item.setWatch(watch);
	    Item.setCustomer(customer);
	    Item.setW_s_id(wsid);
	    Item.setWishdate(date);
	    Item.setPrice(view.getPrice());
	     
	    wishListService.addWishItem(Item);
	    model.addAttribute("wsid", wsid);
	    return"redirect:/ViewWatch{wsid}";
	}

	@RequestMapping("/wishitems")
	public @ResponseBody int count()
	{
		User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username= user.getUsername();
		Customer customer =customerService.getCustomerByUsername(username);
		int customerId=customer.getCustomerId();
		int items=wishListService.countwishitems(customerId);
		
	return items;

	}
	
	 @RequestMapping("/MyWishList")
	    public String myWishList(Model model){
	    	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String username= user.getUsername();
	        Customer customer= customerService.getCustomerByUsername(username);
	        int customerId =customer.getCustomerId();
	        List <WishList> Items=wishListService.wishitems(customerId);
	        model.addAttribute("Items",Items);
	    return "WishList";	
	    }
	 
	 @RequestMapping("/removeitem/{wishId}")
	// @ResponseStatus(value=HttpStatus.NO_CONTENT)
	 public String removeCartItem(
	 	@PathVariable(value="wishId") int wishId){
	 	wishListService.removeWishitem(wishId);
	 	return"redirect:/MyWishList";
	 }
	
	 @RequestMapping("/removewishitem/{wishId}")
     @ResponseStatus(value=HttpStatus.NO_CONTENT)
		 public void removeCartItm(
		 	@PathVariable(value="wishId") int wishId){
		 	wishListService.removeWishitem(wishId);
		 	
		 }

}
