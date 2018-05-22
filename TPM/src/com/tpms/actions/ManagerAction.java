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
import com.tpms.entities.Manager;
import com.tpms.service.ManagerService;

public class ManagerAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Manager>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private ManagerService managerService;

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
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

	public String register(){
		return null;
	}
	
	public String login() throws Exception{
		String username = model.getUsername();
		String password=model.getPassword();
		Manager manager=managerService.login(username, password);
		System.out.println("in action"+manager);
		if(manager!=null){
			session.put("loginmanagername",manager.getUsername());
			session.put("loginmanagerpassword", manager.getPassword());
			request.put("message", "");
			return "success";
		}	
		else {
			request.put("message", "用户名或密码错误");
			return "fail";
		}
	}
	
	public String list(){
		request.put("managers", managerService.getAll());
		map = managerService.findword(model.getUsername() == null ? "" : model.getUsername(), (page - 1) * row,row);
//		map = managerService.findword1(model.getAdminId(), (page - 1) * row,row);
		return "list";
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String ids;

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Manager();
		}else{
			model = managerService.get(id);
		}
	}
	
	public String save(){
		managerService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public String update() {
		System.out.println(model);
		managerService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}

	public void prepareUpdate() {
		if (id == null) {
			model = new Manager();
		} else {
		
			model = managerService.get(id);
		}
	}
	
	public String delete() {
		String[] result = ids.split(",");
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			res.add(Integer.valueOf(result[i]));
		}
		managerService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
		
	}
	
	private Manager model;

	public Manager getModel() {
		if(model == null){
			model = new Manager();
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
}