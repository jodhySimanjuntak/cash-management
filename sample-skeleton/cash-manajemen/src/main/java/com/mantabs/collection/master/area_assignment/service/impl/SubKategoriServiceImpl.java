package com.mantabs.collection.master.area_assignment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mantabs.collection.master.area_assignment.util.Paging;

import com.mantabs.collection.master.area_assignment.controller.BaseDaoImpl;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalHdrDto;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;
import com.mantabs.collection.master.area_assignment.repository.GroupApprovalHdrRepository;
import com.mantabs.collection.master.area_assignment.repository.JenisBiayaCMRepository;
import com.mantabs.collection.master.area_assignment.repository.SubKategoriRepository;
import com.mantabs.collection.master.area_assignment.service.SubKategoriService;
import com.mantabs.collection.master.area_assignment.util.StringUtil;
import com.mantabs.entity.master.GroupApprovalHdr;
import com.mantabs.entity.master.KategoriBiaya;
import com.mantabs.entity.master.SubKategori;

import ma.glasnost.orika.MapperFacade;

@Service("subKategoriService")
@Transactional
public class SubKategoriServiceImpl extends BaseDaoImpl implements SubKategoriService {
	@Autowired
	private SubKategoriRepository subKategoriRepository;
	
	@Autowired
	private JenisBiayaCMRepository jenisBiayaCMRepository;
	
	@Autowired
	private GroupApprovalHdrRepository groupApprovalHdrRepository;

	private Paging paging = new Paging();
	
	@Autowired
	private MapperFacade mapperFacade;

	@Override
	public Map<String, Object> findAllSubKategori(String kodeKategoriBiaya, String subKategori, String status, int page,
			int perPage) {
		// TODO Auto-generated method stub

//		if (kodeKategoriBiaya.equals("") && subKategori.equals("") && status.equals("")) {
//			kodeKategoriBiaya = "";
//			subKategori = "";
//			status = "";
//		} else {
		kodeKategoriBiaya = StringUtil.nevl(kodeKategoriBiaya, "%%");
		subKategori = StringUtil.nevl(subKategori, "%%");
		status = StringUtil.nevl(status, "%%");
//		}

		String sql = " select a.kategori_biaya as kode_kategori_biaya, a.id_sub_kategori, a.sub_kategori, b.kategori_biaya, "
				+ " case when a.status = 1 then 'AKTIF' "
				+ " when a.status = 0 then 'TIDAK AKTIF' end status, a.created_by, a.created_dt "
				+ " from MMF_MASTER.MMF_MST_SUB_KATEGORI a"
				+ " join MMF_MASTER.MMF_MST_KATEGORI_BIAYA b on a.kategori_biaya = b.id_kategori_biaya "
				+ " where a.kategori_biaya like '" + kodeKategoriBiaya + "' "
				+ " and upper (a.sub_kategori) like upper ('" + subKategori + "') " + " and a.status like '" + status
				+ "' ";

		int a = 0;
		if (page == 1) {
			a = page - 1;
		} else {
//			a = ((page - 1) * perPage) + 1;
			a = page - 1;
		}

		Map<String, Object> mapList = getPaging(sql, paging.getPageable(a, perPage, "asc", "id_sub_kategori"));

		@SuppressWarnings("unchecked")
		List<Object[]> objData = (List<Object[]>) mapList.get("contentData");
		List<SubKategoriDTO> listDto = new ArrayList<>();

		for (Object[] o : objData) {
			SubKategoriDTO dto = new SubKategoriDTO();
			dto.setKodeKategoriBiaya((String) o[0]);
			dto.setKodeSubKategori((String) o[1]);
			dto.setSubKategori((String) o[2]);
			dto.setNamaKategoriBiaya((String) o[3]);
			dto.setStatus((String) o[4]);
			dto.setCreatedBy((String) o[5]);
			dto.setCreatedDt((Date) o[6]);

			listDto.add(dto);
		}

		int jumlahHalaman = 0;
		int totalSize;
		if ((int) mapList.get("totalRecords") == 0) {
			totalSize = 1;
		} else {
			totalSize = (int) mapList.get("totalRecords");
		}
		jumlahHalaman = totalSize / perPage;
		if (totalSize % perPage > 0) {
			jumlahHalaman++;
		}

		Map<String, Object> map = new HashMap<>();
		map.put("totalSizeSubKategori", mapList.get("totalRecords"));
		map.put("listSubKategori", listDto);
		map.put("totalPageSubKategori", jumlahHalaman);

		return map;
	}

	@Override
	public List<SubKategoriDTO> comboSubKategori(String kode) {
		// TODO Auto-generated method stub
		List<SubKategori> listObj = subKategoriRepository.getListSubKategori(kode);
		List<SubKategoriDTO> listDto = new ArrayList<>();

		for (SubKategori o : listObj) {
			SubKategoriDTO dto = new SubKategoriDTO();
			dto.setKodeSubKategori(o.getKodeSubKategori());
			dto.setSubKategori(o.getSubKategori());
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public void saveSubKategori(SubKategoriDTO subKategoriDTO) {
		// TODO Auto-generated method stub

		if (subKategoriDTO.getKodeSubKategori() != null) {
			SubKategori dto = new SubKategori();

			dto.setKodeSubKategori(subKategoriDTO.getKodeSubKategori());
			dto.setKategoriBiaya(subKategoriDTO.getKodeKategoriBiaya());
			dto.setSubKategori(subKategoriDTO.getSubKategori().toUpperCase());
			dto.setStatus(subKategoriDTO.getStatus());
			dto.setCreatedBy(subKategoriDTO.getCreatedBy().toUpperCase());
			dto.setCreatedDt(subKategoriDTO.getCreatedDt());
			dto.setModifiedBy(subKategoriDTO.getModifiedBy().toUpperCase());
			dto.setModifiedDt(new Date());

			subKategoriRepository.save(dto);
		} else {
			SubKategori dto = new SubKategori();
			String z = "";

			int y = 0;
			int x = 0;

			String kode = subKategoriRepository.getLastKodeSubKategori();

			if (kode == null) {
				z = "01";
			} else {
				x = kode.length();
				y = Integer.parseInt(kode);
			}

			if (z != "01") {
				y = y + 1;
				z = Integer.toString(y);

				z.length();

				if (z.length() == 1) {
					z = "0" + z;
				} else {
					z = "" + z;
				}
			} else {
				y = y + 1;
				z = Integer.toString(y);

				z.length();

				if (z.length() == 1) {
					z = "0" + z;
				} else {
					z = "" + z;
				}
			}

			dto.setKodeSubKategori(z + "");
			dto.setKategoriBiaya(subKategoriDTO.getKategoriBiaya());
			dto.setSubKategori(subKategoriDTO.getSubKategori().toUpperCase());
			dto.setStatus(subKategoriDTO.getStatus());
			dto.setCreatedBy(subKategoriDTO.getCreatedBy().toUpperCase());
			dto.setCreatedDt(new Date());

			subKategoriRepository.save(dto);
		}

	}

	@Override
	public void deleteSubKategori(String kodeSubKategori) {
		// TODO Auto-generated method stub
		List<GroupApprovalHdr> listObj = groupApprovalHdrRepository.listGroupApprovalHdrWithSubKategori
				(kodeSubKategori);


		for (GroupApprovalHdr o : listObj) {
			GroupApprovalHdrDto dto = mapperFacade.map(o, GroupApprovalHdrDto.class);
			groupApprovalHdrRepository.deleteDetailById(dto.getIdNo());
		}
		
		subKategoriRepository.deleteSubKategori(kodeSubKategori);
		jenisBiayaCMRepository.deleteJenisBiayaBySubKategori(kodeSubKategori);
		groupApprovalHdrRepository.deleteHeaderBySubKategori(kodeSubKategori);
		
	}

	@Override
	public List<SubKategoriDTO> comboSubKategoriForDetail(String kodeKategoriBiaya) {
		// TODO Auto-generated method stub
		List<SubKategori> listObj = subKategoriRepository.getListSubKategoriWithKode(kodeKategoriBiaya);
		List<SubKategoriDTO> listDto = new ArrayList<>();

		for (SubKategori o : listObj) {
			SubKategoriDTO dto = new SubKategoriDTO();
			dto.setKodeSubKategori(o.getKodeSubKategori());
			dto.setSubKategori(o.getSubKategori());
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public List<SubKategoriDTO> cekSubKategori(String subKategori) {
		// TODO Auto-generated method stub
		List<SubKategori> listObj = subKategoriRepository.cekSubKategori(subKategori);
		List<SubKategoriDTO> listDto = new ArrayList<>();

		for (SubKategori o : listObj) {
			SubKategoriDTO dto = new SubKategoriDTO();
			dto.setKodeSubKategori(o.getKodeSubKategori());
			dto.setSubKategori(o.getSubKategori());
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public SubKategoriDTO cekSubKategoriDanStatus(String subKategori) {
		// TODO Auto-generated method stub
		SubKategori listObj = subKategoriRepository.cekSubKategoriDanStatus(subKategori);
		SubKategoriDTO dto = new SubKategoriDTO();
		
		if (listObj != null) {
			dto.setKodeSubKategori(listObj.getKodeSubKategori());
			dto.setSubKategori(listObj.getSubKategori());
			dto.setStatus(listObj.getStatus());
		}
		
		return dto;
	}

}
