package com.mantabs.collection.master.area_assignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.CMSMenu;
import com.mantabs.entity.master.MasterMenu;

import java.util.List;

public interface MasterMenuRepository extends CrudRepository<MasterMenu, Long>, PagingAndSortingRepository<MasterMenu,Long> {
    List<MasterMenu> findAllByOrderByOrderNoAsc();

    @Query(value = "SELECT f.* FROM MMF_MASTER.MMF_MST_MENU f WHERE f.id = :id", nativeQuery = true)
    List<MasterMenu> findAllById(@Param("id") Long id);

//    @Query(value = "SELECT * FROM MMF_MASTER.MMF_MST_MENU  WHERE STATUS='ACTIVE' AND \"MODULE_NAME\" LIKE 'collection-%' ORDER BY \"ORDER_NO\"", nativeQuery = true)
//    List<MasterMenu> findActiveCollectionMenuOrderByOrderNo();

	
//	  @Query(value =
//	  "SELECT * FROM MMF_MASTER.MMF_MST_MENU  WHERE STATUS='ACTIVE' AND \"MODULE_NAME\" LIKE 'collateral-%' ORDER BY \"ORDER_NO\""
//	  , nativeQuery = true) List<MasterMenu>
//	  findActiveCollateralMenuOrderByOrderNo();
	 
    
    @Query(value = " SELECT * FROM MMF_MASTER.MMF_MST_MENU  WHERE STATUS='ACTIVE' AND \"MODULE_NAME\" LIKE 'cm-%' ORDER BY \"ORDER_NO\"", nativeQuery = true)
    List<MasterMenu> findActiveCollateralMenuOrderByOrderNo();

    Page<MasterMenu> findAllByOrderByOrderNoAsc(Pageable pageable);
    
    @Query(value = " SELECT * FROM MMF_MASTER.MMF_MST_MENU  "
    		+ " WHERE STATUS='ACTIVE' AND \"MODULE_NAME\" LIKE 'cm-%' "
    		+ " and PARENT_PAGE_NAME =:parentPageName "
    		+ " ORDER BY \"ORDER_NO\"", nativeQuery = true )	
	public List<MasterMenu> findByParentMenu(@Param("parentPageName")String parentPageName);
}
