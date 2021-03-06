package com.mantabs.collection.master.area_assignment.viewmodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.asn1.eac.Flags;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.collection.master.area_assignment.dto.CabangDto;
import com.mantabs.collection.master.area_assignment.dto.GlobalParamDTO;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalDtlDto;
import com.mantabs.collection.master.area_assignment.dto.GroupApprovalHdrDto;
import com.mantabs.collection.master.area_assignment.dto.JabatanDto;
import com.mantabs.collection.master.area_assignment.dto.JenisBiayaCMDTO;
import com.mantabs.collection.master.area_assignment.dto.KategoriBiayaDTO;
import com.mantabs.collection.master.area_assignment.dto.RegionalDto;
import com.mantabs.collection.master.area_assignment.dto.SubKategoriDTO;
import com.mantabs.collection.master.area_assignment.dto.WilayahDto;
import com.mantabs.collection.master.area_assignment.repository.AreaApprovalHdrRepository;
import com.mantabs.collection.master.area_assignment.service.AreaApprovalHdrSvc;
import com.mantabs.collection.master.area_assignment.service.GroupApprovalDtlSvc;
import com.mantabs.collection.master.area_assignment.service.GroupApprovalHdrSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MasterApprovalVM extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@WireVariable
	private GroupApprovalDtlSvc groupApprovalDtlSvc;

	@WireVariable
	private GroupApprovalHdrSvc groupApprovalHdrSvc;

	@WireVariable
	private AreaApprovalHdrSvc areaApprovalHdrSvc;

	private String tipeProses = "";
	private boolean groupApprovalWindow = true;
	private boolean tabGroupApproval = false;
	private boolean tabGroupApprovalDetail = false;
	private boolean tabGroupApprovalListDetail = false;
	private boolean rBAktifGroupApproval = false;
	private boolean rBtidakAKtifGroupApproval = false;
	private String tipeProsesArea = "";
	private boolean groupApprovalAreaWindow = true;
	private boolean tabGroupApprovalArea = false;
	private boolean tabGroupApprovalAreaDetail = false;
	private boolean tabGroupApprovalListAreaDetail = false;
	private boolean rBAktifGroupApprovalArea = false;
	private boolean rBtidakAKtifGroupApprovalArea = false;
	private List<GroupApprovalDtlDto> selectsListDetail = new ArrayList<>();
	private GroupApprovalDtlDto dtoDetail = new GroupApprovalDtlDto();
	private GroupApprovalHdrDto dto = new GroupApprovalHdrDto();
	private List<GlobalParamDTO> listComboLevel = new ArrayList<>();
	private GlobalParamDTO selectedComboLevel = new GlobalParamDTO();
	private List<JabatanDto> listComboJabatan = new ArrayList<>();
	private JabatanDto selectedComboJabatan = new JabatanDto();
	private JabatanDto tempComboJabatan = new JabatanDto();
	private List<GlobalParamDTO> listComboStatusHdr = new ArrayList<>();
	private GlobalParamDTO selectedComboStatus = new GlobalParamDTO();
	private List<GlobalParamDTO> listComboInisiator = new ArrayList<>();
	private GlobalParamDTO selectedComboInisiator = new GlobalParamDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiaya = new ArrayList<>();
	private KategoriBiayaDTO selectedComboKategoriBiaya = new KategoriBiayaDTO();
	private List<JenisBiayaCMDTO> listComboJenisBiaya = new ArrayList<>();
	private JenisBiayaCMDTO selectedComboJenisBiaya = new JenisBiayaCMDTO();
	private List<GlobalParamDTO> listComboInisiatorDetail = new ArrayList<>();
	private GlobalParamDTO selectedComboInisiatorDetail = new GlobalParamDTO();
	private List<KategoriBiayaDTO> listComboKategoriBiayaDetail = new ArrayList<>();
	private KategoriBiayaDTO selectedComboKategoriBiayaDetail = new KategoriBiayaDTO();
	private List<JenisBiayaCMDTO> listComboJenisBiayaDetail = new ArrayList<>();
	private JenisBiayaCMDTO selectedComboJenisBiayaDetail = new JenisBiayaCMDTO();
	private List<GlobalParamDTO> listComboBudgetDetail = new ArrayList<>();
	private GlobalParamDTO selectedComboBudgetDetail = new GlobalParamDTO();
	private List<SubKategoriDTO> listComboSubKategori = new ArrayList<>();
	private SubKategoriDTO selectedComboSubKategori = new SubKategoriDTO();
	private List<SubKategoriDTO> listComboSubKategoriDetail = new ArrayList<>();
	private SubKategoriDTO selectedComboSubKategoriDetail = new SubKategoriDTO();
	private List<JabatanDto> listComboTingkatJabatan = new ArrayList<>();
	private JabatanDto selectedComboTingkatJabatan = new JabatanDto();
	private List<GroupApprovalHdrDto> listHeaderGroupApproval = new ArrayList<>();
	private GroupApprovalHdrDto selectedHeaderGroupApproval = new GroupApprovalHdrDto();
	private List<GroupApprovalDtlDto> listDetailGroupApproval = new ArrayList<>();
	private GroupApprovalDtlDto selectedDetailGroupApproval = new GroupApprovalDtlDto();
	private List<GroupApprovalHdrDto> listComboGroupApprovalAA = new ArrayList<>();
	private GroupApprovalHdrDto selectedComboGroupApprovalAA = new GroupApprovalHdrDto();
	private List<KategoriBiayaDTO> listComboKategoriBiayaAA = new ArrayList<>();
	private KategoriBiayaDTO selectedComboKategoriBiayaAA = new KategoriBiayaDTO();
	private List<JenisBiayaCMDTO> listComboJenisBiayaAA = new ArrayList<>();
	private JenisBiayaCMDTO selectedComboJenisBiayaAA = new JenisBiayaCMDTO();
	private List<SubKategoriDTO> listComboSubKategoriAA = new ArrayList<>();
	private SubKategoriDTO selectedComboSubKategoriAA = new SubKategoriDTO();
	private List<GlobalParamDTO> listComboStatusAA = new ArrayList<>();
	private GlobalParamDTO selectedComboStatusAA = new GlobalParamDTO();
	private List<GlobalParamDTO> listComboInisiatorAA = new ArrayList<>();
	private GlobalParamDTO selectedComboInisiatorAA = new GlobalParamDTO();
	private List<WilayahDto> listComboWilayah = new ArrayList<>();
	private WilayahDto selectedComboWilayah = new WilayahDto();
	private List<RegionalDto> listComboRegional = new ArrayList<>();
	private RegionalDto selectedComboRegional = new RegionalDto();
	private List<CabangDto> listComboCabang = new ArrayList<>();
	private CabangDto selectedComboCabang = new CabangDto();
	private List<WilayahDto> listComboWilayahDetail = new ArrayList<>();
	private WilayahDto selectedComboWilayahDetail = new WilayahDto();
	private List<RegionalDto> listComboRegionalDetail = new ArrayList<>();
	private RegionalDto selectedComboRegionalDetail = new RegionalDto();
	private List<CabangDto> listComboCabangDetail = new ArrayList<>();
	private CabangDto selectedComboCabangDetail = new CabangDto();

	private boolean flagMsgFree = false;
	private boolean flagMsgDelete = false;
	private boolean flagMsgSuccessDelete = false;
	private boolean flagMsgDataSudahAda = false;
	private boolean flagMsgWarningDeleteStatusAktif = false;
	private boolean flagMsgWarningUpdateStatusAktif = false;
	private boolean flagMsgSave = false;
	private boolean flagMsgInvNumber = false;
	private String paramSave = "";
	private boolean flagEditGroupApproval = false;
	private boolean flagEditAreaApproval = false;
	private String statusGA = "";
	private String statusAA = "";
	private boolean GAAktif = false;
	private boolean GANonAktif = false;
	private String kodeKategoriBiaya = "";
	private String kodeSubKategori = "";
	private String kodeJenisBiaya = "";
	private String kodeBudged = "";
	private String kodeInisiator = "";
	private String groupApproval = "";
	private int totalSize = 0;
	public int totalPage = 0;
	public int pageNumber = 1;
	private boolean flagMaxPage = false;
	private boolean flagMinPage = true;
	int pageSize = 15;
	private String judulDetailGroupApproval = "";
	private String judulDetailAreaApproval = "";
	private String kategoriBiayaGADetail = "";
	private String subKategoriGADetail = "";
	private String jenisBiayaGADetail = "";
	private String budgetGADetail = "";
	private String inisiatorGADetail = "";
	private String tingkatJabatanGADetail = "";
	private boolean flagDisable = false;
	private boolean flagdisableButton = false;
	private boolean flagButton = true;
	private String paramDeleteGA = "";
	private String kategoriBiayaAA = "";
	private String subKategoriAA = "";
	private String jenisBiayaAA = "";
	private String wilayah = "";
	private String regional = "";
	private String cabang = "";
	private String wilayahDetail = "";
	private String regionalDetail = "";
	private String cabangDetail = "";
	private boolean flagTakHingga = false;

	CMSUserDto user = new CMSUserDto();
	private String jabatan = "";

	private String comboJabatan = "";

	@Init
	@NotifyChange({ "listComboLevel", "listComboJabatan", "listComboKategoriBiaya", "listComboStatusHdr",
			"listComboInisiator", "listComboInisiatorDetail", "listComboKategoriBiayaDetail", "listComboBudgetDetail",
			"listComboTingkatJabatan", "listHeaderGroupApproval", "listComboInisiatorAA", "listComboStatusAA",
			"listComboWilayah", "listComboWilayahDetail" })
	public void MainVM() {
		getloadComboboxJabatan();
		getloadComboboxTingkatJabatan();
		getloadComboboxLevel();
		getloadComboboxInisiator();
		getloadComboboxKategoriBiaya();
		getloadComboboxLevelHdr();
		getloadComboboxBudgetDetail();
		getloadComboboxInisiatorDetail();
		getloadComboboxKategoriBiayaDetail();
		getloadComboboxInisiatorAA();
		getloadComboboxStatusAA();
		getloadComboboxWilayah();
		getloadComboboxWilayahDetail();
		loadGroupApproval(kodeKategoriBiaya, kodeSubKategori, kodeJenisBiaya, kodeInisiator, groupApproval, statusGA, cabang,
				getPageNumber(), getPageSize());
	}

	@Command("addGroupApproval")
	@NotifyChange({ "groupApprovalWindow", "groupApprovalWindow", "tabGroupApprovalDetail", "listDetail", "GAAktif",
			"judulDetailGroupApproval", "flagDisable", "flagButton", "flagdisableButton" })
	public void addGroupApproval() {
		setTipeProses("A");
		GAAktif = true;
		groupApprovalWindow = false;
		setJudulDetailGroupApproval("Group Approval >> Tambah");
		tabGroupApprovalDetail = true;
		flagDisable = false;
		flagButton = true;
		flagdisableButton = true;
	}

	@Command("addGroupAreaApproval")
	@NotifyChange({ "groupApprovalAreaWindow", "tabGroupApprovalArea" })
	public void addGroupAreaApproval() {
		setTipeProsesArea("A");
		groupApprovalAreaWindow = false;
		tabGroupApprovalArea = true;
	}

	@Command
	public void OK() {
		if (isFlagMsgDelete() == true) {

			if (paramDeleteGA.equals("GA")) {

				setFlagMsgDelete(false);
				forDeleteGroupApprovalDetail();

			}

		} else if (isFlagMsgSave() == true) {
			if (paramSave.equals("GA")) {
				setFlagMsgSave(false);
				forsaveGroupApproval();
			}
		} else {
			flagMsgInvNumber = false;
			flagMsgFree = false;
			flagMsgDataSudahAda = false;
			flagMsgWarningDeleteStatusAktif = false;
			flagMsgSuccessDelete = false;
			flagMsgWarningUpdateStatusAktif = false;
		}
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

	public void cekStatusGA() {
		if (GAAktif == true) {
			setStatusGA("1");
		} else {
			setStatusGA("0");
		}
	}

	@Command("saveGroupApproval")
	@NotifyChange({ "listHeaderGroupApproval", "flagMsgSave", "paramSave", "groupApprovalWindow" })
	public void saveGroupApproval() {
		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");

		flagMsgSave = true;
		paramSave = "GA";
	}

	private void ref() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridName", "configGrid");
		BindUtils.postGlobalCommand(null, null, "refreshGrid", map);
	}

	@GlobalCommand
	@NotifyChange({ "listHeaderGroupApproval", "dto", "listComboKategoriBiayaSK", "listComboKategoriBiayaSKDetail",
			"listComboKategoriBiayaJB", "listComboKategoriBiayaJBDetail", "tabGroupApprovalDetail",
			"groupApprovalWindow" })
	public void refreshGrid(@BindingParam("gridName") String gridName) {
		if (gridName.equals("configGrid")) {
			filterGA();
			refreshGroupApproval();
//			getloadCombobox
//			getloadComboboxKategoriBiayaSKDetail();
//			getloadComboboxKategoriBiayaJB();
//			getloadComboboxKategoriBiayaJBDetail();
			tabGroupApprovalDetail = false;
			groupApprovalWindow = true;
		}
	}

	@Command("forsaveGroupApproval")
	@NotifyChange({ "listKategoriBiaya", "dto", "flagMsgFree", "listDetailGroupApproval", "flagMsgDataSudahAda",
			"groupApprovalWindow", "tabGroupApprovalDetail", "statusGA" })
	public void forsaveGroupApproval() {
		List<GroupApprovalHdrDto> datas = groupApprovalHdrSvc.cekGroupApproval(dto.getGroupApproval(),
				dto.getKodeKategoriBiaya(), dto.getKodeSubKategori(), dto.getKodeJenisBiaya(), dto.getKodeBudget(),
				dto.getKodeInisiator(), dto.getKodeTingkatJabatan(), dto.getStartRangePengajuan(),
				dto.getEndRangePengajuan());

		boolean cekDetail = false;

		List<GroupApprovalDtlDto> listTempDtl = groupApprovalHdrSvc.getListDetailByHeader(dto.getKodeGroupApproval());

		GroupApprovalHdrDto dtoTemp = groupApprovalHdrSvc.cekGroupApprovalDanStatus(dto.getKodeGroupApproval());

		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");

		if (getTipeProses().equals("A")) {
			if (datas.size() < 1) {
				cekStatusGA();

				dto.setStatus(getStatusGA());
				dto.setCreatedBy(user.getId() + "");
				dto.setKategoriBiaya(selectedComboKategoriBiayaDetail.getKodeKategoriBiaya());
				dto.setSubKategori(selectedComboSubKategoriDetail.getKodeSubKategori());
				dto.setJenisBiaya(selectedComboJenisBiayaDetail.getKodeJenisBiaya());
				dto.setBudget(selectedComboBudgetDetail.getIdParam());
				dto.setInisiator(selectedComboInisiatorDetail.getIdParam());
				dto.setTingkatJabatan(selectedComboTingkatJabatan.getIdJabatan());
				dto.setGroupApprovalDtlDtos(listDetailGroupApproval);
				dto.setBranchId(selectedComboCabangDetail.getIdCabang());
				dto.setTipeProses("A");
				groupApprovalHdrSvc.saveGroupApproval(dto);
				flagMsgFree = true;
				ref();
			} else {
				flagMsgDataSudahAda = true;
				ref();
			}
		} else {
			dto.setTipeProses("U");

			if (selectedComboKategoriBiayaDetail.getKodeKategoriBiaya() != null) {
				dto.setKodeKategoriBiaya(selectedComboKategoriBiayaDetail.getKodeKategoriBiaya());
			} else {
				dto.setKodeKategoriBiaya(dto.getKodeKategoriBiaya());
			}

			if (selectedComboSubKategoriDetail.getKodeSubKategori() != null) {
				dto.setKodeSubKategori(selectedComboSubKategoriDetail.getKodeSubKategori());
			} else {
				dto.setKodeSubKategori(dto.getKodeSubKategori());
			}

			if (selectedComboJenisBiayaDetail.getKodeJenisBiaya() != null) {
				dto.setKodeJenisBiaya(selectedComboJenisBiayaDetail.getKodeJenisBiaya());
			} else {
				dto.setKodeJenisBiaya(dto.getKodeJenisBiaya());
			}

			if (selectedComboBudgetDetail.getIdParam() != null) {
				dto.setKodeBudget(selectedComboBudgetDetail.getIdParam());
			} else {
				dto.setKodeBudget(dto.getKodeBudget());
			}

			if (selectedComboInisiatorDetail.getIdParam() != null) {
				dto.setKodeInisiator(selectedComboInisiatorDetail.getIdParam());
			} else {
				dto.setKodeInisiator(dto.getKodeInisiator());
			}

			if (selectedComboTingkatJabatan.getIdJabatan() != null) {
				dto.setTingkatJabatan(selectedComboTingkatJabatan.getIdJabatan());
			} else {
				dto.setTingkatJabatan(dto.getTingkatJabatan());
			}
			
			if (selectedComboCabangDetail.getIdCabang() != null) {
				dto.setBranchId(selectedComboCabangDetail.getIdCabang());
			} else {
				dto.setBranchId(dto.getBranchId());
			}

			cekStatusGA();

			if (dtoTemp.getGroupApproval().equals(dto.getGroupApproval())
					&& dtoTemp.getKategoriBiaya().equals(dto.getKodeKategoriBiaya())
					&& dtoTemp.getSubKategori().equals(dto.getKodeSubKategori())
					&& dtoTemp.getJenisBiaya().equals(dto.getKodeJenisBiaya())
					&& dtoTemp.getBudget().equals(dto.getKodeBudget())
					&& dtoTemp.getInisiator().equals(dto.getKodeInisiator())
					&& dtoTemp.getTingkatJabatan().equals(dto.getKodeTingkatJabatan())
					&& dtoTemp.getStatus().equals(getStatusGA())
					&& dtoTemp.getBranchId().equals(dto.getBranchId())
					&& dtoTemp.getStartRangePengajuan().compareTo(dto.getStartRangePengajuan()) == 0
					&& dtoTemp.getEndRangePengajuan().compareTo(dto.getEndRangePengajuan()) == 0) {

				List<String> det = new ArrayList<String>();
				List<String> detTemp = new ArrayList<String>();

				for (GroupApprovalDtlDto dtoTempDetail : listDetailGroupApproval) {
					det.add(dtoTempDetail.getJabatan());
				}

				for (GroupApprovalDtlDto dtoTempDetail : listTempDtl) {
					detTemp.add(dtoTempDetail.getJabatan());
				}

				if (det.equals(detTemp)) {
					cekDetail = false;
				} else {
					cekDetail = true;
				}

				if (cekDetail == true) {
					dto.setStatus(getStatusGA());
					dto.setCreatedBy(user.getId() + "");
					if (selectedComboKategoriBiayaDetail.getKodeKategoriBiaya() != null) {
						dto.setKategoriBiaya(selectedComboKategoriBiayaDetail.getKodeKategoriBiaya());
					} else {
						dto.setKategoriBiaya(dto.getKodeKategoriBiaya());
					}
					if (selectedComboSubKategoriDetail.getKodeSubKategori() != null) {
						dto.setSubKategori(selectedComboSubKategoriDetail.getKodeSubKategori());
					} else {
						dto.setSubKategori(dto.getKodeSubKategori());
					}
					if (selectedComboJenisBiayaDetail.getKodeJenisBiaya() != null) {
						dto.setJenisBiaya(selectedComboJenisBiayaDetail.getKodeJenisBiaya());
					} else {
						dto.setJenisBiaya(dto.getKodeJenisBiaya());
					}
					if (selectedComboBudgetDetail.getIdParam() != null) {
						dto.setBudget(selectedComboBudgetDetail.getIdParam());
					} else {
						dto.setBudget(dto.getKodeBudget());
					}
					if (selectedComboInisiatorDetail.getIdParam() != null) {
						dto.setInisiator(selectedComboInisiatorDetail.getIdParam());
					} else {
						dto.setInisiator(dto.getKodeInisiator());
					}
					if (selectedComboTingkatJabatan.getIdJabatan() != null) {
						dto.setTingkatJabatan(selectedComboTingkatJabatan.getIdJabatan());
					} else {
						dto.setTingkatJabatan(dto.getKodeTingkatJabatan());
					}

					dto.setModifiedBy(user.getId() + "");
					dto.setGroupApprovalDtlDtos(listDetailGroupApproval);
					groupApprovalHdrSvc.saveGroupApproval(dto);
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
				dto.setStatus(getStatusGA());
				dto.setCreatedBy(user.getId() + "");
				if (selectedComboKategoriBiayaDetail.getKodeKategoriBiaya() != null) {
					dto.setKategoriBiaya(selectedComboKategoriBiayaDetail.getKodeKategoriBiaya());
				} else {
					dto.setKategoriBiaya(dto.getKodeKategoriBiaya());
				}
				if (selectedComboSubKategoriDetail.getKodeSubKategori() != null) {
					dto.setSubKategori(selectedComboSubKategoriDetail.getKodeSubKategori());
				} else {
					dto.setSubKategori(dto.getKodeSubKategori());
				}
				if (selectedComboJenisBiayaDetail.getKodeJenisBiaya() != null) {
					dto.setJenisBiaya(selectedComboJenisBiayaDetail.getKodeJenisBiaya());
				} else {
					dto.setJenisBiaya(dto.getKodeJenisBiaya());
				}
				if (selectedComboBudgetDetail.getIdParam() != null) {
					dto.setBudget(selectedComboBudgetDetail.getIdParam());
				} else {
					dto.setBudget(dto.getKodeBudget());
				}
				if (selectedComboInisiatorDetail.getIdParam() != null) {
					dto.setInisiator(selectedComboInisiatorDetail.getIdParam());
				} else {
					dto.setInisiator(dto.getKodeInisiator());
				}
				if (selectedComboTingkatJabatan.getIdJabatan() != null) {
					dto.setTingkatJabatan(selectedComboTingkatJabatan.getIdJabatan());
				} else {
					dto.setTingkatJabatan(dto.getKodeTingkatJabatan());
				}

				dto.setModifiedBy(user.getId() + "");
				dto.setGroupApprovalDtlDtos(listDetailGroupApproval);
				groupApprovalHdrSvc.saveGroupApproval(dto);
				flagMsgFree = true;
				ref();
			}

		}
		BindUtils.postNotifyChange(null, null, this, "flagMsgSave");
		groupApprovalWindow = true;
		tabGroupApprovalDetail = false;
//		tab1Detail = false;
//		kategoriBiayaWindow = true;
	}

	@NotifyChange({ "listHeaderGroupApproval", "totalSize", "totalPage", "pageNumber", "flagMaxPage" })
	public void loadGroupApproval(String kategoriBiaya, String SubKategori, String jenisBiaya, 
			String groupApproval, String status,String inisiator, String cabang, int pageNumber, int pageSize) {
		listHeaderGroupApproval.clear();
		Map<String, Object> map = new HashMap<>();

		map = groupApprovalHdrSvc.findAllGroupApprovalHdr(kategoriBiaya, SubKategori, jenisBiaya, groupApproval, status,
				inisiator, cabang,  getPageNumber(), getPageSize());
		totalSize = ((int) map.get("totalSize"));
		totalPage = ((int) map.get("totalPage"));

		if (totalPage == pageNumber) {
			flagMaxPage = true;
		} else {
			flagMaxPage = false;
		}

//		cekFlagDisabledPageMax();
//		cekFlagDisabledPageMin();

		listHeaderGroupApproval = (List<GroupApprovalHdrDto>) map.get("list");

	}

	@Command("filterGA")
	@NotifyChange({ "listSubKategori", "flagMaxPageSubKategori", "flagMinPageSubKategori","listHeaderGroupApproval" })
	public void filterGA() {
		if (selectedComboKategoriBiaya != null) {
			setKodeKategoriBiaya(selectedComboKategoriBiaya.getKodeKategoriBiaya());
		} else {
			setKodeKategoriBiaya("");
		}

		if (selectedComboSubKategori != null) {
			setKodeSubKategori(selectedComboSubKategori.getKodeSubKategori());
		} else {
			setKodeSubKategori("");
		}

		if (selectedComboJenisBiaya != null) {
			setKodeJenisBiaya(selectedComboJenisBiaya.getKodeJenisBiaya());
		} else {
			setKodeJenisBiaya("");
		}

		if (selectedComboInisiator != null) {
			setKodeInisiator(selectedComboInisiator.getIdParam());
		} else {
			setKodeInisiator("");
		}

		if (selectedComboStatus != null) {
			setStatusGA(selectedComboStatus.getIdParam());
		} else {
			setStatusGA("");
		}
		
		if (selectedComboCabang != null) {
			setCabang(selectedComboCabang.getIdCabang());
		} else {
			setCabang("");
		}

		loadGroupApproval(kodeKategoriBiaya, kodeSubKategori, kodeJenisBiaya, kodeInisiator, groupApproval, statusGA, cabang,
				getPageNumber(), getPageSize());

	}

	// Method untuk paging group approval

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
	@NotifyChange({ "pageNumber", "listHeaderGroupApproval", "flagMaxPage", "flagMinPage" })
	public void firstPage() {
		setPageNumber(1);
		cekFlagDisabledPageMin();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumber", "listHeaderGroupApproval", "flagMaxPage", "flagMinPage" })
	public void prevPage() {
		setPageNumber(getPageNumber() - 1);
		cekFlagDisabledPageMin();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumber", "listHeaderGroupApproval", "flagMaxPage", "flagMinPage", "totalPage",
			"flagMsgInvNumber" })
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
	@NotifyChange({ "pageNumber", "listHeaderGroupApproval", "flagMaxPage", "flagMinPage" })
	public void nextPage() {
		setPageNumber(getPageNumber() + 1);
		cekFlagDisabledPageMax();
		MainVM();
	}

	@Command
	@NotifyChange({ "pageNumber", "flagMaxPage", "listHeaderGroupApproval", "flagMinPage" })
	public void lastPage() {
		setPageNumber(getTotalPage());
		cekFlagDisabledPageMax();
		MainVM();
	}

	// End method paging group approval

	@Command("BATAL")
	public void batal() {
		flagMsgSave = false;

		BindUtils.postNotifyChange(null, null, this, "flagMsgSave");
	}

	@Command("saveGroupAreaApproval")
	public void saveGroupAreaApproval() {
		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");
	}

	@Command("batalGroupApproval")
	@NotifyChange({ "tabGroupApprovalDetail", "groupApprovalWindow", "listDetailGroupApproval" })
	public void batalGroupApproval() {
		tabGroupApprovalDetail = false;
		groupApprovalWindow = true;
		listDetailGroupApproval.clear();
	}

	@Command("batalGroupAreaApproval")
	@NotifyChange({ "tabGroupApprovalArea", "groupApprovalAreaWindow" })
	public void batalGroupAreaApproval() {
		tabGroupApprovalArea = false;
		groupApprovalAreaWindow = true;
	}

	@Command("addListDetailGroupApproval")
	@NotifyChange({ "tabGroupApprovalListDetail", "tabGroupApprovalDetail", "selectedComboJabatan",
			"selectedComboLevel", "rBAktifGroupApproval", "rBtidakAKtifGroupApproval", "listComboJabatan",
			"listComboLevel", "jabatan", "listComboTingkatJabatan" })
	public void addListDetailGroupApproval() {
//		getloadComboboxJabatan();
//		getloadComboboxLevel();
//		listComboJabatan = groupApprovalDtlSvc.comboJabatan();
		getloadComboboxTingkatJabatan();
//		listComboLevel = groupApprovalDtlSvc.comboLevel();

		dtoDetail = new GroupApprovalDtlDto();
		selectedComboJabatan = new JabatanDto();
		selectedComboLevel = new GlobalParamDTO();
		tabGroupApprovalListDetail = true;
		tabGroupApprovalDetail = false;
		jabatan = "";
		List<String> listNotIn = new ArrayList<>();
		List<String> listNotInLevel = new ArrayList<>();
		for (GroupApprovalDtlDto a : listDetailGroupApproval) {
			String namaJabatan = a.getJabatan();
			listNotIn.add(namaJabatan);
			listNotInLevel.add(a.getLevelJabatan());
		}

		List<JabatanDto> listJabatanNotIn = new ArrayList<>();

		List<GlobalParamDTO> listLevelNotIn = new ArrayList<>();

		if (listNotIn.size() > 0) {
			listJabatanNotIn = groupApprovalDtlSvc.listNotInJabatan(listNotIn);
		} else {
			listJabatanNotIn = groupApprovalDtlSvc.comboJabatan();
		}

		if (listNotInLevel.size() > 0) {
			listLevelNotIn = groupApprovalDtlSvc.comboLevel(listNotInLevel);
		} else {
			listLevelNotIn = groupApprovalDtlSvc.comboLevel();
		}

		listComboJabatan = listJabatanNotIn;
		listComboLevel = listLevelNotIn;

		BindUtils.postNotifyChange(null, null, this, "listComboLevel");
		BindUtils.postNotifyChange(null, null, this, "listComboJabatan");
		BindUtils.postNotifyChange(null, null, this, "selectedComboJabatan");
		BindUtils.postNotifyChange(null, null, this, "selectedComboLevel");
	}
	
	@Command("takHingga")
	@NotifyChange({"flagTakHingga"})
	public void takHingga() {
		if (flagTakHingga) {
			dto.setEndRangePengajuan(new BigDecimal("99999999999"));
		} else {
			dto.setEndRangePengajuan(null);
		}
		
		
		BindUtils.postNotifyChange(null, null, dto, "endRangePengajuan");
	}

	@Command("pilihJabatan")
	public void pilihJabatan() {
		setTempComboJabatan(selectedComboJabatan);
	}

	@Command("setComboJabatan")
	@NotifyChange("comboJabatan")
	public void setComboJabatan() {
		comboJabatan = selectedComboJabatan.getNamaJabatan();
	}

	@Command("ubahJabatan")
	@NotifyChange({ "listComboJabatan" })
	public void ubahJabatan() {
		List<String> listNotIn = new ArrayList<>();
		for (GroupApprovalDtlDto a : listDetailGroupApproval) {
			String namaJabatan = a.getJabatan();
			listNotIn.add(namaJabatan);
		}
//		
//		List<JabatanDto> listJabatanNotIn = new ArrayList<>();
//		
//		if (listNotIn.size() > 0) {
//			listJabatanNotIn = groupApprovalDtlSvc.listNotInJabatan(listNotIn);
//		} else {
//			listJabatanNotIn = groupApprovalDtlSvc.comboJabatan();
//		}

		listComboJabatan = groupApprovalDtlSvc.comboJabatan("%" + getJabatan() + "%", listNotIn);
	}

	@Command("ubahWilayah")
	@NotifyChange({ "listComboWilayah", "listComboRegional", "selectedComboRegional", "selectedComboCabang" })
	public void ubahWilayah() {

		listComboWilayah = groupApprovalHdrSvc.comboListWilayahWithName("%" + getWilayah() + "%");
		selectedComboRegional = null;
		selectedComboCabang = null;

		getloadComboboxRegional(selectedComboWilayah.getIdWilayah());
	}

	@Command("ubahWilayahDetail")
	@NotifyChange({ "listComboWilayahDetail", "listComboRegionalDetail", "selectedComboRegionalDetail",
			"selectedComboCabangDetail" })
	public void ubahWilayahDetail() {

		listComboWilayahDetail = groupApprovalHdrSvc.comboListWilayahWithName("%" + getWilayahDetail() + "%");
		selectedComboRegionalDetail = null;
		selectedComboCabangDetail = null;

		getloadComboboxRegionalDetail(selectedComboWilayahDetail.getIdWilayah());
	}

	@Command("ubahRegional")
	@NotifyChange({ "listComboRegional", "listComboCabang", "selectedComboCabang" })
	public void ubahRegional() {
		getloadComboboxRegionalWithName(selectedComboWilayah.getIdWilayah(), "%" + getRegional() + "%");
		getloadComboboxCabang(selectedComboRegional.getIdRegional());
		selectedComboCabang = null;
	}

	@Command("ubahRegionalDetail")
	@NotifyChange({ "listComboRegionalDetail", "listComboCabangDetail", "selectedComboCabangDetail" })
	public void ubahRegionalDetail() {
		getloadComboboxRegionalWithNameDetail(selectedComboWilayahDetail.getIdWilayah(),
				"%" + getRegionalDetail() + "%");
		getloadComboboxCabangDetail(selectedComboRegionalDetail.getIdRegional());
		selectedComboCabangDetail = null;
	}

	@Command("ubahCabang")
	@NotifyChange({ "listComboCabang" })
	public void ubahCabang() {
		getloadComboboxCabangWithName(selectedComboRegional.getIdRegional(), "%" + getCabang() + "%");
	}

	@Command("ubahCabangDetail")
	@NotifyChange({ "listComboCabangDetail","cabangDetail" })
	public void ubahCabangDetail() {
		setCabangDetail(selectedComboCabangDetail.getNamaCabang());
		getloadComboboxCabangWithNameDetail(selectedComboRegional.getIdRegional(), "%" + getCabangDetail() + "%");
		BindUtils.postNotifyChange(null, null, this, "cabangDetail");
	}
	
	@Command("pilihCabangDetail")
	@NotifyChange({"cabangDetail" })
	public void pilihCabangDetail() {
		setCabangDetail(selectedComboCabangDetail.getNamaCabang());
		BindUtils.postNotifyChange(null, null, this, "cabangDetail");
	}

	@Command("refresGridGroupApproval")
	@NotifyChange({ "selectedComboKategoriBiaya", "selectedComboJenisBiaya", "selectedComboSubKategori",
			"groupApproval", "selectedComboStatus", "selectedComboInisiator", "listHeaderGroupApproval" })
	public void refresGridGroupApproval() {
		selectedComboKategoriBiaya = null;
		selectedComboJenisBiaya = null;
		selectedComboSubKategori = null;
		setGroupApproval("");
		selectedComboStatus = null;
		selectedComboInisiator = null;
		loadGroupApproval(kodeKategoriBiaya, kodeSubKategori, kodeJenisBiaya, kodeInisiator, groupApproval, statusGA, cabang,
				getPageNumber(), getPageSize());
		Executions.sendRedirect("");

	}

	@Command("refreshGroupApproval")
	@NotifyChange({ "selectedComboKategoriBiaya", "selectedComboSubKategori", "selectedComboJenisBiaya", "dto",
			"selectedComboStatus", "selectedComboInisiator" })
	public void refreshGroupApproval() {
		selectedComboKategoriBiaya = null;
		selectedComboSubKategori = null;
		selectedComboJenisBiaya = null;
		dto = new GroupApprovalHdrDto();
		selectedComboStatus = null;
		selectedComboInisiator = null;
//		refresGridGroupApproval();

	}

	@Command("ubahKategoriBiaya")
	@NotifyChange({ "listComboSubKategori" })
	public void ubahKategoriBiaya() {
		getloadComboboxSubKategori(selectedComboKategoriBiaya.getKodeKategoriBiaya());
	}

	@Command("ubahInisiator")
	@NotifyChange({ "listComboGroupApprovalAA", "selectedComboKategoriBiayaAA", "selectedComboGroupApprovalAA",
			"selectedComboSubKategoriAA", "selectedComboJenisBiayaAA" })
	public void ubahInisiator() {
		getloadComboboxGroupApprovalAA(selectedComboInisiatorAA.getIdParam());
		if (listComboGroupApprovalAA.size() < 1) {
			selectedComboGroupApprovalAA = null;
			selectedComboKategoriBiayaAA = null;
			selectedComboSubKategoriAA = null;
			selectedComboJenisBiayaAA = null;
			kategoriBiayaAA = "";
			subKategoriAA = "";
			jenisBiayaAA = "";
		}
		BindUtils.postNotifyChange(null, null, this, "selectedComboJenisBiayaAA");
		BindUtils.postNotifyChange(null, null, this, "selectedComboSubKategoriAA");
		BindUtils.postNotifyChange(null, null, this, "selectedComboKategoriBiayaAA");
		BindUtils.postNotifyChange(null, null, this, "selectedComboGroupApprovalAA");
		BindUtils.postNotifyChange(null, null, this, "kategoriBiayaAA");
		BindUtils.postNotifyChange(null, null, this, "subKategoriAA");
		BindUtils.postNotifyChange(null, null, this, "jenisBiayaAA");

	}

	@Command("ubahGroupApprovalAA")
	@NotifyChange({ "listComboKategoriBiayaAA", "listComboSubKategoriAA", "listComboJenisBiayaAA", "kategoriBiayaAA",
			"subKategoriAA", "jenisBiayaAA" })
	public void ubahGroupApprovalAA() {
		getloadComboboxKategoriBiayaAA(selectedComboGroupApprovalAA.getKategoriBiaya());
		getloadComboboxSubKategoriAA(selectedComboGroupApprovalAA.getSubKategori());
		getloadComboboxJenisBiayaAA(selectedComboGroupApprovalAA.getJenisBiaya());
		KategoriBiayaDTO dtoKatB = areaApprovalHdrSvc
				.findOneKategoriBiaya(selectedComboGroupApprovalAA.getKategoriBiaya());
		SubKategoriDTO dtoSubK = areaApprovalHdrSvc.findOneSubKategori(selectedComboGroupApprovalAA.getSubKategori());
		JenisBiayaCMDTO dtoJenB = areaApprovalHdrSvc.findOneJenisBiaya(selectedComboGroupApprovalAA.getJenisBiaya());
		kategoriBiayaAA = dtoKatB.getKategoriBiaya();
		subKategoriAA = dtoSubK.getSubKategori();
		jenisBiayaAA = dtoJenB.getJenisBiaya();

	}

	@Command("ubahKategoriBiayaDetail")
	@NotifyChange({ "listComboSubKategoriDetail", "flagdisableButton" })
	public void ubahKategoriBiayaDetail() {
		flagdisableButton = false;
		getloadComboboxSubKategoriDetail(selectedComboKategoriBiayaDetail.getKodeKategoriBiaya());

		dto.setGroupApproval("GROUP" + selectedComboKategoriBiayaDetail.getKodeKategoriBiaya());

		BindUtils.postNotifyChange(null, null, dto, "groupApproval");
	}

	@Command("ubahSubKategori")
	@NotifyChange({ "listComboJenisBiaya" })
	public void ubahSubKategori() {

		getloadComboboxJenisBiaya(selectedComboSubKategori.getKodeSubKategori());
	}

	@Command("ubahSubKategoriDetail")
	@NotifyChange({ "listComboJenisBiayaDetail", "flagdisableButton" })
	public void ubahSubKategoriDetail() {
		flagdisableButton = false;
		getloadComboboxJenisBiayaDetail(selectedComboSubKategoriDetail.getKodeSubKategori());
	}

	@NotifyChange({ "selectedComboJabatan", "selectedComboLevel", "rBAktifGroupApproval", "rBtidakAKtifGroupApproval",
			"comboJabatan", "listComboLevel", "listComboJabatan", "jabatan" })
	public void refreshListDetail() {
		selectedComboJabatan = new JabatanDto();
		selectedComboLevel = new GlobalParamDTO();
		rBAktifGroupApproval = false;
		rBtidakAKtifGroupApproval = false;
		comboJabatan = "";
		listComboJabatan.clear();
		listComboLevel.clear();
		jabatan = "";
		BindUtils.postNotifyChange(null, null, this, "selectedComboJabatan");
		BindUtils.postNotifyChange(null, null, this, "selectedComboLevel");
	}

	@Command("saveGroupApprovalDetail")
	@NotifyChange({ "tabGroupApprovalListDetail", "tabGroupApprovalDetail", "listDetailGroupApproval" })
	public void saveGroupApprovalDetail() {
		dtoDetail.setJabatan(selectedComboJabatan.getNamaJabatan());
		dtoDetail.setKodeJabatan(selectedComboJabatan.getIdJabatan());
		dtoDetail.setLevelJabatan(selectedComboLevel.getNamaParam());
		dtoDetail.setKodeLevelJabatan(selectedComboLevel.getIdParam());
		if (rBAktifGroupApproval == true) {
			dtoDetail.setStatus("1");
		} else if (rBtidakAKtifGroupApproval) {
			dtoDetail.setStatus("0");
		}
		listDetailGroupApproval.add(dtoDetail);
		tabGroupApprovalListDetail = false;
		tabGroupApprovalDetail = true;
		refreshListDetail();
	}

	@Command("updateGroupApprovalDetail")
	@NotifyChange({ "flagMsgWarningUpdateStatusAktif", "groupApprovalWindow", "tabGroupApprovalDetail", "dto",
			"GAAktif", "GANonAktif", "kategoriBiayaGADetail", "subKategoriGADetail", "jenisBiayaGADetail",
			"budgetGADetail", "inisiatorGADetail", "tingkatJabatanGADetail", "listDetailGroupApproval",
			"judulDetailGroupApproval", "flagDisable", "listComboSubKategoriDetail", "listComboJenisBiayaDetail",
			"flagButton", "flagdisableButton" })
	public void updateGroupApprovalDetail(@BindingParam("dtoEdit") GroupApprovalHdrDto dto) {
		if (dto.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningUpdateStatusAktif = true;
			return;
		}
		if (dto.getStatus().equals("AKTIF")) {
			setStatusGA("1");
			GAAktif = true;
		} else {
			setStatusGA("0");
			GANonAktif = true;
		}
		flagdisableButton = false;
		flagDisable = false;
		flagButton = true;
		setKategoriBiayaGADetail(dto.getKategoriBiaya());
		setSubKategoriGADetail(dto.getSubKategori());
		setJenisBiayaGADetail(dto.getJenisBiaya());
		setBudgetGADetail(dto.getBudget());
		setInisiatorGADetail(dto.getInisiator());
		setTingkatJabatanGADetail(dto.getTingkatJabatan());
		setTipeProses("E");
		setJudulDetailGroupApproval("Group Approval >> Ubah");
		getloadComboboxSubKategoriDetail(dto.getKodeKategoriBiaya());
		getloadComboboxJenisBiayaDetail(dto.getKodeSubKategori());
		listDetailGroupApproval = groupApprovalHdrSvc.getListDetailByHeader(dto.getKodeGroupApproval());
		setDto(dto);
		groupApprovalWindow = false;
		tabGroupApprovalDetail = true;

	}

	@Command("deleteGroupApproval")
	@NotifyChange({ "listHeaderGroupApproval", "dto", "flagMsgDelete", "kategoriBiayaWindow",
			"flagMsgWarningDeleteStatusAktif" })
	public void deleteGroupApproval(@BindingParam("dtoDel") GroupApprovalHdrDto dtoNew) {
		if (dtoNew.getStatus().equals("TIDAK AKTIF")) {
			flagMsgWarningDeleteStatusAktif = true;
			return;
		}

		groupApprovalWindow = true;
		flagMsgDelete = true;
		paramDeleteGA = "GA";
		dto = dtoNew;
	}

	@NotifyChange({ "flagMsgDelete", "groupApprovalWindow", "flagMsgSuccessDelete" })
	public void forDeleteGroupApprovalDetail() {

		try {
			groupApprovalHdrSvc.deleteHeaderAndList(dto);
			flagMsgSuccessDelete = true;
			ref();

		} catch (Exception e) {
			Messagebox.show("Data Gagal Dihapus", "Error", Messagebox.OK, Messagebox.ERROR);
		}

	}

	@Command("viewDetail")
	@NotifyChange({ "flagMsgWarningUpdateStatusAktif", "groupApprovalWindow", "tabGroupApprovalDetail", "dto",
			"GAAktif", "GANonAktif", "kategoriBiayaGADetail", "subKategoriGADetail", "jenisBiayaGADetail",
			"budgetGADetail", "inisiatorGADetail", "tingkatJabatanGADetail", "listDetailGroupApproval",
			"judulDetailGroupApproval", "flagDisable", "listComboSubKategoriDetail", "listComboJenisBiayaDetail",
			"flagButton", "flagdisableButton", "judulDetailGroupApproval","cabangDetail" })
	public void viewDetail(@BindingParam("dtoView") GroupApprovalHdrDto dto) {
		if (dto.getStatus().equals("AKTIF")) {
			setStatusGA("1");
			GAAktif = true;
		} else {
			setStatusGA("0");
			GANonAktif = true;
		}
		setJudulDetailGroupApproval("Group Approval >> Lihat");
		flagdisableButton = true;
		flagDisable = true;
		flagButton = false;
		setKategoriBiayaGADetail(dto.getKategoriBiaya());
		setSubKategoriGADetail(dto.getSubKategori());
		setJenisBiayaGADetail(dto.getJenisBiaya());
		setBudgetGADetail(dto.getBudget());
		setInisiatorGADetail(dto.getInisiator());
		setTingkatJabatanGADetail(dto.getTingkatJabatan());
		setTipeProses("E");
		getloadComboboxSubKategoriDetail(dto.getKodeKategoriBiaya());
		getloadComboboxJenisBiayaDetail(dto.getKodeSubKategori());
		setCabangDetail(dto.getNamaCabang());
		listDetailGroupApproval = groupApprovalHdrSvc.getListDetailByHeader(dto.getKodeGroupApproval());
		setDto(dto);
		groupApprovalWindow = false;
		tabGroupApprovalDetail = true;
		
		BindUtils.postNotifyChange(null, null, this, "cabangDetail");

	}

	@Command("deleteGroupApprovalDetail")
	@NotifyChange({ "listDetailGroupApproval" })
	public void deleteGroupApprovalDetail(@BindingParam("dtoDetail") GroupApprovalDtlDto dtoDetail) {
		listDetailGroupApproval.remove(dtoDetail);
	}

	@Command("batalGroupApprovalDetail")
	@NotifyChange({ "tabGroupApprovalListDetail", "tabGroupApprovalDetail", "listDetail" })
	public void batalGroupApprovalDetail() {
		tabGroupApprovalListDetail = false;
		tabGroupApprovalDetail = true;

	}

	public List<GlobalParamDTO> getloadComboboxLevel() {
		List<GlobalParamDTO> list = groupApprovalDtlSvc.comboLevel();
		listComboLevel = list;
		return listComboLevel;
	}

	public List<GlobalParamDTO> getloadComboboxLevelHdr() {
		List<GlobalParamDTO> list = groupApprovalHdrSvc.comboLevel();
		listComboStatusHdr = list;
		return listComboStatusHdr;
	}

	public List<GlobalParamDTO> getloadComboboxStatusAA() {
		List<GlobalParamDTO> list = areaApprovalHdrSvc.comboLevel();
		listComboStatusAA = list;
		return listComboStatusAA;
	}

	public List<GlobalParamDTO> getloadComboboxInisiator() {
		List<GlobalParamDTO> list = groupApprovalHdrSvc.comboInisiator();
		listComboInisiator = list;
		return listComboInisiator;
	}

	public List<GlobalParamDTO> getloadComboboxInisiatorAA() {
		List<GlobalParamDTO> list = areaApprovalHdrSvc.comboInisiator();
		listComboInisiatorAA = list;
		return listComboInisiatorAA;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiaya() {
		List<KategoriBiayaDTO> list = groupApprovalHdrSvc.comboKategoriBiaya();
		listComboKategoriBiaya = list;
		return listComboKategoriBiaya;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiayaAA(String kategoriBiaya) {
		List<KategoriBiayaDTO> list = areaApprovalHdrSvc.comboKategoriBiaya(kategoriBiaya);
		listComboKategoriBiayaAA = list;
		return listComboKategoriBiayaAA;
	}

	public List<SubKategoriDTO> getloadComboboxSubKategoriAA(String subKategori) {
		List<SubKategoriDTO> list = areaApprovalHdrSvc.comboSubKategori(subKategori);
		listComboSubKategoriAA = list;
		return listComboSubKategoriAA;
	}

	public List<JenisBiayaCMDTO> getloadComboboxJenisBiayaAA(String jenisBiaya) {
		List<JenisBiayaCMDTO> list = areaApprovalHdrSvc.comboJenisBiaya(jenisBiaya);
		listComboJenisBiayaAA = list;
		return listComboJenisBiayaAA;
	}

	public List<GlobalParamDTO> getloadComboboxInisiatorDetail() {
		List<GlobalParamDTO> list = groupApprovalHdrSvc.comboInisiatorDetail();
		listComboInisiatorDetail = list;
		return listComboInisiatorDetail;
	}

	public List<GlobalParamDTO> getloadComboboxBudgetDetail() {
		List<GlobalParamDTO> list = groupApprovalHdrSvc.comboBudgetDetail();
		listComboBudgetDetail = list;
		return listComboBudgetDetail;
	}

	public List<KategoriBiayaDTO> getloadComboboxKategoriBiayaDetail() {
		List<KategoriBiayaDTO> list = groupApprovalHdrSvc.comboKategoriBiayaDetail();
		listComboKategoriBiayaDetail = list;
		return listComboKategoriBiayaDetail;
	}

	public List<JabatanDto> getloadComboboxJabatan() {
		List<JabatanDto> list = groupApprovalDtlSvc.comboJabatan();
		listComboJabatan = list;
		return listComboJabatan;
	}

	public List<RegionalDto> getloadComboboxRegional(String wilayah) {
		List<RegionalDto> list = groupApprovalHdrSvc.comboListRegionalWithIdWilayah(wilayah);
		listComboRegional = list;
		return listComboRegional;
	}

	public List<RegionalDto> getloadComboboxRegionalWithName(String wilayah, String regional) {
		List<RegionalDto> list = groupApprovalHdrSvc.comboListRegionalWithNameAndIdWilayah(wilayah, regional);
		listComboRegional = list;
		return listComboRegional;
	}

	public List<WilayahDto> getloadComboboxWilayah() {
		List<WilayahDto> list = groupApprovalHdrSvc.comboListWilayah();
		listComboWilayah = list;
		return listComboWilayah;
	}

	public List<CabangDto> getloadComboboxCabang(String regional) {
		List<CabangDto> list = groupApprovalHdrSvc.comboListCabangWithIdRegional(regional);
		listComboCabang = list;
		return listComboCabang;
	}

	public List<CabangDto> getloadComboboxCabangWithName(String regional, String cabang) {
		List<CabangDto> list = groupApprovalHdrSvc.comboListCabangWithNameAndIdRegional(regional, regional);
		listComboCabang = list;
		return listComboCabang;
	}

	public List<RegionalDto> getloadComboboxRegionalDetail(String wilayah) {
		List<RegionalDto> list = groupApprovalHdrSvc.comboListRegionalWithIdWilayah(wilayah);
		listComboRegionalDetail = list;
		return listComboRegionalDetail;
	}

	public List<RegionalDto> getloadComboboxRegionalWithNameDetail(String wilayah, String regional) {
		List<RegionalDto> list = groupApprovalHdrSvc.comboListRegionalWithNameAndIdWilayah(wilayah, regional);
		listComboRegionalDetail = list;
		return listComboRegionalDetail;
	}

	public List<WilayahDto> getloadComboboxWilayahDetail() {
		List<WilayahDto> list = groupApprovalHdrSvc.comboListWilayah();
		listComboWilayahDetail = list;
		return listComboWilayahDetail;
	}

	public List<CabangDto> getloadComboboxCabangDetail(String regional) {
		List<CabangDto> list = groupApprovalHdrSvc.comboListCabangWithIdRegional(regional);
		listComboCabangDetail = list;
		return listComboCabangDetail;
	}

	public List<CabangDto> getloadComboboxCabangWithNameDetail(String regional, String cabang) {
		List<CabangDto> list = groupApprovalHdrSvc.comboListCabangWithNameAndIdRegional(regional, regional);
		listComboCabangDetail = list;
		return listComboCabangDetail;
	}

	public List<JabatanDto> getloadComboboxTingkatJabatan() {
		List<JabatanDto> list = groupApprovalDtlSvc.comboJabatan();
		listComboTingkatJabatan = list;
		return listComboTingkatJabatan;
	}

	public List<SubKategoriDTO> getloadComboboxSubKategori(String kode) {
		List<SubKategoriDTO> list = groupApprovalHdrSvc.comboSubKategori(kode);
		listComboSubKategori = list;
		return listComboSubKategori;
	}

	public List<GroupApprovalHdrDto> getloadComboboxGroupApprovalAA(String inisiator) {
		List<GroupApprovalHdrDto> list = areaApprovalHdrSvc.comboGroupApproval(inisiator);
		listComboGroupApprovalAA = list;
		return listComboGroupApprovalAA;
	}

	public List<JenisBiayaCMDTO> getloadComboboxJenisBiaya(String kode) {
		List<JenisBiayaCMDTO> list = groupApprovalHdrSvc.comboJenisBiaya(kode);
		listComboJenisBiaya = list;
		return listComboJenisBiaya;
	}

	public List<SubKategoriDTO> getloadComboboxSubKategoriDetail(String kode) {
		List<SubKategoriDTO> list = groupApprovalHdrSvc.comboSubKategori(kode);
		listComboSubKategoriDetail = list;
		return listComboSubKategoriDetail;
	}

	public List<JenisBiayaCMDTO> getloadComboboxJenisBiayaDetail(String kode) {
		List<JenisBiayaCMDTO> list = groupApprovalHdrSvc.comboJenisBiayaDetail(kode);
		listComboJenisBiayaDetail = list;
		return listComboJenisBiayaDetail;
	}

	public String getTipeProses() {
		return tipeProses;
	}

	public void setTipeProses(String tipeProses) {
		this.tipeProses = tipeProses;
	}

	public boolean isGroupApprovalWindow() {
		return groupApprovalWindow;
	}

	public void setGroupApprovalWindow(boolean groupApprovalWindow) {
		this.groupApprovalWindow = groupApprovalWindow;
	}

	public boolean isTabGroupApprovalDetail() {
		return tabGroupApprovalDetail;
	}

	public void setTabGroupApprovalDetail(boolean tabGroupApprovalDetail) {
		this.tabGroupApprovalDetail = tabGroupApprovalDetail;
	}

	public boolean isTabGroupApprovalListDetail() {
		return tabGroupApprovalListDetail;
	}

	public void setTabGroupApprovalListDetail(boolean tabGroupApprovalListDetail) {
		this.tabGroupApprovalListDetail = tabGroupApprovalListDetail;
	}

	public GroupApprovalDtlDto getDtoDetail() {
		return dtoDetail;
	}

	public void setDtoDetail(GroupApprovalDtlDto dtoDetail) {
		this.dtoDetail = dtoDetail;
	}

	public GroupApprovalHdrDto getDto() {
		return dto;
	}

	public void setDto(GroupApprovalHdrDto dto) {
		this.dto = dto;
	}

	public List<GlobalParamDTO> getListComboLevel() {
		return listComboLevel;
	}

	public void setListComboLevel(List<GlobalParamDTO> listComboLevel) {
		this.listComboLevel = listComboLevel;
	}

	public GlobalParamDTO getSelectedComboLevel() {
		return selectedComboLevel;
	}

	public void setSelectedComboLevel(GlobalParamDTO selectedComboLevel) {
		this.selectedComboLevel = selectedComboLevel;
	}

	public List<JabatanDto> getListComboJabatan() {
		return listComboJabatan;
	}

	public void setListComboJabatan(List<JabatanDto> listComboJabatan) {
		this.listComboJabatan = listComboJabatan;
	}

	public JabatanDto getSelectedComboJabatan() {
		return selectedComboJabatan;
	}

	public void setSelectedComboJabatan(JabatanDto selectedComboJabatan) {
		this.selectedComboJabatan = selectedComboJabatan;
	}

	public boolean isTabGroupApproval() {
		return tabGroupApproval;
	}

	public void setTabGroupApproval(boolean tabGroupApproval) {
		this.tabGroupApproval = tabGroupApproval;
	}

	public boolean isrBAktifGroupApproval() {
		return rBAktifGroupApproval;
	}

	public void setrBAktifGroupApproval(boolean rBAktifGroupApproval) {
		this.rBAktifGroupApproval = rBAktifGroupApproval;
	}

	public boolean isrBtidakAKtifGroupApproval() {
		return rBtidakAKtifGroupApproval;
	}

	public void setrBtidakAKtifGroupApproval(boolean rBtidakAKtifGroupApproval) {
		this.rBtidakAKtifGroupApproval = rBtidakAKtifGroupApproval;
	}

	public String getComboJabatan() {
		return comboJabatan;
	}

	public void setComboJabatan(String comboJabatan) {
		this.comboJabatan = comboJabatan;
	}

	public String getTipeProsesArea() {
		return tipeProsesArea;
	}

	public void setTipeProsesArea(String tipeProsesArea) {
		this.tipeProsesArea = tipeProsesArea;
	}

	public boolean isGroupApprovalAreaWindow() {
		return groupApprovalAreaWindow;
	}

	public void setGroupApprovalAreaWindow(boolean groupApprovalAreaWindow) {
		this.groupApprovalAreaWindow = groupApprovalAreaWindow;
	}

	public boolean isTabGroupApprovalArea() {
		return tabGroupApprovalArea;
	}

	public void setTabGroupApprovalArea(boolean tabGroupApprovalArea) {
		this.tabGroupApprovalArea = tabGroupApprovalArea;
	}

	public boolean isTabGroupApprovalAreaDetail() {
		return tabGroupApprovalAreaDetail;
	}

	public void setTabGroupApprovalAreaDetail(boolean tabGroupApprovalAreaDetail) {
		this.tabGroupApprovalAreaDetail = tabGroupApprovalAreaDetail;
	}

	public boolean isTabGroupApprovalListAreaDetail() {
		return tabGroupApprovalListAreaDetail;
	}

	public void setTabGroupApprovalListAreaDetail(boolean tabGroupApprovalListAreaDetail) {
		this.tabGroupApprovalListAreaDetail = tabGroupApprovalListAreaDetail;
	}

	public boolean isrBAktifGroupApprovalArea() {
		return rBAktifGroupApprovalArea;
	}

	public void setrBAktifGroupApprovalArea(boolean rBAktifGroupApprovalArea) {
		this.rBAktifGroupApprovalArea = rBAktifGroupApprovalArea;
	}

	public boolean isrBtidakAKtifGroupApprovalArea() {
		return rBtidakAKtifGroupApprovalArea;
	}

	public void setrBtidakAKtifGroupApprovalArea(boolean rBtidakAKtifGroupApprovalArea) {
		this.rBtidakAKtifGroupApprovalArea = rBtidakAKtifGroupApprovalArea;
	}

	public List<GroupApprovalDtlDto> getSelectsListDetail() {
		return selectsListDetail;
	}

	public void setSelectsListDetail(List<GroupApprovalDtlDto> selectsListDetail) {
		this.selectsListDetail = selectsListDetail;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public JabatanDto getTempComboJabatan() {
		return tempComboJabatan;
	}

	public void setTempComboJabatan(JabatanDto tempComboJabatan) {
		this.tempComboJabatan = tempComboJabatan;
	}

	public List<GlobalParamDTO> getListComboStatusHdr() {
		return listComboStatusHdr;
	}

	public void setListComboStatusHdr(List<GlobalParamDTO> listComboStatusHdr) {
		this.listComboStatusHdr = listComboStatusHdr;
	}

	public GlobalParamDTO getSelectedComboStatus() {
		return selectedComboStatus;
	}

	public void setSelectedComboStatus(GlobalParamDTO selectedComboStatus) {
		this.selectedComboStatus = selectedComboStatus;
	}

	public List<GlobalParamDTO> getListComboInisiator() {
		return listComboInisiator;
	}

	public void setListComboInisiator(List<GlobalParamDTO> listComboInisiator) {
		this.listComboInisiator = listComboInisiator;
	}

	public GlobalParamDTO getSelectedComboInisiator() {
		return selectedComboInisiator;
	}

	public void setSelectedComboInisiator(GlobalParamDTO selectedComboInisiator) {
		this.selectedComboInisiator = selectedComboInisiator;
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

	public List<JenisBiayaCMDTO> getListComboJenisBiaya() {
		return listComboJenisBiaya;
	}

	public void setListComboJenisBiaya(List<JenisBiayaCMDTO> listComboJenisBiaya) {
		this.listComboJenisBiaya = listComboJenisBiaya;
	}

	public JenisBiayaCMDTO getSelectedComboJenisBiaya() {
		return selectedComboJenisBiaya;
	}

	public void setSelectedComboJenisBiaya(JenisBiayaCMDTO selectedComboJenisBiaya) {
		this.selectedComboJenisBiaya = selectedComboJenisBiaya;
	}

	public List<GlobalParamDTO> getListComboInisiatorDetail() {
		return listComboInisiatorDetail;
	}

	public void setListComboInisiatorDetail(List<GlobalParamDTO> listComboInisiatorDetail) {
		this.listComboInisiatorDetail = listComboInisiatorDetail;
	}

	public GlobalParamDTO getSelectedComboInisiatorDetail() {
		return selectedComboInisiatorDetail;
	}

	public void setSelectedComboInisiatorDetail(GlobalParamDTO selectedComboInisiatorDetail) {
		this.selectedComboInisiatorDetail = selectedComboInisiatorDetail;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiayaDetail() {
		return listComboKategoriBiayaDetail;
	}

	public void setListComboKategoriBiayaDetail(List<KategoriBiayaDTO> listComboKategoriBiayaDetail) {
		this.listComboKategoriBiayaDetail = listComboKategoriBiayaDetail;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiayaDetail() {
		return selectedComboKategoriBiayaDetail;
	}

	public void setSelectedComboKategoriBiayaDetail(KategoriBiayaDTO selectedComboKategoriBiayaDetail) {
		this.selectedComboKategoriBiayaDetail = selectedComboKategoriBiayaDetail;
	}

	public List<JenisBiayaCMDTO> getListComboJenisBiayaDetail() {
		return listComboJenisBiayaDetail;
	}

	public void setListComboJenisBiayaDetail(List<JenisBiayaCMDTO> listComboJenisBiayaDetail) {
		this.listComboJenisBiayaDetail = listComboJenisBiayaDetail;
	}

	public JenisBiayaCMDTO getSelectedComboJenisBiayaDetail() {
		return selectedComboJenisBiayaDetail;
	}

	public void setSelectedComboJenisBiayaDetail(JenisBiayaCMDTO selectedComboJenisBiayaDetail) {
		this.selectedComboJenisBiayaDetail = selectedComboJenisBiayaDetail;
	}

	public List<GlobalParamDTO> getListComboBudgetDetail() {
		return listComboBudgetDetail;
	}

	public void setListComboBudgetDetail(List<GlobalParamDTO> listComboBudgetDetail) {
		this.listComboBudgetDetail = listComboBudgetDetail;
	}

	public GlobalParamDTO getSelectedComboBudgetDetail() {
		return selectedComboBudgetDetail;
	}

	public void setSelectedComboBudgetDetail(GlobalParamDTO selectedComboBudgetDetail) {
		this.selectedComboBudgetDetail = selectedComboBudgetDetail;
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

	public List<SubKategoriDTO> getListComboSubKategoriDetail() {
		return listComboSubKategoriDetail;
	}

	public void setListComboSubKategoriDetail(List<SubKategoriDTO> listComboSubKategoriDetail) {
		this.listComboSubKategoriDetail = listComboSubKategoriDetail;
	}

	public SubKategoriDTO getSelectedComboSubKategoriDetail() {
		return selectedComboSubKategoriDetail;
	}

	public void setSelectedComboSubKategoriDetail(SubKategoriDTO selectedComboSubKategoriDetail) {
		this.selectedComboSubKategoriDetail = selectedComboSubKategoriDetail;
	}

	public List<JabatanDto> getListComboTingkatJabatan() {
		return listComboTingkatJabatan;
	}

	public void setListComboTingkatJabatan(List<JabatanDto> listComboTingkatJabatan) {
		this.listComboTingkatJabatan = listComboTingkatJabatan;
	}

	public JabatanDto getSelectedComboTingkatJabatan() {
		return selectedComboTingkatJabatan;
	}

	public void setSelectedComboTingkatJabatan(JabatanDto selectedComboTingkatJabatan) {
		this.selectedComboTingkatJabatan = selectedComboTingkatJabatan;
	}

	public GroupApprovalDtlSvc getGroupApprovalDtlSvc() {
		return groupApprovalDtlSvc;
	}

	public void setGroupApprovalDtlSvc(GroupApprovalDtlSvc groupApprovalDtlSvc) {
		this.groupApprovalDtlSvc = groupApprovalDtlSvc;
	}

	public GroupApprovalHdrSvc getGroupApprovalHdrSvc() {
		return groupApprovalHdrSvc;
	}

	public void setGroupApprovalHdrSvc(GroupApprovalHdrSvc groupApprovalHdrSvc) {
		this.groupApprovalHdrSvc = groupApprovalHdrSvc;
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

	public boolean isFlagMsgInvNumber() {
		return flagMsgInvNumber;
	}

	public void setFlagMsgInvNumber(boolean flagMsgInvNumber) {
		this.flagMsgInvNumber = flagMsgInvNumber;
	}

	public String getParamSave() {
		return paramSave;
	}

	public void setParamSave(String paramSave) {
		this.paramSave = paramSave;
	}

	public boolean isFlagEditGroupApproval() {
		return flagEditGroupApproval;
	}

	public void setFlagEditGroupApproval(boolean flagEditGroupApproval) {
		this.flagEditGroupApproval = flagEditGroupApproval;
	}

	public boolean isFlagEditAreaApproval() {
		return flagEditAreaApproval;
	}

	public void setFlagEditAreaApproval(boolean flagEditAreaApproval) {
		this.flagEditAreaApproval = flagEditAreaApproval;
	}

	public CMSUserDto getUser() {
		return user;
	}

	public void setUser(CMSUserDto user) {
		this.user = user;
	}

	public List<GroupApprovalHdrDto> getListHeaderGroupApproval() {
		return listHeaderGroupApproval;
	}

	public void setListHeaderGroupApproval(List<GroupApprovalHdrDto> listHeaderGroupApproval) {
		this.listHeaderGroupApproval = listHeaderGroupApproval;
	}

	public GroupApprovalHdrDto getSelectedHeaderGroupApproval() {
		return selectedHeaderGroupApproval;
	}

	public void setSelectedHeaderGroupApproval(GroupApprovalHdrDto selectedHeaderGroupApproval) {
		this.selectedHeaderGroupApproval = selectedHeaderGroupApproval;
	}

	public List<GroupApprovalDtlDto> getListDetailGroupApproval() {
		return listDetailGroupApproval;
	}

	public void setListDetailGroupApproval(List<GroupApprovalDtlDto> listDetailGroupApproval) {
		this.listDetailGroupApproval = listDetailGroupApproval;
	}

	public GroupApprovalDtlDto getSelectedDetailGroupApproval() {
		return selectedDetailGroupApproval;
	}

	public void setSelectedDetailGroupApproval(GroupApprovalDtlDto selectedDetailGroupApproval) {
		this.selectedDetailGroupApproval = selectedDetailGroupApproval;
	}

	public String getStatusGA() {
		return statusGA;
	}

	public void setStatusGA(String statusGA) {
		this.statusGA = statusGA;
	}

	public String getStatusAA() {
		return statusAA;
	}

	public void setStatusAA(String statusAA) {
		this.statusAA = statusAA;
	}

	public boolean isGAAktif() {
		return GAAktif;
	}

	public void setGAAktif(boolean GAAktif) {
		this.GAAktif = GAAktif;
	}

	public boolean isGANonAktif() {
		return GANonAktif;
	}

	public void setGANonAktif(boolean GANonAktif) {
		this.GANonAktif = GANonAktif;
	}

	public String getKodeKategoriBiaya() {
		return kodeKategoriBiaya;
	}

	public void setKodeKategoriBiaya(String kodeKategoriBiaya) {
		this.kodeKategoriBiaya = kodeKategoriBiaya;
	}

	public String getKodeSubKategori() {
		return kodeSubKategori;
	}

	public void setKodeSubKategori(String kodeSubKategori) {
		this.kodeSubKategori = kodeSubKategori;
	}

	public String getKodeJenisBiaya() {
		return kodeJenisBiaya;
	}

	public void setKodeJenisBiaya(String kodeJenisBiaya) {
		this.kodeJenisBiaya = kodeJenisBiaya;
	}

	public String getKodeBudged() {
		return kodeBudged;
	}

	public void setKodeBudged(String kodeBudged) {
		this.kodeBudged = kodeBudged;
	}

	public String getKodeInisiator() {
		return kodeInisiator;
	}

	public void setKodeInisiator(String kodeInisiator) {
		this.kodeInisiator = kodeInisiator;
	}

	public String getGroupApproval() {
		return groupApproval;
	}

	public void setGroupApproval(String groupApproval) {
		this.groupApproval = groupApproval;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getJudulDetailGroupApproval() {
		return judulDetailGroupApproval;
	}

	public void setJudulDetailGroupApproval(String judulDetailGroupApproval) {
		this.judulDetailGroupApproval = judulDetailGroupApproval;
	}

	public String getJudulDetailAreaApproval() {
		return judulDetailAreaApproval;
	}

	public void setJudulDetailAreaApproval(String judulDetailAreaApproval) {
		this.judulDetailAreaApproval = judulDetailAreaApproval;
	}

	public String getKategoriBiayaGADetail() {
		return kategoriBiayaGADetail;
	}

	public void setKategoriBiayaGADetail(String kategoriBiayaGADetail) {
		this.kategoriBiayaGADetail = kategoriBiayaGADetail;
	}

	public String getSubKategoriGADetail() {
		return subKategoriGADetail;
	}

	public void setSubKategoriGADetail(String subKategoriGADetail) {
		this.subKategoriGADetail = subKategoriGADetail;
	}

	public String getJenisBiayaGADetail() {
		return jenisBiayaGADetail;
	}

	public void setJenisBiayaGADetail(String jenisBiayaGADetail) {
		this.jenisBiayaGADetail = jenisBiayaGADetail;
	}

	public String getBudgetGADetail() {
		return budgetGADetail;
	}

	public void setBudgetGADetail(String budgetGADetail) {
		this.budgetGADetail = budgetGADetail;
	}

	public String getInisiatorGADetail() {
		return inisiatorGADetail;
	}

	public void setInisiatorGADetail(String inisiatorGADetail) {
		this.inisiatorGADetail = inisiatorGADetail;
	}

	public String getTingkatJabatanGADetail() {
		return tingkatJabatanGADetail;
	}

	public void setTingkatJabatanGADetail(String tingkatJabatanGADetail) {
		this.tingkatJabatanGADetail = tingkatJabatanGADetail;
	}

	public boolean isFlagDisable() {
		return flagDisable;
	}

	public void setFlagDisable(boolean flagDisable) {
		this.flagDisable = flagDisable;
	}

	public boolean isFlagButton() {
		return flagButton;
	}

	public void setFlagButton(boolean flagButton) {
		this.flagButton = flagButton;
	}

	public boolean isFlagdisableButton() {
		return flagdisableButton;
	}

	public void setFlagdisableButton(boolean flagdisableButton) {
		this.flagdisableButton = flagdisableButton;
	}

	public String getParamDeleteGA() {
		return paramDeleteGA;
	}

	public void setParamDeleteGA(String paramDeleteGA) {
		this.paramDeleteGA = paramDeleteGA;
	}

	public List<GroupApprovalHdrDto> getListComboGroupApprovalAA() {
		return listComboGroupApprovalAA;
	}

	public void setListComboGroupApprovalAA(List<GroupApprovalHdrDto> listComboGroupApprovalAA) {
		this.listComboGroupApprovalAA = listComboGroupApprovalAA;
	}

	public GroupApprovalHdrDto getSelectedComboGroupApprovalAA() {
		return selectedComboGroupApprovalAA;
	}

	public void setSelectedComboGroupApprovalAA(GroupApprovalHdrDto selectedComboGroupApprovalAA) {
		this.selectedComboGroupApprovalAA = selectedComboGroupApprovalAA;
	}

	public List<KategoriBiayaDTO> getListComboKategoriBiayaAA() {
		return listComboKategoriBiayaAA;
	}

	public void setListComboKategoriBiayaAA(List<KategoriBiayaDTO> listComboKategoriBiayaAA) {
		this.listComboKategoriBiayaAA = listComboKategoriBiayaAA;
	}

	public KategoriBiayaDTO getSelectedComboKategoriBiayaAA() {
		return selectedComboKategoriBiayaAA;
	}

	public void setSelectedComboKategoriBiayaAA(KategoriBiayaDTO selectedComboKategoriBiayaAA) {
		this.selectedComboKategoriBiayaAA = selectedComboKategoriBiayaAA;
	}

	public List<JenisBiayaCMDTO> getListComboJenisBiayaAA() {
		return listComboJenisBiayaAA;
	}

	public void setListComboJenisBiayaAA(List<JenisBiayaCMDTO> listComboJenisBiayaAA) {
		this.listComboJenisBiayaAA = listComboJenisBiayaAA;
	}

	public JenisBiayaCMDTO getSelectedComboJenisBiayaAA() {
		return selectedComboJenisBiayaAA;
	}

	public void setSelectedComboJenisBiayaAA(JenisBiayaCMDTO selectedComboJenisBiayaAA) {
		this.selectedComboJenisBiayaAA = selectedComboJenisBiayaAA;
	}

	public List<SubKategoriDTO> getListComboSubKategoriAA() {
		return listComboSubKategoriAA;
	}

	public void setListComboSubKategoriAA(List<SubKategoriDTO> listComboSubKategoriAA) {
		this.listComboSubKategoriAA = listComboSubKategoriAA;
	}

	public SubKategoriDTO getSelectedComboSubKategoriAA() {
		return selectedComboSubKategoriAA;
	}

	public void setSelectedComboSubKategoriAA(SubKategoriDTO selectedComboSubKategoriAA) {
		this.selectedComboSubKategoriAA = selectedComboSubKategoriAA;
	}

	public List<GlobalParamDTO> getListComboStatusAA() {
		return listComboStatusAA;
	}

	public void setListComboStatusAA(List<GlobalParamDTO> listComboStatusAA) {
		this.listComboStatusAA = listComboStatusAA;
	}

	public GlobalParamDTO getSelectedComboStatusAA() {
		return selectedComboStatusAA;
	}

	public void setSelectedComboStatusAA(GlobalParamDTO selectedComboStatusAA) {
		this.selectedComboStatusAA = selectedComboStatusAA;
	}

	public List<GlobalParamDTO> getListComboInisiatorAA() {
		return listComboInisiatorAA;
	}

	public void setListComboInisiatorAA(List<GlobalParamDTO> listComboInisiatorAA) {
		this.listComboInisiatorAA = listComboInisiatorAA;
	}

	public GlobalParamDTO getSelectedComboInisiatorAA() {
		return selectedComboInisiatorAA;
	}

	public void setSelectedComboInisiatorAA(GlobalParamDTO selectedComboInisiatorAA) {
		this.selectedComboInisiatorAA = selectedComboInisiatorAA;
	}

	public String getKategoriBiayaAA() {
		return kategoriBiayaAA;
	}

	public void setKategoriBiayaAA(String kategoriBiayaAA) {
		this.kategoriBiayaAA = kategoriBiayaAA;
	}

	public String getSubKategoriAA() {
		return subKategoriAA;
	}

	public void setSubKategoriAA(String subKategoriAA) {
		this.subKategoriAA = subKategoriAA;
	}

	public String getJenisBiayaAA() {
		return jenisBiayaAA;
	}

	public void setJenisBiayaAA(String jenisBiayaAA) {
		this.jenisBiayaAA = jenisBiayaAA;
	}

	public List<WilayahDto> getListComboWilayah() {
		return listComboWilayah;
	}

	public void setListComboWilayah(List<WilayahDto> listComboWilayah) {
		this.listComboWilayah = listComboWilayah;
	}

	public WilayahDto getSelectedComboWilayah() {
		return selectedComboWilayah;
	}

	public void setSelectedComboWilayah(WilayahDto selectedComboWilayah) {
		this.selectedComboWilayah = selectedComboWilayah;
	}

	public String getWilayah() {
		return wilayah;
	}

	public void setWilayah(String wilayah) {
		this.wilayah = wilayah;
	}

	public List<RegionalDto> getListComboRegional() {
		return listComboRegional;
	}

	public void setListComboRegional(List<RegionalDto> listComboRegional) {
		this.listComboRegional = listComboRegional;
	}

	public RegionalDto getSelectedComboRegional() {
		return selectedComboRegional;
	}

	public void setSelectedComboRegional(RegionalDto selectedComboRegional) {
		this.selectedComboRegional = selectedComboRegional;
	}

	public List<CabangDto> getListComboCabang() {
		return listComboCabang;
	}

	public void setListComboCabang(List<CabangDto> listComboCabang) {
		this.listComboCabang = listComboCabang;
	}

	public CabangDto getSelectedComboCabang() {
		return selectedComboCabang;
	}

	public void setSelectedComboCabang(CabangDto selectedComboCabang) {
		this.selectedComboCabang = selectedComboCabang;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getCabang() {
		return cabang;
	}

	public void setCabang(String cabang) {
		this.cabang = cabang;
	}

	public List<WilayahDto> getListComboWilayahDetail() {
		return listComboWilayahDetail;
	}

	public void setListComboWilayahDetail(List<WilayahDto> listComboWilayahDetail) {
		this.listComboWilayahDetail = listComboWilayahDetail;
	}

	public WilayahDto getSelectedComboWilayahDetail() {
		return selectedComboWilayahDetail;
	}

	public void setSelectedComboWilayahDetail(WilayahDto selectedComboWilayahDetail) {
		this.selectedComboWilayahDetail = selectedComboWilayahDetail;
	}

	public List<RegionalDto> getListComboRegionalDetail() {
		return listComboRegionalDetail;
	}

	public void setListComboRegionalDetail(List<RegionalDto> listComboRegionalDetail) {
		this.listComboRegionalDetail = listComboRegionalDetail;
	}

	public RegionalDto getSelectedComboRegionalDetail() {
		return selectedComboRegionalDetail;
	}

	public void setSelectedComboRegionalDetail(RegionalDto selectedComboRegionalDetail) {
		this.selectedComboRegionalDetail = selectedComboRegionalDetail;
	}

	public List<CabangDto> getListComboCabangDetail() {
		return listComboCabangDetail;
	}

	public void setListComboCabangDetail(List<CabangDto> listComboCabangDetail) {
		this.listComboCabangDetail = listComboCabangDetail;
	}

	public CabangDto getSelectedComboCabangDetail() {
		return selectedComboCabangDetail;
	}

	public void setSelectedComboCabangDetail(CabangDto selectedComboCabangDetail) {
		this.selectedComboCabangDetail = selectedComboCabangDetail;
	}

	public String getWilayahDetail() {
		return wilayahDetail;
	}

	public void setWilayahDetail(String wilayahDetail) {
		this.wilayahDetail = wilayahDetail;
	}

	public String getRegionalDetail() {
		return regionalDetail;
	}

	public void setRegionalDetail(String regionalDetail) {
		this.regionalDetail = regionalDetail;
	}

	public String getCabangDetail() {
		return cabangDetail;
	}

	public void setCabangDetail(String cabangDetail) {
		this.cabangDetail = cabangDetail;
	}

	public boolean isFlagTakHingga() {
		return flagTakHingga;
	}

	public void setFlagTakHingga(boolean flagTakHingga) {
		this.flagTakHingga = flagTakHingga;
	}
	
	

}
