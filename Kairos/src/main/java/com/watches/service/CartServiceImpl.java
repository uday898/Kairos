package com.watches.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.CartDao;
import com.watches.model.Cart;

@Service
public class CartServiceImpl implements CartService {
@Autowired
private CartDao cartdao;

	public Cart getCartByCartId(int cartId) {
		return cartdao.getCartByCartId(cartId);
	}

	public Cart validate(int cartId) throws IOException {
		return cartdao.validate(cartId);
	}

	public void update(Cart cart) {
		cartdao.update(cart);
		
	}

	public int cartitems(int cartId) {
		
		return cartdao.cartitems(cartId);
	}

}
