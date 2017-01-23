package com.watches.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.model.Watch_Supplier;
@Repository
@Transactional
public class SupplierDaoimpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Suppliers> getsuppliers() {
		Session session = sessionFactory.openSession();
		List<Suppliers> suppliers =session.createQuery("from Suppliers").list();
		session.flush();
		session.close();
		return suppliers;
	}

	public List<Watch_Supplier> getwatchsuppliers() {
		
		Session session = sessionFactory.openSession();
		List<Watch_Supplier> data =session.createQuery("from Watch_Supplier").list();
		session.flush();
		session.close();
		return data;
	}

	public List<String> getsupplierids() {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("select sid from Suppliers");		
		List<String> sids = qr.list();
		ses.flush();
		ses.close();
		return sids;
	}
	
	

	public List<String> getwatchids() {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("select watchid from Watch");		
		List<String> watchid = qr.list();
		ses.flush();
		ses.close();
		return watchid;
	}

	public void AddSupplier(Suppliers sup) {
		Session ss = sessionFactory.openSession();
		sup.setSid(generateSid());
		ss.save(sup);
		ss.flush();
		ss.close();
	}

	public void AddSup_Watch(Watch_Supplier ws) {
		Session ss = sessionFactory.openSession();
		ws.setW_S_id(generateWSid());
		ss.save(ws);
		ss.flush();
		ss.close();
		
		
	}
	private String generateSid()
	{
		String newSid="";
		Session ss = sessionFactory.openSession();
		//Transaction t=ss.beginTransaction();
		Query q = ss.createQuery("from Suppliers");
		List<Suppliers> suppliers = q.list();
		if(suppliers.isEmpty()){
			newSid="S0001";
		}
		else{
			Query q1 = ss.createQuery("select max(sid) from Suppliers");
			String prevId = q1.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(1));
		System.out.print("\nExisting id : "+id);
		
		id=id+1;
		if(id<=9)
			newSid="S000"+id;
		else if(id<=99)
			newSid="S00"+id;
		else if(id<=999)
			newSid="S0"+id;
		else
			newSid="S"+id;		
		System.out.print("\nGenerated : "+newSid);
		
		
		}
		ss.close();
		return newSid;
	}
	private String generateWSid()
	{
		String newWSid="";
		Session ss = sessionFactory.openSession();
		//Transaction t=ss.beginTransaction();
		Query q = ss.createQuery("from Watch_Supplier");
		List<Suppliers> wsuppliers = q.list();
		if(wsuppliers.isEmpty()){
			newWSid="WS0001";
		}
		else{
			Query q1 = ss.createQuery("select max(w_S_id) from Watch_Supplier");
			String prevId = q1.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(2));
		System.out.print("\nExisting id : "+id);
		  
		id=id+1;
		if(id<=9)
			newWSid="WS000"+id;
		else if(id<=99)
			newWSid="WS00"+id;
		else if(id<=999)
			newWSid="WS0"+id;
		else
			newWSid="WS"+id;		
		System.out.print("\nGenerated : "+newWSid);
		
		}
		ss.close();
		return newWSid;
	}

	public void deleteWS(String ws) {
		Session ss =sessionFactory.openSession();
		Watch_Supplier watch =(Watch_Supplier)ss.get(Watch_Supplier.class,ws);
		ss.delete(watch);
		ss.flush();
		ss.close();
		
	}
	
	
	public Suppliers getsup(String sid){
		Session ss = sessionFactory.openSession();
		Suppliers view= (Suppliers) ss.get(Suppliers.class,sid);
		ss.close();
		return view;
		
	}
	
	
	public List<Vw1> getwatchsellers(String watchid) {
		
		Session session = sessionFactory.openSession();
		Query qr = session.createQuery("from Vw1 where watchid = '"+watchid+"' order by price");
		List<Vw1> watches =qr.list();
		
		session.flush();
		session.close();
		return watches;
	}
	
public List<Vw1> getothersellers(String watchid) {
		
		Session session = sessionFactory.openSession();
		List<Vw1> all=getwatchsellers(watchid);
		List<Vw1> other=new ArrayList<Vw1>();
		int j =all.size();
		int i=0;
		for(i=1;i<=j-1;i++){
			other.add(all.get(i));
		}
		session.flush();
		session.close();
		return other;
	}
}
