package com.watches.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.CartItemDao;
import com.watches.model.Cart;
import com.watches.model.CartItem;
@Service
public class CartItemServiceimpl implements CartItemService{
	@Autowired
	private CartItemDao cartitemdao;

	public void addCartItem(CartItem cartitem) {
		cartitemdao.addCartItem(cartitem);
	}

	public void removeAllCartItems(Cart cart) {
	  cartitemdao.removeAllCartItems(cart);
	}

	public void removeCartItem(int cartItemId) {
	   cartitemdao.removeCartItem(cartItemId);
		
	}

	public int countcartitems(int cartId) {
		
		return cartitemdao.countcartitems(cartId);
	}

}
