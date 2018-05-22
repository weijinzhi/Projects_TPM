package com.tpms.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.tpms.entities.Salary;
import com.tpms.service.SalaryService;

public class SalaryAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Salary>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private SalaryService salaryService;

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
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
	
	private HttpServletRequest req = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	public String find(){
		String user = req.getParameter("name");
		System.out.println(user);
		map = salaryService.find(user, (page - 1) * row,row);
		System.out.println(map.size());
		request.put("sal", map);
		req.setAttribute("sal", map);
		return "find";
	}
	
	public String list(){
		String cc = req.getParameter("cc");
		System.out.println(cc);
		request.put("salary", salaryService.getAll());
		map = salaryService.findword(model.getName() == null ? "" : model.getName(), (page - 1) * row,row);
		return "list";
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Salary();
		}else{
			model = salaryService.get(id);
		}
	}
	
	public String save(){
		salaryService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public void prepareUpdate() {
		if (id == null) {
			model = new Salary();
		} else {
			model = salaryService.get(id);
		}
	}
	
	public String update() {
		System.out.println(model);
		salaryService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}
	
	private Salary model;

	public Salary getModel() {
		if(model == null){
			model = new Salary();
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
		salaryService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
