package com.tpms.entities;

import java.util.Date;

public class Sheet {
//���ڱ�
	private Integer id; 
	private Date start;    //��ʼ��ʱ��
	private Date end;   //������ʱ��
	private String sheetDesc;    //��ע
	
	private Employee emp;    //��ӦԱ��

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}


	public String getSheetDesc() {
		return sheetDesc;
	}

	public void setSheetDesc(String sheetDesc) {
		this.sheetDesc = sheetDesc;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
}
