package com.watches.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.watches.model.Brand;
import com.watches.model.Customer;
import com.watches.model.DisplayType;
import com.watches.model.IdealFor;
import com.watches.model.ReviewProduct;
import com.watches.model.Strap;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.service.CustomerService;
import com.watches.service.OperationsService;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;

@Controller
public class WatchController {
	@Autowired
	private WatchService watchservice;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private OperationsService operationsService;
	
	@RequestMapping("/getAllWatches")
    public ModelAndView getallProducts(){
		
		List<Watch> watch = watchservice.getAllWatches();
		return new ModelAndView("watchlist","watches",watch);
	}
	
	@RequestMapping("/getWatchList")
	public @ResponseBody List <Vw1> getallwatchesinJson()
	{
		System.out.println("getwatchesangular");
		return watchservice.getwatches();
		
	}
	
	@RequestMapping("/ViewWatch{w_s_id}")
	public String getwatch(@PathVariable(value="w_s_id")String wsid,Model model){
		Vw1 v=watchservice.getrecord(wsid);
		
		Watch watch =watchservice.getWatchById(v.getWatchid());
		List <Vw1> watchsellers=supplierService.getwatchsellers(v.getWatchid());
		List<ReviewProduct> review=operationsService.getreview(v.getWatchid());
		int count=operationsService.getcount(v.getWatchid());
		if(count!=0){
			double avg=operationsService.getavg(v.getWatchid());
			model.addAttribute("avg",avg);
		}else{
			double avg=0.0;
			model.addAttribute("avg",avg);
		}
		
		model.addAttribute("count",count);
		
		model.addAttribute("reviews", review);
		model.addAttribute("watchObj",watch);
		model.addAttribute("watch",v);
		model.addAttribute("sellers",watchsellers);
		System.out.println(watchsellers);
		return "Watch";
	}

	@RequestMapping("/admin/delete/{watchid}")
	public String deletewatch(@PathVariable(value="watchid") String watchid){
		watchservice.deleteWatch(watchid);
		return "redirect:/getAllWatches";
	}
	
   @RequestMapping(value="/addWatch",method=RequestMethod.POST)
	public String addRecord(@Valid @ModelAttribute(value="watch")Watch watch, BindingResult result){
	   System.out.println("\nController - add book");
		if(result.hasErrors()){
			return "addwatch";
		}
		watchservice.AddWatch(watch);
		return "redirect:/addWatch";
		}

	@RequestMapping("/addWatch")
	public String getwatchform(Model model){
		Watch watch = new Watch();
		IdealFor idealfor = new IdealFor();
		Brand brand = new Brand();
		DisplayType type = new DisplayType();
		Strap strap = new Strap();
		System.out.println("Watch form");
		idealfor.setGid(3);
		brand.setBrandid(4);
		type.setTypeid(3);
		strap.setStrapid(3);
		watch.setIdealfor(idealfor);
		watch.setBrand(brand);
		watch.setDisplaytype(type);
		watch.setStrap(strap);
		
		model.addAttribute("watch",watch);
		return "addwatch";
	}
	
	
	@RequestMapping("/editwatch{watchid}")
	public ModelAndView getEditForm(@PathVariable(value="watchid") String watchid){
		
		Watch watch=this.watchservice.getWatchById(watchid);
		return new ModelAndView("EditWatch","watch",watch);
	}
	
	
	@RequestMapping("/editit")
	public String editwatch(@ModelAttribute(value="watch") Watch watch)
	{
	watchservice.editWatch(watch);
	return "redirect:/getAllWatches";

	}
   
	
	

	
	

}
