package com.tpms.entities;

import java.util.HashSet;
import java.util.Set;

public class Education {
//Ñ§Àú±í
	private Integer id;
	private String eduName;
	
	private Set<Employee> emps = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", eduName=" + eduName + "]";
	}
	
}
