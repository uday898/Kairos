package com.watches.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.Customer;
import com.watches.model.ReviewProduct;
import com.watches.model.Statistics;
import com.watches.model.Suppliers;
import com.watches.model.Users;
import com.watches.model.Vw1;
import com.watches.model.Watch;

@Repository
@Transactional
public class OperationsDaoImpl implements OperationsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	
public  List<Vw1> getLeastPriceWatches(int type){
		
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from Vw1 v1 where price = (select min(price) from Vw1 where watchid=v1.watchid) and gid="+type);
		List<Vw1> data = qr.list();
		ses.close();
		return data;
	}

public List<Vw1> getMenCategory(String brand){
	Session session =sessionFactory.openSession();
	Query qr = session.createQuery("from Vw1 v1 where price = (select min(price) from Vw1 where watchid=v1.watchid) and gid=1 and brand='"+brand+"'");
	List<Vw1> data = qr.list();
	return data;
}

public List<Vw1> getWomenCategory(String brand){
	Session session =sessionFactory.openSession();
	Query qr = session.createQuery("from Vw1 v1 where price = (select min(price) from Vw1 where watchid=v1.watchid) and gid=2 and brand='"+brand+"'");
	List<Vw1> data = qr.list();
	return data;
}

public List<Vw1> getKidCategory(String brand){
	Session session =sessionFactory.openSession();
	Query qr = session.createQuery("from Vw1 v1 where price = (select min(price) from Vw1 where watchid=v1.watchid) and gid=3 and brand='"+brand+"'");
	List<Vw1> data = qr.list();
	return data;
}

public void addreview(ReviewProduct review) {
	Session session =sessionFactory.openSession();
	Date date=new Date();
	review.setReviewdate(date);
	session.save(review);
	getavgsellers(review.getSupplier().getSid());
	session.flush();
	session.close();
}

public List<ReviewProduct> getreview(String watchid){
	Session session=sessionFactory.openSession();
	
	Query query=session.createQuery("from ReviewProduct where watchid=?");
	query.setString(0, watchid);
	List<ReviewProduct> review=query.list();

	session.flush();
	session.close();
	return review;
	
}


public int getcount(String watchid){
Session session=sessionFactory.openSession();
	
	Query query=session.createQuery("select count(*) from ReviewProduct where watchid='"+watchid+"'");

	int count=0;
	 count=Integer.parseInt(query.list().get(0).toString());
System.out.println("count of the function:"+count);
	session.flush();
	session.close();
	return count;
	
}

public double getavg(String watchid){
Session session=sessionFactory.openSession();
	
	Query query=session.createQuery("select avg(rating) from ReviewProduct where watchid='"+watchid+"'");
double avg=0.0;
avg=Double.parseDouble(query.list().get(0).toString());

System.out.println("average of function"+avg);
	session.flush();
	session.close();
	return avg;
	
}


public void getavgsellers(String sid){
Session session=sessionFactory.openSession();
	
	Query query=session.createQuery("select avg(srating) from ReviewProduct where sid='"+sid+"'");
double avg=0.0;
avg=Double.parseDouble(query.list().get(0).toString());

System.out.println("average of function"+avg);
Suppliers s=(Suppliers) session.get(Suppliers.class,sid);
	s.setRating(avg);
    session.update(s);
	session.flush();
	session.close();
	
}

public List<Statistics> stats(){
	Session session = sessionFactory.openSession();
	@SuppressWarnings("unchecked")
	List<Statistics> stats =session.createQuery("from Statistics").list();
	session.flush();
	session.close();
	return stats;
}


public void enableUser(Users user){
	Session ses = sessionFactory.openSession();
	
	ses.update(user);

	ses.flush();
	ses.close();
}

public void disableUser(Users user){
	Session ses = sessionFactory.openSession();
ses.update(user);

	ses.flush();
	ses.close();
}

public Users getUserById(int userId){
	Session ses = sessionFactory.openSession();
	Users user=(Users)ses.get(Users.class,userId);
	ses.flush();
	ses.close();
	return user;
}

public List<Users> getAllUsers() {
	Session session = sessionFactory.openSession();
	@SuppressWarnings("unchecked")
	List<Users> users =session.createQuery("from Users").list();
	session.flush();
	session.close();
	return users;
}

public List<ReviewProduct> getreviewsbyCustomerId(int customerId){
	Session session=sessionFactory.openSession();
	
	Query query=session.createQuery("from ReviewProduct where customerId=?");
	query.setInteger(0,customerId);
	List<ReviewProduct> review=query.list();

	session.flush();
	session.close();
	return review;
	
}



}
