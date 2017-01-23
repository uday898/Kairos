package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.WishListDao;
import com.watches.model.WishList;

@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListDao wishListdao;
	public void addWishItem(WishList wishItem) {
		wishListdao.addWishItem(wishItem);
		
	}

	public void removeWishitem(int wishId) {
		wishListdao.removeWishitem(wishId);
		
	}

	public int countwishitems(int customerId) {
		
		return wishListdao.countwishitems(customerId);
	}

	public List<WishList> wishitems(int customerId) {
		
		return wishListdao.wishitems(customerId);
	}
	
}
