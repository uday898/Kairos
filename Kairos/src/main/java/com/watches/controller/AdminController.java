package com.watches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watches.model.Statistics;
import com.watches.model.Users;
import com.watches.service.CustomerService;
import com.watches.service.OperationsService;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;

@Controller
public class AdminController {
	
	@Autowired
	private OperationsService operationService;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private SupplierService supplierService;
	

	@Autowired
	private WatchService watchservice;
	
	
	@RequestMapping("/stats")
	public String stats(Model model){
		List<Statistics> stats=operationService.stats();
		model.addAttribute("stats", stats);
		return"Statistics";
	}
	
	@RequestMapping("/users")
	public String displayUser(Model model){
		List<Users> userlist = operationService.getAllUsers();
		model.addAttribute("userlist",userlist);
		
		return "Viewusers";
	}
	
	@RequestMapping("/enableUser/{userId}")
	public String enableUser(@PathVariable("userId")int userId,Model model){
		Users user = operationService.getUserById(userId);
		user.setEnabled(true);
		operationService.enableUser(user);
		System.out.print("\nUser enabled");
		return "redirect:/users";
		 
	}
	@RequestMapping("/disableUser/{userId}")
	public String disableUser(@PathVariable("userId")int userId,Model model){
		Users user = operationService.getUserById(userId);
		
		user.setEnabled(false);
		operationService.disableUser(user);
		return "redirect:/users";
		
	}
	
	
	

}
