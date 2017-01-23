package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.OperationsDao;
import com.watches.model.ReviewProduct;
import com.watches.model.Statistics;
import com.watches.model.Users;
import com.watches.model.Vw1;

@Service
public class OperationsServiceImpl implements OperationsService {
	@Autowired
	private OperationsDao operationsDao;

	public List<Vw1> getLeastPriceWatches(int type) {
	return operationsDao.getLeastPriceWatches(type);
		
	}

	public List<Vw1> getMenCategory(String brand) {
		
		return operationsDao.getMenCategory(brand);
	}

	public List<Vw1> getWomenCategory(String brand) {
		
		return operationsDao.getWomenCategory(brand);
	}

	public List<Vw1> getKidCategory(String brand) {
		
		return operationsDao.getKidCategory(brand);
	}

	public void addreview(ReviewProduct review) {
		operationsDao.addreview(review);
		
	}

	public List<ReviewProduct> getreview(String watchid) {
		return operationsDao.getreview(watchid);
	}

	public double getavg(String watchid) {
		
		return operationsDao.getavg(watchid);
	}

	public int getcount(String watchid) {
		
		return operationsDao.getcount(watchid);
	}

	public List<Statistics> stats() {
		
		return operationsDao.stats();
	}

	public Users getUserById(int userId) {
		
		return operationsDao.getUserById(userId);
	}

	public void disableUser(Users user) {
		operationsDao.disableUser(user);
		
	}

	public void enableUser(Users user) {
		operationsDao.enableUser(user);
		
	}

	public List<Users> getAllUsers() {
		
		return operationsDao.getAllUsers();
	}

	public List<ReviewProduct> getreviewsbyCustomerId(int customerId) {
		
		return operationsDao.getreviewsbyCustomerId(customerId);
	}

	

}
