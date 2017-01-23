package com.watches.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.watches.model.Customer;
import com.watches.model.Myorders;
import com.watches.model.ReviewProduct;
import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.service.CustomerOrderService;
import com.watches.service.CustomerService;
import com.watches.service.OperationsService;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;

@Controller
public class ReviewController {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private OperationsService operationService;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private SupplierService supplierService;
	

	@Autowired
	private WatchService watchservice;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("/review{orderId}")
	public ModelAndView review(@PathVariable(value="orderId")String orderId)
	{
		Session ss=sessionFactory.openSession();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerservice.getCustomerByUsername(username);
	    Myorders order=customerOrderService.myorder(orderId);
	    order.setReviewed(true);
	    ss.update(order);
	    ss.flush();
	    ss.close();
	    Vw1 v=watchservice.getrecord(order.getW_s_id());
	    Watch watch=watchservice.getWatchById(v.getWatchid());
	    Suppliers sup=supplierService.getsup(v.getSid());
		ReviewProduct rp=new ReviewProduct();
		rp.setCustomer(customer);
		rp.setWatch(watch);
		rp.setSupplier(sup);
		rp.setRating(5.0);
		rp.setSrating(5.0);
		return new ModelAndView("Review","review",rp);
	}
	
	@RequestMapping("/submitReview")
	public String submitreview(@ModelAttribute(value="review") ReviewProduct review){
		operationService.addreview(review);
		return"redirect:/Myorders";
	}

	@RequestMapping("/myreviews")
	public String myreviews(Model model){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username= user.getUsername();
        Customer customer= customerservice.getCustomerByUsername(username);
        int customerId =customer.getCustomerId();
		List<ReviewProduct> review=operationService.getreviewsbyCustomerId(customerId);
		model.addAttribute("reviews",review);
		return "Myreviews";
		
	}
}
