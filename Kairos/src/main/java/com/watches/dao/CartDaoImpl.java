package com.watches.dao;

import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.Cart;
import com.watches.model.Vw1;
import com.watches.service.CustomerOrderService;
@Repository("cartDaoImpl")
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	private CustomerOrderService customerOrderService;
	@Autowired 
	private SessionFactory sessionFactory;
	

	public Cart getCartByCartId(int cartId) {
		
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		System.out.println(cart.getCartId() + " " + cart.getCartItems());
		session.flush();
		session.close();
		return cart;

	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartByCartId(cartId);
		if(cart==null || cart.getCartItems().size() == 0){
			throw new IOException(cartId+"");
		}
		update(cart);
		return cart;
		
	}

	public void update(Cart cart) {
		int cartId = cart.getCartId();
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);
	
		Session session = sessionFactory.openSession();
		session.update(cart);
		session.flush();
		session.close();
		

	}
	
	public int cartitems(int cartId){
		Session session=sessionFactory.openSession();
		Query qr=session.createQuery("select count(cartItemId) from CartItem where cartId='" +cartId+"'");
		int num = Integer.parseInt(qr.list().get(0).toString());
		session.flush();
		session.close();
		return num;
		
		
	}

}
