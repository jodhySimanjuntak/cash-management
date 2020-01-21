package com.mantabs.collection.master.area_assignment.repository;


import java.util.List;

import javax.inject.Qualifier;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.CMSMenu;

public interface MenuRepository extends JpaRepository<CMSMenu, String> {

	@Query(value = " select a.* from MMF_CMS.MF_MENU a where a.menu_Order > 99 and a.parent_id is null and a.menu_type = 'cm' ", nativeQuery = true)
	public List<CMSMenu> menu();
	
	
	@Query(value = "select a.menu_code, a.menu_name, a.menu_display_name from MMF_CMS.MF_Menu a  "
			+ "where a.parent_Menu_Code = '' and a.menu_type = 'cm' ", nativeQuery = true )	
	public List<Object[]> findAllParentMenuNull();
	
	
	@Query(value = "select a.* from MMF_CMS.MF_MENU a where "
			+ " a.parent_id = :parentCode and a.menu_type = 'cm' ", nativeQuery = true )	
	public List<CMSMenu> findByParentMenu(@Param("parentCode")int parentCode);

}
