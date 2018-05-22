package com.tpms.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.NationDao;
import com.tpms.entities.Nation;

public class NationService {

	private NationDao nationDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setNationDao(NationDao nationDao) {
		this.nationDao = nationDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Nation> getAll(){
		return nationDao.getAll();
	}
	
	public Map findword(String s, int i, int rows){
		return nationDao.findword(s, i, rows);
	}
	
	public void saveOrUpdate(Nation nation){
		nationDao.saveOrUpdate(nation);
	}
	
	public Nation get(Integer id){ //ÐÞ¸Ä
		
		return nationDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		nationDao.delete(ids);
	}
}
