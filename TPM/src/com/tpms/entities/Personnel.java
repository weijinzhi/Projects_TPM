package com.tpms.entities;

import java.util.Date;

public class Personnel {
//���±����
	private Integer id;
	private Integer oldId;   //��Ա����
	private Integer newId;   //��Ա����
	private String name;   //Ա������
	private String oldSection;   //�ɲ���
	private String newSection;   //�²���
	private String oldPosition;  //��ְλ
	private String newPosition;  //��ְλ
	private String oldsalary;   //�ɵ�н
	private String newsalary;   //�µ�н
	private String reason;   //�䶯����
	private Date date;   //���ʱ��
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
