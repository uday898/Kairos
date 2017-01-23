package com.watches.dao;

import java.util.List;

import com.watches.model.WishList;

public interface WishListDao {

	public abstract void addWishItem(WishList wishItem);
	public abstract void removeWishitem(int wishId);
	public abstract int countwishitems(int customerId);

	public abstract List<WishList> wishitems(int customerId);
}
