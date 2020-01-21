package com.mantabs.collection.master.area_assignment.service;

import java.util.List;
import java.util.Map;

import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;

public interface SubKategoriService {

	public Map<String, Object> findAllSubKategori(String KategoriBiaya, String subKategori, String status, int page,
			int perPage);

	public void saveSubKategori(SubKategoriDTO subKategoriDTO);

	public void deleteSubKategori(String kodeSubKategori);

	public List<SubKategoriDTO> comboSubKategori(String kodeKategoriBiaya);
	
	public List<SubKategoriDTO> comboSubKategoriForDetail(String kodeKategoriBiaya);
	
	public List<SubKategoriDTO> cekSubKategori (String subKategori);
	
	public SubKategoriDTO cekSubKategoriDanStatus (String subKategori);

}
