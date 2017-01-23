package com.watches.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.model.WishList;

@Repository
public class WishListDaoImpl implements WishListDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addWishItem(WishList wishItem) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(wishItem);
		session.flush();
	    session.close();
	}
	
	
	
	public void removeWishitem(int wishId) {
		Session session=sessionFactory.openSession();
		WishList cartItem=(WishList)session.get(WishList.class,wishId);
		session.delete(cartItem);
		session.flush();
		session.close();
	}
	
	public int countwishitems(int customerId) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("select count(customerId) from WishList where customerId='"+customerId+"'");

		int count=0;
		 count=Integer.parseInt(query.list().get(0).toString());
	System.out.println("count of the function:"+count);
		session.flush();
		session.close();
		return count;
	
	}
	

	public List<WishList> wishitems(int customerId) {
		Session session = sessionFactory.openSession();
		List <WishList> orders=session.createQuery("from WishList where customerId='"+customerId+"'").list();
		session.flush();
		session.close();
		return orders;
	}
	
}

