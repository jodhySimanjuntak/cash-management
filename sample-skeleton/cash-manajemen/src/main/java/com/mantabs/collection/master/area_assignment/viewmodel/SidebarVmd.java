package com.mantabs.collection.master.area_assignment.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.collection.master.area_assignment.tools.SidebarPage;
import com.mantabs.collection.master.area_assignment.tools.SidebarPageConfig;
import com.mantabs.collection.master.area_assignment.tools.SidebarPageConfigAjaxBasedImpl;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SidebarVmd {
	
	@Init
	public void load(){
		getSidebarPage();
	}
	
	@Command
	public void cek(@BindingParam("item")SidebarPage item){
	}
	
	CMSUserDto user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");
	private SidebarPageConfig pageConfig = new SidebarPageConfigAjaxBasedImpl(
			user);

	public List<SidebarPage> getSidebarPage() {
		return pageConfig.getPages();
	}


}
