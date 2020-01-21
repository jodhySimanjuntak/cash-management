package com.mantabs.collection.master.area_assignment.viewmodel;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;

import com.mantabs.collection.master.area_assignment.dto.UserMenu;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AdminController extends SelectorComposer<Component> implements
		Serializable {

	private static final long serialVersionUID = 7010841483291616467L;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	List<UserMenu> listMenu = new ArrayList<>();
	// UserMenu dto = new UserMenu();
	private String nama;
	private String url;
	private String namaFile;
	String[] menu = new String[] { "Sports", "Life Style", "Tips And Trick" };
	String[] route = new String[] { "/admin/sport_admin.zul",
			"/admin/lifestyle_admin.zul", "/admin/tipstrick_admin.zul" };

	@Init
	@NotifyChange({ "listMenu", "dto" })
	public void load() {
		for (int i = 0; i < menu.length; i++) {
			UserMenu dto = new UserMenu();
			dto.setMenuTitle(menu[i]);
			dto.setMenuUrl(route[i]);
			listMenu.add(dto);
		}

		System.out.println("jumlah list  : " + listMenu.size());
		BindUtils.postNotifyChange(null, null, this, "listMenu");
	}

	@Command("selectMenu")
	public void selectMenu(@BindingParam("data") UserMenu data) {
		setUrl(data.getMenuUrl());
		BindUtils.postNotifyChange(null, null, this, "url");
		System.out.println("URL : " + url);

	}

	@Command("logout")
	public void logout() throws NoSuchAlgorithmException {
		Executions.sendRedirect("/pages/login.zul");

	}

	@Command("saveSport")
	public void saveSport() throws NoSuchAlgorithmException {
		Messagebox.show("Yakin Untuk Menyimpan?", "Question", Messagebox.OK
				| Messagebox.CANCEL, Messagebox.QUESTION,
				new org.zkoss.zk.ui.event.EventListener() {

					@Override
					public void onEvent(Event evt) {
						// TODO Auto-generated method stub
						if (Messagebox.ON_OK.equals(evt.getName())) {
							Messagebox.show("Data Tersimpan");
						} else {

						}
					}

				});
	}

	@Command("saveLifeStyle")
	public void saveLifeStyle() throws NoSuchAlgorithmException {
		Messagebox.show("Yakin Untuk Menyimpan?", "Question", Messagebox.OK
				| Messagebox.CANCEL, Messagebox.QUESTION,
				new org.zkoss.zk.ui.event.EventListener() {

					@Override
					public void onEvent(Event evt) {
						// TODO Auto-generated method stub
						if (Messagebox.ON_OK.equals(evt.getName())) {
							Messagebox.show("Data Tersimpan");
						} else {

						}
					}

				});
	}

	@Command("saveTipsTrick")
	public void saveTipsTrick() throws NoSuchAlgorithmException {
		Messagebox.show("Yakin Untuk Menyimpan?", "Question", Messagebox.OK
				| Messagebox.CANCEL, Messagebox.QUESTION,
				new org.zkoss.zk.ui.event.EventListener() {

					@Override
					public void onEvent(Event evt) {
						// TODO Auto-generated method stub
						if (Messagebox.ON_OK.equals(evt.getName())) {
							Messagebox.show("Data Tersimpan");
						} else {

						}
					}

				});
	}

	@Command
	@NotifyChange({ "fileuploaded", "namaFile", "sportEvent", "byteImage",
			"fileUpload", "media" })
	public void uploadSportImg(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
			throws IOException {
		try {
			UploadEvent upEvent = (UploadEvent) ctx.getTriggerEvent();
			Media media = upEvent.getMedia();

			if (media.getFormat().equals("jpg")
					|| media.getFormat().equals("jpeg")
					|| media.getFormat().equals("png")) {

				if ((media.getByteData().length / 1024) > 4096) {
					// msgError("E1028");
					Messagebox.show("Ukuran File Terlalu Besar");
				} else {
					String fileName = upEvent.getMedia().getName();
					// namaFile = fileName;
					setNamaFile(fileName);
					// pegFamilyMemberDto.setNamaFile(media.getName());
					//
					// pegFamilyMemberDto.setAttachment1(media.getByteData());
					// fileUpload = pegFamilyMemberDto.getAttachment1();
					System.out.println("BYTE ARRAY = " + media.getByteData());
				}
			} else {
				// msgError("E1029");
				Messagebox.show("Format File Salah");
			}

			System.out.println("Nama File " + namaFile);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		BindUtils.postNotifyChange(null, null, this, "namaFile");
	}

	@Command
	@NotifyChange({ "fileuploaded", "namaFile", "eventLifeStyle", "byteImage",
			"fileUpload", "media" })
	public void uploadLifeStyleImg(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
			throws IOException {
		try {
			UploadEvent upEvent = (UploadEvent) ctx.getTriggerEvent();
			Media media = upEvent.getMedia();

			if (media.getFormat().equals("jpg")
					|| media.getFormat().equals("jpeg")
					|| media.getFormat().equals("png")) {

				if ((media.getByteData().length / 1024) > 4096) {
					// msgError("E1028");
					Messagebox.show("Ukuran File Terlalu Besar");
				} else {
					String fileName = upEvent.getMedia().getName();
					// namaFile = fileName;
					setNamaFile(fileName);
					// pegFamilyMemberDto.setNamaFile(media.getName());
					//
					// pegFamilyMemberDto.setAttachment1(media.getByteData());
					// fileUpload = pegFamilyMemberDto.getAttachment1();
					System.out.println("BYTE ARRAY = " + media.getByteData());
				}
			} else {
				// msgError("E1029");
				Messagebox.show("Format File Salah");
			}

			System.out.println("Nama File " + namaFile);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		BindUtils.postNotifyChange(null, null, this, "namaFile");
	}

	@Command
	@NotifyChange({ "fileuploaded", "namaFile", "eventTipsTrick", "byteImage",
			"fileUpload", "media" })
	public void uploadTipsTrickImg(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
			throws IOException {
		try {
			UploadEvent upEvent = (UploadEvent) ctx.getTriggerEvent();
			Media media = upEvent.getMedia();

			if (media.getFormat().equals("jpg")
					|| media.getFormat().equals("jpeg")
					|| media.getFormat().equals("png")) {

				if ((media.getByteData().length / 1024) > 4096) {
					// msgError("E1028");
					Messagebox.show("Ukuran File Terlalu Besar");
				} else {
					String fileName = upEvent.getMedia().getName();
					// namaFile = fileName;
					setNamaFile(fileName);
					// pegFamilyMemberDto.setNamaFile(media.getName());
					//
					// pegFamilyMemberDto.setAttachment1(media.getByteData());
					// fileUpload = pegFamilyMemberDto.getAttachment1();
					System.out.println("BYTE ARRAY = " + media.getByteData());
				}
			} else {
				// msgError("E1029");
				Messagebox.show("Format File Salah");
			}

			System.out.println("Nama File " + namaFile);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		BindUtils.postNotifyChange(null, null, this, "namaFile");
	}

	public List<UserMenu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<UserMenu> listMenu) {
		this.listMenu = listMenu;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNamaFile() {
		return namaFile;
	}

	public void setNamaFile(String namaFile) {
		this.namaFile = namaFile;
	}

}
