package com.tpms.entities;

import java.util.HashSet;
import java.util.Set;

public class Position {
//职位表
	private Integer position_id;  //编号
	private String position_name;  //职位
	private String salary;   //工资
	
	private Section section;   //所属部门
	
	private Set<Employee> emps = new HashSet<>();
	
	public Integer getPosition_id() {
		return position_id;
	}
	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	
}
