package com.tpms.entities;

import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
//Ա����
	private Integer id;  //Ա����
	private String name;  //Ա������
	private String password;     //����
	private String sex;   //�Ա�
	private Integer age;   //����
	private String address;   //��ַ
	private String phone;   //��ϵ��ʽ
	private String email;   //����
	private Date birth;  //��������
	private Blob img;   //��Ƭ
	private String mary;   //����״��
	private String height;   //���
	private String  polity;   //������ò
	private String idcard;   //���֤��
	private String account;   //�����˺�
	private String bank_name;   //��������
	private Date arrival;   //��������
	
	private Position position;  //ְλ
	private Section section;   //��������
	private Nation nation;   //����
	private Education education;   //ѧ��
	
	private Set<Sheet> sheet = new HashSet<>();
	
	private String Incumbency;   //��ְ״̬
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Sheet> getSheet() {
		return sheet;
	}
	public void setSheet(Set<Sheet> sheet) {
		this.sheet = sheet;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Blob getImg() {
		return img;
	}
	public void setImg(Blob img) {
		this.img = img;
	}
	public String getMary() {
		return mary;
	}
	public void setMary(String mary) {
		this.mary = mary;
	}
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getPolity() {
		return polity;
	}
	public void setPolity(String polity) {
		this.polity = polity;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public String getIncumbency() {
		return Incumbency;
	}
	public void setIncumbency(String incumbency) {
		Incumbency = incumbency;
	}
}
