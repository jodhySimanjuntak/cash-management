package com.mantabs.collection.master.area_assignment.service;

import java.util.List;

import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalHdrDto;
import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;

public interface AreaApprovalHdrSvc {

	public List<GlobalParamDTO> comboLevel();

	public List<KategoriBiayaDTO> comboKategoriBiaya(String kategoriBiaya);

	public List<JenisBiayaCMDTO> comboJenisBiaya(String jenisBiaya);

	public List<GlobalParamDTO> comboInisiator();

	public List<GlobalParamDTO> comboLevelDetail();

	public List<KategoriBiayaDTO> comboKategoriBiayaDetail(String kategoriBiaya);

	public List<JenisBiayaCMDTO> comboJenisBiayaDetail(String jenisBiaya);

	public List<GlobalParamDTO> comboInisiatorDetail();

	public List<GlobalParamDTO> comboBudgetDetail(String budget);

	public List<SubKategoriDTO> comboSubKategori(String subKategori);
	
	public List<GroupApprovalHdrDto> comboGroupApproval(String inisiator);
	
	public KategoriBiayaDTO findOneKategoriBiaya( String kategoriBiaya);
	
	public SubKategoriDTO findOneSubKategori( String subKategori);
	
	public JenisBiayaCMDTO findOneJenisBiaya( String jenisBiaya);

}
