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
import com.tpms.entities.Section;
import com.tpms.service.SectionService;

public class SectionAction extends ActionSupport implements SessionAware,
RequestAware,ModelDriven<Section>, Preparable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
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
	
	public String list(){
		request.put("sections", sectionService.getAll());
		map = sectionService.findword(model.getSection_name() == null ? "" : model.getSection_name(), (page - 1) * row,row);
		return "list";
	}
	
	private Integer section_id;
	
	public void setSection_id(Integer section_id) {
		this.section_id = section_id;
	}
	
	public void prepareSave(){
		if(section_id == null){
			model = new Section();
		}else{
			model = sectionService.get(section_id);
		}
	}
	
	public String save(){
		sectionService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "添加成功");
		return "save";
	}
	
	public void prepareUpdate() {
		if (section_id == null) {
			model = new Section();
		} else {
			model = sectionService.get(section_id);
		}
	}
	
	public String update() {
		System.out.println(model);
		System.out.println("aaa");
		sectionService.saveOrUpdate(model);
		map.put("status", "提示消息");
		map.put("message", "更新成功");
		return "update";
	}
	
	private Section model;

	public Section getModel() {
		if(model == null){
			model = new Section();
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
		sectionService.delete(res);
		map.put("status", "提示消息");
		map.put("message", "删除成功");
		return "delete";
	}
}
