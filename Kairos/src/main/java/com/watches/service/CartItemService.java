package com.watches.service;

import com.watches.model.Cart;
import com.watches.model.CartItem;

public interface CartItemService {
	public abstract void addCartItem(CartItem cartitem);
	public void removeAllCartItems(Cart cart);
	public void removeCartItem(int cartItemId);
	public int countcartitems(int cartId);
}
