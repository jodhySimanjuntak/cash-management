package com.mantabs.entity.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMF_MST_MENU database table.
 * 
 */
@Entity
@Table(name="MMF_MST_MENU")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal id;

	@Column(name="MODULE_NAME")
	private String moduleName;

	@Column(name="ORDER_NO")
	private BigDecimal orderNo;

	@Column(name="PAGE_NAME")
	private String pageName;

	@Column(name="PAGE_TITLE")
	private String pageTitle;

	@Column(name="PARENT_PAGE_NAME")
	private String parentPageName;

	@Column(name="VIEW_MODEL")
	private String viewModel;

	public Menu() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public BigDecimal getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(BigDecimal orderNo) {
		this.orderNo = orderNo;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageTitle() {
		return this.pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getParentPageName() {
		return this.parentPageName;
	}

	public void setParentPageName(String parentPageName) {
		this.parentPageName = parentPageName;
	}

	public String getViewModel() {
		return this.viewModel;
	}

	public void setViewModel(String viewModel) {
		this.viewModel = viewModel;
	}

}