package com.mantabs.collection.master.area_assignment.viewmodel;

//import id.co.indocyber.spFactoryCms.tools.RestResponse;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;

import com.mantabs.collection.master.area_assignment.dto.CMSUserDto;

public class CekLogoutVmd extends org.zkoss.zk.ui.util.GenericInitiator implements Initiator {

	public void doInit(Page arg0, Map<String, Object> arg1) throws IOException {
		CMSUserDto user = (CMSUserDto) Sessions.getCurrent().getAttribute("user");
		Sessions.getCurrent().removeAttribute("user");
		Session sess = Sessions.getCurrent();

		Executions.sendRedirect("/pages/login.zul");

	}
}
