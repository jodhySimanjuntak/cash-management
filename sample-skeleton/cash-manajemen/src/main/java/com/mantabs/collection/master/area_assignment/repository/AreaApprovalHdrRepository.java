package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.AreaApprovalHdr;
import com.mantabs.entity.master.JenisBiayaCM;
import com.mantabs.entity.master.KategoriBiaya;
import com.mantabs.entity.master.SubKategori;


public interface AreaApprovalHdrRepository extends  JpaRepository<AreaApprovalHdr, String> {

	@Query(value = "select a.id_param, a.nama_param from mmf_master.mmf_mst_Global_Param a "
			+ " where a.id_Condition = 'STATUS' ", nativeQuery = true)
	public List<Object[]> getListStatus();
	
	@Query(value = "select a.id_param, a.nama_param from mmf_master.mmf_mst_Global_Param a "
			+ " where a.id_Condition = 'INISIATOR' ", nativeQuery = true)
	public List<Object[]> getListInisiator(
			);
	
	@Query(value = "select a.id_param, a.nama_param from mmf_master.mmf_mst_Global_Param a "
			+ " where a.id_Condition = 'TIPE_BUDGET' "
			+ " and a.id_param =:idParam ", nativeQuery = true)
	public List<Object[]> getListBudget(
			@Param("idParam")String idParam
			);
	
	@Query(value = "select a.id_sub_kategori, a.sub_kategori from mmf_master.mmf_mst_sub_kategori a "
			+ " where a.status = '1' and a.kategori_Biaya =:kode ", nativeQuery = true)
	public List<Object[]> getListSubKategori(
			@Param("kode")String kode
			);
	
	@Query(value = " select b.nama_jabatan "
			+ " from MMF_MASTER.MMF_MST_JABATAN b "
			+ " join MMF_MASTER.MMF_MST_GROUP_APPROVAL_DTL a on a.jabatan = b.id_jabatan "
			+ " where a.group_approval =:groupApproval "
			+ " order by a.level_jabatan asc ",nativeQuery = true)
	public List<String> getLevelFromDtl(
			@Param("groupApproval")String groupApproval
			);
	
	@Query(value = "select a.id_kategori_biaya, a.kategori_biaya from mmf_master.mmf_mst_Kategori_Biaya a "
			+ " where a.status = '1' "
			+ " and a.kategori_biaya =:kategoriBiaya  ", nativeQuery = true)
	public List<Object[]> getListKategoriBiaya(
			@Param("kategoriBiaya")String kategoriBiaya
			);
	
	@Query(value = "select a.id_jenis_biaya, a.jenis_biaya from mmf_master.mmf_mst_jenis_Biaya_cm a "
			+ " where a.status = '1' and a.sub_kategori =:subKategori ", nativeQuery = true)
	public List<Object[]> getListJenisBiaya(
			@Param("subKategori") String subKategori
			);
	
	@Query(value = "select a.id_group_approval, a.group_approval, a.kategori_biaya, a.sub_kategori, a.jenis_biaya, a.budget,"
			+ " a.inisiator, a.tingkat_jabatan "
			+ " from mmf_master.mmf_mst_group_approval_hdr a "
			+ " where a.status = '1' "
			+ " and a.inisiator =:inisiator ", nativeQuery = true)
	public List<Object[]> getListGroupApproval(
			@Param("inisiator") String inisiator
			);
	
	@Query("select a from KategoriBiaya a "
			+ " where a.status = '1' and a.kodeKategoriBiaya =:kategoriBiaya " )
	public KategoriBiaya findOneKategoriBiaya(
			@Param("kategoriBiaya") String kategoriBiaya
			);
	
	@Query("select a from SubKategori a "
			+ " where a.status = '1' and a.kodeSubKategori =:subKategori " )
	public SubKategori findOneSubKategori(
			@Param("subKategori") String subKategori
			);
	
	@Query("select a from JenisBiayaCM a "
			+ " where a.status = '1' and a.kodeJenisBiaya =:jenisBiaya " )
	public JenisBiayaCM findOneJenisBiaya(
			@Param("jenisBiaya") String jenisBiaya
			);
	
}
