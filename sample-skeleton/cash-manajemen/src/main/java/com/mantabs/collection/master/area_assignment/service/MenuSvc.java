package com.mantabs.collection.master.area_assignment.service;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.mantabs.collection.master.area_assignment.dto.CMSMenuDto;


public interface MenuSvc {
	public List<CMSMenuDto> menu();
//	public List<TbMRoleDDto> role(String userName);
	
}
