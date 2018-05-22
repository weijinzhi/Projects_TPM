package com.tpms.entities;

import java.util.HashSet;
import java.util.Set;

public class Nation {
//Ãñ×å±í
	private Integer nationId;
	private String nationName;
	
	private Set<Employee> emps = new HashSet<>();
	
	public Integer getNationId() {
		return nationId;
	}
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
}
