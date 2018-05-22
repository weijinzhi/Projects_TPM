package com.tpms.actions;

import java.util.ArrayList;
import java.util.Date;
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
import com.tpms.entities.Sheet;
import com.tpms.service.EmployeeService;
import com.tpms.service.SheetService;

public class SheetAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Sheet>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private SheetService sheetService;

	public void setSheetService(SheetService sheetService) {
		this.sheetService = sheetService;
	}
	
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
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
	
	private Date date1;
	private Date date2;
	private Date date3;
	private Date date4;
	
	public Date getDate1() {
		return date1;
	}
	
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	
	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public Date getDate4() {
		return date4;
	}

	public void setDate4(Date date4) {
		this.date4 = date4;
	}
	
	private HttpServletRequest req = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	public String find(){
		String user = req.getParameter("name");
		System.out.println(user);
		map = sheetService.find(user, (page - 1) * row,row);
		System.out.println(map.size());
		request.put("sal", map);
		req.setAttribute("sal", map);
		return "find";
	}

	public String list(){
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(date4);
		request.put("sheets", sheetService.getAll());
		map = sheetService.findword((page - 1) * row,row);
		if(date1 != null && date2 != null && date3!= null && date4 != null){
			map = sheetService.finddate(date1, date2, date3, date4, (page - 1) * row,row);
		}else if(date1 != null && date2 != null){
			map = sheetService.finddate1(date1, date2, (page - 1) * row,row);
		}else if(date3 != null && date4 != null){
			map = sheetService.finddate2(date3, date4, (page - 1) * row,row);
		}
		return "list";
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void prepareSave(){
		if(id == null){
			model = new Sheet();
		}else{
			model = sheetService.get(id);
		}
	}
	
	public String save(){
		sheetService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public String update() {
		System.out.println(model);
		sheetService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}

	public void prepareUpdate() {
		if (id == null) {
			model = new Sheet();
		} else {
		
			model = sheetService.get(id);
		}
	}
	
	public String input(){
		request.put("emps", employeeService.getAll());
		System.out.println(employeeService.getAll().size());
		System.out.println(employeeService.getAll().get(0).toString());
		return "input";
	}
	
	public void prepareInput(){
		if(id != null){
			model = sheetService.get(id);
		}
	}
	
	public String edit(){
		return "edit";
	}
	
	public void prepareEdit(){
		if(id != null){
			model = sheetService.get(id);
		}
	}
	
	private Sheet model;

	public Sheet getModel() {
		if(model == null){
			model = new Sheet();
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
		sheetService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
