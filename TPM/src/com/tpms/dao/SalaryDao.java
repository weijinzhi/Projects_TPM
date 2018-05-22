package com.tpms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tpms.entities.Salary;

public class SalaryDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public Map find(String name, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Salary.class)
                .add(Restrictions.eq("name", name));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public List getResult(String hql, Object[] parameters) {
		Query query=sessionFactory.openSession().createQuery(hql);
		//×¢Èë?
		if(parameters!=null&&parameters.length>0){
			
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}
	
	public List<Salary> getAll() {
		String hql = "FROM Salary";
		return getSession().createQuery(hql).list();
	}
	
	public Map findword(String name, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Salary.class)
                .add(Restrictions.like("name", "%" + name + "%"));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public void saveOrUpdate(Salary salary){
		getSession().saveOrUpdate(salary);
	}
	
	public Salary get(Integer id) {
		return (Salary) getSession().get(Salary.class, id);
	}
	
	public void delete(List<Integer> ids){
		String hql = "DELETE FROM Salary s WHERE s.id = ?";
		for(int i=0;i<ids.size();i++){
			  Integer temp = ids.get(i);
			  getSession().createQuery(hql).setInteger(0, temp).executeUpdate();
		}
	}
}
