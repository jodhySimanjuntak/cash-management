package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.JenisBiayaCM;
import com.mantabs.entity.master.KategoriBiaya;
import com.mantabs.entity.master.SubKategori;


public interface JenisBiayaCMRepository extends  JpaRepository<JenisBiayaCM, String> {
	
	@Query(value = "select a.* from mmf_master.mmf_mst_Jenis_Biaya_CM a "
			+ " where status = '1' ", nativeQuery = true)
	public List<SubKategori> getListJenisBiaya();
	
	@Query(value = "select case when max(a.id_Jenis_Biaya) is null then '0' else max(a.id_Jenis_Biaya) end "
			+ " from mmf_master.mmf_mst_Jenis_Biaya_CM a ", nativeQuery = true)
	public String getLastKodeJenisBiaya();
	
	@Modifying
	@Query(value = " update mmf_master.mmf_mst_jenis_biaya_cm "
			+ " set status = 0 "
			+ " where id_jenis_biaya =:kode ", nativeQuery = true)
	public void deleteJenisBiaya(
			@Param("kode")String kode
			);
	
	@Query(value = " select a.* "
			+ " from mmf_master.mmf_mst_jenis_Biaya_cm a "
			+ " where trim(upper (a.jenis_biaya))= trim(upper(:jenisBiaya)) "
			+ " and a.status = '1' ",nativeQuery = true)
	public List<JenisBiayaCM> cekJenisBiaya(
			@Param("jenisBiaya") String jenisBiaya
			);
	
	@Query(value = " select a.* "
			+ " from mmf_master.mmf_mst_jenis_Biaya_cm a "
			+ " where trim(upper (a.id_jenis_biaya))= trim(upper(:jenisBiaya)) ",nativeQuery = true)
	public JenisBiayaCM cekJenisBiayaDanStatus(
			@Param("jenisBiaya") String jenisBiaya
			);
	
	@Modifying
	@Query(value = " update mmf_master.mmf_mst_jenis_biaya_cm "
			+ " set status = 0 "
			+ " where sub_kategori =:subKategori ", nativeQuery = true)
	public void deleteJenisBiayaBySubKategori(
			@Param("subKategori")String subKategori
			);
	
	@Modifying
	@Query(value = " update mmf_master.mmf_mst_jenis_biaya_cm "
			+ " set status = 0 "
			+ " where kategori_Biaya =:kategoriBiaya ", nativeQuery = true)
	public void deleteJenisBiayaByKategoriBiaya(
			@Param("kategoriBiaya")String kategoriBiaya
			);

}
