package com.mantabs.collection.master.area_assignment.service;

import java.util.List;
import java.util.Map;

import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;




public interface KategoriBiayaService {
	
	
	public Map<String, Object> findAllKategoriBiaya
	(String kodeKategoriBiaya, 
			String status, int page, int perPage);
	
	public List<GlobalParamDTO> comboStatus();
	
	public void saveKategoriBiaya (KategoriBiayaDTO kategoriBiayaDTO);
	
	public void deleteKategoriBiaya (String kodeKategoriBiaya);
	
	public List<KategoriBiayaDTO> comboKategoriBiaya();
	
	public List<KategoriBiayaDTO> comboKategoriBiayaSKDetail();
	
	public List<KategoriBiayaDTO> cekKategoriBiaya (String kategoriBiaya);
	
	public KategoriBiayaDTO cekKategoriBiayaDanStatus (String kategoriBiaya);
	
	

}
