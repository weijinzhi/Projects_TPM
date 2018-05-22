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
import com.tpms.entities.Position;
import com.tpms.service.PositionService;
import com.tpms.service.SectionService;

public class PositionAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Position>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	private PositionService positionService;

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	
	private SectionService sectionService;
	
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}
	
	private int page;
	private int row;
	private String position_name;
	
	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

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
	
	public String list(){
		String position_name = req.getParameter("position_name");
		String s1 = req.getParameter("s1");
		String s2 = req.getParameter("s2");
		request.put("positions", positionService.getAll());
		map = positionService.findword((page - 1) * row,row);
		if(position_name != null){
			map = positionService.findname(position_name, (page - 1) * row,row);
		}else if(s1 != null && s2 != null){
			map = positionService.findsalary(s1, s2, (page - 1) * row,row);
		}
		return "list";
	}
	
	private Integer position_id;
	
	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}
	
	private String s1;
	private String s2;
	
	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public void prepareSave(){
		if(position_id == null){
			model = new Position();
		}else{
			model = positionService.get(position_id);
		}
	}
	
	public String save(){
		positionService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public String update() {
		System.out.println(model);
		positionService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}

	public void prepareUpdate() {
		if (position_id == null) {
			model = new Position();
		} else {
		
			model = positionService.get(position_id);
		}
	}
	
	public String input(){
		request.put("sections", sectionService.getAll());
		System.out.println(sectionService.getAll().get(0).toString());
		return "input";
	}
	
	public void prepareInput(){
		if(position_id != null){
			model = positionService.get(position_id);
		}
	}
	
	public String edit(){
		System.out.println(position_id);
		request.put("sections", sectionService.getAll());
		return "edit";
	}
	
	public void prepareEdit(){
		if(position_id != null){
			model = positionService.get(position_id);
		}
	}
	
	private Position model;

	public Position getModel() {
		if(model == null){
			model = new Position();
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
		positionService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
