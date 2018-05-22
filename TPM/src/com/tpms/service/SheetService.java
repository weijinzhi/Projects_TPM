package com.tpms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.SheetDao;
import com.tpms.entities.Sheet;

public class SheetService {

	private SheetDao sheetDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSheetDao(SheetDao sheetDao) {
		this.sheetDao = sheetDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Sheet> getAll(){
		return sheetDao.getAll();
	}
	
	public Map find(String s, int i, int rows){
		return sheetDao.find(s, i, rows);
	}
	
	public Map findword(int i, int rows){
		return sheetDao.findword(i, rows);
	}
	
	public Map finddate(Date date1, Date date2, Date date3, Date date4, int i, int rows){
		return sheetDao.finddate(date1, date2, date3, date4, i, rows);
	}
	
	public Map finddate1(Date date1, Date date2, int i, int rows){
		return sheetDao.finddate1(date1, date2, i, rows);
	}
	
	public Map finddate2(Date date3, Date date4, int i, int rows){
		return sheetDao.finddate2(date3, date4, i, rows);
	}
	
	public void saveOrUpdate(Sheet sheet){
		sheetDao.saveOrUpdate(sheet);
	}
	
	public Sheet get(Integer id){ //ÐÞ¸Ä
		
		return sheetDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		sheetDao.delete(ids);
	}
}
