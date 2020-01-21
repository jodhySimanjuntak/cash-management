package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.GlobalParam;
import com.mantabs.entity.master.KategoriBiaya;


public interface KategoriBiayaRepository extends  JpaRepository<KategoriBiaya, String> {
	
	@Modifying
	@Query(value = " update mmf_master.mmf_mst_kategori_biaya "
			+ " set status = 0 "
			+ " where id_kategori_biaya =:kode ", nativeQuery = true)
	public void deleteKategoriBiaya(
			@Param("kode")String kode
			);
	
	@Query(value = "select a.* from mmf_master.mmf_mst_Kategori_Biaya a "
			+ " where a.status = '1' ", nativeQuery = true)
	public List<KategoriBiaya> getListKategoriBiaya();
	
	@Query(value = "select case when max(a.id_Kategori_Biaya) is null "
			+ " then '0' else max(a.id_Kategori_Biaya) end from mmf_master.mmf_mst_Kategori_Biaya a ", nativeQuery =  true)
	public String getLastKodeKategoriBiaya();
	
	@Query(value = " select a.* "
			+ " from mmf_master.mmf_mst_Kategori_Biaya a "
			+ " where trim(upper (a.kategori_biaya))= trim(upper(:kategoriBiaya)) "
			+ " and a.status = '1' ",nativeQuery = true)
	public List<KategoriBiaya> cekKategoriBiaya(
			@Param("kategoriBiaya") String kategoriBiaya
			);
	
	@Query(value = " select a.* "
			+ " from mmf_master.mmf_mst_Kategori_Biaya a "
			+ " where trim(upper (a.id_kategori_biaya))= trim(upper(:kategoriBiaya)) ",nativeQuery = true)
	public KategoriBiaya cekKategoriBiayaDanStatus(
			@Param("kategoriBiaya") String kategoriBiaya
			);
	
	

}
