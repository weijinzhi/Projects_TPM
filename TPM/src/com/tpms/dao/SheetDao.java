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

import com.tpms.entities.Employee;
import com.tpms.entities.Sheet;

public class SheetDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public Map find(String name, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Sheet.class)
                .createCriteria("emp").add(Restrictions.like("name", "%" +name + "%"));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        System.out.println("*_**_*****" + rows);
        return map;
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
	
	public List<Sheet> getAll() {
		String hql = "FROM Sheet s LEFT OUTER JOIN FETCH s.emp";
		return getSession().createQuery(hql).list();
	}
	
	public Map findword(int start, int length) {
    	Criteria criteria = getSession().createCriteria(Sheet.class);
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public Map finddate(Date date1, Date date2, Date date3, Date date4, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Sheet.class)
    			.add(Restrictions.between("start", date1, date2))
    			.add(Restrictions.between("end", date3, date4));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public Map finddate1(Date date1, Date date2, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Sheet.class)
    			.add(Restrictions.between("start", date1, date2));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public Map finddate2(Date date3, Date date4, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Sheet.class)
    			.add(Restrictions.between("end", date3, date4));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public void saveOrUpdate(Sheet sheet){
		getSession().saveOrUpdate(sheet);
	}
	
	public Sheet get(Integer id) {
		return (Sheet) getSession().get(Sheet.class, id);
	}
	
	public void delete(List<Integer> ids){
		String hql = "DELETE FROM Sheet s WHERE s.id = ?";
		for(int i=0;i<ids.size();i++){
			  Integer temp = ids.get(i);
			  getSession().createQuery(hql).setInteger(0, temp).executeUpdate();
		}
	}
}
