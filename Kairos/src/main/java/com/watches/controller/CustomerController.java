package com.watches.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watches.model.BillingAddress;
import com.watches.model.Customer;

import com.watches.model.Users;
import com.watches.service.CustomerService;
import com.watches.service.EmailService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/registration")
	public ModelAndView getRegistrationForm(){
		Customer customer=new Customer();
		Users users=new Users();
		BillingAddress billingAddress=new BillingAddress();
		
		
		customer.setUsers(users);
		customer.setBillingAddress(billingAddress);
		
		
		return new ModelAndView("registerCustomer","customer",customer);
		
	}
	
	
	@RequestMapping("/customer/registration")
	public String registerCustomer(@ModelAttribute("customer")Customer customer,Model model) throws javax.mail.MessagingException{
		
		String username =customer.getUsers().getUsername();
		List<Customer> customerList = customerservice.getAllCustomers();
		for(Customer c:customerList){
			System.out.println(c);
			System.out.println(c.getUsers());
			if(username.equals(c.getUsers().getUsername())){
				model.addAttribute("duplicateUname", "Username already exists");
				return "registercustomer";
			}
		}
		
		
		String email =customer.getCustomerEmail();
		for(Customer c:customerList){
			if(email.equals(c.getCustomerEmail())){
				model.addAttribute("duplicateEmail", "Email already exists");
				return "registercustomer";
			}
		}
	    customerservice.addCustomer(customer);
		
		String name = customer.getCustomerName();
		String password=customer.getUsers().getPassword();
		String subject="Registration Success";
		
		String body= " Hi " + name +",";
		body = body + "\n\n\n You signed up for a new account at www.Kairos.com using this email address.You can login with following Details.\nYour user name : "+username+""+"\nYour Password : "+password+"";
		body = body + "\n\n\nRegards,\nKairos Team\nDT7 - Secunderabad";
		emailService.send(customer,subject,body);
		
		model.addAttribute("registrationSuccess","Registered Successfully. Login using username and password");
		return "login";
		
	}
	
	
	@RequestMapping("/retrive")
	public String usernameform(){
		
		return "Retrive";
		
		
	}
	
	@RequestMapping("/forgot")
	public String forgot(@RequestParam("username")String username,Model model) throws MessagingException{
		List<Customer> customerList = customerservice.getAllCustomers();
	
		for(Customer c:customerList){
			if(username.equals(c.getUsers().getUsername())){

				String name = c.getCustomerName();
				String password=c.getUsers().getPassword();
				String subject="Your Password for Kairos";
				
				String body= " Hi" + name +",";
				body = body + "\n\n\n Your password for account at www.Kairos.com is Below"
						+ "\nYour Password : "+password+"";
				body = body + "\n\n\nRegards,\nKairos Team\nDT7 - Secunderabad";
				emailService.send(c,subject,body);
				
				model.addAttribute("Success","Your password for the Username is sent to Registered Email Id");
				return "login";
				
				
				
			}
			
		}
		
		
		model.addAttribute("failed","Username doesn't Exists in our DataBase.Please give a registered username");
		return "Retrive";
		
		
		
	}
	
	@RequestMapping(value="/EditProfile")
	public ModelAndView getform(){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerservice.getCustomerByUsername(username);
		
		return new ModelAndView("EditUser","customer",customer);
	}
	
	
	
	
	@RequestMapping(value="/registrationedit")
	public String edituser(@ModelAttribute(value="customer")Customer customer) throws MessagingException
	{
	customerservice.Editprofile(customer);
	
	String name = customer.getCustomerName();
	String password=customer.getUsers().getPassword();
	String subject="Your Profile has been Edited";
	
	String body= " Hi " + name +",";
	body = body + "\n\n\n Your Profile for account at www.Kairos.com is Changed.."
			+ "\n Please make a note that your details are changed  : "+password+"";
	body = body + "\n\n\nRegards,\nKairos Team\nDT7 - Secunderabad";
	emailService.send(customer,subject,body);
	
	return "redirect:/Myprofile";

	}
	
	@RequestMapping("/Myprofile")
	public ModelAndView Myprofile(){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerservice.getCustomerByUsername(username);
		
		return new ModelAndView("Myprofile","customer",customer);
	}
	
   

	@RequestMapping("/checkpassword")
	public String checkpassword(){
		return"checkPassword";
	}
	
	@RequestMapping("/validatepassword")
	public String validatepassword(@RequestParam("password")String password,Model model){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerservice.getCustomerByUsername(username);
	    if(customer.getUsers().getPassword().equals(password))
	    {
	    	
	    	return"redirect:/newpassword";
	    }
	    model.addAttribute("failed","Password does not match the records");
		return"checkPassword";
	}
	
	@RequestMapping("/newpassword")
	public ModelAndView newpassword(){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerservice.getCustomerByUsername(username);
		
		return new ModelAndView("ResetPassword","customer",customer);
		
	}
	
	
	@RequestMapping(value="/Editpassword")
	public String editpassword(@ModelAttribute(value="customer")Customer customer) throws MessagingException
	{
	customerservice.Editprofile(customer);
	String name = customer.getCustomerName();
	String password=customer.getUsers().getPassword();
	String subject="Your Password has been Reset";
	
	String body= " Hi " + name +",";
	body = body + "\n\n\n Your password for account at www.Kairos.com is Changed...Your New Password is"
			+ "\nYour New Password : "+password+"";
	body = body + "\n\n\nRegards,\nKairos Team\nDT7 - Secunderabad";
	emailService.send(customer,subject,body);
	
	return "redirect:/Myprofile";

	}

		
		
	
}
