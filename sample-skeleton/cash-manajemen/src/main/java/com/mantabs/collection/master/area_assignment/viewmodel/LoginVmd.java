package com.mantabs.collection.master.area_assignment.viewmodel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import com.mantabs.collection.master.area_assignment.dto.CMSMenuDto;
import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;
import com.mantabs.collection.master.area_assignment.service.LoginSvc;
import com.mantabs.collection.master.area_assignment.service.MenuSvc;
import com.mantabs.entity.master.CMSMenu;
import com.mantabs.entity.master.CMSUser;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LoginVmd extends BaseVmd {

	private String username = "";
	private String password = "";
	int maxWrong;
	int adminRole;
	Date today;

	@WireVariable
	LoginSvc loginSvc;

	@WireVariable
	MenuSvc menuSvc;
//
//	@WireVariable
//	MGlobalImageSvc mGlobalImageSvc;
//
//	@WireVariable
//	PegPersonalDataSvc pegPersonalDataSvc;
//	
//	@WireVariable
//	PegDataChangeRequestSvc pegDataChangeRequestSvc;

	@Init
	public void load() {
		setFlagMsgFree(false);
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}

	@Command("login")
	@NotifyChange({ "username", "password" })
	public void login() throws IOException {
//		setFlagMsgFree(false);
		if (username.trim().length() > 0 || password.trim().length() > 0) {
			if (username.trim().length() > 0) {
				if (password.trim().length() > 0) {
					
					CMSUser user1 = loginSvc.login(getUsername());
					CMSUser userPass = loginSvc.loginPass(getUsername(), getPassword());

					if (user1 != null) {
						if (userPass != null) {
							List<CMSMenuDto> menu = menuSvc.menu();
							CMSUserDto um = new CMSUserDto(user1);

							um.setMenuList(menu);
							
							Sessions.getCurrent().setAttribute("user",
									um);
							Executions.sendRedirect("/pages/index.zul");

						} else {
//							msgError("E1014");
							Messagebox.show("Username atau Password salah.");
						}
					} else {
//						msgError("E1013");
						Messagebox.show("Username tidak terdaftar.");
					}

				} else {
//					msgError("E1014");
					Messagebox.show("Username atau Password salah.");
				}
			} else {
//				msgError("E1015");
				Messagebox.show("Silahkan, Isi Username dan Password terlebih dahulu.");
			}
		} else

		{
//			msgError("E1015");
			Messagebox.show("Silahkan, Isi Username dan Password terlebih dahulu.");
		}
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}

	@Command
	public void OK() {
		setFlagMsgFree(false);
		BindUtils.postNotifyChange(null, null, this, "flagMsgFree");
	}

	public String getUsername() {
		return username == null ? "" : username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password == null ? "" : password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
