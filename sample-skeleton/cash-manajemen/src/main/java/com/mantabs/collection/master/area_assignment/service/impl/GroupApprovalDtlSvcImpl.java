package com.mantabs.collection.master.area_assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantabs.collection.master.area_assignment.controller.BaseDaoImpl;
import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.JabatanDto;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.repository.GroupApprovalDtlRepository;
import com.mantabs.collection.master.area_assignment.service.GroupApprovalDtlSvc;
import com.mantabs.entity.master.GlobalParam;
import com.mantabs.entity.master.Jabatan;
import com.mantabs.entity.master.KategoriBiaya;

@Service("groupApprovalDtlSvc")
@Transactional
public class GroupApprovalDtlSvcImpl extends BaseDaoImpl implements GroupApprovalDtlSvc {

	@Autowired
	private GroupApprovalDtlRepository groupApprovalDtlRepository;
	
	@Override
	public List<GlobalParamDTO> comboLevel() {
		// TODO Auto-generated method stub
		List<Object[]> listObj = groupApprovalDtlRepository.getListLevel();
		List<GlobalParamDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String)o[0]);
			dto.setNamaParam((String)o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<JabatanDto> comboJabatan() {
		// TODO Auto-generated method stub
		List<Object[]> listObj = groupApprovalDtlRepository.getListJabatan();
		List<JabatanDto> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			JabatanDto dto = new JabatanDto();
			dto.setIdJabatan((String)o[0]);
			dto.setNamaJabatan((String)o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<JabatanDto> comboJabatan(String jabatan, List<String> namaJabatan) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = groupApprovalDtlRepository.getListJabatanByName(jabatan, namaJabatan);
		List<JabatanDto> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			JabatanDto dto = new JabatanDto();
			dto.setIdJabatan((String)o[0]);
			dto.setNamaJabatan((String)o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<JabatanDto> listNotInJabatan(List<String> namaJabatan) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = groupApprovalDtlRepository.getListNotInJabatan(namaJabatan);
		List<JabatanDto> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			JabatanDto dto = new JabatanDto();
			dto.setIdJabatan((String)o[0]);
			dto.setNamaJabatan((String)o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<GlobalParamDTO> comboLevel(List<String> namaParam) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = groupApprovalDtlRepository.getListNotInLevel(namaParam);
		List<GlobalParamDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String)o[0]);
			dto.setNamaParam((String)o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

}
