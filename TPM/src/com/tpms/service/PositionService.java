package com.tpms.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.PositionDao;
import com.tpms.entities.Position;

public class PositionService {

	private PositionDao positionDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Position> getAll(){
		return positionDao.getAll();
	}
	
	public Map findword(int i, int rows){
		return positionDao.findword(i, rows);
	}
	
	public Map findname(String name, int i, int rows){
		return positionDao.findname(name, i, rows);
	}
	
	public Map findsalary(String s1, String s2, int i, int rows){
		return positionDao.findsalary(s1, s2, i, rows);
	}
	
	public void saveOrUpdate(Position position){
		positionDao.saveOrUpdate(position);
	}
	
	public Position get(Integer id){ //ÐÞ¸Ä
		
		return positionDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		positionDao.delete(ids);
	}
}
