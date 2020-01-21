package com.mantabs.collection.master.area_assignment.tools;

import java.io.Serializable;
import java.util.List;

public class SidebarPage implements Serializable{
	private static final long serialVersionUID=1L;
	
	String label;
	String iconUri;
	String uri;
	String menuCode;
	List<SidebarPage> listSubMenu;
	
	public SidebarPage(String label, String iconUri, String uri, String menuCode, List<SidebarPage> listSubMenu) {
		this.label = label;
		this.uri = uri;
		this.iconUri=iconUri;
		this.menuCode = menuCode;
		this.listSubMenu = listSubMenu;
	}

	
	public SidebarPage(String label, String iconUri, String uri, String menuCode) {
		this.label = label;
		this.uri = uri;
		this.iconUri=iconUri;
		this.menuCode = menuCode;
	}

	public SidebarPage(String label, String iconUri, String uri) {
		this.label = label;
		this.uri = uri;
		this.iconUri=iconUri;
	}
	
	public SidebarPage(String iconUri, String uri) {
		this.uri = uri;
		this.iconUri=iconUri;
	}

	public SidebarPage() {
	}
	
	public String getIconUri(){
		return iconUri;
	}

	public String getLabel() {
		return label;
	}

	public String getUri() {
		return uri;
	}
	
	public String getMenuCode() {
		return menuCode;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public void setIconUri(String iconUri) {
		this.iconUri = iconUri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}


	public List<SidebarPage> getListSubMenu() {
		return listSubMenu;
	}


	public void setListSubMenu(List<SidebarPage> listSubMenu) {
		this.listSubMenu = listSubMenu;
	}


	
	
}
