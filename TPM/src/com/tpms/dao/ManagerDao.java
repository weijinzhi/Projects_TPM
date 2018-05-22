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

import com.tpms.entities.Manager;

public class ManagerDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	public Manager login(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		List<Manager> list=getResult
				("FROM Manager WHERE username=? and password=?", new Object[]{manager.getUsername(), manager.getPassword()});
				if(list.size()==1){
					return  list.get(0);
				}else{
					return null;
				}	
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
	
	public List<Manager> getAll() {
		String hql = "FROM Manager";

		return getSession().createQuery(hql).list();
	}
	
	public Map findword(String username, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Manager.class)
                .add(Restrictions.like("username", "%" + username + "%"));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
	
	public void delete(List<Integer> ids){
		String hql = "DELETE FROM Manager u WHERE u.id = ?";
		for(int i=0;i<ids.size();i++){
			  Integer temp = ids.get(i);
			  getSession().createQuery(hql).setInteger(0, temp).executeUpdate();
		}
	}
	
	public void saveOrUpdate(Manager manager){
		getSession().saveOrUpdate(manager);
	}
	
	public Manager get(Integer id) {
		return (Manager) getSession().get(Manager.class, id);
	}
}
