package com.tpms.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.tpms.entities.Nation;
import com.tpms.service.NationService;

public class NationAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Nation>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private NationService nationService;

	public void setNationService(NationService nationService) {
		this.nationService = nationService;
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
		request.put("nations", nationService.getAll());
		map = nationService.findword(model.getNationName() == null ? "" : model.getNationName(), (page - 1) * row,row);
		return "list";
	}
	
	private Integer nationId;
	
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	
	public void prepareSave(){
		if(nationId == null){
			model = new Nation();
		}else{
			model = nationService.get(nationId);
		}
	}
	
	public String save(){
		nationService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public String update() {
		System.out.println(model);
		nationService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}

	public void prepareUpdate() {
		if (nationId == null) {
			model = new Nation();
		} else {
		
			model = nationService.get(nationId);
		}
	}
	
	private Nation model;

	public Nation getModel() {
		if(model == null){
			model = new Nation();
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
		nationService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
