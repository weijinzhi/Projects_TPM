package com.tpms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.PersonnelDao;
import com.tpms.entities.Personnel;

public class PersonnelService {

	private PersonnelDao personnelDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = personnelDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Personnel> getAll(){
		return personnelDao.getAll();
	}
	
	public Map findword(String s, int i, int rows){
		return personnelDao.findword(s, i, rows);
	}
	
	public Map finddate(Date date1, Date date2, int i, int rows){
		return personnelDao.finddate(date1, date2, i, rows);
	}
	
	public void saveOrUpdate(Personnel personnel){
		personnelDao.saveOrUpdate(personnel);
	}
	
	public Personnel get(Integer id){ //ÐÞ¸Ä
		
		return personnelDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		personnelDao.delete(ids);
	}
}
