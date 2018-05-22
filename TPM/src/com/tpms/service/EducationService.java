package com.tpms.service;

import java.util.List;

import com.tpms.dao.EducationDao;
import com.tpms.entities.Education;

public class EducationService {

	private EducationDao educationDao;

	public void setEducationDao(EducationDao educationDao) {
		this.educationDao = educationDao;
	}
	//获取所有信息
	public List<Education> getAll(){
		return educationDao.getAll();
	}
	//增、改
	public void saveOrUpdate(Education education){
		educationDao.saveOrUpdate(education);
	}
	//修改
	public Education get(Integer id){ 
		return educationDao.get(id);
	}
	
}
