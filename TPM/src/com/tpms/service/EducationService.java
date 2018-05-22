package com.tpms.service;

import java.util.List;

import com.tpms.dao.EducationDao;
import com.tpms.entities.Education;

public class EducationService {

	private EducationDao educationDao;

	public void setEducationDao(EducationDao educationDao) {
		this.educationDao = educationDao;
	}
	//��ȡ������Ϣ
	public List<Education> getAll(){
		return educationDao.getAll();
	}
	//������
	public void saveOrUpdate(Education education){
		educationDao.saveOrUpdate(education);
	}
	//�޸�
	public Education get(Integer id){ 
		return educationDao.get(id);
	}
	
}
