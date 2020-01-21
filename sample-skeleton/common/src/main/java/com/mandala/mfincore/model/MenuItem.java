package com.mandala.mfincore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuItem {
	private String uri;
	private String viewModel;
	private String name;
	private String pageId;
	private List<MenuItem> children;
	private Map<String, Object> bindingValue;
	
	private final String viewModelLocation="";
	private final String zulLocation = "/pages/";


	public MenuItem(String pageTitle, String moduleName, String pageName, String viewModel) {
		viewModel=(viewModel!=null?viewModel.trim():"");
		moduleName=(moduleName!=null?moduleName.trim().toLowerCase():"");
		pageTitle=(pageTitle!=null?pageTitle.trim():"");
		pageName=(pageName!=null?pageName.trim():"");
		pageId=pageName;
		if (pageTitle.isEmpty())  {
			name = pageName.substring(0, 1).toUpperCase() + pageName.substring(1);
		} else {
			name = pageTitle;
		}
		if (moduleName.isEmpty()) {
			if (viewModel.isEmpty()) {
				this.uri = "";
				this.viewModel="";
			} else {
				this.uri = viewModel;
				this.viewModel= viewModel.substring(0,1).toUpperCase()+viewModel.substring(1);
			}
		} else {
			if (viewModel.isEmpty()) {
				this.uri = "";
				this.viewModel="";
			} else {
				this.uri = viewModel;
				this.viewModel=moduleName + "." + viewModel.substring(0,1).toUpperCase()+viewModel.substring(1);
			}
		}

		children=new ArrayList<>();
	}

	public void addChild(MenuItem node) {
		children.add(node);
	}

	public String getUri() {
		return uri;
	}
	
	
	public String getViewModel() {
		return viewModelLocation+"./"+viewModel;
	}

	public String getName() {
//		System.out.println("get----"+title);
		return name;
	}

	public String getPageId() {
		return pageId;
	}

	public List<MenuItem> getChildren() {
		return children;
	}

	public void setChildren(List<MenuItem> children) {
		this.children = children;
	}

	public Map<String, Object> getBindingValue() {
		return bindingValue;
	}

	public void setBindingValue(Map<String, Object> bindingValue) {
		this.bindingValue = bindingValue;
	}
}
