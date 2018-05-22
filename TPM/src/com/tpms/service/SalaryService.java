package com.tpms.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.SalaryDao;
import com.tpms.entities.Salary;

public class SalaryService {

	private SalaryDao salaryDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Salary> getAll(){
		return salaryDao.getAll();
	}
	
	public Map find(String s, int i, int rows){
		return salaryDao.findword(s, i, rows);
	}
	
	public Map findword(String s, int i, int rows){
		return salaryDao.findword(s, i, rows);
	}
	
	public void saveOrUpdate(Salary salary){
		salaryDao.saveOrUpdate(salary);
	}
	
	public Salary get(Integer id){ //ÐÞ¸Ä
		
		return salaryDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		salaryDao.delete(ids);
	}
}
