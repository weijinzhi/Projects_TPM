package com.tpms.entities;

import java.util.Date;

public class Sheet {
//考勤表
	private Integer id; 
	private Date start;    //开始打卡时间
	private Date end;   //结束打卡时间
	private String sheetDesc;    //备注
	
	private Employee emp;    //对应员工

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
