package com.mantabs.collection.master.area_assignment.service.impl;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantabs.collection.master.area_assignment.dto.CMSMenuDto;
import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.collection.master.area_assignment.repository.LoginRepository;
import com.mantabs.collection.master.area_assignment.service.LoginSvc;
import com.mantabs.entity.master.CMSMenu;
import com.mantabs.entity.master.CMSUser;

@Service("loginSvc")
@Transactional
public class LoginSvcImpl implements LoginSvc{
	
	
	@Autowired
	LoginRepository loginDao;
	
	
	@Override
	public CMSUser login(String userName) {
		CMSUser user = loginDao.login(userName);
		
//		CMSUser user2 = new CMSUser();
//		user2.setId(user.getId());
//		user2.setEmail(user.getEmail());
//		user2.setFullname(user.getFullname());
//		user2.setName(user.getName());
//		user2.setUsername(user.getUsername());
//		user2.setPassword(user.getPassword());
		
		return user;
	}

	@Override
	public List<CMSMenuDto> menu() {
		List<CMSMenu> list = loginDao.menu();
		List<CMSMenuDto> menu =  new ArrayList<>();
		for(CMSMenu o : list){
			CMSMenuDto menu1 = new CMSMenuDto();
			menu1.setId(o.getId());
			menu1.setMenuUrl(o.getMenuUrl());
			menu1.setLabel(o.getLabel());
			menu.add(menu1);
		}
		return menu;
	}


	@Override
	public CMSUser loginPass(String userName, String pass) {
		// TODO Auto-generated method stub
		CMSUser user = loginDao.loginPass(userName,pass);
		
//		CMSUser user2 = new CMSUser();
//		user2.setId(user.getId());
//		user2.setEmail(user.getEmail());
//		user2.setFullname(user.getFullname());
//		user2.setName(user.getName());
//		user2.setUsername(user.getUsername());
//		user2.setPassword(user.getPassword());
		
		return user;
	}
	



}
