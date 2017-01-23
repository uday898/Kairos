package com.watches.dao;

import java.io.IOException;

import com.watches.model.Cart;

public interface CartDao {
	
public abstract Cart getCartByCartId(int cartId);
public abstract Cart validate(int cartId) throws IOException;
public int cartitems(int cartId);
public abstract void update(Cart cart);
}
