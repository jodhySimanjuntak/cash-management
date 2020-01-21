package com.mantabs.collection.master.area_assignment.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.mantabs.collection.master.area_assignment.dto.CabangDto;
import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalDtlDto;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalHdrDto;
import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.RegionalDto;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;
import com.mantabs.collection.master.area_assignment.dto.WilayahDto;

public interface GroupApprovalHdrSvc {

	public Map<String, Object> findAllGroupApprovalHdr(String kategoriBiaya, String subKategori, String jenisBiaya,
			String groupApproval, String status, String inisiator, String cabang, int page, int perPage);

	public List<GlobalParamDTO> comboLevel();

	public List<KategoriBiayaDTO> comboKategoriBiaya();

	public List<JenisBiayaCMDTO> comboJenisBiaya(String katagoriBiaya);

	public List<GlobalParamDTO> comboInisiator();

	public List<GlobalParamDTO> comboLevelDetail();

	public List<KategoriBiayaDTO> comboKategoriBiayaDetail();

	public List<JenisBiayaCMDTO> comboJenisBiayaDetail(String katagoriBiaya);

	public List<GlobalParamDTO> comboInisiatorDetail();

	public List<GlobalParamDTO> comboBudgetDetail();

	public List<SubKategoriDTO> comboSubKategori(String kode);

	public void saveGroupApproval(GroupApprovalHdrDto groupApprovalHdrDto);

	public List<GroupApprovalHdrDto> cekGroupApproval(String groupApproval, String kategoriBiaya, String subKategori,
			String jenisBiaya, String budget, String inisiator, String tingkatJabatan, BigDecimal startRangePengajuan,
			BigDecimal endRangePengajuan);

	public GroupApprovalHdrDto cekGroupApprovalDanStatus(String groupApproval);

	public List<GroupApprovalDtlDto> getListDetailByHeader(String groupApproval);

	public void deleteHeaderAndList(GroupApprovalHdrDto groupApprovalHdrDto);

	public List<WilayahDto> comboListWilayah();

	public List<WilayahDto> comboListWilayahWithName(String wilayah);

	public List<RegionalDto> comboListRegionalWithIdWilayah(String wilayah);

	public List<RegionalDto> comboListRegionalWithNameAndIdWilayah(String wilayah, String regional);
	
	public List<CabangDto> comboListCabangWithIdRegional(String regional);

	public List<CabangDto> comboListCabangWithNameAndIdRegional(String regional, String cabang);

}
