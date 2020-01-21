package com.mantabs.collection.master.area_assignment.service;

import java.util.List;

import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.JabatanDto;

public interface GroupApprovalDtlSvc {

	public List<GlobalParamDTO> comboLevel();
	
	public List<JabatanDto> comboJabatan();
	
	public List<JabatanDto> comboJabatan(String jabatan, List<String> namaJabatan);
	
	public List<JabatanDto> listNotInJabatan(List<String> namaJabatan);
	
	public List<GlobalParamDTO> comboLevel(List<String> namaParam);
	
}
