package com.mantabs.collection.master.area_assignment.viewmodel;

import java.io.IOException;
import java.util.Map;


import javax.servlet.http.HttpServletResponse;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zk.ui.util.Initiator;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LogoutVmd extends org.zkoss.zk.ui.util.GenericInitiator implements Initiator{

	@Init
	public void load(){
		Sessions.getCurrent().removeAttribute("user");
	}
}
