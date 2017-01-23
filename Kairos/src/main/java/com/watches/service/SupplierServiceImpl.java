package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.SupplierDao;
import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch_Supplier;
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierdao;
	
	public List<Suppliers> getsuppliers() {
		
		return supplierdao.getsuppliers();
	}

	public List<Watch_Supplier> getwatchsuppliers() {
		
		return supplierdao.getwatchsuppliers();
	}

	public List<String> getsupplierids() {
		
		return supplierdao.getsupplierids();
	}

	public List<String> getwatchids() {
		
		return supplierdao.getwatchids();
	}

	public void AddSupplier(Suppliers sup) {
		supplierdao.AddSupplier(sup);

	}

	public void AddSup_Watch(Watch_Supplier ws) {
		supplierdao.AddSup_Watch(ws);

	}

	public void deleteWS(String ws) {
		supplierdao.deleteWS(ws);
		
	}
	public List<Vw1> getwatchsellers(String watchid){
		return supplierdao.getwatchsellers(watchid);
	}

	public Suppliers getsup(String sid) {
		
		return supplierdao.getsup(sid);
	}

	public List<Vw1> getothersellers(String watchid) {
		
		return supplierdao.getothersellers(watchid);
	}

}
