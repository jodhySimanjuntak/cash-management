package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mantabs.entity.master.GlobalParam;
import com.mantabs.entity.master.GlobalParamPK;

public interface GlobalParamRepository extends  JpaRepository<GlobalParam, String> {
	
	@Query(value = "select a.* from mmf_master.mmf_mst_Global_Param a "
			+ " where a.id_Condition = 'STATUS_KATEGORI_BIAYA' ", nativeQuery = true)
	public List<GlobalParam> getListStatus();

}
