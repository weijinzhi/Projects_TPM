package com.tpms.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.ManagerDao;
import com.tpms.entities.Manager;

public class ManagerService {

	private ManagerDao managerDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}

	public Manager login(String username, String password) throws Exception {

		Manager manager = new Manager();
		manager.setUsername(username);
		manager.setPassword(password);
		manager = this.managerDao.login(manager);
		if (manager != null) {
			return manager;
		} else {
			return null;
		}
	}

	public Manager get(Integer id){ //ÐÞ¸Ä
		
		return managerDao.get(id);
	}
	
	public List<Manager> getAll(){
		return managerDao.getAll();
	}
	
	public Map findword(String s, int i, int rows){
		return managerDao.findword(s, i, rows);
	}
	
	public void saveOrUpdate(Manager manager){
		managerDao.saveOrUpdate(manager);
	}
	
	public void delete(List<Integer> ids){
		managerDao.delete(ids);
	}
}
