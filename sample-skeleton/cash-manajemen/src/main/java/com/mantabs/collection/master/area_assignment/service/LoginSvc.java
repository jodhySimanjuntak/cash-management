package com.mantabs.collection.master.area_assignment.service;

import java.util.List;

import com.mantabs.collection.master.area_assignment.dto.CMSMenuDto;
import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.entity.master.CMSUser;

public interface LoginSvc {

	public CMSUser login(String userName);
	public CMSUser loginPass(String userName, String pass);
	public List<CMSMenuDto> menu();
}
