package com.tpms.entities;


public class Salary {
//Ա�����ʱ�
	private Integer id;
	private String name;  //����
	private String absence;  //ȱ�ڿ۳�
	private String business;   //�����
	private String basic;   //��������
	private String salary;    //ʵ�ʹ���
	private String annual;   //��н
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAbsence() {
		return absence;
	}

	public void setAbsence(String absence) {
		this.absence = absence;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}

}
