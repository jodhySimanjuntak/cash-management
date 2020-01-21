package com.mantabs.collection.master.area_assignment.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuCode = "";
	private String menuTitle;
	private String menuType;
	private String menuUrl;
	private String menuParent = "";
	private String positionCode;
	private String positionName;
	private List<UserMenu> children = new ArrayList<>();
	private UserMenu parent;
	
	public UserMenu(){}
	
	public UserMenu(UserMenu other){
		menuCode = other.getMenuCode();
		menuTitle = other.getMenuTitle();
		menuType = other.getMenuType();
		menuUrl = other.getMenuUrl();
		menuParent = other.getMenuParent();
	}

	public UserMenu(String code, String title, String type){
		this.menuCode = code;
		this.menuTitle = title;
		this.menuType = type;
	}

	public void appendChild(UserMenu child) {
		if (children == null)
			children = new ArrayList<>();
		children.add(child);
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public List<UserMenu> getChildren() {
		if (children == null)
			return new ArrayList<>();
		
		return children;
	}

	public void setChildren(List<UserMenu> children) {
		this.children = children;
	}

	public String getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}

	public UserMenu getParent() {
		return parent;
	}

	public void setParent(UserMenu parent) {
		this.parent = parent;
	}
}