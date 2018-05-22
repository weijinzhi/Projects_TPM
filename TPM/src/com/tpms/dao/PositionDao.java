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

import com.tpms.entities.Position;

public class PositionDao {

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
	
	public List<Position> getAll() {
		String hql = "FROM Position p LEFT OUTER JOIN FETCH p.section";
		return getSession().createQuery(hql).list();
	}
	
	public Map findname(String name, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Position.class)
                .add(Restrictions.like("position_name", "%" + name + "%"));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public Map findword(int start, int length) {
    	Criteria criteria = getSession().createCriteria(Position.class);
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public Map findsalary(String s1, String s2, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Position.class)
                .add(Restrictions.between("salary", s1, s2));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public void saveOrUpdate(Position position){
		getSession().saveOrUpdate(position);
	}
	
	public Position get(Integer id) {
		return (Position) getSession().get(Position.class, id);
	}
	
	public void delete(List<Integer> ids){
		String hql = "DELETE FROM Position p WHERE p.position_id = ?";
		for(int i=0;i<ids.size();i++){
			  Integer temp = ids.get(i);
			  getSession().createQuery(hql).setInteger(0, temp).executeUpdate();
		}
	}
}
