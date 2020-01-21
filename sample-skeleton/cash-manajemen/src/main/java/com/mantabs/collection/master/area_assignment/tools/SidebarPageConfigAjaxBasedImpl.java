package com.mantabs.collection.master.area_assignment.tools;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mantabs.collection.master.area_assignment.dto.CMSMenuDto;
import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;

public class SidebarPageConfigAjaxBasedImpl implements SidebarPageConfig {
//
//	@Autowired
//	LoginDao loginDao;

	HashMap<String, SidebarPage> pageMp = new LinkedHashMap<String, SidebarPage>();

	List<SidebarPage> listSubMenu = new ArrayList<>();

	public SidebarPageConfigAjaxBasedImpl(CMSUserDto user) {
		if (user != null) {
			for (CMSMenuDto m : user.getMenuList()) {
//				System.err.println("luthfi " + m.getMenuCode() + " "+ m.getParentMenuCode() + " "+m.getListSubMenu());
				pageMp.put(m.getId()+"",new SidebarPage(m.getLabel(), m.getIconUrl(), m.getMenuUrl(), m.getParentId()+"",m.getListSubMenu()));
			}
		} else {
			pageMp.put("42", new SidebarPage("Master Kategori Biaya",
					"",
					"/pages/master/MasterData.zul"));
			// pageMp.put("fn3", new SidebarPage("permintaan Perubahan Data",
			// "/res/icon_permintaan.png",
			// "/WEB_INF/pages/userManagement/customer/index.zul"));

		}

	}

	@Override
	public List<SidebarPage> getPages() {
		return new ArrayList<SidebarPage>(pageMp.values());
	}


}
