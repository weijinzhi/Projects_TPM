package com.tpms.entities;

import java.util.HashSet;
import java.util.Set;

public class Section {
//���ű�
	private Integer section_id;  //���
	private String section_name;  //��������
	private String phone;  //���ŵ绰
	private String sectionManager;  //���ž���
	
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
