package com.mantabs.collection.master.area_assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantabs.collection.master.area_assignment.model.MenuItem;
import com.mantabs.collection.master.area_assignment.repository.MasterMenuRepository;
import com.mantabs.collection.master.area_assignment.tools.SidebarPage;
import com.mantabs.entity.master.CMSMenu;
import com.mantabs.entity.master.MasterMenu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MasterMenuService {
    private long lastCount=0;
    private int lastTotalPages=0;
    
    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    private MasterMenuRepository menuRepository;

    private List<MenuItem> menus;

    public List<MenuItem> listMenu(String menuType) {
        menus=new ArrayList<>();
        List<MasterMenu> lstMasterMenu=menuRepository.findActiveCollateralMenuOrderByOrderNo();
        for (MasterMenu mnuItem : lstMasterMenu) {
            addPage(mnuItem);
        }
        return menus;
    }


    public List<MasterMenu> listPageableMenu(int activePage, int pageSize) {
        Pageable paging = PageRequest.of(activePage,pageSize);
        Page<MasterMenu> pagedResult = menuRepository.findAllByOrderByOrderNoAsc(paging);
        if(pagedResult.hasContent()) {
            lastCount=pagedResult.getTotalElements();
            lastTotalPages=pagedResult.getTotalPages();
            return pagedResult.getContent();
        } else {
            lastCount=0;
            lastTotalPages=0;
            return new ArrayList<>();
        }
    }


    private void  addPage(MasterMenu menuData) {
        String parentPageName=menuData.getParentPageName();
        String pageTitle=menuData.getPageTitle();
        String moduleName=menuData.getModuleName();
        String pageName=menuData.getPageName();
        String uri=menuData.getUri();
        if (uri==null) {
            uri="/notready";
        } else {
			/* pageTitle+=" [READY]"; */
        }


        if (parentPageName==null || parentPageName.isEmpty()) {
            MenuItem mainMenu = new MenuItem(pageTitle,moduleName,pageName,uri);
            menus.add(mainMenu);
        } else {
            MenuItem mainMenu = menus.stream()
                    .filter(mainMenuItem -> parentPageName.equals(mainMenuItem.getPageId()))
                    .findAny()
                    .orElse(null);
            MenuItem subMenu=new MenuItem(pageTitle,moduleName,pageName,uri);
            if (subMenu != null) {
            	mainMenu.addChild(subMenu);
            }
            
//            if (menuDao.findByParentMenu(user.getParentId()).size() == 0) {
//				for (CMSMenu s : menuDao.findByParentMenu(user.getMenuOrder())) {
//					int aktif = s.getIsActive();
//					if (aktif != 0) {
//						SidebarPage listSub = new SidebarPage();
//						listSub.setMenuCode(s.getId()+"");
//						listSub.setLabel(s.getLabel());
//						listSub.setUri(s.getMenuUrl());
//						listSub.setIconUri(s.getIconUrl());
//						subMenus.add(listSub);
//					}
//				}
//				user.setListSubMenu(subMenus);
//			} else {
//				user.setListSubMenu(null);
//			}
            
        }
    }


    public long getCount() {
        return lastCount;
    }


    public int getTotalPages() {
        return lastTotalPages;
    }

}
