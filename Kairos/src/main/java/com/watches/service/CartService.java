package com.watches.service;

import java.io.IOException;

import com.watches.model.Cart;

public interface CartService {
	Cart getCartByCartId(int cartId);
	Cart validate(int cartId) throws IOException;

	void update(Cart cart);
	
	public int cartitems(int cartId);
}
