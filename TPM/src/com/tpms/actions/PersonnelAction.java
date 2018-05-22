package com.tpms.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.tpms.entities.Personnel;
import com.tpms.service.PersonnelService;

public class PersonnelAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Personnel>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private PersonnelService personnelService;

	public void setPersonnelService(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	private int page;
	private int row;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public String list(){
		request.put("personnel", personnelService.getAll());
		map = personnelService.findword(model.getName() == null ? "" : model.getName(), (page - 1) * row,row);
		if(date1 != null && date2 != null){
			map = personnelService.finddate(date1, date2, (page - 1) * row,row);
		}
		return "list";
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	private Date date1;
	
	public Date getDate1() {
		return date1;
	}
	
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	private Date date2;
	
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	
	public String date(){
		map = personnelService.finddate(date1, date2, (page - 1) * row,row);
		System.out.println(date1);
		System.out.println(date2);
		return "date";
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Personnel();
		}else{
			model = personnelService.get(id);
		}
	}
	
	public String save(){
		personnelService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public void prepareUpdate() {
		if (id == null) {
			model = new Personnel();
		} else {
			model = personnelService.get(id);
		}
	}
	
	public String update() {
		System.out.println(model);
		personnelService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}
	
	private Personnel model;

	public Personnel getModel() {
		if(model == null){
			model = new Personnel();
		}
		return model;
	
	}
	public Map<String, Object> getMap() {
		return map;
	}

	@Override
	public void prepare() throws Exception {
	}
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
	private String ids;

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public String delete() {
		String[] result = ids.split(",");
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			res.add(Integer.valueOf(result[i]));
		}
		personnelService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
