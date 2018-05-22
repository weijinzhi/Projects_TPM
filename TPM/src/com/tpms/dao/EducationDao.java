package com.tpms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpms.entities.Education;

public class EducationDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	//��ȡ������Ϣ
	public List<Education> getAll() {
		String hql = "FROM Education";
		System.out.println("from education");
		return getSession().createQuery(hql).list();
	}
	//������
	public void saveOrUpdate(Education education){
		getSession().saveOrUpdate(education);
	}
	public Education get(Integer id) {
		return (Education) getSession().get(Education.class, id);
	}
}
