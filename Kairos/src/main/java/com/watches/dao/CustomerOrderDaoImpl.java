package com.watches.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.CustomerOrder;
import com.watches.model.Myorders;
@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {
	@Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder){
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
        session.close();
}

	public List<Myorders> orders(int customerId) {
		Session session = sessionFactory.openSession();
		List <Myorders> orders=session.createQuery("from Myorders where customerId='"+customerId+"'").list();
		session.flush();
		session.close();
		return orders;
	}
	
	public Myorders myorder(String orderId){
		Session session =sessionFactory.openSession();
		Myorders order=(Myorders) session.get(Myorders.class,orderId);
		session.flush();
		session.close();
		return order;
		
	}
}


