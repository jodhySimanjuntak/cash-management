package com.mantabs.collection.master.area_assignment.viewmodel;

//import id.co.indocyber.spFactoryCms.dto.TbMUserDto;
//import id.co.indocyber.spFactoryCms.entity.TbMCompany;
//import id.co.indocyber.spFactoryCms.service.TbMCompanySvc;
//import id.co.indocyber.spFactoryCms.service.TbMRoleHSvc;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class BannerVmd extends BaseVmd {
	private final String url = "/userManagement/customer/index.zul";
	private final String urlTransfer = "/userManagement/transferData/index.zul";
	private final String urlPermintaan = "/userManagement/permintaan_perubahan_data/index.zul";


	private Date hariIni;
	private String tglini;
	private String username;
	private String role;
	private String position;
//	private String user;
	private String name;
	private String companyName;
	private String image;
	private boolean flagAdm = false;
	private String notifTransfer;
	private String notifPermintaan;
	private String jmlNotifP;
	private String jmlNotifT;
	private boolean flagNotifP;
	private boolean flagNotifT;
	private String companyCode;
	private String personelArea;
	private String subArea;
	private String userLogin="";
	CMSUserDto user = new CMSUserDto();

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getPersonelArea() {
		return personelArea;
	}

	public void setPersonelArea(String personelArea) {
		this.personelArea = personelArea;
	}
	
	

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getSubArea() {
		return subArea;
	}

	public void setSubArea(String subArea) {
		this.subArea = subArea;
	}

	public boolean isFlagNotifT() {
		return flagNotifT;
	}

	public void setFlagNotifT(boolean flagNotifT) {
		this.flagNotifT = flagNotifT;
	}

	public boolean isFlagNotifP() {
		return flagNotifP;
	}

	public void setFlagNotifP(boolean flagNotifP) {
		this.flagNotifP = flagNotifP;
	}

	public String getJmlNotifP() {
		return jmlNotifP;
	}

	public void setJmlNotifP(String jmlNotifP) {
		this.jmlNotifP = jmlNotifP;
	}

	public String getJmlNotifT() {
		return jmlNotifT;
	}

	public void setJmlNotifT(String jmlNotifT) {
		this.jmlNotifT = jmlNotifT;
	}

	public String getNotifTransfer() {
		return notifTransfer;
	}

	public void setNotifTransfer(String notifTransfer) {
		this.notifTransfer = notifTransfer;
	}

	public String getNotifPermintaan() {
		return notifPermintaan;
	}

	public void setNotifPermintaan(String notifPermintaan) {
		this.notifPermintaan = notifPermintaan;
	}

	public boolean isFlagAdm() {
		return flagAdm;
	}

	public void setFlagAdm(boolean flagAdm) {
		this.flagAdm = flagAdm;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTglini() {
		return tglini;
	}

	public void setTglini(String tglini) {
		this.tglini = tglini;
	}

	public Date getHariIni() {
		return hariIni;
	}

	public void setHariIni(Date hariIni) {
		this.hariIni = hariIni;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Init
	@NotifyChange({ "flagNotifP", "flagNotifT", "companyCode", "personelArea",
			"subArea","userLogin" })
	public void load() throws IOException {
		
		user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");
		
		if (user != null) {
			setUserLogin(user.getName());
		} else {
			Executions.getCurrent().sendRedirect("/pages/login.zul");
		}
		
		
		
//		userDto = (TbMUserDto) Sessions.getCurrent().getAttribute("user");
//
//		if (userDto != null)
//			if (userDto.getRole().size() > 0) {
//				// for (TbMRoleDDto r : userDto.getRole()) {
//				// if (r.isAdmin()) {
//				// name = "Administrator";
//				// flagAdm = true;
//				// }
//				// }
//				for (TbMRoleDDto r : userDto.getRole()) {
//					if (r.isAdmin()) {
//						name = "Administrator";
//						flagAdm = true;
//						if (userDto.getPersonelArea().equals("1000")) {
//							companyCode = "";
//							personelArea = "";
//							subArea = "";
//						} else {
//							if (userDto.getSubArea().equals("0001")) {
//								companyCode = userDto.getCompanyCode();
//								personelArea = userDto.getPersonelArea();
//								subArea = "";
//							} else {
//								if (userDto.getSubArea().substring(2)
//										.equals("00")) {
//									companyCode = userDto.getCompanyCode();
//									personelArea = userDto.getPersonelArea();
//									subArea = userDto.getSubArea().substring(0,
//											2);
//								} else {
//									companyCode = userDto.getCompanyCode();
//									personelArea = userDto.getPersonelArea();
//									subArea = userDto.getSubArea();
//								}
//							}
//						}
//						int notifP = pegDataChangeRequestSvc.count(companyCode,
//								personelArea, subArea);
//						int notifT = pegDataChangeRequestSvc.countTransfer(
//								companyCode, personelArea, subArea);
//						jmlNotifP = String.valueOf(notifP);
//						jmlNotifT = String.valueOf(notifT);
//						flagNotifP = true;
//						if (notifP == 0) {
//							flagNotifP = false;
//						}
//						flagNotifT = true;
//						if (notifT == 0) {
//							flagNotifT = false;
//						}
//					}
//				}
//
//			}
//
//		if (userDto != null) {
//			for (UserMenu m : userDto.getMenuList()) {
//				if (m.getMenuCode().equals("0103000")) {
//					notifTransfer = m.getMenuDisplayName();
//				}
//				if (m.getMenuCode().equals("0102000")) {
//					notifPermintaan = m.getMenuDisplayName();
//				}
//			}
//		}
//		MGlobalImageDto dto = mGlobalImageSvc.findOne("IMG001");
//		if (userDto == null) {
//			userDto = new TbMUserDto();
//			userDto.setPhoto(dto.getParmImgValue());
//			if (Sessions.getCurrent().getAttribute("user") != null) {
//				Executions.sendRedirect("/logout.zul");
//			}
//		} else {
//			PegPersonalDataDto personalData = pegPersonalDataSvc.dto(userDto
//					.getReferenceCode());
//			if (personalData != null) {
//				if (personalData.getPhoto() == null) {
//					personalData.setPhoto(dto.getParmImgValue());
//					InputStream in = new ByteArrayInputStream(
//							personalData.getPhoto());
//					BufferedImage bImageFromConvert = ImageIO.read(in);
//
//					BufferedImage outputImage;
//					int min = 0;
//					if (bImageFromConvert.getWidth() > bImageFromConvert
//							.getHeight())
//						min = bImageFromConvert.getHeight();
//					else
//						min = bImageFromConvert.getWidth();
//
//					outputImage = Thumbnails.of(bImageFromConvert)
//							.sourceRegion(Positions.TOP_CENTER, min, min)
//							.size(120, 120).asBufferedImage();
//
//					ByteArrayOutputStream baos = new ByteArrayOutputStream();
//					ImageIO.write(outputImage, "png", baos);
//					baos.flush();
//					byte[] img = baos.toByteArray();
//					baos.close();
//
//					userDto.setPhoto(img);
//
//				} else {
//					InputStream in = new ByteArrayInputStream(
//							personalData.getPhoto());
//					ByteArrayInputStream bais = new ByteArrayInputStream(
//							personalData.getPhoto());
//					BufferedImage bImageFromConvert = ImageIO.read(bais);
//
//					BufferedImage outputImage;
//					int min = 0;
//					if (bImageFromConvert.getWidth() > bImageFromConvert
//							.getHeight())
//						min = bImageFromConvert.getHeight();
//					else
//						min = bImageFromConvert.getWidth();
//
//					outputImage = Thumbnails.of(bImageFromConvert)
//							.sourceRegion(Positions.TOP_CENTER, min, min)
//							.size(120, 120).asBufferedImage();
//
//					ByteArrayOutputStream baos = new ByteArrayOutputStream();
//					ImageIO.write(outputImage, "png", baos);
//					baos.flush();
//					byte[] img = baos.toByteArray();
//					baos.close();
//
//					userDto.setPhoto(img);
//
//				}
//			}
//		}

		// if(userDto!=null){
		// if(userDto.getPhoto()==null){
		// userDto.setPhoto(dto.getParmImgValue());
		// }else{
		// userDto.setPhoto(dto.getParmImgValue());
		// }
		// }else{
		// userDto = new TbMUserDto();
		// userDto.setPhoto(dto.getParmImgValue());
		// }
		// if(userDto.get)
		// hariIni = new Date();
		// SimpleDateFormat obDateFormat = new SimpleDateFormat(
		// "EEEE, dd MMM yyyy HH:mm:ss");
		// tglini = " " + obDateFormat.format(hariIni.getTime()) + " ";
		// if (Sessions.getCurrent().getAttribute("user") != null) {
		// TbMUserDto user1 = (TbMUserDto) Sessions.getCurrent().getAttribute(
		// "user");
		// TbMCompany thisCompany = tbMCompanySvc
		// .findOne(user1.getIdCompany());
		// // DsfMstUser2Dto user1 = (DsfMstUser2Dto)
		// // Sessions.getCurrent().getAttribute("user");
		// username = user1.getUserName();
		// position = tbMRoleHSvc.findOneRole(user1.getIdRole()).getRoleName();
		//
		// companyName = thisCompany.getName();
		// image =
		// StringUtils.isEmpty(user1.getImageDataPath())?"/res/button_profile.png":user1.getImageDataPath();
		// Sessions.getCurrent().setAttribute("superAdmin",
		// thisCompany.getSuperAdmin());
		// // posisi = dsfMstPositionSvc.selectById(position);
		// }
		/*
		 * try{ if((Boolean) Sessions.getCurrent().getAttribute("isChangePass")
		 * == true){ Messagebox.show("Mohon segera mengganti password!", new
		 * Button[] { Button.OK }, new EventListener<Messagebox.ClickEvent>() {
		 * 
		 * @Override public void onEvent(ClickEvent event)throws Exception {
		 * changePass(); } }); } } catch(Exception e){
		 * Executions.sendRedirect("/login.zul"); }
		 */
	}

	

	@Command
	public void profil() {
//		TbMUserDto user = (TbMUserDto) Sessions.getCurrent().getAttribute(
//				"user");
//		Sessions.getCurrent().setAttribute("user", user);
//		navigate(url);
	}

	@Command
	public void toTransfer() {
		navigate(urlTransfer);
	}

	@Command
	public void toPermintaan() {
		navigate(urlPermintaan);
	}

	@Command("logout")
	public void logout() throws IOException {
		Executions.getCurrent().sendRedirect("/pages/logout.zul");

	}

	@Command("updateTime")
	@NotifyChange("tglini")
	public void updateTime() {
		hariIni = new Date();
		SimpleDateFormat obDateFormat = new SimpleDateFormat(
				"EEEE, dd MMM yyyy HH:mm:ss");
		tglini = " " + obDateFormat.format(hariIni.getTime()) + " ";
	}

	@Command("changePass")
	public void changePass() {
		navigate("/userManagement/user/changePass.zul");
	}

	@Command("toCompany")
	public void toCompany() {
		navigate("");
	}

	public static BufferedImage crop(BufferedImage src, int width, int height)
			throws IOException {
		int x = src.getWidth() / 2 - width / 2;
		int y = src.getHeight() / 2 - height / 2;

		// System.out.println("---" + src.getWidth() + " - " + src.getHeight() +
		// " - " + x + " - " + y);

		BufferedImage clipping = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);// src.getType());
		Graphics2D area = (Graphics2D) clipping.getGraphics().create();
		area.drawImage(src, 0, 0, clipping.getWidth(), clipping.getHeight(), x,
				y, x + clipping.getWidth(), y + clipping.getHeight(), null);
		area.dispose();

		return clipping;
	}

}
