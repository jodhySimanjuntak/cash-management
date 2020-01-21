package com.mantabs.collection.master.area_assignment.viewmodel;


import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Sessions;

import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.collection.master.area_assignment.tools.SidebarPage;

public class NavigationVM {

	private String includeSrc = "/pages/empty.zul";

	@GlobalCommand("onNavigate")
	@NotifyChange("includeSrc")
	public void onNavigate(@BindingParam("page") SidebarPage page) {
		String locationUri = page.getUri();
		includeSrc = locationUri;
	}

	@GlobalCommand("onNavigateSub")
	@NotifyChange("includeSrc")
	public void onNavigateSub(@BindingParam("page") SidebarPage page) {
		String locationUri = page.getUri();
		includeSrc = locationUri;
	}

	public String getIncludeSrc() {
		CMSUserDto user = (CMSUserDto) Sessions.getCurrent().getAttribute(
				"user");
		Sessions.getCurrent().removeAttribute("admin");
		
//		includeSrc = "/zul/MasterData.zul";
		
//		if (includeSrc
//				.equals("/WEB-INF/pages/userManagement/dashboard/index.zul")) {
//			if (user.getMenuList().size() > 0) {
//				for (TbMRoleDDto r : user.getRole()) {
//					if (r.isAdmin()) {
//						includeSrc = "/WEB-INF/pages/userManagement/dashboard/index.zul";
//					} else {
//						includeSrc = "/WEB-INF/pages/userManagement/customer/index.zul";
//					}
//				}
//			} else {
//				includeSrc = "userRoleNonActive.zul";
//			}
//
//		} else if (includeSrc
//				.equals("/WEB-INF/pages/userManagement/customer/index.zul")) {
//			for (TbMRoleDDto r : user.getRole()) {
//				if (r.isAdmin()) {
//					includeSrc = "/WEB-INF/pages/userManagement/ListProfile/index.zul";
//				} else {
//					includeSrc = "/WEB-INF/pages/userManagement/customer/index.zul";
//				}
//			}
//		}
		return includeSrc;
	}
	
}
