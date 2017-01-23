package com.watches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.model.Vw1;
import com.watches.service.WatchService;

@Controller
public class HomeController {
	@Autowired
	private WatchService watchService;

@RequestMapping("/")
public String gethomepage(Model model){
    List<Vw1> newarrivals=watchService.newarrivals();
	model.addAttribute("watches",newarrivals);
	return"index" ;
}

@RequestMapping("/login")
public String login(@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout,Model model){
		if(error!=null){
			model.addAttribute("error","Invalid Username or Password");
		}
		if(logout!=null){
			model.addAttribute("logout","Logged out succesfully");
		}
		return"login";
		
	
	}
	
@RequestMapping("/contact")
public String contactus(){
	return "contactus";
}

@RequestMapping("/contactsubmit")
public String reply(Model model){
	model.addAttribute("Reply","Thank You for contacting Us...We will get to You Soon");
	return "contactus";
	
}

}

