package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.KategoriBiaya;
import com.mantabs.entity.master.SubKategori;


public interface SubKategoriRepository extends  JpaRepository<SubKategori, String> {

	@Query(value = "select a.* from mmf_master.mmf_mst_Sub_Kategori a "
			+ " where status = '1'"
			+ " and a.kategori_Biaya =:kode ", nativeQuery = true)
	public List<SubKategori> getListSubKategori(
			@Param("kode")String kode
			);
	
	@Query(value = "select a.* from mmf_master.mmf_mst_Sub_Kategori a "
			+ " where status = '1' "
			+ " and a.kategori_Biaya =:kode ", nativeQuery = true)
	public List<SubKategori> getListSubKategoriWithKode(
			@Param("kode")String kode
			);
	
	@Query(value = "select case when max(a.id_Sub_Kategori) is null then '0' else max(a.id_Sub_Kategori) end "
			+ " from mmf_master.mmf_mst_Sub_Kategori a ", nativeQuery = true)
	public String getLastKodeSubKategori();
	
	@Modifying
	@Query(value = " update mmf_master.mmf_mst_sub_kategori "
			+ " set status = 0 "
			+ " where id_sub_kategori =:kode ", nativeQuery = true)
	public void deleteSubKategori(
			@Param("kode")String kode
			);
	
	@Modifying
	@Query(value = " update mmf_master.mmf_mst_sub_kategori "
			+ " set status = 0 "
			+ " where kategori_biaya =:kategoriBiaya ", nativeQuery = true)
	public void deleteSubKategoriByKategoriBiaya(
			@Param("kategoriBiaya")String kategoriBiaya
			);
	
	@Query(value = " select a.* "
			+ " from mmf_master.mmf_mst_sub_kategori a "
			+ " where trim(upper (a.sub_kategori))= trim(upper(:subKategori)) "
			+ " and a.status = '1' ",nativeQuery = true)
	public List<SubKategori> cekSubKategori(
			@Param("subKategori") String subKategori
			);
	
	@Query(value = " select a.* "
			+ " from mmf_master.mmf_mst_sub_kategori a "
			+ " where trim(upper (a.id_sub_kategori))= trim(upper(:subKategori)) ",nativeQuery = true)
	public SubKategori cekSubKategoriDanStatus(
			@Param("subKategori") String subKategori
			);
}
