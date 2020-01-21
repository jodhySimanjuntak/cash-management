package com.mantabs.collection.master.area_assignment.service;

import java.util.List;
import java.util.Map;

import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;


public interface JenisBiayaCMService {
	
	public Map<String, Object> findAllJenisBiaya(String KategoriBiaya, String subKategori, String kodeJenisBiaya,
			String status, int page,
			int perPage);

	public void saveJenisBiaya(JenisBiayaCMDTO jenisBiayaCMDTO);

	public void deleteJenisBiaya(String kodeSubKategori);
	
	public List<JenisBiayaCMDTO> cekJenisBiaya (String jenisBiaya);
	
	public JenisBiayaCMDTO cekJenisBiayaDanStatus (String jenisBiaya);


}
