package com.mantabs.collection.master.area_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mantabs.entity.master.GlobalParam;
import com.mantabs.entity.master.GroupApprovalDtl;
import com.mantabs.entity.master.Jabatan;


public interface GroupApprovalDtlRepository extends  JpaRepository<GroupApprovalDtl, String> {

	@Query(value = "select a.id_param, a.nama_param from mmf_master.mmf_mst_global_param a "
			+ " where a.status = '1' and id_condition = 'LEVEL_APPROVAL' ", nativeQuery = true)
	public List<Object[]> getListLevel();
	
	@Query(value = "select a.id_jabatan, a.nama_jabatan from mmf_master.mmf_mst_jabatan a "
			+ " where a.status = '1' ", nativeQuery = true)
	public List<Object[]> getListJabatan();
	
	@Query(value = "select a.id_jabatan, a.nama_jabatan from mmf_master.mmf_mst_jabatan a "
			+ " where a.status = '1' and upper(a.nama_jabatan) like upper(:jabatan) and "
			+ " a.nama_jabatan not in (:namaJabatan) ", nativeQuery = true)
	public List<Object[]> getListJabatanByName(
			@Param("jabatan") String jabatan,
			@Param("namaJabatan")List<String> namaJabatan
			);
	@Query(value = "select a.id_jabatan, a.nama_jabatan from mmf_master.mmf_mst_jabatan a "
			+ " where a.status = '1' and a.nama_jabatan not in (:namaJabatan) ", nativeQuery = true)
	public List<Object[]> getListNotInJabatan(
			@Param("namaJabatan")List<String> namaJabatan
			);
	
	@Query(value = "select a.id_param, a.nama_param from mmf_master.mmf_mst_global_param a "
			+ " where a.status = '1' and id_condition = 'LEVEL_APPROVAL' "
			+ " and a.nama_param not in (:namaParam) ", nativeQuery = true)
	public List<Object[]> getListNotInLevel(
			@Param("namaParam")List<String> namaParam
			);
}
