package com.tpms.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.dao.SectionDao;
import com.tpms.entities.Section;

public class SectionService {

	private SectionDao sectionDao;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<Section> getAll(){
		return sectionDao.getAll();
	}
	
	public Map findword(String s, int i, int rows){
		return sectionDao.findword(s, i, rows);
	}
	
	public void saveOrUpdate(Section section){
		sectionDao.saveOrUpdate(section);
	}
	
	public Section get(Integer id){ //ÐÞ¸Ä
		
		return sectionDao.get(id);
	}
	
	public void delete(List<Integer> ids){
		sectionDao.delete(ids);
	}
}
