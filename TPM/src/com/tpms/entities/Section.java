package com.tpms.entities;

import java.util.HashSet;
import java.util.Set;

public class Section {
//部门表
	private Integer section_id;  //编号
	private String section_name;  //部门名称
	private String phone;  //部门电话
	private String sectionManager;  //部门经理
	
	public Integer getSection_id() {
		return section_id;
	}
	public void setSection_id(Integer section_id) {
		this.section_id = section_id;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSectionManager() {
		return sectionManager;
	}
	public void setSectionManager(String sectionManager) {
		this.sectionManager = sectionManager;
	}
	@Override
	public String toString() {
		return "Section [section_id=" + section_id + ", section_name="
				+ section_name + ", phone=" + phone + ", sectionManager="
				+ sectionManager + ", positions=" ;
	}
	
}
