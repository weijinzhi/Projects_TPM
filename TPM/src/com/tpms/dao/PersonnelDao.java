package com.tpms.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tpms.entities.Personnel;

public class PersonnelDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public List getResult(String hql, Object[] parameters) {
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//×¢Èë?
		if(parameters!=null&&parameters.length>0){
			
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}
	
	public List<Personnel> getAll() {
		String hql = "FROM Personnel";
		return getSession().createQuery(hql).list();
	}
	
	public Map findword(String name, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Personnel.class)
                .add(Restrictions.like("name", "%" + name + "%"));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public Map finddate(Date date1, Date date2, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Personnel.class)
                .add(Restrictions.between("date", date1, date2));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public void saveOrUpdate(Personnel personnel){
		getSession().saveOrUpdate(personnel);
	}
	
	public Personnel get(Integer id) {
		return (Personnel) getSession().get(Personnel.class, id);
	}
	
	public void delete(List<Integer> ids){
		String hql = "DELETE FROM Personnel p WHERE p.id = ?";
		for(int i=0;i<ids.size();i++){
			  Integer temp = ids.get(i);
			  getSession().createQuery(hql).setInteger(0, temp).executeUpdate();
		}
	}
}
