package com.mantabs.collection.master.area_assignment.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.event.EventListener;

import org.zkoss.bind.annotation.ContextParam;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;
import org.zkoss.zul.Window;

import com.mandala.mfincore.common.Constant;
import com.mandala.mfincore.common.UIConstants;
import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;
import com.mantabs.collection.master.area_assignment.service.JenisBiayaCMService;
import com.mantabs.collection.master.area_assignment.service.KategoriBiayaService;
import com.mantabs.collection.master.area_assignment.service.SubKategoriService;
import com.mantabs.entity.master.CMSUser;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MasterDataVM extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@WireVariable
	private KategoriBiayaService kategoriBiayaService;

	@WireVariable
	private SubKategoriService subKategoriService;

	@WireVariable
	private JenisBiayaCMService jenisBiayaCMService;

	private final HashMap<String, Object> map = new LinkedHashMap<String, Object>();
	int activePage = 0;
	int pageSize = 15;

	int activePageSubKategori = 0;

	private int totalSize = 0;
	public int totalPage = 0;
	public int pageNumber = 1;
	private boolean flagMaxPage = false;
	private boolean flagMinPage = true;

	private int pageSizeSubKategori = 15;
	private int totalSizeSubKategori = 0;
	public int totalPageSubKategori = 0;
	public int pageNumberSubKategori = 1;
	public boolean flagMaxPageSubKategori = false;
	public boolean flagMinPageSubKategori = true;
	public boolean flagMaxPageJenisBiaya = false;
	public boolean flagMinPageJenisBiaya = true;

	private int pageSizeJenisBiaya = 15;
	private int totalSizeJenisBiaya = 0;
	public int totalPageJenisBiaya = 0;
	public int pageNumberJenisBiaya = 1;

	private List<GlobalParamDTO> listStatusKategoriBiaya = new ArrayList<GlobalParamDTO>();
	private GlobalParamDTO selectedStatusKategoriBiaya = new GlobalParamDTO();
	private List<GlobalParamDTO> listStatusSK = new ArrayList<GlobalParamDTO>();
	private GlobalParamDTO selectedStatusSK = new GlobalParamDTO();
	private List<GlobalParamDTO> listStatusJB = new ArrayList<GlobalParamDTO>();
	private GlobalParamDTO selectedStatusJB = new GlobalParamDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiaya = new ArrayList<KategoriBiayaDTO>();
	private KategoriBiayaDTO selectedComboKategoriBiaya = new KategoriBiayaDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiayaJB = new ArrayList<KategoriBiayaDTO>();
	private KategoriBiayaDTO selectedComboKategoriBiayaJB = new KategoriBiayaDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiayaSK = new ArrayList<KategoriBiayaDTO>();
	private KategoriBiayaDTO selectedComboKategoriBiayaSK = new KategoriBiayaDTO();
	private List<SubKategoriDTO> listSubKategori = new ArrayList<SubKategoriDTO>();
	private SubKategoriDTO dtoSK = new SubKategoriDTO();
	private List<SubKategoriDTO> listComboSubKategori = new ArrayList<SubKategoriDTO>();
	private SubKategoriDTO selectedComboSubKategori = new SubKategoriDTO();
	private List<SubKategoriDTO> listComboSubKategoriJB = new ArrayList<SubKategoriDTO>();
	private SubKategoriDTO selectedComboSubKategoriJB = new SubKategoriDTO();
	private KategoriBiayaDTO selectedComboKategoriBiayaSKDetail = new KategoriBiayaDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiayaSKDetail = new ArrayList<KategoriBiayaDTO>();
	private KategoriBiayaDTO selectedComboKategoriBiayaJBDetail = new KategoriBiayaDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiayaJBDetail = new ArrayList<KategoriBiayaDTO>();
	private List<SubKategoriDTO> listComboSubKategoriJBDetail = new ArrayList<SubKategoriDTO>();
	private SubKategoriDTO selectedComboSubKategoriJBDetail = new SubKategoriDTO();
	private List<JenisBiayaCMDTO> listJenisBiaya = new ArrayList<JenisBiayaCMDTO>();
	private JenisBiayaCMDTO dtoJB = new JenisBiayaCMDTO();
	private String kategoriBiayaSKDetail;
	private String kategoriBiayaJBDetail;
	private String SubKategoriJBDetail;
	CMSUserDto user = new CMSUserDto();

	Constant c = new Constant();
	private boolean tab1Detail = false;
	private boolean tab2Detail = false;
	private boolean tab3Detail = false;
	private boolean KBAktif = false;
	private boolean KBNonAktif = false;
	private boolean KBAktifSK = false;
	private boolean KBNonAktifSK = false;
	private boolean KBAktifJB = false;
	private boolean KBNonAktifJB = false;
	private boolean kategoriBiayaWindow = true;
	private boolean subKategoriWindow = true;
	private boolean jenisBiayaWindow = true;
	private String tipeProses = "";
	private String judulDetailKatagoriBiaya = "";
	private String judulDetailSubKategori = "";
	private String judulDetailJenisBiaya = "";
	private String tipeProsesSK = "";
	private String tipeProsesJB = "";
	private String status = "";
	private String statusSK = "";
	private String kodeKategoriBiaya = "";
	private String kodeSubKategori = "";
	private String kodeKategoriBiayaSK = "";
	private String kodeSubKategoriJB = "";
	private String kodeKategoriBiayaJB = "";
	private String statusJB = "";
	private String jenisBiaya = "";
	private String kategoriBiaya = "";
	private String subKategori = "";
	private String statusComboKategori;
	private String statusComboJenisBiaya;
	private String statusComboSubKategori;
	private boolean flagMsgFree = false;
	private boolean flagMsgDelete = false;
	private boolean flagMsgSuccessDelete = false;
	private boolean flagMsgDataSudahAda = false;
	private boolean flagMsgWarningDeleteStatusAktif = false;
	private boolean flagMsgWarningUpdateStatusAktif = false;
	private List<KategoriBiayaDTO> listKategoriBiaya = new ArrayList<KategoriBiayaDTO>();
	private KategoriBiayaDTO dto = new KategoriBiayaDTO();
	private String paramDelete = "";
	private boolean tabKategoriBiaya = true;
	private boolean tabSubkategori = false;
	private boolean tabJenisBiaya = false;
	private boolean flagEditKategoriBiayaSK = false;
	private boolean flagEditKategoriBiayaJB = false;
	private boolean flagEditSubKategoriJB = false;
	private boolean flagMsgSave = false;
	private boolean flagMsgInvNumber = false;
	private String paramSave = "";

	@Init
	@NotifyChange({ "listKategoriBiaya", "listSubKategori", "listComboKategoriBiayaSKDetail",
			"listComboKategoriBiayaJBDetail", "listComboSubKategoriJBDetail", "listComboKategoriBiayaSK" })
	public void MainVM() {
		loadKategoriBiaya(kodeKategoriBiaya, status, getPageNumber(), getPageSize());
		loadSubKategori(kodeKategoriBiayaSK, kodeSubKategori, statusSK, getPageNumberSubKategori(),
				getPageSizeSubKategori());
		loadJenisBiaya(kodeKategoriBiayaJB, kodeSubKategoriJB, jenisBiaya, status, getPageNumberJenisBiaya(),
				getPageSizeJenisBiaya());
		getloadComboboxStatus();
		getloadComboboxKategoriBiaya();
		getloadComboboxKategoriBiayaJB();
		getloadComboboxStatusJB();
		getloadComboboxStatusSK();
		getloadComboboxKategoriBiayaSK();
		if (selectedComboKategoriBiayaJB != null) {
			getloadComboSubKategori(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
		}
		if (selectedComboKategoriBiayaJB != null) {
			getloadComboSubKategoriJB(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
		}

		if (selectedComboKategoriBiayaJBDetail != null) {
			getloadComboboxSubKategoriJBDetail(selectedComboKategoriBiayaJBDetail.getKodeKategoriBiaya());
		}

		getloadComboboxKategoriBiayaSKDetail();
		getloadComboboxKategoriBiayaJBDetail();

	}

	@Command("refresGridKategoriBiaya")
	@NotifyChange({ "tabKategoriBiaya", "tabSubkategori", "tabJenisBiaya", "selectedStatusKategoriBiaya",
			"kategoriBiaya", "listKategoriBiaya" })
	public void refresGridKategoriBiaya() {
		kategoriBiaya = "";
		selectedStatusKategoriBiaya = null;
		loadKategoriBiaya(kodeKategoriBiaya, status, getPageNumber(), getPageSize());
//		Executions.sendRedirect("");

	}

	@Command("refresGridSubKategori")
	@NotifyChange({ "selectedComboKategoriBiayaSK", "subKategori", "selectedStatusSK", "listSubKategori" })
	public void refresGridSubKategori() {
		selectedComboKategoriBiayaSK = null;
		subKategori = "";
		selectedStatusSK = null;
		loadSubKategori(kodeKategoriBiayaSK, kodeSubKategori, statusSK, getPageNumberSubKategori(),
				getPageSizeSubKategori());
		loadJenisBiaya(kodeKategoriBiayaJB, kodeSubKategoriJB, jenisBiaya, status, getPageNumberJenisBiaya(),
				getPageSizeJenisBiaya());
	}

	@Command("cekSubKategori")
	@NotifyChange({ "listComboKategoriBiayaSK" })
	public void cekSubKategori() {
		List<KategoriBiayaDTO> list = kategoriBiayaService.comboKategoriBiaya();
		listComboKategoriBiayaSK = list;
	}

	@Command("refresGridJenisBiaya")
	@NotifyChange({ "selectedComboKategoriBiayaJB", "jenisBiaya", "selectedComboSubKategoriJB", "selectedStatusJB",
			"listJenisBiaya" })
	public void refresGridJenisBiaya() {
		selectedComboKategoriBiayaJB = null;
		jenisBiaya = "";
		selectedComboSubKategoriJB = null;
		selectedStatusJB = null;
		loadJenisBiaya(kodeKategoriBiayaJB, kodeSubKategoriJB, jenisBiaya, status, getPageNumberJenisBiaya(),
				getPageSizeJenisBiaya());
	}

	@Command("filter")
	@NotifyChange({ "listKategoriBiaya", "listComboKategoriBiayaSK" })
	public void filter() {
		setKodeKategoriBiaya(getKategoriBiaya());

		if (selectedStatusKategoriBiaya != null) {
			setStatus(selectedStatusKategoriBiaya.getIdParam());
		} else {
			setStatus("");
		}
		loadKategoriBiaya(kodeKategoriBiaya, status, getPageNumber(), getPageSize());

		getloadComboboxKategoriBiayaSK();

		MainVM();

//		refreshKategoriBiaya();

	}

	@Command("filterSK")
	@NotifyChange({ "listSubKategori", "flagMaxPageSubKategori", "flagMinPageSubKategori" })
	public void filterSK() {
		if (selectedComboKategoriBiayaSK != null) {
			setKodeKategoriBiayaSK(selectedComboKategoriBiayaSK.getKodeKategoriBiaya());
		} else {
			setKodeKategoriBiayaSK("");
		}

		if (selectedStatusSK != null) {
			setStatusSK(selectedStatusSK.getIdParam());
		} else {
			setStatusSK("");
		}

		setKodeSubKategori(getSubKategori());
		loadSubKategori(kodeKategoriBiayaSK, kodeSubKategori, statusSK, getPageNumberSubKategori(),
				getPageSizeSubKategori());

//		refreshSubKategori();
	}

	@Command("filterJB")
	@NotifyChange({ "listJenisBiaya", "flagMaxPageJenisBiaya", "flagMinPageJenisBiaya" })
	public void filterJB() {
		if (selectedComboKategoriBiayaJB != null) {
			setKodeKategoriBiayaJB(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
		} else {
			setKodeKategoriBiayaJB("");
		}
		if (selectedStatusJB != null) {
			setStatusJB(selectedStatusJB.getIdParam());
		} else {
			setStatusJB("");
		}
		if (selectedComboSubKategoriJB != null) {
			setKodeSubKategoriJB(selectedComboSubKategoriJB.getKodeSubKategori());
		} else {
			setKodeSubKategoriJB("");
		}

		loadJenisBiaya(kodeKategoriBiayaJB, kodeSubKategoriJB, jenisBiaya, status, getPageNumberJenisBiaya(),
				getPageSizeJenisBiaya());

//		refreshJenisBiaya();
	}

	@NotifyChange({ "listKategoriBiaya", "totalSize", "totalPage", "pageNumber", "flagMaxPage" })
	public void loadKategoriBiaya(String kategoriBiaya, String status, int pageNumber, int pageSize) {
		listKategoriBiaya.clear();
		Map<String, Object> map2 = new HashMap<>();

		map2 = kategoriBiayaService.findAllKategoriBiaya(kodeKategoriBiaya, status, getPageNumber(), getPageSize());
		totalSize = ((int) map2.get("totalSize"));
		totalPage = ((int) map2.get("totalPage"));

		if (totalPage == pageNumber) {
			flagMaxPage = true;
		} else {
			flagMaxPage = false;
		}

		cekFlagDisabledPageMax();
		cekFlagDisabledPageMin();

		listKategoriBiaya = (List<KategoriBiayaDTO>) map2.get("list");

	}

	@NotifyChange({ "listSubKategori", "totalSizeSubKategori", "totalPageSubKategori", "flagMaxPageSubKategori",
			"flagMaxPageSubKategori", "flagMinPageSubKategori" })
	public void loadSubKategori(String koddeKategoriBiaya, String kodeSubKategori, String status,
			int pageNumberSubKategori, int pageSizeSubKategori) {
		listSubKategori.clear();
		Map<String, Object> map = new HashMap<>();

		map = subKategoriService.findAllSubKategori(kodeKategoriBiayaSK, kodeSubKategori, status,
				getPageNumberSubKategori(), getPageSizeSubKategori());

		totalSizeSubKategori = ((int) map.get("totalSizeSubKategori"));
		totalPageSubKategori = ((int) map.get("totalPageSubKategori"));

		if (totalPageSubKategori == pageNumberSubKategori) {
			flagMaxPageSubKategori = true;
		} else {
			flagMaxPageSubKategori = false;
		}

		cekFlagDisabledPageMaxSubKategori();
		cekFlagDisabledPageMinSubKategori();

		listSubKategori = (List<SubKategoriDTO>) map.get("listSubKategori");

	}

	public void cekStatus() {
		if (KBAktif == true) {
			setStatus("1");
		} else {
			setStatus("0");
		}
	}

	public void cekStatusSK() {
		if (KBAktifSK == true) {
			setStatusSK("1");
		} else {
			setStatusSK("0");
		}
	}

	public void cekStatusJB() {
		if (KBAktifJB == true) {
			setStatusJB("1");
		} else {
			setStatusJB("0");
		}
	}

	@NotifyChange({ "listJenisBiaya", "totalSizeJenisBiaya", "totalPageSubKategori", "flagMaxPageSubKategori",
			"flagMaxPageJenisBiaya", "flagMinPageJenisBiaya" })
	public void loadJenisBiaya(String kodeKategoriBiaya, String kodeSubKategori, String kodeJenisBiaya, String status,
			int pageNumberJenisBiaya, int pageSizeJenisBiaya) {
		listJenisBiaya.clear();
		Map<String, Object> map = new HashMap<>();

		map = jenisBiayaCMService.findAllJenisBiaya(kodeKategoriBiayaJB, kodeSubKategoriJB, kodeJenisBiaya, statusJB,
				getPageNumberJenisBiaya(), getPageSizeJenisBiaya());

		totalSizeJenisBiaya = ((int) map.get("totalSizeJenisBiaya"));
		totalPageJenisBiaya = ((int) map.get("totalPageJenisBiaya"));

		if (totalPageJenisBiaya == pageNumberJenisBiaya) {
			flagMaxPageJenisBiaya = true;
		} else {
			flagMaxPageJenisBiaya = false;
		}

		cekFlagDisabledPageMaxJenisBiaya();
		cekFlagDisabledPageMinJenisBiaya();

		listJenisBiaya = (List<JenisBiayaCMDTO>) map.get("listJenisBiaya");

	}

	public List<GlobalParamDTO> getloadComboboxStatus() {
		List<GlobalParamDTO> list = kategoriBiayaService.comboStatus();
		listStatusKategoriBiaya = list;
		return listStatusKategoriBiaya;
	}

	public List<GlobalParamDTO> getloadComboboxStatusSK() {
		List<GlobalParamDTO> list = kategoriBiayaService.comboStatus();
		listStatusSK = list;
		return listStatusSK;
	}

	public List<GlobalParamDTO> getloadComboboxStatusJB() {
		List<GlobalParamDTO> list = kategoriBiayaService.comboStatus();
		listStatusJB = list;
		return listStatusJB;

	}

	public List<SubKategoriDTO> getloadComboSubKategori(String kode) {
		List<SubKategoriDTO> list = subKategoriService
				.comboSubKategori(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
		listComboSubKategori = list;
		return listComboSubKategori;
	}

	public List<SubKategoriDTO> getloadComboSubKategoriJB(String kode) {
		List<SubKategoriDTO> list = subKategoriService
				.comboSubKategori(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
		listComboSubKategoriJB = list;
		return listComboSubKategoriJB;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiaya() {
		List<KategoriBiayaDTO> list = kategoriBiayaService.comboKategoriBiaya();
		listComboKategoriBiaya = list;
		return listComboKategoriBiaya;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiayaJB() {
		List<KategoriBiayaDTO> list = kategoriBiayaService.comboKategoriBiaya();
		listComboKategoriBiayaJB = list;
		return listComboKategoriBiayaJB;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiayaSKDetail() {
		List<KategoriBiayaDTO> list = kategoriBiayaService.comboKategoriBiayaSKDetail();
		listComboKategoriBiayaSKDetail = list;
		return listComboKategoriBiayaSKDetail;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiayaJBDetail() {
		List<KategoriBiayaDTO> list = kategoriBiayaService.comboKategoriBiayaSKDetail();
		listComboKategoriBiayaJBDetail = list;
		return listComboKategoriBiayaJBDetail;
	}

	public List<SubKategoriDTO> getloadComboboxSubKategoriJBDetail(String kode) {
		List<SubKategoriDTO> list = subKategoriService
				.comboSubKategoriForDetail(selectedComboKategoriBiayaJBDetail.getKodeKategoriBiaya());
		listComboSubKategoriJBDetail = list;
		return listComboSubKategoriJBDetail;
	}

	@Command("ubahComboSubKategori")
	@NotifyChange({ "listComboSubKategoriJBDetail" })
	public void ubahComboSubKategori() {
		getloadComboboxSubKategoriJBDetail(selectedComboKategoriBiayaJBDetail.getKodeKategoriBiaya());
	}

	@Command("ubahComboSubKategoriFilter")
	@NotifyChange({ "listComboSubKategoriJB" })
	public void ubahComboSubKategoriFilter() {
		getloadComboSubKategoriJB(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiayaSK() {
		List<KategoriBiayaDTO> list = kategoriBiayaService.comboKategoriBiaya();
		listComboKategoriBiayaSK = list;
		return listComboKategoriBiayaSK;
	}

	@Command("addKategoriBiaya")
	@NotifyChange({ "tab1Detail", "dto", "status", "kategoriBiayaWindow", "KBAktif", "judulDetailKatagoriBiaya" })
	public void addKategoriBiaya() {
		setTipeProses("A");
		kategoriBiayaWindow = false;
		tab1Detail = true;
		KBAktif = true;
		setJudulDetailKatagoriBiaya("Kategori Biaya >> Tambah");
	}

	@Command("batalKategoriBiaya")
	@NotifyChange({ "tab1Detail", "kategoriBiayaWindow", "kategoriBiayaWindow" })
	public void batalKategoriBiaya() {
		tab1Detail = false;
		kategoriBiayaWindow = true;
		refreshKategoriBiaya();
	}

	@Command("saveKategoriBiaya")
	@NotifyChange({ "listKategoriBiaya", "flagMsgSave", "kategoriBiayaWindow", "paramSave" })
	public void saveKategoriBiaya() {
//		kategoriBiayaWindow = true;
		flagMsgSave = true;
		paramSave = "KB";
	}

	@Command("saveSubKategori")
	@NotifyChange({ "listSubKategori", "flagMsgSave", "kategoriBiayaWindow", "paramSave" })
	public void saveSubKategori() {
//		subKategoriWindow = true;
		flagMsgSave = true;
		paramSave = "SK";
	}

	@Command("saveJenisBiaya")
	@NotifyChange({ "listJenisBiaya", "flagMsgSave", "jenisBiayaWindow", "paramSave" })
	public void saveJenisBiaya() {
//		jenisBiayaWindow = true;
		flagMsgSave = true;
		paramSave = "JB";
	}

	@Command("forsaveKategoriBiaya")
	@NotifyChange({ "tab1Detail", "listKategoriBiaya", "dto", "kategoriBiayaWindow", "flagMsgFree",
			"flagMsgDataSudahAda" })
	public void forsaveKategoriBiaya() {
		List<KategoriBiayaDTO> datas = kategoriBiayaService.cekKategoriBiaya(dto.getKategoriBiaya());

		KategoriBiayaDTO dtoTemp = kategoriBiayaService.cekKategoriBiayaDanStatus(dto.getKodeKategoriBiaya());

		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");

		if (getTipeProses().equals("A")) {
			if (datas.size() < 1) {
				cekStatus();

				dto.setStatus(getStatus());
				dto.setCreatedBy(user.getId() + "");
				kategoriBiayaService.saveKategoriBiaya(dto);
				flagMsgFree = true;
				ref();
			} else {
				flagMsgDataSudahAda = true;
				ref();
			}
		} else {
			if (dtoTemp.getKategoriBiaya().equals(dto.getKategoriBiaya())) {
				if (!(dtoTemp.getStatus().equals(getStatus()))) {
					dto.setKategoriBiaya(dto.getKategoriBiaya());
					dto.setStatus(getStatus());
					dto.setModifiedBy(user.getId() + "");
					kategoriBiayaService.saveKategoriBiaya(dto);
					flagMsgFree = true;
					ref();

				} else {
					flagMsgDataSudahAda = true;
					ref();
				}

			} else if (datas.size() > 0) {
				flagMsgDataSudahAda = true;
				ref();
			} else {
				dto.setKategoriBiaya(dto.getKategoriBiaya());
				dto.setStatus(getStatus());
				dto.setModifiedBy(user.getId() + "");
				kategoriBiayaService.saveKategoriBiaya(dto);
				flagMsgFree = true;
				ref();
			}

		}

		tab1Detail = false;
		kategoriBiayaWindow = true;
	}

	@Command("forsaveSubKategori")
	@NotifyChange({ "tab2Detail", "listSubKategori", "dtoSK", "subKategoriWindow", "flagMsgFree",
			"flagMsgDataSudahAda" })
	public void forsaveSubKategori() {

		List<SubKategoriDTO> datasSK = subKategoriService.cekSubKategori(dtoSK.getSubKategori());

		SubKategoriDTO dtoTemp = subKategoriService.cekSubKategoriDanStatus(dtoSK.getKodeSubKategori());

		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");

		if (getTipeProsesSK().equals("A")) {
			if (datasSK.size() < 1) {

				cekStatusSK();

				dtoSK.setStatus(getStatusSK());
				dtoSK.setKategoriBiaya(selectedComboKategoriBiayaSKDetail.getKodeKategoriBiaya());
				dtoSK.setCreatedBy(user.getId() + "");
				subKategoriService.saveSubKategori(dtoSK);
				flagMsgFree = true;
				refSK();
			} else {
				flagMsgDataSudahAda = true;
				refSK();
			}

		} else {
			if (dtoTemp.getSubKategori().equals(dtoSK.getSubKategori())) {
				if (!(dtoTemp.getStatus().equals(getStatusSK()))) {
					dtoSK.setSubKategori(dtoSK.getSubKategori());
					dtoSK.setStatus(getStatusSK());
					dtoSK.setModifiedBy(user.getId() + "");
					subKategoriService.saveSubKategori(dtoSK);
					flagMsgFree = true;
					refSK();
				} else {
					flagMsgDataSudahAda = true;
					refSK();
				}
			} else if (datasSK.size() > 0) {
				flagMsgDataSudahAda = true;
				refSK();
			} else {
				dtoSK.setSubKategori(dtoSK.getSubKategori());
				dtoSK.setStatus(getStatusSK());
				dtoSK.setModifiedBy(user.getId() + "");
				subKategoriService.saveSubKategori(dtoSK);
				flagMsgFree = true;
				refSK();
			}

		}

		tab2Detail = false;
		subKategoriWindow = true;

	}

	@Command("forsaveJenisBiaya")
	@NotifyChange({ "tab3Detail", "dtoJB", "listJenisBiaya", "jenisBiayaWindow", "flagMsgFree", "flagMsgDataSudahAda" })
	public void forsaveJenisBiaya() {

		List<JenisBiayaCMDTO> datasJB = jenisBiayaCMService.cekJenisBiaya(dtoJB.getJenisBiaya());
		
		JenisBiayaCMDTO dtoTemp = jenisBiayaCMService.cekJenisBiayaDanStatus(dtoJB.getKodeJenisBiaya());

		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");

		if (getTipeProsesJB().equals("A")) {

			if (datasJB.size() < 1) {

				cekStatusJB();

				dtoJB.setStatus(getStatusJB());
				dtoJB.setKategoriBiaya(selectedComboKategoriBiayaJBDetail.getKodeKategoriBiaya());
				dtoJB.setSubKategori(selectedComboSubKategoriJBDetail.getKodeSubKategori());
				dtoJB.setCreatedBy(user.getId() + "");
				jenisBiayaCMService.saveJenisBiaya(dtoJB);
				flagMsgFree = true;
				refJB();

			} else {
				flagMsgDataSudahAda = true;
				refJB();
			}

		} else {
			if (dtoTemp.getJenisBiaya().equals(dtoJB.getJenisBiaya())) {
				if (!(dtoTemp.getStatus().equals(getStatusJB()))) {
					dtoJB.setSubKategori(dtoJB.getSubKategori());
					dtoJB.setStatus(getStatusJB());
					dtoJB.setModifiedBy(user.getId() + "");
					jenisBiayaCMService.saveJenisBiaya(dtoJB);
					flagMsgFree = true;
					refJB();
				} else {
					flagMsgDataSudahAda = true;
					refJB();
				}
			} else if (datasJB.size() > 0) {
				flagMsgDataSudahAda = true;
				refJB();
			} else {
				dtoJB.setSubKategori(dtoJB.getSubKategori());
				dtoJB.setStatus(getStatusJB());
				dtoJB.setModifiedBy(user.getId() + "");
				jenisBiayaCMService.saveJenisBiaya(dtoJB);
				flagMsgFree = true;
				refJB();
			}
			
		}

		tab3Detail = false;
		jenisBiayaWindow = true;
	}

	@Command
	@NotifyChange("listComboKategoriBiayaSK")
	public void OK() {

		if (isFlagMsgDelete() == true) {

			if (paramDelete.equals("KB")) {

				setFlagMsgDelete(false);
				forDeleteKategoriBiaya();

			} else if (paramDelete.equals("SK")) {
				setFlagMsgDelete(false);
				forDeleteSubKategori();
			} else if (paramDelete.equals("JB")) {
				setFlagMsgDelete(false);
				forDeleteJenisBiaya();
			}

		} else if (isFlagMsgSave() == true) {
			if (paramSave.equals("KB")) {
				setFlagMsgSave(false);
				forsaveKategoriBiaya();
			} else if (paramSave.equals("SK")) {
				setFlagMsgSave(false);
				forsaveSubKategori();
			} else if (paramSave.equals("JB")) {
				setFlagMsgSave(false);
				forsaveJenisBiaya();
			}
		} else {
			setFlagMsgInvNumber(false);
			setFlagMsgSuccessDelete(false);
			setFlagMsgFree(false);
			setFlagMsgDataSudahAda(false);
			setFlagMsgSave(false);
			setFlagMsgWarningDeleteStatusAktif(false);
			setFlagMsgWarningUpdateStatusAktif(false);
			refreshKategoriBiaya();
			refreshSubKategori();
			refreshJenisBiaya();
		}

//		listComboKategoriBiayaSK = getloadComboboxKategoriBiayaSK();

		BindUtils.postNotifyChange(null, null, this, "flagMsgInvNumber");
		BindUtils.postNotifyChange(null, null, this, "flagMsgWarningUpdateStatusAktif");
		BindUtils.postNotifyChange(null, null, this, "flagMsgWarningDeleteStatusAktif");
		BindUtils.postNotifyChange(null, null, this, "flagMsgDataSudahAda");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
		BindUtils.postNotifyChange(null, null, this, "flagMsgDelete");
		BindUtils.postNotifyChange(null, null, this, "flagMsgSave");
		BindUtils.postNotifyChange(null, null, this, "flagMsg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgSuccessDelete");

	}

	@Command
	public void BATAL() {

		setFlagMsgDelete(false);
		setFlagMsgSave(false);
		BindUtils.postNotifyChange(null, null, this, "flagMsgDelete");
		BindUtils.postNotifyChange(null, null, this, "flagMsgSave");

	}

	@GlobalCommand
	@NotifyChange({ "listJenisBiaya", "dtoJB", "tab3Detail", "jenisBiayaWindow" })
	public void refreshGridJB(@BindingParam("gridNameJB") String gridNameJB) {
		if (gridNameJB.equals("configGridJB")) {
			filterJB();
			refreshJenisBiaya();
			tab3Detail = false;
			jenisBiayaWindow = true;
		}
	}

	private void refJB() {
		Map<String, Object> mapJB = new HashMap<String, Object>();
		mapJB.put("gridNameJB", "configGridJB");
		BindUtils.postGlobalCommand(null, null, "refreshGridJB", mapJB);
	}

	@GlobalCommand
	@NotifyChange({ "listKategoriBiaya", "dto", "listComboKategoriBiayaSK", "listComboKategoriBiayaSKDetail",
			"listComboKategoriBiayaJB", "listComboKategoriBiayaJBDetail", "tab1Detail", "kategoriBiayaWindow",
			"listSubKategori","listJenisBiaya"})
	public void refreshGrid(@BindingParam("gridName") String gridName) {
		if (gridName.equals("configGrid")) {
			filter();
			refreshKategoriBiaya();
			refresGridSubKategori();
			refresGridJenisBiaya();
			getloadComboboxKategoriBiayaSK();
			getloadComboboxKategoriBiayaSKDetail();
			getloadComboboxKategoriBiayaJB();
			getloadComboboxKategoriBiayaJBDetail();
			tab1Detail = false;
			kategoriBiayaWindow = true;
		}
	}

	private void ref() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridName", "configGrid");
		BindUtils.postGlobalCommand(null, null, "refreshGrid", map);
	}

	@GlobalCommand
	@NotifyChange({ "listSubKategori", "dtoSK", "listComboSubKategoriJB", "listComboSubKategoriJBDetail", "tab2Detail",
			"subKategoriWindow","listJenisBiaya" })
	public void refreshGridSK(@BindingParam("gridNameSK") String gridNameSK) {
		if (gridNameSK.equals("configGridSK")) {
			filterSK();
			refreshSubKategori();
			refresGridJenisBiaya(); 
			if (selectedComboKategoriBiayaJB != null) {
				getloadComboSubKategoriJB(selectedComboKategoriBiayaJB.getKodeKategoriBiaya());
			}
			if (selectedComboKategoriBiayaJBDetail != null) {
				getloadComboboxSubKategoriJBDetail(selectedComboKategoriBiayaJBDetail.getKodeKategoriBiaya());
			}
			tab2Detail = false;
			subKategoriWindow = true;
		}
	}

	private void refSK() {
		Map<String, Object> mapSK = new HashMap<String, Object>();
		mapSK.put("gridNameSK", "configGridSK");
		BindUtils.postGlobalCommand(null, null, "refreshGridSK", mapSK);
	}

	@NotifyChange({ "dto", "status", "listComboKategoriBiaya", "listStatusKategoriBiaya", "KBNonAktif", "KBAktif",
			"selectedStatusKategoriBiaya", "statusComboKategori","listSubKategori","listJenisBiaya" })
	public void refreshKategoriBiaya() {
		KBAktif = false;
		KBNonAktif = false;
		setStatus("");
		selectedStatusKategoriBiaya = new GlobalParamDTO();
		statusComboKategori = "";
		dto = new KategoriBiayaDTO();
		getloadComboboxStatus();
		getloadComboboxKategoriBiaya();
		
		refresGridSubKategori();
		refresGridJenisBiaya();
		

		BindUtils.postNotifyChange(null, null, this, "selectedStatusKategoriBiaya");
	}

	@NotifyChange({ "dtoSK", "statusSK", "listComboKategoriBiayaSK", "listStatusSK", "KBNonAktifSK", "KBAktifSK",
			"kategoriBiayaSKDetail", "listComboKategoriBiayaSKDetail", "selectedComboKategoriBiayaSKDetail",
			"selectedStatusSK", "flagEditKategoriBiayaSK","listJenisBiaya" })
	public void refreshSubKategori() {
		listComboKategoriBiayaSKDetail.clear();
		selectedComboKategoriBiayaSKDetail = new KategoriBiayaDTO();
		selectedStatusSK = new GlobalParamDTO();
		setKategoriBiayaSKDetail("");
		KBAktifSK = false;
		KBNonAktifSK = false;
		setStatusSK("");
		flagEditKategoriBiayaSK = false;
		dtoSK = new SubKategoriDTO();
		getloadComboboxStatusSK();
		getloadComboboxKategoriBiayaSK();
		getloadComboboxKategoriBiayaSKDetail();
		refresGridJenisBiaya();
	}

	@NotifyChange({ "dtoJB", "statusJB", "listComboKategoriBiayaJB", "listStatusJB", "KBNonAktifJB", "KBAktifJB",
			"kategoriBiayaJBDetail", "listComboKategoriBiayaJBDetail", "selectedComboKategoriBiayaJBDetail",
			"listComboSubKategoriJBDetail", "selectedComboSubKategoriJBDetail", "subKategoriJBDetail",
			"selectedStatusJB", "flagEditKategoriBiayaJB", "flagEditSubKategoriJB" })
	public void refreshJenisBiaya() {
		listComboKategoriBiayaJBDetail.clear();
		selectedComboKategoriBiayaJBDetail = new KategoriBiayaDTO();
		listComboSubKategoriJBDetail.clear();
		selectedComboSubKategoriJBDetail = new SubKategoriDTO();
		selectedStatusJB = new GlobalParamDTO();
		setKategoriBiayaJBDetail("");
		setSubKategoriJBDetail("");
		flagEditKategoriBiayaJB = false;
		flagEditSubKategoriJB = false;
		KBAktifJB = false;
		KBNonAktifJB = false;
		setStatusJB("");
		dtoJB = new JenisBiayaCMDTO();
		getloadComboboxStatusJB();
		getloadComboboxKategoriBiayaJB();
		getloadComboboxKategoriBiayaJBDetail();
		getloadComboboxSubKategoriJBDetail(selectedComboKategoriBiayaJBDetail.getKodeKategoriBiaya());
	}

	@NotifyChange({ "flagMsgDelete", "kategoriBiayaWindow", "flagMsgSuccessDelete" })
	public void forDeleteKategoriBiaya() {

		try {
			kategoriBiayaService.deleteKategoriBiaya(dto.getKodeKategoriBiaya());
			flagMsgSuccessDelete = true;
			ref();

		} catch (Exception e) {
			Messagebox.show("Data Gagal Dihapus", "Error", Messagebox.OK, Messagebox.ERROR);
		}

	}

	@Command("deleteKategoriBiaya")
	@NotifyChange({ "listKategoriBiaya", "dto", "flagMsgDelete", "kategoriBiayaWindow",
			"flagMsgWarningDeleteStatusAktif" })
	public void deleteKategoriBiaya(@BindingParam("dto") KategoriBiayaDTO dtoKB) {
		if (dtoKB.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningDeleteStatusAktif = true;
			return;
		}

		kategoriBiayaWindow = true;
		flagMsgDelete = true;
		paramDelete = "KB";
		dto = dtoKB;
	}

	@NotifyChange({ "flagMsgDelete", "kategoriBiayaWindow", "flagMsgSuccessDelete" })
	public void forDeleteSubKategori() {

		try {
			subKategoriService.deleteSubKategori(dtoSK.getKodeSubKategori());
			flagMsgSuccessDelete = true;
			
			refSK();

		} catch (Exception e) {
			Messagebox.show("Data Gagal Dihapus", "Error", Messagebox.OK, Messagebox.ERROR);
		}

	}

	@Command("deleteSubKategori")
	@NotifyChange({ "listSubKategori", "dtoSKDel", "subKategoriWindow", "flagMsgDelete",
			"flagMsgWarningDeleteStatusAktif" })
	public void deleteSubKategori(@BindingParam("dtoSKDel") SubKategoriDTO dtoSKDel) {
		if (dtoSKDel.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningDeleteStatusAktif = true;
			return;
		}

		flagMsgDelete = true;
		paramDelete = "SK";
		dtoSK = dtoSKDel;
	}

	@NotifyChange({ "flagMsgDelete", "flagMsgSuccessDelete" })
	public void forDeleteJenisBiaya() {

		try {
			jenisBiayaCMService.deleteJenisBiaya(dtoJB.getKodeJenisBiaya());
			flagMsgSuccessDelete = true;
			refJB();

		} catch (Exception e) {
			Messagebox.show("Data Gagal Dihapus", "Error", Messagebox.OK, Messagebox.ERROR);
		}

	}

	@Command("deleteJenisBiaya")
	@NotifyChange({ "listJenisBiaya", "dtoJBDel", "flagMsgDelete", "flagMsgWarningDeleteStatusAktif" })
	public void deleteJenisBiaya(@BindingParam("dtoJBDel") JenisBiayaCMDTO dtoJBDel) {

		if (dtoJBDel.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningDeleteStatusAktif = true;
			return;
		}

		flagMsgDelete = true;
		paramDelete = "JB";
		dtoJB = dtoJBDel;

	}

	@Command("updateKategoriBiaya")
	@NotifyChange({ "dto", "tab1Detail", "KBAktif", "KBNonAktif", "kategoriBiayaWindow", "judulDetailKatagoriBiaya",
			"flagMsgWarningUpdateStatusAktif" })
	public void updateKategoriBiaya(@BindingParam("dtoEdit") KategoriBiayaDTO dto) {
		if (dto.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningUpdateStatusAktif = true;
			return;
		}

		if (dto.getStatus().equals("AKTIF")) {
			setStatus("1");
			KBAktif = true;
		} else {
			setStatus("0");
			KBNonAktif = true;
		}
		setTipeProses("E");
		setJudulDetailKatagoriBiaya("Kategori Biaya >> Ubah");
		setDto(dto);
		kategoriBiayaWindow = false;
		tab1Detail = true;
	}

	@Command("updateSubKategori")
	@NotifyChange({ "dtoSK", "tab2Detail", "KBAktifSK", "KBNonAktifSK", "kategoriBiayaSKDetail", "subKategoriWindow",
			"judulDetailSubKategori", "flagEditKategoriBiayaSK", "flagMsgWarningUpdateStatusAktif" })
	public void updateSubKategori(@BindingParam("dtoEdit") SubKategoriDTO dtoSK) {

		if (dtoSK.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningUpdateStatusAktif = true;
			return;
		}

		if (dtoSK.getStatus().equals("AKTIF")) {
			setStatusSK("1");
			KBAktifSK = true;
		} else {
			setStatusSK("0");
			KBNonAktifSK = true;
		}
		setKategoriBiayaSKDetail(dtoSK.getNamaKategoriBiaya());
		setTipeProsesSK("E");
		setDtoSK(dtoSK);
		tab2Detail = true;
		subKategoriWindow = false;
		setJudulDetailSubKategori("Sub Katagori >> Ubah");
		flagEditKategoriBiayaSK = true;
	}

	@Command("updateJenisBiaya")
	@NotifyChange({ "dtoJB", "tab3Detail", "KBAktifJB", "KBNonAktifJB", "kategoriBiayaJBDetail", "jenisBiayaWindow",
			"subKategoriJBDetail", "judulDetailJenisBiaya", "flagEditKategoriBiayaJB", "flagEditSubKategoriJB",
			"flagMsgWarningUpdateStatusAktif" })
	public void updateJenisBiaya(@BindingParam("dtoEdit") JenisBiayaCMDTO dtoJB) {

		if (dtoJB.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningUpdateStatusAktif = true;
			return;
		}

		if (dtoJB.getStatus().equals("AKTIF")) {
			setStatusJB("1");
			KBAktifJB = true;
		} else {
			setStatusJB("0");
			KBNonAktifJB = true;
		}
		setKategoriBiayaJBDetail(dtoJB.getKategoriBiaya());
		setSubKategoriJBDetail(dtoJB.getSubKategori());
		setJudulDetailJenisBiaya("Jenis Biaya >> Ubah");
		setTipeProsesJB("E");
		setDtoJB(dtoJB);
		flagEditKategoriBiayaJB = true;
		flagEditSubKategoriJB = true;
		tab3Detail = true;
		jenisBiayaWindow = false;
	}

	@Command("addSubKategoriBiaya")
	@NotifyChange({ "tab2Detail", "dtoSK", "statusSK", "kategoriBiayaSKDetail", "subKategoriWindow", "KBAktifSK",
			"judulDetailSubKategori" })
	public void addSubKategoriBiaya() {
		tab2Detail = true;
		subKategoriWindow = false;
		KBAktifSK = true;
		setTipeProsesSK("A");
		setJudulDetailSubKategori("Sub Kategori >> Tambah");
	}

	@Command("batalSubKategoriBiaya")
	@NotifyChange({ "tab2Detail", "subKategoriWindow", "flagEditKategoriBiayaSK" })
	public void batalSubKategoriBiaya() {
		tab2Detail = false;
		subKategoriWindow = true;
		refreshSubKategori();
	}

	@Command("addJenisBiaya")
	@NotifyChange({ "tab3Detail", "dtoJB", "statusJB", "kategoriBiayaJBDetail", "subKategoriJBDetail",
			"jenisBiayaWindow", "judulDetailJenisBiaya", "KBAktifJB" })
	public void addJenisBiaya() {
		tab3Detail = true;
		setTipeProsesJB("A");
		jenisBiayaWindow = false;
		KBAktifJB = true;
		setJudulDetailJenisBiaya("Jenis Biaya >> Tambah");

		BindUtils.postNotifyChange(null, null, this, "KBAktifJB");
	}

	// Method Untuk Paging Kategori Biaya

	public void cekFlagDisabledPageMin() {
		if (getPageNumber() == 1) {
			setFlagMinPage(true);
		} else {
			setFlagMinPage(false);
		}
		if (getPageNumber() == getTotalPage()) {
			setFlagMaxPage(true);
		} else {
			setFlagMaxPage(false);
		}
	}

	public void cekFlagDisabledPageMax() {
		if (getPageNumber() == getTotalPage()) {
			setFlagMaxPage(true);
		} else {
			setFlagMaxPage(false);
		}
		setFlagMinPage(false);
	}

	@Command
	@NotifyChange({ "pageNumber", "listKategoriBiaya", "flagMaxPage", "flagMinPage" })
	public void firstPage() {
		setPageNumber(1);
		cekFlagDisabledPageMin();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumber", "listKategoriBiaya", "flagMaxPage", "flagMinPage" })
	public void prevPage() {
		setPageNumber(getPageNumber() - 1);
		cekFlagDisabledPageMin();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumber", "listKategoriBiaya", "flagMaxPage", "flagMinPage", "totalPage", "flagMsgInvNumber" })
	public void searchPage() {
		if (getPageNumber() <= 0 || getPageNumber() > getTotalPage()) {
			setPageNumber(getTotalPage());
			cekFlagDisabledPageMax();
			cekFlagDisabledPageMin();
			flagMsgInvNumber = true;
			MainVM();
		} else {
			cekFlagDisabledPageMax();
			cekFlagDisabledPageMin();
			MainVM();
		}
		BindUtils.postNotifyChange(null, null, this, "flagMsgInvNumber");
	}

	@Command
	@NotifyChange({ "pageNumber", "listKategoriBiaya", "flagMaxPage", "flagMinPage" })
	public void nextPage() {
		setPageNumber(getPageNumber() + 1);
		cekFlagDisabledPageMax();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumber", "flagMaxPage", "listKategoriBiaya", "flagMinPage" })
	public void lastPage() {
		setPageNumber(getTotalPage());
		cekFlagDisabledPageMax();
		MainVM();
	}

	// ---> END Method Untuk Paging Kategori Biaya

	// Method Untuk Paging Sub Kategori

	public void cekFlagDisabledPageMinSubKategori() {
		if (getPageNumberSubKategori() == 1) {
			setFlagMinPageSubKategori(true);
		} else {
			setFlagMinPageSubKategori(false);
		}
		if (getPageNumberSubKategori() == getTotalPageSubKategori()) {
			setFlagMaxPageSubKategori(true);
		} else {
			setFlagMaxPageSubKategori(false);
		}
	}

	public void cekFlagDisabledPageMaxSubKategori() {
		if (getPageNumberSubKategori() == getTotalPageSubKategori()) {
			setFlagMaxPageSubKategori(true);
		} else {
			setFlagMaxPageSubKategori(false);
		}
		setFlagMinPageSubKategori(false);
	}

	@Command
	@NotifyChange({ "pageNumberSubKategori", "listSubKategori", "flagMaxPageSubKategori", "flagMinPageSubKategori" })
	public void firstPageSubKategori() {
		setPageNumberSubKategori(1);
		cekFlagDisabledPageMinSubKategori();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumberSubKategori", "listSubKategori", "flagMaxPageSubKategori", "flagMinPageSubKategori" })
	public void prevPageSubKategori() {
		setPageNumberSubKategori(getPageNumberSubKategori() - 1);
		cekFlagDisabledPageMinSubKategori();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumberSubKategori", "listKategoriBiayaSubKategori", "flagMaxPageSubKategori",
			"flagMinPageSubKategori", "totalPageSubKategori", "flagMsgInvNumberSubKategori" })
	public void searchPageSubKategori() {
		if (getPageNumberSubKategori() <= 0 || getPageNumberSubKategori() > getTotalPageSubKategori()) {
			setPageNumberSubKategori(getTotalPageSubKategori());
			cekFlagDisabledPageMaxSubKategori();
			cekFlagDisabledPageMinSubKategori();
			flagMsgInvNumber = true;
			MainVM();
		} else {
			cekFlagDisabledPageMaxSubKategori();
			cekFlagDisabledPageMinSubKategori();
			MainVM();
		}
		BindUtils.postNotifyChange(null, null, this, "flagMsgInvNumber");
	}

	@Command
	@NotifyChange({ "pageNumberSubKategori", "listSubKategori", "flagMaxPageSubKategori", "flagMinPageSubKategori" })
	public void nextPageSubKategori() {
		setPageNumberSubKategori(getPageNumberSubKategori() + 1);
		cekFlagDisabledPageMaxSubKategori();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumberSubKategori", "flagMaxPageSubKategori", "listKategoriBiayaSubKategori",
			"flagMinPageSubKategori" })
	public void lastPageSubKategori() {
		setPageNumberSubKategori(getTotalPageSubKategori());
		cekFlagDisabledPageMaxSubKategori();
		MainVM();
	}

	// ---> END Method Untuk Paging Sub Kategori

	// Method Untuk Paging Jenis Biaya

	public void cekFlagDisabledPageMinJenisBiaya() {
		if (getPageNumberJenisBiaya() == 1) {
			setFlagMinPageJenisBiaya(true);
		} else {
			setFlagMinPageJenisBiaya(false);
		}
		if (getPageNumberJenisBiaya() == getTotalPageJenisBiaya()) {
			setFlagMaxPageJenisBiaya(true);
		} else {
			setFlagMaxPageJenisBiaya(false);
		}
	}

	public void cekFlagDisabledPageMaxJenisBiaya() {
		if (getPageNumberJenisBiaya() == getTotalPageJenisBiaya()) {
			setFlagMaxPageJenisBiaya(true);
		} else {
			setFlagMaxPageJenisBiaya(false);
		}
		setFlagMinPageJenisBiaya(false);
	}

	@Command
	@NotifyChange({ "pageNumberJenisBiaya", "listJenisBiaya", "flagMaxPageJenisBiaya", "flagMinPageJenisBiaya" })
	public void firstPageJenisBiaya() {
		setPageNumberJenisBiaya(1);
		cekFlagDisabledPageMinJenisBiaya();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumberJenisBiaya", "listJenisBiaya", "flagMaxPageJenisBiaya", "flagMinPageJenisBiaya" })
	public void prevPageJenisBiaya() {
		setPageNumberJenisBiaya(getPageNumberJenisBiaya() - 1);
		cekFlagDisabledPageMinJenisBiaya();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumberJenisBiaya", "listJenisBiaya", "flagMaxPageJenisBiaya", "flagMinPageJenisBiaya",
			"totalPageJenisBiaya", "flagMsgInvNumber" })
	public void searchPageJenisBiaya() {
		if (getPageNumberJenisBiaya() <= 0 || getPageNumberJenisBiaya() > getTotalPageJenisBiaya()) {
			setPageNumberJenisBiaya(getTotalPageJenisBiaya());
			cekFlagDisabledPageMaxJenisBiaya();
			cekFlagDisabledPageMinJenisBiaya();
			flagMsgInvNumber = true;
			MainVM();
		} else {
			cekFlagDisabledPageMaxJenisBiaya();
			cekFlagDisabledPageMinJenisBiaya();
			MainVM();
		}
		BindUtils.postNotifyChange(null, null, this, "flagMsgInvNumber");
	}

	@Command
	@NotifyChange({ "pageNumberJenisBiaya", "listJenisBiaya", "flagMaxPageJenisBiaya", "flagMinPageJenisBiaya" })
	public void nextPageJenisBiaya() {
		setPageNumberJenisBiaya(getPageNumberJenisBiaya() + 1);
		cekFlagDisabledPageMaxJenisBiaya();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumberJenisBiaya", "flagMaxPageJenisBiaya", "listJenisBiaya", "flagMinPageJenisBiaya" })
	public void lastPageJenisBiaya() {
		setPageNumberJenisBiaya(getTotalPageJenisBiaya());
		cekFlagDisabledPageMaxJenisBiaya();
		MainVM();
	}

	// ---> END Method Untuk Paging Kategori Biaya

	@Command("batalJenisBiaya")
	@NotifyChange({ "tab3Detail", "jenisBiayaWindow", "flagEditKategoriBiayaJB", "flagEditSubKategoriJB" })
	public void batalJenisBiaya() {
		tab3Detail = false;
		jenisBiayaWindow = true;
		refreshJenisBiaya();
	}

	public int getActivePage() {
		return activePage;
	}

	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isTab1Detail() {
		return tab1Detail;
	}

	public void setTab1Detail(boolean tab1Detail) {
		this.tab1Detail = tab1Detail;
	}

	public boolean isTab2Detail() {
		return tab2Detail;
	}

	public void setTab2Detail(boolean tab2Detail) {
		this.tab2Detail = tab2Detail;
	}

	public boolean isTab3Detail() {
		return tab3Detail;
	}

	public void setTab3Detail(boolean tab3Detail) {
		this.tab3Detail = tab3Detail;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKodeKategoriBiaya() {
		return kodeKategoriBiaya;
	}

	public void setKodeKategoriBiaya(String kodeKategoriBiaya) {
		this.kodeKategoriBiaya = kodeKategoriBiaya;
	}

	public List<KategoriBiayaDTO> getListKategoriBiaya() {
		return listKategoriBiaya;
	}

	public void setListKategoriBiaya(List<KategoriBiayaDTO> listKategoriBiaya) {
		this.listKategoriBiaya = listKategoriBiaya;
	}

	public List<GlobalParamDTO> getListStatusKategoriBiaya() {
		return listStatusKategoriBiaya;
	}

	public void setListStatusKategoriBiaya(List<GlobalParamDTO> listStatusKategoriBiaya) {
		this.listStatusKategoriBiaya = listStatusKategoriBiaya;
	}

	public GlobalParamDTO getSelectedStatusKategoriBiaya() {
		return selectedStatusKategoriBiaya;
	}

	public void setSelectedStatusKategoriBiaya(GlobalParamDTO selectedStatusKategoriBiaya) {
		this.selectedStatusKategoriBiaya = selectedStatusKategoriBiaya;
	}

	public KategoriBiayaDTO getDto() {
		return dto;
	}

	public void setDto(KategoriBiayaDTO dto) {
		this.dto = dto;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiaya() {
		return listComboKategoriBiaya;
	}

	public void setListComboKategoriBiaya(List<KategoriBiayaDTO> listComboKategoriBiaya) {
		this.listComboKategoriBiaya = listComboKategoriBiaya;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiaya() {
		return selectedComboKategoriBiaya;
	}

	public void setSelectedComboKategoriBiaya(KategoriBiayaDTO selectedComboKategoriBiaya) {
		this.selectedComboKategoriBiaya = selectedComboKategoriBiaya;
	}

	public boolean isKBAktif() {
		return KBAktif;
	}

	public void setKBAktif(boolean kBAktif) {
		KBAktif = kBAktif;
	}

	public boolean isKBNonAktif() {
		return KBNonAktif;
	}

	public void setKBNonAktif(boolean kBNonAktif) {
		KBNonAktif = kBNonAktif;
	}

	public String getTipeProses() {
		return tipeProses;
	}

	public void setTipeProses(String tipeProses) {
		this.tipeProses = tipeProses;
	}

	public List<SubKategoriDTO> getListSubKategori() {
		return listSubKategori;
	}

	public void setListSubKategori(List<SubKategoriDTO> listSubKategori) {
		this.listSubKategori = listSubKategori;
	}

	public SubKategoriDTO getDtoSK() {
		return dtoSK;
	}

	public void setDtoSK(SubKategoriDTO dtoSK) {
		this.dtoSK = dtoSK;
	}

	public int getActivePageSubKategori() {
		return activePageSubKategori;
	}

	public void setActivePageSubKategori(int activePageSubKategori) {
		this.activePageSubKategori = activePageSubKategori;
	}

	public int getPageSizeSubKategori() {
		return pageSizeSubKategori;
	}

	public void setPageSizeSubKategori(int pageSizeSubKategori) {
		this.pageSizeSubKategori = pageSizeSubKategori;
	}

	public int getTotalSizeSubKategori() {
		return totalSizeSubKategori;
	}

	public void setTotalSizeSubKategori(int totalSizeSubKategori) {
		this.totalSizeSubKategori = totalSizeSubKategori;
	}

	public int getTotalPageSubKategori() {
		return totalPageSubKategori;
	}

	public void setTotalPageSubKategori(int totalPageSubKategori) {
		this.totalPageSubKategori = totalPageSubKategori;
	}

	public int getPageNumberSubKategori() {
		return pageNumberSubKategori;
	}

	public void setPageNumberSubKategori(int pageNumberSubKategori) {
		this.pageNumberSubKategori = pageNumberSubKategori;
	}

	public String getStatusSK() {
		return statusSK;
	}

	public void setStatusSK(String statusSK) {
		this.statusSK = statusSK;
	}

	public String getKodeSubKategori() {
		return kodeSubKategori;
	}

	public void setKodeSubKategori(String kodeSubKategori) {
		this.kodeSubKategori = kodeSubKategori;
	}

	public String getKodeKategoriBiayaSK() {
		return kodeKategoriBiayaSK;
	}

	public void setKodeKategoriBiayaSK(String kodeKategoriBiayaSK) {
		this.kodeKategoriBiayaSK = kodeKategoriBiayaSK;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiayaSK() {
		return listComboKategoriBiayaSK;
	}

	public void setListComboKategoriBiayaSK(List<KategoriBiayaDTO> listComboKategoriBiayaSK) {
		this.listComboKategoriBiayaSK = listComboKategoriBiayaSK;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiayaSK() {
		return selectedComboKategoriBiayaSK;
	}

	public void setSelectedComboKategoriBiayaSK(KategoriBiayaDTO selectedComboKategoriBiayaSK) {
		this.selectedComboKategoriBiayaSK = selectedComboKategoriBiayaSK;
	}

	public List<GlobalParamDTO> getListStatusSK() {
		return listStatusSK;
	}

	public void setListStatusSK(List<GlobalParamDTO> listStatusSK) {
		this.listStatusSK = listStatusSK;
	}

	public GlobalParamDTO getSelectedStatusSK() {
		return selectedStatusSK;
	}

	public void setSelectedStatusSK(GlobalParamDTO selectedStatusSK) {
		this.selectedStatusSK = selectedStatusSK;
	}

	public List<SubKategoriDTO> getListComboSubKategori() {
		return listComboSubKategori;
	}

	public void setListComboSubKategori(List<SubKategoriDTO> listComboSubKategori) {
		this.listComboSubKategori = listComboSubKategori;
	}

	public SubKategoriDTO getSelectedComboSubKategori() {
		return selectedComboSubKategori;
	}

	public void setSelectedComboSubKategori(SubKategoriDTO selectedComboSubKategori) {
		this.selectedComboSubKategori = selectedComboSubKategori;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiayaSKDetail() {
		return selectedComboKategoriBiayaSKDetail;
	}

	public void setSelectedComboKategoriBiayaSKDetail(KategoriBiayaDTO selectedComboKategoriBiayaSKDetail) {
		this.selectedComboKategoriBiayaSKDetail = selectedComboKategoriBiayaSKDetail;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiayaSKDetail() {
		return listComboKategoriBiayaSKDetail;
	}

	public void setListComboKategoriBiayaSKDetail(List<KategoriBiayaDTO> listComboKategoriBiayaSKDetail) {
		this.listComboKategoriBiayaSKDetail = listComboKategoriBiayaSKDetail;
	}

	public String getKategoriBiayaSKDetail() {
		return kategoriBiayaSKDetail;
	}

	public void setKategoriBiayaSKDetail(String kategoriBiayaSKDetail) {
		this.kategoriBiayaSKDetail = kategoriBiayaSKDetail;
	}

	public String getTipeProsesSK() {
		return tipeProsesSK;
	}

	public void setTipeProsesSK(String tipeProsesSK) {
		this.tipeProsesSK = tipeProsesSK;
	}

	public boolean isKBAktifSK() {
		return KBAktifSK;
	}

	public void setKBAktifSK(boolean kBAktifSK) {
		KBAktifSK = kBAktifSK;
	}

	public boolean isKBNonAktifSK() {
		return KBNonAktifSK;
	}

	public void setKBNonAktifSK(boolean kBNonAktifSK) {
		KBNonAktifSK = kBNonAktifSK;
	}

	public boolean isFlagMaxPageSubKategori() {
		return flagMaxPageSubKategori;
	}

	public void setFlagMaxPageSubKategori(boolean flagMaxPageSubKategori) {
		this.flagMaxPageSubKategori = flagMaxPageSubKategori;
	}

	public boolean isFlagMinPageSubKategori() {
		return flagMinPageSubKategori;
	}

	public void setFlagMinPageSubKategori(boolean flagMinPageSubKategori) {
		this.flagMinPageSubKategori = flagMinPageSubKategori;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiayaJB() {
		return listComboKategoriBiayaJB;
	}

	public void setListComboKategoriBiayaJB(List<KategoriBiayaDTO> listComboKategoriBiayaJB) {
		this.listComboKategoriBiayaJB = listComboKategoriBiayaJB;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiayaJB() {
		return selectedComboKategoriBiayaJB;
	}

	public void setSelectedComboKategoriBiayaJB(KategoriBiayaDTO selectedComboKategoriBiayaJB) {
		this.selectedComboKategoriBiayaJB = selectedComboKategoriBiayaJB;
	}

	public List<SubKategoriDTO> getListComboSubKategoriJB() {
		return listComboSubKategoriJB;
	}

	public void setListComboSubKategoriJB(List<SubKategoriDTO> listComboSubKategoriJB) {
		this.listComboSubKategoriJB = listComboSubKategoriJB;
	}

	public SubKategoriDTO getSelectedComboSubKategoriJB() {
		return selectedComboSubKategoriJB;
	}

	public void setSelectedComboSubKategoriJB(SubKategoriDTO selectedComboSubKategoriJB) {
		this.selectedComboSubKategoriJB = selectedComboSubKategoriJB;
	}

	public SubKategoriService getSubKategoriService() {
		return subKategoriService;
	}

	public void setSubKategoriService(SubKategoriService subKategoriService) {
		this.subKategoriService = subKategoriService;
	}

	public List<GlobalParamDTO> getListStatusJB() {
		return listStatusJB;
	}

	public void setListStatusJB(List<GlobalParamDTO> listStatusJB) {
		this.listStatusJB = listStatusJB;
	}

	public GlobalParamDTO getSelectedStatusJB() {
		return selectedStatusJB;
	}

	public void setSelectedStatusJB(GlobalParamDTO selectedStatusJB) {
		this.selectedStatusJB = selectedStatusJB;
	}

	public boolean isKBAktifJB() {
		return KBAktifJB;
	}

	public void setKBAktifJB(boolean kBAktifJB) {
		KBAktifJB = kBAktifJB;
	}

	public boolean isKBNonAktifJB() {
		return KBNonAktifJB;
	}

	public void setKBNonAktifJB(boolean kBNonAktifJB) {
		KBNonAktifJB = kBNonAktifJB;
	}

	public String getTipeProsesJB() {
		return tipeProsesJB;
	}

	public void setTipeProsesJB(String tipeProsesJB) {
		this.tipeProsesJB = tipeProsesJB;
	}

	public String getStatusJB() {
		return statusJB;
	}

	public void setStatusJB(String statusJB) {
		this.statusJB = statusJB;
	}

	public String getJenisBiaya() {
		return jenisBiaya;
	}

	public void setJenisBiaya(String jenisBiaya) {
		this.jenisBiaya = jenisBiaya;
	}

	public List<JenisBiayaCMDTO> getListJenisBiaya() {
		return listJenisBiaya;
	}

	public void setListJenisBiaya(List<JenisBiayaCMDTO> listJenisBiaya) {
		this.listJenisBiaya = listJenisBiaya;
	}

	public JenisBiayaCMDTO getDtoJB() {
		return dtoJB;
	}

	public void setDtoJB(JenisBiayaCMDTO dtoJB) {
		this.dtoJB = dtoJB;
	}

	public int getPageSizeJenisBiaya() {
		return pageSizeJenisBiaya;
	}

	public void setPageSizeJenisBiaya(int pageSizeJenisBiaya) {
		this.pageSizeJenisBiaya = pageSizeJenisBiaya;
	}

	public int getTotalSizeJenisBiaya() {
		return totalSizeJenisBiaya;
	}

	public void setTotalSizeJenisBiaya(int totalSizeJenisBiaya) {
		this.totalSizeJenisBiaya = totalSizeJenisBiaya;
	}

	public int getTotalPageJenisBiaya() {
		return totalPageJenisBiaya;
	}

	public void setTotalPageJenisBiaya(int totalPageJenisBiaya) {
		this.totalPageJenisBiaya = totalPageJenisBiaya;
	}

	public int getPageNumberJenisBiaya() {
		return pageNumberJenisBiaya;
	}

	public void setPageNumberJenisBiaya(int pageNumberJenisBiaya) {
		this.pageNumberJenisBiaya = pageNumberJenisBiaya;
	}

	public String getKodeSubKategoriJB() {
		return kodeSubKategoriJB;
	}

	public void setKodeSubKategoriJB(String kodeSubKategoriJB) {
		this.kodeSubKategoriJB = kodeSubKategoriJB;
	}

	public String getKodeKategoriBiayaJB() {
		return kodeKategoriBiayaJB;
	}

	public void setKodeKategoriBiayaJB(String kodeKategoriBiayaJB) {
		this.kodeKategoriBiayaJB = kodeKategoriBiayaJB;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiayaJBDetail() {
		return selectedComboKategoriBiayaJBDetail;
	}

	public void setSelectedComboKategoriBiayaJBDetail(KategoriBiayaDTO selectedComboKategoriBiayaJBDetail) {
		this.selectedComboKategoriBiayaJBDetail = selectedComboKategoriBiayaJBDetail;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiayaJBDetail() {
		return listComboKategoriBiayaJBDetail;
	}

	public void setListComboKategoriBiayaJBDetail(List<KategoriBiayaDTO> listComboKategoriBiayaJBDetail) {
		this.listComboKategoriBiayaJBDetail = listComboKategoriBiayaJBDetail;
	}

	public List<SubKategoriDTO> getListComboSubKategoriJBDetail() {
		return listComboSubKategoriJBDetail;
	}

	public void setListComboSubKategoriJBDetail(List<SubKategoriDTO> listComboSubKategoriJBDetail) {
		this.listComboSubKategoriJBDetail = listComboSubKategoriJBDetail;
	}

	public SubKategoriDTO getSelectedComboSubKategoriJBDetail() {
		return selectedComboSubKategoriJBDetail;
	}

	public void setSelectedComboSubKategoriJBDetail(SubKategoriDTO selectedComboSubKategoriJBDetail) {
		this.selectedComboSubKategoriJBDetail = selectedComboSubKategoriJBDetail;
	}

	public String getKategoriBiayaJBDetail() {
		return kategoriBiayaJBDetail;
	}

	public void setKategoriBiayaJBDetail(String kategoriBiayaJBDetail) {
		this.kategoriBiayaJBDetail = kategoriBiayaJBDetail;
	}

	public String getSubKategoriJBDetail() {
		return SubKategoriJBDetail;
	}

	public void setSubKategoriJBDetail(String subKategoriJBDetail) {
		SubKategoriJBDetail = subKategoriJBDetail;
	}

	public String getKategoriBiaya() {
		return kategoriBiaya;
	}

	public void setKategoriBiaya(String kategoriBiaya) {
		this.kategoriBiaya = kategoriBiaya;
	}

	public String getSubKategori() {
		return subKategori;
	}

	public void setSubKategori(String subKategori) {
		this.subKategori = subKategori;
	}

	public boolean isKategoriBiayaWindow() {
		return kategoriBiayaWindow;
	}

	public void setKategoriBiayaWindow(boolean kategoriBiayaWindow) {
		this.kategoriBiayaWindow = kategoriBiayaWindow;
	}

	public boolean isSubKategoriWindow() {
		return subKategoriWindow;
	}

	public void setSubKategoriWindow(boolean subKategoriWindow) {
		this.subKategoriWindow = subKategoriWindow;
	}

	public boolean isJenisBiayaWindow() {
		return jenisBiayaWindow;
	}

	public void setJenisBiayaWindow(boolean jenisBiayaWindow) {
		this.jenisBiayaWindow = jenisBiayaWindow;
	}

	public boolean isFlagMsgFree() {
		return flagMsgFree;
	}

	public void setFlagMsgFree(boolean flagMsgFree) {
		this.flagMsgFree = flagMsgFree;
	}

	public boolean isFlagMsgDelete() {
		return flagMsgDelete;
	}

	public void setFlagMsgDelete(boolean flagMsgDelete) {
		this.flagMsgDelete = flagMsgDelete;
	}

	public boolean isFlagMsgSuccessDelete() {
		return flagMsgSuccessDelete;
	}

	public void setFlagMsgSuccessDelete(boolean flagMsgSuccessDelete) {
		this.flagMsgSuccessDelete = flagMsgSuccessDelete;
	}

	public String getParamDelete() {
		return paramDelete;
	}

	public void setParamDelete(String paramDelete) {
		this.paramDelete = paramDelete;
	}

	public String getStatusComboKategori() {
		return statusComboKategori;
	}

	public void setStatusComboKategori(String statusComboKategori) {
		this.statusComboKategori = statusComboKategori;
	}

	public String getStatusComboJenisBiaya() {
		return statusComboJenisBiaya;
	}

	public void setStatusComboJenisBiaya(String statusComboJenisBiaya) {
		this.statusComboJenisBiaya = statusComboJenisBiaya;
	}

	public String getStatusComboSubKategori() {
		return statusComboSubKategori;
	}

	public void setStatusComboSubKategori(String statusComboSubKategori) {
		this.statusComboSubKategori = statusComboSubKategori;
	}

	public boolean isFlagMsgDataSudahAda() {
		return flagMsgDataSudahAda;
	}

	public void setFlagMsgDataSudahAda(boolean flagMsgDataSudahAda) {
		this.flagMsgDataSudahAda = flagMsgDataSudahAda;
	}

	public boolean isFlagMsgWarningDeleteStatusAktif() {
		return flagMsgWarningDeleteStatusAktif;
	}

	public void setFlagMsgWarningDeleteStatusAktif(boolean flagMsgWarningDeleteStatusAktif) {
		this.flagMsgWarningDeleteStatusAktif = flagMsgWarningDeleteStatusAktif;
	}

	public String getJudulDetailKatagoriBiaya() {
		return judulDetailKatagoriBiaya;
	}

	public void setJudulDetailKatagoriBiaya(String judulDetailKatagoriBiaya) {
		this.judulDetailKatagoriBiaya = judulDetailKatagoriBiaya;
	}

	public String getJudulDetailSubKategori() {
		return judulDetailSubKategori;
	}

	public void setJudulDetailSubKategori(String judulDetailSubKategori) {
		this.judulDetailSubKategori = judulDetailSubKategori;
	}

	public String getJudulDetailJenisBiaya() {
		return judulDetailJenisBiaya;
	}

	public void setJudulDetailJenisBiaya(String judulDetailJenisBiaya) {
		this.judulDetailJenisBiaya = judulDetailJenisBiaya;
	}

	public boolean isTabKategoriBiaya() {
		return tabKategoriBiaya;
	}

	public void setTabKategoriBiaya(boolean tabKategoriBiaya) {
		this.tabKategoriBiaya = tabKategoriBiaya;
	}

	public boolean isTabSubkategori() {
		return tabSubkategori;
	}

	public void setTabSubkategori(boolean tabSubkategori) {
		this.tabSubkategori = tabSubkategori;
	}

	public boolean isTabJenisBiaya() {
		return tabJenisBiaya;
	}

	public void setTabJenisBiaya(boolean tabJenisBiaya) {
		this.tabJenisBiaya = tabJenisBiaya;
	}

	public boolean isFlagEditKategoriBiayaSK() {
		return flagEditKategoriBiayaSK;
	}

	public void setFlagEditKategoriBiayaSK(boolean flagEditKategoriBiayaSK) {
		this.flagEditKategoriBiayaSK = flagEditKategoriBiayaSK;
	}

	public boolean isFlagEditKategoriBiayaJB() {
		return flagEditKategoriBiayaJB;
	}

	public void setFlagEditKategoriBiayaJB(boolean flagEditKategoriBiayaJB) {
		this.flagEditKategoriBiayaJB = flagEditKategoriBiayaJB;
	}

	public boolean isFlagEditSubKategoriJB() {
		return flagEditSubKategoriJB;
	}

	public void setFlagEditSubKategoriJB(boolean flagEditSubKategoriJB) {
		this.flagEditSubKategoriJB = flagEditSubKategoriJB;
	}

	public boolean isFlagMsgWarningUpdateStatusAktif() {
		return flagMsgWarningUpdateStatusAktif;
	}

	public void setFlagMsgWarningUpdateStatusAktif(boolean flagMsgWarningUpdateStatusAktif) {
		this.flagMsgWarningUpdateStatusAktif = flagMsgWarningUpdateStatusAktif;
	}

	public boolean isFlagMsgSave() {
		return flagMsgSave;
	}

	public void setFlagMsgSave(boolean flagMsgSave) {
		this.flagMsgSave = flagMsgSave;
	}

	public boolean isFlagMaxPage() {
		return flagMaxPage;
	}

	public void setFlagMaxPage(boolean flagMaxPage) {
		this.flagMaxPage = flagMaxPage;
	}

	public boolean isFlagMinPage() {
		return flagMinPage;
	}

	public void setFlagMinPage(boolean flagMinPage) {
		this.flagMinPage = flagMinPage;
	}

	public boolean isFlagMsgInvNumber() {
		return flagMsgInvNumber;
	}

	public void setFlagMsgInvNumber(boolean flagMsgInvNumber) {
		this.flagMsgInvNumber = flagMsgInvNumber;
	}

	public boolean isFlagMaxPageJenisBiaya() {
		return flagMaxPageJenisBiaya;
	}

	public void setFlagMaxPageJenisBiaya(boolean flagMaxPageJenisBiaya) {
		this.flagMaxPageJenisBiaya = flagMaxPageJenisBiaya;
	}

	public boolean isFlagMinPageJenisBiaya() {
		return flagMinPageJenisBiaya;
	}

	public void setFlagMinPageJenisBiaya(boolean flagMinPageJenisBiaya) {
		this.flagMinPageJenisBiaya = flagMinPageJenisBiaya;
	}

}
