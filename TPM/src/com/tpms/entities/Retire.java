package com.tpms.entities;

import java.sql.Blob;
import java.util.Date;

public class Retire {
//退休员工管理
	private Integer id;  //员工号
	private String name;  //员工姓名
	private String sex;   //性别
	private Integer age;   //年龄
	private String address;   //地址
	private String phone;   //联系方式
	private Date birth;  //出生年月
	private String mary;   //婚姻状况
	private String height;   //身高
	private String  polity;   //政治面貌
	private String idcard;   //身份证号
	private String account;   //银行账号
	private String bank_name;   //银行名称
	private Date arrival;   //到岗日期
	
	private Position position;  //职位
	private Section section;   //所属部门
	private Nation nation;   //民族
	private Education education;   //学历
}
