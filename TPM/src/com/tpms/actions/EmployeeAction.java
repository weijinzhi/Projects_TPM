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
import com.tpms.entities.Employee;
import com.tpms.service.EmployeeService;
import com.tpms.service.SectionService;

public class EmployeeAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Employee>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private SectionService sectionService;
	
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
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
	
	public String login() throws Exception{
		String name = model.getName();
		String password=model.getPassword();
		Employee employee=employeeService.login(name, password);
		System.out.println("in action"+employee);
		if(employee!=null){
			session.put("loginmanagername",employee.getName());
			session.put("loginmanagerpassword", employee.getPassword());
			request.put("message", "");
			return "success";
		}	
		else {
			request.put("message", "用户名或密码错误");
			return "fail";
		}
	}
	
	private HttpServletRequest req = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	public String find(){
		String user = req.getParameter("name");
		System.out.println(user);
		Employee emp = employeeService.find(user);
		System.out.println(emp.getPassword());
		request.put("emp", emp);
		req.setAttribute("emp", emp);
		return "find";
	}
	
	public String list(){
		request.put("sections", sectionService.getAll());
		request.put("positions", employeeService.getAll());
		map = employeeService.findword(model.getName() == null ? "" : model.getName(), (page - 1) * row,row);
		return "list";
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Employee();
		}else{
			model = employeeService.get(id);
		}
	}
	
	public String save(){
		employeeService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public String update() {
		employeeService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}

	public void prepareUpdate() {
		if (id == null) {
			model = new Employee();
		} else {
		
			model = employeeService.get(id);
		}
	}
	
	public String input(){
		return "input";
	}
	
	public void prepareInput(){
		if(id != null){
			model = employeeService.get(id);
		}
	}
	
	private Employee model;

	public Employee getModel() {
		if(model == null){
			model = new Employee();
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
		employeeService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
