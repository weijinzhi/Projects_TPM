package com.tpms.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.tpms.entities.Education;
import com.tpms.service.EducationService;

public class EducationAction extends ActionSupport implements RequestAware,
 ModelDriven<Education>,Preparable{

	private static final long serialVersionUID = 1L;
	
	private EducationService educationService;

	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	}
	//显示所有信息
	public String list(){
		request.put("educations", educationService.getAll());
		System.out.println(educationService.getAll().get(0).toString());
		return "list";
	}
	//信息录入
	public String input(){
		return "input";
	}
	
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Education();
		}else{
			model = educationService.get(id);
		}
	}
	
	public String save(){
		educationService.saveOrUpdate(model);
		return "save";
	}
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	@Override
	public void prepare() throws Exception {}
	
	private Education model;
	
	@Override
	public Education getModel() {
		
		return model;
	}

}