package com.tpms.entities;

import java.util.HashSet;
import java.util.Set;

public class Position {
//ְλ��
	private Integer position_id;  //���
	private String position_name;  //ְλ
	private String salary;   //����
	
	private Section section;   //��������
	
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
