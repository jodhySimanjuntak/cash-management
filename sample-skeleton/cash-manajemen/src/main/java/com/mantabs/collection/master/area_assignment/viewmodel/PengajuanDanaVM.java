package com.mantabs.collection.master.area_assignment.viewmodel;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.Form;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PengajuanDanaVM extends SelectorComposer<Component>  {
	
	private static final long serialVersionUID = 1L;

	private final HashMap<String, Object> map = new LinkedHashMap<String, Object>();
	int activePage=0;
	int pageSize=15;
	
	@Init
	public void MainVM(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	public int getActivePage() {
		return activePage;
	}

	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	
	

}
