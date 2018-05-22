package com.tpms.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.EmployeeDao;
import com.tpms.entities.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public Employee login(String name, String password) throws Exception {

		Employee employee = new Employee();
		employee.setName(name);
		employee.setPassword(password);
		employee = this.employeeDao.login(employee);
		if (employee != null) {
			return employee;
		} else {
			return null;
		}
	}

	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
	
	public Map findword(String s, int i, int rows){
		return employeeDao.findword(s, i, rows);
	}
	
	public Employee find(String s){
		return employeeDao.find(s);
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public Employee get(Integer id){ //ÐÞ¸Ä
		
		return employeeDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		employeeDao.delete(ids);
	}
}
