package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;

import javax.inject.Qualifier;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.CMSMenu;
import com.mantabs.entity.master.CMSUser;

public interface LoginRepository extends JpaRepository<CMSUser, Integer> {

	@Query(value = "select a.* from MMF_CMS.MF_USER a where upper(trim(a.username))= upper (:userName) ", nativeQuery = true)
	public CMSUser login(@Param("userName")String userName);

	@Query(value = "select a.* from MMF_CMS.MF_USER a where upper (trim(a.username))= upper(:userName) and upper (trim(a.password)) =upper (:pass) "
			+ " and a.cabang_id = '10000' ", nativeQuery = true)
	public CMSUser loginPass(
			@Param("userName")String userName,
			@Param("pass")String pass);
	
	@Query(value = "select a.* from MMF_CMS.MF_USER a where a.is_Active = '1' ", nativeQuery = true)
	public List<CMSMenu> menu();
	
	
	

}
