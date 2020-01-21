package com.mantabs.collection.master.area_assignment.viewmodel;


import org.zkoss.util.resource.Labels;
import org.zkoss.zul.Window;

import com.mantabs.collection.master.area_assignment.tools.ExcelExport;
import com.mantabs.collection.master.area_assignment.tools.StringConstants;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Default;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;

public abstract class BaseVmd {
	
	
	public String search;

	// total data per page to be showed
	private int pageSize = 10;
	private int defaultPageSize = 10;

	// total data in list
	private int totalSize = 0;

	// public int activePage = 0; // current active page index

	public int totalPage = 0;

	public int pageNumber = 1;

	public boolean flagMaxPage = false;
	public boolean flagMinPage = true;
	public boolean flagActive = true;
	public boolean flagMsg = false;
	public String msg;
	public String msgDelete;
	public boolean flagMsgAt = false;
	public boolean flagMsgInv = false;
	public boolean flagMsgInvPass = false;
	public boolean flagMsgAktif = false;
	public boolean flagMsgNonAktif = false;
	public boolean flagMsgSubmitNoChange = false;
	public boolean flagMsgInvNumber = false;
	public boolean flagMsgDelete = false;
	public boolean flagMsgSuccessDelete = false;
	public boolean flagMsgInvalidSizeFile = false;
	public boolean flagMsgInvalidTypeFile = false;
	public boolean flagIconCek = false;
	public boolean flagIconWarning = false;
	public boolean flagIconError = false;
	public boolean flagMsgFree =false;

//	public List<MGlobalParmDto> listDisplayPageSize = new ArrayList<>(); 
//	public MGlobalParmDto selectedDisplayPageSize;
	
	protected void loadList() {
	}

	public void navigate(@BindingParam("uri") String locationUri) {
		Include include = (Include) Executions.getCurrent().getDesktop()
				.getPage("index").getFellow("mainInclude");
		include.setSrc("/WEB-INF/pages" + locationUri);
	}

	public void serve(String title, Object[] data) {
		if (data.length > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Filedownload.save(ExcelExport.generate(
						title + "-" + sdf.format(new java.util.Date()), data),
						null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Clients.alert(StringConstants.MSG_NOTHING_TO_EXPORT, "Warning", "");
		}
	}

	@Command
	@NotifyChange({ "flagIconCek", "flagIconWarning", "flagIconError", "msg","flagMsgFree" })
	public void msgWarningCustom(String msg1, String ex) {
		msg = Labels.getLabel(msg1)+" "+ex;
		flagIconWarning = true;
		flagIconCek = false;
		flagIconError = false;
		flagMsgFree = true;
		BindUtils.postNotifyChange(null, null, this, "flagIconCek");
		BindUtils.postNotifyChange(null, null, this, "flagIconError");
		BindUtils.postNotifyChange(null, null, this, "flagIconWarning");
		BindUtils.postNotifyChange(null, null, this, "msg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}
	
	@Command
	@NotifyChange({ "flagIconCek", "flagIconWarning", "flagIconError", "msg","flagMsgFree" })
	public void msgWarning(String msg1) {
		msg = Labels.getLabel(msg1);
		flagIconWarning = true;
		flagIconCek = false;
		flagIconError = false;
		flagMsgFree = true;
		BindUtils.postNotifyChange(null, null, this, "flagIconCek");
		BindUtils.postNotifyChange(null, null, this, "flagIconError");
		BindUtils.postNotifyChange(null, null, this, "flagIconWarning");
		BindUtils.postNotifyChange(null, null, this, "msg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}

	@Command
	@NotifyChange({ "flagIconCek", "flagIconWarning", "flagIconError", "msg", "flagMsgFree" })
	public void msgCek(String msg1) {
		msg = Labels.getLabel(msg1);
		flagIconWarning = false;
		flagIconCek = true;
		flagIconError = false;
		flagMsgFree = true;
		BindUtils.postNotifyChange(null, null, this, "flagIconCek");
		BindUtils.postNotifyChange(null, null, this, "flagIconError");
		BindUtils.postNotifyChange(null, null, this, "flagIconWarning");
		BindUtils.postNotifyChange(null, null, this, "msg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
		
	}
	
	@Command
	@NotifyChange({ "flagIconCek", "flagIconWarning", "flagIconError", "msg", "flagMsgFree" })
	public void msgCekCustom(String msg1, List<String> msg2, String msg3) {
		String pesan = "";
		int no=1;
		for(String m : msg2){
			if(no==1){
				pesan=m;
			}else{
				pesan = pesan+", "+m;
			}
			no++;
		}
		msg = Labels.getLabel(msg1)+". "+Labels.getLabel(msg3)+ " "+pesan;
		flagIconWarning = false;
		flagIconCek = true;
		flagIconError = false;
		flagMsgFree = true;
		BindUtils.postNotifyChange(null, null, this, "flagIconCek");
		BindUtils.postNotifyChange(null, null, this, "flagIconError");
		BindUtils.postNotifyChange(null, null, this, "flagIconWarning");
		BindUtils.postNotifyChange(null, null, this, "msg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
		
	}

	@Command
	@NotifyChange({ "flagIconCek", "flagIconError", "flagIconWarning", "msg","flagMsgFree" })
	public void msgError(String msg1) {
		msg = Labels.getLabel(msg1);
		flagIconWarning = false;
		flagIconCek = false;
		flagIconError = true;
		flagMsgFree = true;
		BindUtils.postNotifyChange(null, null, this, "flagIconCek");
		BindUtils.postNotifyChange(null, null, this, "flagIconError");
		BindUtils.postNotifyChange(null, null, this, "flagIconWarning");
		BindUtils.postNotifyChange(null, null, this, "msg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}
	
	@Command
	@NotifyChange({ "flagIconCek", "flagIconError", "flagIconWarning", "msg","flagMsgFree" })
	public void msgErrorCustom(String msg1, String ex) {
		msg = Labels.getLabel(msg1)+" "+ex;
		flagIconWarning = false;
		flagIconCek = false;
		flagIconError = true;
		flagMsgFree = true;
		BindUtils.postNotifyChange(null, null, this, "flagIconCek");
		BindUtils.postNotifyChange(null, null, this, "flagIconError");
		BindUtils.postNotifyChange(null, null, this, "flagIconWarning");
		BindUtils.postNotifyChange(null, null, this, "msg");
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}

	/* Start Button Paging */
	@Command
	public void firstPage() {
	}

	@Command
	public void prevPage() {
	}

	@Command
	public void nextPage() {
	}

	@Command
	public void lastPage() {
	}

	@Command
	public void searchPage() {
	}

	public void cekFlagDisabledPageMax() {
		if (getPageNumber() == getTotalPage()) {
			setFlagMaxPage(true);
		} else {
			setFlagMaxPage(false);
		}
	}

	public void cekFlagDisabledPageMin() {
		if (getPageNumber() == 1) {
			setFlagMinPage(true);
		} else {
			setFlagMinPage(false);
		}
		
	}

	/* End Button Paging */
	
	@Command
	@NotifyChange("pageSize")
	public void changeDisplayPage(){

	}
	
	@Command("showLov")
	public void showLov(
			@BindingParam("popup") String popup,
			@Default(StringConstants.LOV_HANDLER) @BindingParam(StringConstants.LOV_HANDLER) String globalHandleMethodName) {
		Map<String, Object> args = new HashMap<>();

		// put global command method name that will be invoked after user choose
		// data in LOV popup
		args.put(StringConstants.LOV_HANDLER, globalHandleMethodName);

		if (!beforeCallLov(args, popup))
			return;
		try {
			((Window) Executions.createComponents(popup, null, args)).doModal();
		} catch (UiException u) {
			u.printStackTrace();
		}
	}

	protected boolean beforeCallLov(Map<String, Object> args, String popup) {
		return true;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	// public int getActivePage() {
	// return activePage;
	// }
	//
	// public void setActivePage(int activePage) {
	// this.activePage = activePage;
	// loadList();
	// BindUtils.postNotifyChange(null, null, this, "activePage");
	// }

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

	public boolean isFlagActive() {
		return flagActive;
	}

	public void setFlagActive(boolean flagActive) {
		this.flagActive = flagActive;
	}

	public boolean isFlagMsg() {
		return flagMsg;
	}

	public void setFlagMsg(boolean flagMsg) {
		this.flagMsg = flagMsg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isFlagMsgAt() {
		return flagMsgAt;
	}

	public void setFlagMsgAt(boolean flagMsgAt) {
		this.flagMsgAt = flagMsgAt;
	}

	public boolean isFlagMsgInv() {
		return flagMsgInv;
	}

	public void setFlagMsgInv(boolean flagMsgInv) {
		this.flagMsgInv = flagMsgInv;
	}

	public boolean isFlagMsgInvPass() {
		return flagMsgInvPass;
	}

	public void setFlagMsgInvPass(boolean flagMsgInvPass) {
		this.flagMsgInvPass = flagMsgInvPass;
	}

	public boolean isFlagMsgAktif() {
		return flagMsgAktif;
	}

	public void setFlagMsgAktif(boolean flagMsgAktif) {
		this.flagMsgAktif = flagMsgAktif;
	}

	public boolean isFlagMsgNonAktif() {
		return flagMsgNonAktif;
	}

	public void setFlagMsgNonAktif(boolean flagMsgNonAktif) {
		this.flagMsgNonAktif = flagMsgNonAktif;
	}

	public boolean isFlagMsgInvNumber() {
		return flagMsgInvNumber;
	}

	public void setFlagMsgInvNumber(boolean flagMsgInvNumber) {
		this.flagMsgInvNumber = flagMsgInvNumber;
	}

	public boolean isFlagMsgDelete() {
		return flagMsgDelete;
	}

	public void setFlagMsgDelete(boolean flagMsgDelete) {
		this.flagMsgDelete = flagMsgDelete;
	}

	public String getMsgDelete() {
		return msgDelete = Labels.getLabel("E1007");
	}

	public void setMsgDelete(String msgDelete) {
		this.msgDelete = msgDelete;
	}

	public boolean isFlagMsgSuccessDelete() {
		return flagMsgSuccessDelete;
	}

	public void setFlagMsgSuccessDelete(boolean flagMsgSuccessDelete) {
		this.flagMsgSuccessDelete = flagMsgSuccessDelete;
	}

	public boolean isFlagMsgSubmitNoChange() {
		return flagMsgSubmitNoChange;
	}

	public void setFlagMsgSubmitNoChange(boolean flagMsgSubmitNoChange) {
		this.flagMsgSubmitNoChange = flagMsgSubmitNoChange;
	}

	public boolean isFlagMsgInvalidSizeFile() {
		return flagMsgInvalidSizeFile;
	}

	public void setFlagMsgInvalidSizeFile(boolean flagMsgInvalidSizeFile) {
		this.flagMsgInvalidSizeFile = flagMsgInvalidSizeFile;
	}

	public boolean isFlagMsgInvalidTypeFile() {
		return flagMsgInvalidTypeFile;
	}

	public void setFlagMsgInvalidTypeFile(boolean flagMsgInvalidTypeFile) {
		this.flagMsgInvalidTypeFile = flagMsgInvalidTypeFile;
	}

	public boolean isFlagIconCek() {
		return flagIconCek;
	}

	public void setFlagIconCek(boolean flagIconCek) {
		this.flagIconCek = flagIconCek;
	}

	public boolean isFlagIconWarning() {
		return flagIconWarning;
	}

	public void setFlagIconWarning(boolean flagIconWarning) {
		this.flagIconWarning = flagIconWarning;
	}

	public boolean isFlagIconError() {
		return flagIconError;
	}

	public void setFlagIconError(boolean flagIconError) {
		this.flagIconError = flagIconError;
	}

	public boolean isFlagMsgFree() {
		return flagMsgFree;
	}

	public void setFlagMsgFree(boolean flagMsgFree) {
		this.flagMsgFree = flagMsgFree;
	}

	public int getDefaultPageSize() {
		return defaultPageSize;
	}

	public void setDefaultPageSize(int defaultPageSize) {
		this.defaultPageSize = defaultPageSize;
	}

	
	

}
