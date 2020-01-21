package com.mantabs.collection.master.area_assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantabs.collection.master.area_assignment.controller.BaseDaoImpl;
import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalHdrDto;
import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;
import com.mantabs.collection.master.area_assignment.repository.AreaApprovalDtlRepository;
import com.mantabs.collection.master.area_assignment.repository.AreaApprovalHdrRepository;
import com.mantabs.collection.master.area_assignment.service.AreaApprovalHdrSvc;
import com.mantabs.collection.master.area_assignment.util.Paging;
import com.mantabs.entity.master.GroupApprovalHdr;
import com.mantabs.entity.master.JenisBiayaCM;
import com.mantabs.entity.master.KategoriBiaya;
import com.mantabs.entity.master.SubKategori;

@Service("areaApprovalHdrSvc")
@Transactional
public class AreaApprovalHdrSvcImpl extends BaseDaoImpl implements AreaApprovalHdrSvc {
	
	@Autowired
	private AreaApprovalHdrRepository areaApprovalHdrRepository;

	@Autowired
	private AreaApprovalDtlRepository areaApprovalDtlRepository;

	private Paging paging = new Paging();

	@Override
	public List<GlobalParamDTO> comboLevel() {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListStatus();
		List<GlobalParamDTO> listDto = new ArrayList<>();

		GlobalParamDTO dtoNew = new GlobalParamDTO();
		dtoNew.setIdParam("%%");
		dtoNew.setNamaParam("-All-");
		listDto.add(dtoNew);

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String) o[0]);
			dto.setNamaParam((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<KategoriBiayaDTO> comboKategoriBiaya(String kategoriBiaya) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListKategoriBiaya(kategoriBiaya);
		List<KategoriBiayaDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			KategoriBiayaDTO dto = new KategoriBiayaDTO();
			dto.setKodeKategoriBiaya((String) o[0]);
			dto.setKategoriBiaya((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<JenisBiayaCMDTO> comboJenisBiaya(String jenisBiaya) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListJenisBiaya(jenisBiaya);
		List<JenisBiayaCMDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			JenisBiayaCMDTO dto = new JenisBiayaCMDTO();
			dto.setKodeJenisBiaya((String) o[0]);
			dto.setJenisBiaya((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<GlobalParamDTO> comboInisiator() {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListInisiator();
		List<GlobalParamDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String) o[0]);
			dto.setNamaParam((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<GlobalParamDTO> comboLevelDetail() {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListStatus();
		List<GlobalParamDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String) o[0]);
			dto.setNamaParam((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<KategoriBiayaDTO> comboKategoriBiayaDetail(String kategoriBiaya) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListKategoriBiaya(kategoriBiaya);
		List<KategoriBiayaDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			KategoriBiayaDTO dto = new KategoriBiayaDTO();
			dto.setKodeKategoriBiaya((String) o[0]);
			dto.setKategoriBiaya((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<JenisBiayaCMDTO> comboJenisBiayaDetail(String katagoriBiaya) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListJenisBiaya(katagoriBiaya);
		List<JenisBiayaCMDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			JenisBiayaCMDTO dto = new JenisBiayaCMDTO();
			dto.setKodeJenisBiaya((String) o[0]);
			dto.setJenisBiaya((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<GlobalParamDTO> comboInisiatorDetail() {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListInisiator();
		List<GlobalParamDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String) o[0]);
			dto.setNamaParam((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<GlobalParamDTO> comboBudgetDetail(String budget) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListBudget(budget);
		List<GlobalParamDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GlobalParamDTO dto = new GlobalParamDTO();
			dto.setIdParam((String) o[0]);
			dto.setNamaParam((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<SubKategoriDTO> comboSubKategori(String kode) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListSubKategori(kode);
		List<SubKategoriDTO> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			SubKategoriDTO dto = new SubKategoriDTO();
			dto.setKodeSubKategori((String) o[0]);
			dto.setSubKategori((String) o[1]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<GroupApprovalHdrDto> comboGroupApproval(String inisiator) {
		// TODO Auto-generated method stub
		List<Object[]> listObj = areaApprovalHdrRepository.getListGroupApproval(inisiator);
		List<GroupApprovalHdrDto> listDto = new ArrayList<>();

		for (Object[] o : listObj) {
			GroupApprovalHdrDto dto = new GroupApprovalHdrDto();
			dto.setKodeGroupApproval((String)o[0]);
			dto.setGroupApproval((String)o[1]);
			dto.setKategoriBiaya((String)o[2]);
			dto.setSubKategori((String)o[3]);
			dto.setJenisBiaya((String)o[4]);
			dto.setBudget((String)o[5]);
			dto.setInisiator((String)o[6]);
			dto.setTingkatJabatan((String)o[7]);
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public KategoriBiayaDTO findOneKategoriBiaya(String kategoriBiaya) {
		// TODO Auto-generated method stub
		KategoriBiaya dto = areaApprovalHdrRepository.findOneKategoriBiaya(kategoriBiaya);

		KategoriBiayaDTO dtoNew = new KategoriBiayaDTO();

		if (dto != null) {
			dtoNew.setKodeKategoriBiaya(dto.getKodeKategoriBiaya());
			dtoNew.setKategoriBiaya(dto.getKategoriBiaya());
			dtoNew.setStatus(dto.getStatus());
			dtoNew.setCreatedBy(dto.getCreatedBy());
			dtoNew.setCreatedDt(dto.getCreatedDt());
		}

		return dtoNew;
	}

	@Override
	public SubKategoriDTO findOneSubKategori(String subKategori) {
		// TODO Auto-generated method stub
		SubKategori dto = areaApprovalHdrRepository.findOneSubKategori(subKategori);

		SubKategoriDTO dtoNew = new SubKategoriDTO();

		if (dto != null) {
			dtoNew.setKodeSubKategori(dto.getKodeSubKategori());
			dtoNew.setSubKategori(dto.getSubKategori());
		}

		return dtoNew;
	}

	@Override
	public JenisBiayaCMDTO findOneJenisBiaya(String jenisBiaya) {
		// TODO Auto-generated method stub
		JenisBiayaCM dto = areaApprovalHdrRepository.findOneJenisBiaya(jenisBiaya);

		JenisBiayaCMDTO dtoNew = new JenisBiayaCMDTO();

		if (dto != null) {
			dtoNew.setKodeJenisBiaya(dto.getKodeJenisBiaya());
			dtoNew.setJenisBiaya(dto.getJenisBiaya());
		}

		return dtoNew;
	}
	

}
