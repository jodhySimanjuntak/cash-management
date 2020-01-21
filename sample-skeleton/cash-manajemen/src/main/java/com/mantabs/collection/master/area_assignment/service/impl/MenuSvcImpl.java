package com.mantabs.collection.master.area_assignment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantabs.collection.master.area_assignment.controller.BaseDaoImpl;
import com.mantabs.collection.master.area_assignment.dto.CMSMenuDto;
import com.mantabs.collection.master.area_assignment.repository.MenuRepository;
import com.mantabs.collection.master.area_assignment.service.MenuSvc;
import com.mantabs.collection.master.area_assignment.tools.SidebarPage;
import com.mantabs.entity.master.CMSMenu;

@Service("menuSvc")
@Transactional
public class MenuSvcImpl extends BaseDaoImpl implements MenuSvc {

	@Autowired
	MenuRepository menuDao;


	@Override
	public List<CMSMenuDto> menu() {
		List<CMSMenu> list = menuDao.menu();
		List<CMSMenuDto> menu = new ArrayList<>();
		for (CMSMenu o : list) {
			CMSMenuDto user = new CMSMenuDto();
			List<SidebarPage> subMenus = new ArrayList<>();
			List<SidebarPage> mainMenu = new ArrayList<>();
			user.setId(o.getId());
			user.setLabel(o.getLabel());
			if (o.getParentId() != null) {
				user.setParentId(o.getParentId());
			}
			if (o.getMenuOrder() != null) {
				user.setMenuOrder(o.getMenuOrder());
			}
			user.setMenuUrl(o.getMenuUrl());
			if (menuDao.findByParentMenu(user.getParentId()).size() == 0) {
				for (CMSMenu s : menuDao.findByParentMenu(user.getMenuOrder())) {
					int aktif = s.getIsActive();
					if (aktif != 0) {
						SidebarPage listSub = new SidebarPage();
						listSub.setMenuCode(s.getId()+"");
						listSub.setLabel(s.getLabel());
						listSub.setUri(s.getMenuUrl());
						listSub.setIconUri(s.getIconUrl());
						subMenus.add(listSub);
					}
				}
				user.setListSubMenu(subMenus);
				
//				user.setListSubMenu(null);
			} else /* if (menuDao.findByParentMenu(user.getParentId()).size() > 0) */ {
//				for (CMSMenu s : menuDao.findByParentMenu(user.getParentId())) {
//					int aktif = o.getIsActive();
//					if (aktif != 0) {
//						SidebarPage listSub = new SidebarPage();
//						listSub.setMenuCode(o.getId()+"");
//						listSub.setLabel(o.getLabel());
//						listSub.setUri(o.getLabel());
//						listSub.setIconUri(o.getIconUrl());
//						subMenus.add(listSub);
//					}
//				}
//				user.setListSubMenu(subMenus);
				user.setListSubMenu(null);
			}
			menu.add(user);
		}
		return menu;
	}


}
