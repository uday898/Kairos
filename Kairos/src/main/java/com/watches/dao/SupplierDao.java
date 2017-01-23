package com.watches.dao;

import java.util.List;

import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch_Supplier;

public interface SupplierDao {
	public abstract List <Suppliers> getsuppliers();
	public abstract List <Watch_Supplier> getwatchsuppliers();
	public abstract List <String> getsupplierids();
	public abstract List <String> getwatchids();
    public abstract void AddSupplier(Suppliers sup);
    public abstract void AddSup_Watch(Watch_Supplier ws);
    public abstract void deleteWS(String ws);
    public abstract List<Vw1> getwatchsellers(String watchid);
    public Suppliers getsup(String sid);
    public List<Vw1> getothersellers(String watchid);
}
