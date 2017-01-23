package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.WatchDao;
import com.watches.model.Vw1;
import com.watches.model.Watch;
@Service
public class WatchServiceImpl implements WatchService {
    @Autowired
    private WatchDao watchdao;
    
	public List<Watch> getAllWatches() {
		return watchdao.getAllWatches();
	}

	public Watch getWatchById(String watchid) {
		
		return watchdao.getWatchById(watchid);
	}

	public void deleteWatch(String watchid) {
		watchdao.deleteWatch(watchid);

	}

	public void editWatch(Watch watch) {
		watchdao.editWatch(watch);

	}

	public void AddWatch(Watch watch) {
		watchdao.AddWatch(watch);

	}
	
	public Vw1 getLeastPwVw(String watchid){
		return watchdao.getLeastPwVw(watchid);
	}

	public List<Vw1> getwatches() {
		
		return watchdao.getwatches();
	}

	public List<Vw1> newarrivals() {
		
		return watchdao.newarrivals();
	}

	public Vw1 getrecord(String w_s_id) {
	
		return watchdao.getrecord(w_s_id);
	}

	
}
