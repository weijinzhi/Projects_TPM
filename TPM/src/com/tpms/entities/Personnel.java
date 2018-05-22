package com.tpms.entities;

import java.util.Date;

public class Personnel {
//人事变更表
	private Integer id;
	private Integer oldId;   //旧员工号
	private Integer newId;   //新员工号
	private String name;   //员工姓名
	private String oldSection;   //旧部门
	private String newSection;   //新部门
	private String oldPosition;  //旧职位
	private String newPosition;  //新职位
	private String oldsalary;   //旧底薪
	private String newsalary;   //新底薪
	private String reason;   //变动理由
	private Date date;   //变更时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOldId() {
		return oldId;
	}
	public void setOldId(Integer oldId) {
		this.oldId = oldId;
	}
	public Integer getNewId() {
		return newId;
	}
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOldSection() {
		return oldSection;
	}
	public void setOldSection(String oldSection) {
		this.oldSection = oldSection;
	}
	public String getNewSection() {
		return newSection;
	}
	public void setNewSection(String newSection) {
		this.newSection = newSection;
	}
	public String getOldPosition() {
		return oldPosition;
	}
	public void setOldPosition(String oldPosition) {
		this.oldPosition = oldPosition;
	}
	public String getNewPosition() {
		return newPosition;
	}
	public void setNewPosition(String newPosition) {
		this.newPosition = newPosition;
	}
	
	public String getOldsalary() {
		return oldsalary;
	}
	public void setOldsalary(String oldsalary) {
		this.oldsalary = oldsalary;
	}
	public String getNewsalary() {
		return newsalary;
	}
	public void setNewsalary(String newsalary) {
		this.newsalary = newsalary;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
