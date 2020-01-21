package com.mantabs.collection.master.area_assignment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantabs.collection.master.area_assignment.controller.BaseDaoImpl;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalHdrDto;
import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;
import com.mantabs.collection.master.area_assignment.repository.GroupApprovalHdrRepository;
import com.mantabs.collection.master.area_assignment.repository.JenisBiayaCMRepository;
import com.mantabs.collection.master.area_assignment.service.JenisBiayaCMService;
import com.mantabs.collection.master.area_assignment.util.Paging;
import com.mantabs.collection.master.area_assignment.util.StringUtil;
import com.mantabs.entity.master.GroupApprovalHdr;
import com.mantabs.entity.master.JenisBiayaCM;
import com.mantabs.entity.master.KategoriBiaya;
import com.mantabs.entity.master.SubKategori;

import ma.glasnost.orika.MapperFacade;

@Service("jenisBiayaCMService")
@Transactional
public class JenisBiayaCMServiceImpl extends BaseDaoImpl implements JenisBiayaCMService {

	@Autowired
	private JenisBiayaCMRepository jenisBiayaCMRepository;
	
	@Autowired
	private GroupApprovalHdrRepository groupApprovalHdrRepository;

	private Paging paging = new Paging();
	
	@Autowired
	private MapperFacade mapperFacade;

	@Override
	public Map<String, Object> findAllJenisBiaya(String KategoriBiaya, String subKategori, String kodeJenisBiaya,
			String status, int page, int perPage) {
		// TODO Auto-generated method stub

//		if (KategoriBiaya.equals("") && subKategori.equals("") && kodeJenisBiaya.equals("") && status.equals(""))  {
//			KategoriBiaya = "";
//			subKategori = "";
//			kodeJenisBiaya = "";
//			status = "";
//		} else {
		KategoriBiaya = StringUtil.nevl(KategoriBiaya, "%%");
		subKategori = StringUtil.nevl(subKategori, "%%");
		kodeJenisBiaya = StringUtil.nevl(kodeJenisBiaya, "%%");
		status = StringUtil.nevl(status, "%%");
//		}

		String sql = " select a.kategori_biaya as kode_kategori_biaya, a.sub_kategori as kode_sub_kategori, "
				+ " a.id_jenis_biaya, a.jenis_biaya, b.kategori_biaya, c.sub_kategori, "
				+ " case when a.status = 1 then 'AKTIF' "
				+ " when a.status = 0 then 'TIDAK AKTIF' end status, a.created_by, a.created_dt "
				+ " from MMF_MASTER.MMF_MST_JENIS_BIAYA_CM a"
				+ " join MMF_MASTER.MMF_MST_KATEGORI_BIAYA b on a.kategori_biaya = b.id_kategori_biaya "
				+ " join MMF_MASTER.MMF_MST_SUB_KATEGORI c on a.sub_kategori = c.id_sub_kategori "
				+ " where a.kategori_biaya like '" + KategoriBiaya + "' " + " and a.sub_kategori like '" + subKategori
				+ "' " + " and upper (a.jenis_biaya) like upper ('" + kodeJenisBiaya + "') " + " and a.status like '"
				+ status + "' ";

		int a = 0;
		if (page == 1) {
			a = page - 1;
		} else {
//			a = ((page - 1) * perPage) + 1;
			a = page - 1;
		}

		Map<String, Object> mapList = getPaging(sql, paging.getPageable(a, perPage, "asc", "id_jenis_biaya"));

		@SuppressWarnings("unchecked")
		List<Object[]> objData = (List<Object[]>) mapList.get("contentData");
		List<JenisBiayaCMDTO> listDto = new ArrayList<>();

		for (Object[] o : objData) {
			JenisBiayaCMDTO dto = new JenisBiayaCMDTO();
			dto.setKodeKategoriBiaya((String) o[0]);
			dto.setKodeSubKategori((String) o[1]);
			dto.setKodeJenisBiaya((String) o[2]);
			dto.setJenisBiaya((String) o[3]);
			dto.setKategoriBiaya((String) o[4]);
			dto.setSubKategori((String) o[5]);
			dto.setStatus((String) o[6]);
			dto.setCreatedBy((String) o[7]);
			dto.setCreatedDt((Date) o[8]);

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
		map.put("totalSizeJenisBiaya", mapList.get("totalRecords"));
		map.put("listJenisBiaya", listDto);
		map.put("totalPageJenisBiaya", jumlahHalaman);

		return map;
	}

	@Override
	public void saveJenisBiaya(JenisBiayaCMDTO jenisBiayaCMDTO) {
		// TODO Auto-generated method stub

		if (jenisBiayaCMDTO.getKodeJenisBiaya() != null) {
			JenisBiayaCM dto = new JenisBiayaCM();

			dto.setKategoriBiaya(jenisBiayaCMDTO.getKodeKategoriBiaya());
			dto.setSubKategori(jenisBiayaCMDTO.getKodeSubKategori());
			dto.setKodeJenisBiaya(jenisBiayaCMDTO.getKodeJenisBiaya());
			dto.setJenisBiaya(jenisBiayaCMDTO.getJenisBiaya().toUpperCase());
			dto.setStatus(jenisBiayaCMDTO.getStatus());
			dto.setCreatedBy(jenisBiayaCMDTO.getCreatedBy().toUpperCase());
			dto.setCreatedDt(jenisBiayaCMDTO.getCreatedDt());
			dto.setModifiedBy(jenisBiayaCMDTO.getModifiedBy().toUpperCase());
			dto.setModifiedDt(new Date());

			jenisBiayaCMRepository.save(dto);
		} else {
			JenisBiayaCM dto = new JenisBiayaCM();
			String z = "";

			int y = 0;
			int x = 0;

			String kode = jenisBiayaCMRepository.getLastKodeJenisBiaya();

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

			dto.setKodeJenisBiaya(z + "");
			dto.setJenisBiaya(jenisBiayaCMDTO.getJenisBiaya().toUpperCase());
			dto.setKategoriBiaya(jenisBiayaCMDTO.getKategoriBiaya());
			dto.setSubKategori(jenisBiayaCMDTO.getSubKategori());
			dto.setStatus(jenisBiayaCMDTO.getStatus());
			dto.setCreatedBy(jenisBiayaCMDTO.getCreatedBy().toUpperCase());
			dto.setCreatedDt(new Date());

			jenisBiayaCMRepository.save(dto);
		}

	}

	@Override
	public void deleteJenisBiaya(String kodeJenisBiaya) {
		// TODO Auto-generated method stub
		
		List<GroupApprovalHdr> listObj = groupApprovalHdrRepository.listGroupApprovalHdrWithJenisBiaya
				(kodeJenisBiaya);


		for (GroupApprovalHdr o : listObj) {
			GroupApprovalHdrDto dto = mapperFacade.map(o, GroupApprovalHdrDto.class);
			groupApprovalHdrRepository.deleteDetailById(dto.getIdNo());
		}
		
		jenisBiayaCMRepository.deleteJenisBiaya(kodeJenisBiaya);
		groupApprovalHdrRepository.deleteHeaderByJenisBiaya(kodeJenisBiaya);
	}

	@Override
	public List<JenisBiayaCMDTO> cekJenisBiaya(String jenisBiaya) {
		// TODO Auto-generated method stub
		List<JenisBiayaCM> listObj = jenisBiayaCMRepository.cekJenisBiaya(jenisBiaya);
		List<JenisBiayaCMDTO> listDto = new ArrayList<>();

		for (JenisBiayaCM o : listObj) {
			JenisBiayaCMDTO dto = new JenisBiayaCMDTO();
			dto.setKodeJenisBiaya(o.getKodeJenisBiaya());
			dto.setJenisBiaya(o.getJenisBiaya());
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public JenisBiayaCMDTO cekJenisBiayaDanStatus(String jenisBiaya) {
		// TODO Auto-generated method stub
		JenisBiayaCM listObj = jenisBiayaCMRepository.cekJenisBiayaDanStatus(jenisBiaya);

		JenisBiayaCMDTO dto = new JenisBiayaCMDTO();
		
		if (listObj != null) {
			dto.setKodeJenisBiaya(listObj.getKodeJenisBiaya());
			dto.setJenisBiaya(listObj.getJenisBiaya());
			dto.setStatus(listObj.getStatus());
		}
		
		
		return dto;
	}

}
