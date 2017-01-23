package com.watches.dao;

import java.util.List;

import com.watches.model.Vw1;
import com.watches.model.Watch;

public interface WatchDao {
public abstract List<Watch> getAllWatches();
public abstract Watch getWatchById(String watchid);
public abstract void deleteWatch(String watchid);
public abstract void editWatch(Watch watch);
public abstract void AddWatch(Watch watch);
public Vw1 getLeastPwVw(String watchid);
public abstract List<Vw1> getwatches();
public abstract List<Vw1> newarrivals();
public Vw1 getrecord(String w_s_id);

}
