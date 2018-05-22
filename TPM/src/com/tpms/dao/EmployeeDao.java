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

import com.tpms.entities.Employee;

public class EmployeeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public Employee login(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> list=getResult
				("FROM Employee WHERE name=? and password=?", new Object[]{employee.getName(), employee.getPassword()});
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
	
	public List<Employee> getAll() {
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.position " +
				"LEFT OUTER JOIN FETCH e.section LEFT OUTER JOIN FETCH e.nation" +
				" LEFT OUTER JOIN FETCH e.education";
		return getSession().createQuery(hql).list();
	}
	
	public Map findword(String name, int start, int length) {
    	Criteria criteria = getSession().createCriteria(Employee.class)
                .add(Restrictions.like("name", "%" + name + "%"));
        Long  total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        List rows = criteria.setFirstResult(start).setMaxResults(length).list();

		Map map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
        
    }
	
	public Employee find(String name) {
        List<Employee> list=getResult
				("FROM Employee WHERE name=?", new Object[]{name});
				if(list.size()==1){
					return  list.get(0);
				}else{
					return null;
				}
    }
	
	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	
	public Employee get(Integer id) {
		return (Employee) getSession().get(Employee.class, id);
	}
	
	public void delete(List<Integer> ids){
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		for(int i=0;i<ids.size();i++){
			  Integer temp = ids.get(i);
			  getSession().createQuery(hql).setInteger(0, temp).executeUpdate();
		}
	}

}
