package com.watches.dao;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.watches.model.Cart;
import com.watches.model.CartItem;
import com.watches.model.Customer;
import com.watches.model.Myorders;
import com.watches.model.Statistics;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.model.Watch_Supplier;
import com.watches.service.CustomerService;
import com.watches.service.EmailService;
import com.watches.service.WatchService;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
private SessionFactory sessionFactory;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private WatchService watchService;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCartItem(CartItem cartItem) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	    session.close();
		
	}

	public void removeCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		Cart cart=cartItem.getCart();
		List<CartItem> cartItems=cart.getCartItems();
		cartItems.remove(cartItem);
		session.flush();
		session.close();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems=cart.getCartItems();
		for(CartItem cartItem:cartItems){
			removeCartItem(cartItem.getCartItemId());
		}
		
		
	}

	
	public void removeAllCartItemsafter(Cart cart) throws MessagingException {
		List<CartItem> cartItems=cart.getCartItems();
	     
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username= user.getUsername();
	    Customer customer= customerService.getCustomerByUsername(username);
		
		Session ss=sessionFactory.openSession();
	     Date date=new Date();
	   
	     for(CartItem cartItem:cartItems){
	    	 
	    	 updatestock(cartItem.getW_s_id(),cartItem.getQuantity());
	    	 
	    	 Myorders order=new Myorders();
	 	     order.setOrderId(generateOid());
	 	     order.setOrderdate(date);
	 	     order.setCustomer(customer);
	 	     order.setW_s_id(cartItem.getW_s_id());
	    	 order.setQuantity(cartItem.getQuantity());
	    	 order.setPrice(cartItem.getPrice());
	    	 order.setReviewed(false);
	    	 order.setTotalprice(cartItem.getTotalprice());
	    	 order.setWatch(cartItem.getWatch());
	    	 ss.save(order);
	    	 Vw1 view =watchService.getrecord(cartItem.getW_s_id());
	    	 Statistics stats=new Statistics();
	    	 stats.setSid(view.getSid());
	    	 stats.setWatchid(view.getWatchid());
	    	 stats.setSoldout(cartItem.getQuantity());
             ss.save(stats);    	 
	    	 ss.flush();
	    	 
	    	 String name = customer.getCustomerName();
	    		String subject="Your Order has been placed";
	    		String id=order.getOrderId();
	    		String watch=order.getWatch().getWatchName();
	    		
	    		String body= " Hi " + name +",";
	    		body = body + "\n\n\n Your order of "+id+" is been successfully placed"
	    				+ "\nYour order of watch: "+watch+"will be delivered soon."
	    				+"Thank you for Buying!!!";
	    		body = body + "\n\n\nRegards,\nKairos Team\nDT7 - Secunderabad";
	    		emailService.send(customer,subject,body);
	    	 
	     }
	     ss.close();
		for(CartItem cartItem:cartItems){
			removeCartItem(cartItem.getCartItemId());
		}
	}
	
	
	public void updatestock(String w_s_id,int quantity) throws MessagingException{
		Session ss = sessionFactory.openSession();
		Watch_Supplier ws= (Watch_Supplier) ss.get(Watch_Supplier.class,w_s_id);
		int existing=ws.getStock();
		int stock=existing-quantity;
		ws.setStock(stock);
		ss.update(ws);
		
			if(stock<8){
			Customer customer=(Customer) ss.get(Customer.class,33);
			String name = customer.getCustomerName();
    		String subject="Alert of Out of Stock";
    		
    		
    		String body= " Hi Admin,";
    		body = body + "\n\n Watch of Id "+w_s_id+" is about to get OUT OF STOCK..please take necessary action";
    		body = body + "\n\n\nRegards,\nKairos Team\nDT7 - Secunderabad";
    		emailService.send(customer,subject,body);
    	 }
			ss.flush();
			ss.close();
			
	}
	
	
	private String generateOid()
	{
		String newOid="";
		Session ss = sessionFactory.openSession();
		//Transaction t=ss.beginTransaction();
		Query q = ss.createQuery("from Myorders");
		@SuppressWarnings("unchecked")
		List<Myorders> order = q.list();
		if(order.isEmpty()){
			newOid="OR0001";
		}
		else{
			Query q1 = ss.createQuery("select max(orderId) from Myorders");
			String prevId = q1.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(2));
		System.out.print("\nExisting id : "+id);
		
		id=id+1;
		if(id<=9)
			newOid="OR000"+id;
		else if(id<=99)
			newOid="OR00"+id;
		else if(id<=999)
			newOid="OR0"+id;
		else
			newOid="OR"+id;		
		System.out.print("\nGenerated : "+newOid);
		
		
		}
		ss.close();
		return newOid;
	}

	public int countcartitems(int cartId) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("select count(cartItemId) from CartItem where cartId='"+cartId+"'");

		int count=0;
		 count=Integer.parseInt(query.list().get(0).toString());
	System.out.println("count of the function:"+count);
		session.flush();
		session.close();
		return count;
	
	}
	
	
	
	
	
	
	
	
}
