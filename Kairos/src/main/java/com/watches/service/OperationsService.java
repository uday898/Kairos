package com.watches.service;

import java.util.List;

import com.watches.model.ReviewProduct;
import com.watches.model.Statistics;
import com.watches.model.Users;
import com.watches.model.Vw1;



public interface OperationsService {
	public  List<Vw1> getLeastPriceWatches(int type);
	public List<Vw1> getMenCategory(String brand);
	public List<Vw1> getWomenCategory(String brand);
	public List<Vw1> getKidCategory(String brand);
	public void addreview(ReviewProduct review);
	public List<ReviewProduct> getreview(String watchid);
	public double getavg(String watchid);
	public List<Statistics> stats();
	public int getcount(String watchid);
	public Users getUserById(int userId);
	public void disableUser(Users user);
	public void enableUser(Users user);
	public List<Users> getAllUsers();
	public List<ReviewProduct> getreviewsbyCustomerId(int customerId);
}
