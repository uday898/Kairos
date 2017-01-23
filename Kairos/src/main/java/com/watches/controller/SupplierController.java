package com.watches.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.model.Watch_Supplier;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;

@Controller
public class SupplierController {
	@Autowired 
	private SupplierService supplierService;
	@Autowired 
	private WatchService watchService;
	
	@RequestMapping("/addSupplier")
	public String addsupplier(Model model){
		List<Suppliers> suppliers =supplierService.getsuppliers();
		Suppliers supplier=new Suppliers();
		model.addAttribute("suppliersdata", suppliers);
		model.addAttribute("supplier", supplier);
		return "addSupplier";
    		
	}
	
	@RequestMapping(value="/addSupplier1")
	public String addsup(@Valid @ModelAttribute(value="supplier")Suppliers supplier,Model model){
		supplierService.AddSupplier(supplier);
		return "redirect:/addSupplier";
	}
	
	
	@RequestMapping("/addWatch_Sup")
	public String addwatchsup(Model model){
		List <Watch_Supplier> W_s =supplierService.getwatchsuppliers();
		Watch_Supplier ws = new Watch_Supplier();
		model.addAttribute("watchids", supplierService.getwatchids());
		model.addAttribute("sids",supplierService.getsupplierids());
		model.addAttribute("Watch_sup",W_s);
		model.addAttribute("Watch_supplier", ws);
		return "addWatchSupplier";
    		
	}
	
	@RequestMapping(value="/AddWatch_Supplier1")
	public String addW_Srecord(@Valid @ModelAttribute(value="Watch_supplier")Watch_Supplier Wsupplier){
		supplierService.AddSup_Watch(Wsupplier);
		return "redirect:/addWatch_Sup";
	}
	
	
	@RequestMapping("/admin/deletews/{w_S_id}")
	public String deletewatchSupplier(@PathVariable(value="w_S_id") String ws){
		supplierService.deleteWS(ws);
		return "redirect:/addWatch_Sup";
	}
	
	@RequestMapping("/other{watchid}")
	public String othersellers(@PathVariable("watchid")String watchid,Model model){
		List <Vw1> other=supplierService.getothersellers(watchid);
		Watch watch=watchService.getWatchById(watchid);
		model.addAttribute("watch", watch);
	model.addAttribute("sellers", other);
	return "otherSellers";
	}

}
