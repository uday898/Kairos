package com.watches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.watches.model.Customer;
import com.watches.model.ReviewProduct;
import com.watches.model.Statistics;
import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.service.CustomerService;
import com.watches.service.OperationsService;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;


@Controller
public class OperationsController {
	
	@Autowired
	private OperationsService operationService;
	
	
	@RequestMapping("/MenWatches")
	private ModelAndView getmenwatches(){
		List<Vw1> menwatches = operationService.getLeastPriceWatches(1);
		return new ModelAndView ("Menwatches","watches",menwatches);
	}
 
	@RequestMapping("/menwatchlist")
	public @ResponseBody List <Vw1> getmenwatchesinJson()
	{
		return operationService.getLeastPriceWatches(1);
		
	}
	
	@RequestMapping("/WomenWatches")
	private ModelAndView getWomenwatches(){
		List<Vw1> womenwatches = operationService.getLeastPriceWatches(2);
		return new ModelAndView("Womenwatches","watches",womenwatches);
	}
	
	@RequestMapping("/womenwatchlist")
	public @ResponseBody List <Vw1> getwomenwatchesinJson()
	{
		return operationService.getLeastPriceWatches(2);
		
	}


	@RequestMapping("/KidWatches")
	private ModelAndView getkidwatches(){
		List<Vw1> kidwatches = operationService.getLeastPriceWatches(3);
		return new ModelAndView("Kidwatches","watches",kidwatches);
	}
	
	@RequestMapping("/kidwatchlist")
	public @ResponseBody List <Vw1> getkidwatchesinJson()
	{
		return operationService.getLeastPriceWatches(3);
		
	}
	
	@RequestMapping("/MenFastrack")
		public ModelAndView getfastrackm(){
		List<Vw1> fastrack =operationService.getMenCategory("Fastrack");
		return new ModelAndView("CategoryWatch","watches",fastrack);
			
		}
	
	@RequestMapping("/MenCasio")
	public ModelAndView getcasiomen(){
	List<Vw1> casio =operationService.getMenCategory("Casio");
	return new ModelAndView("CategoryWatch","watches",casio);
		
	}
	
	@RequestMapping("/MenFossil")
	public ModelAndView getfossilm(){
	List<Vw1> fossil =operationService.getMenCategory("Fossil");
	return new ModelAndView("CategoryWatch","watches",fossil);
		
	}
	
	
	@RequestMapping("/WomenFastrack")
	public ModelAndView getfastw(){
	List<Vw1> fastrack =operationService.getWomenCategory("Fastrack");
	return new ModelAndView("CategoryWatch","watches",fastrack);
		
	}
	
	
	@RequestMapping("/WomenCasio")
		public ModelAndView getcasiow(){
		List<Vw1> casio =operationService.getWomenCategory("Casio");
		return new ModelAndView("CategoryWatch","watches",casio);
			
		}
	
	@RequestMapping("/WomenFossil")
	public ModelAndView getfossilw(){
	List<Vw1> fossil =operationService.getWomenCategory("Fossil");
	return new ModelAndView("CategoryWatch","watches",fossil);
		
	}

	@RequestMapping("/KidDisney")
	public ModelAndView getdisneyk(){
	List<Vw1> fossil =operationService.getKidCategory("Disney");
	return new ModelAndView("CategoryWatch","watches",fossil);
		
	}
	
	
	
	
		
}
	


