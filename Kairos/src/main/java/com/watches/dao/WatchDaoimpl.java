package com.watches.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.Vw1;
import com.watches.model.Watch;
@Repository
@Transactional
public class WatchDaoimpl implements WatchDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Watch> getAllWatches() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Watch> watches =session.createQuery("from Watch").list();
		session.flush();
		session.close();
		return watches;
	}

	public Watch getWatchById(String watchid) {
		Session ss = sessionFactory.openSession();
		Watch watch= (Watch) ss.get(Watch.class,watchid);
		ss.close();
		return watch;
	}
	
	

	public void deleteWatch(String watchid) {
		Session ss =sessionFactory.openSession();
		Watch watch =(Watch)ss.get(Watch.class,watchid);
		ss.delete(watch);
		deleteImage(watchid);
		ss.flush();
		ss.close();
	}
		

	public void editWatch(Watch watch) {
		Session ss = sessionFactory.openSession();
		ss.update(watch);
		ss.flush();
		ss.close();

	}

	public void AddWatch(Watch watch) {
		Session ss = sessionFactory.openSession();
		watch.setWatchid(generateWid());
		ss.save(watch);
		saveImage(watch);
		ss.flush();
		ss.close();
	}
	
	private boolean saveImage(Watch watch){
		boolean res=true;
		try{
			System.out.print("\nimg : " + watch.getImagefile());
			
			
			Path path=Paths.get("F://workspaces//project1//Kairos//src//main//webapp//resources//images//watches//"+watch.getWatchid()+".jpg");		    	
			if (watch.getImagefile() != null && !watch.getImagefile().isEmpty()) {
	            try {
	            	watch.getImagefile().transferTo(new File(path.toString()));                       	
	            	System.out.println("User Image Saved");
	            } catch (Exception e) {
	                e.printStackTrace();
	                throw new RuntimeException("user image saving failed.", e);
	            }
	        }		
		}
		catch(Exception ex){
			res=false;
		}		
		return res;
	}
	private void deleteImage(String watchid){
		Path path=Paths.get("F://MainProject//Luxurywatches//src//main//webapp//resources//images//watches//"+watchid+".jpg");
		if(Files.exists(path))
				{
			           try {
						Files.delete(path);
					} catch (IOException e) {
						
						e.printStackTrace();
					}


                }
		
		
                                            }
	
	private String generateWid()
	{
		String newWid="";
		Session ss = sessionFactory.openSession();
		//Transaction t=ss.beginTransaction();
		Query q = ss.createQuery("from Watch");
		@SuppressWarnings("unchecked")
		List<Watch> watches = q.list();
		if(watches.isEmpty()){
			newWid="W0001";
		}
		else{
			Query q1 = ss.createQuery("select max(watchid) from Watch");
			String prevId = q1.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(1));
		System.out.print("\nExisting id : "+id);
		
		id=id+1;
		if(id<=9)
			newWid="W000"+id;
		else if(id<=99)
			newWid="W00"+id;
		else if(id<=999)
			newWid="W0"+id;
		else
			newWid="W"+id;		
		System.out.print("\nGenerated : "+newWid);
		
		
		}
		ss.close();
		return newWid;
	}
	
public Vw1 getLeastPwVw(String watchid){
		
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from Vw1 v1 where price = (select min(price) from Vw1 where watchid=v1.watchid) and watchid='"+watchid+"'");
		Vw1 data = (Vw1) qr.list().get(0);
		ses.close();
		return data;
 }

public List<Vw1> getwatches() {
	Session session = sessionFactory.openSession();
	@SuppressWarnings("unchecked")
	List<Vw1> watches =session.createQuery("from Vw1 v1 where price = (select min(price) from Vw1 where watchid=v1.watchid)").list();
	session.flush();
	session.close();
	return watches;
 
	
}

public List<Vw1> newarrivals() {
	List<Vw1> watches=getwatches();
	List<Vw1> newarrivals=new ArrayList<Vw1>();
	int j =watches.size();
	int i=0;
	for(i=j-1;i>=j-20;i--){
		newarrivals.add(watches.get(i));
	}
	System.out.println(newarrivals);
	return newarrivals;
	
}

public Vw1 getrecord(String w_s_id){
	Session ss = sessionFactory.openSession();
	Vw1 view= (Vw1) ss.get(Vw1.class,w_s_id);
	ss.close();
	return view;
}




}
