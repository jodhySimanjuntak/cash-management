package com.mantabs.collection.master.area_assignment.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LjpVM extends SelectorComposer<Component> {
	
	private static final long serialVersionUID = 1L;
	
	private boolean lpj = true;
	private boolean detailLpj = false;

	
	
	
	
	
	
	@Init
	@NotifyChange({ "" })
	public void MainVM() {
		
	}
	
	
	@Command("addLpj")
	@NotifyChange({"detailLpj","lpj"})
	public void addLpj () {
		detailLpj = true;
		lpj = false;
	}
	
	
	@Command("saveLpj")
	@NotifyChange({"detailLpj","lpj"})
	public void saveLpj () {
		detailLpj = false;
		lpj = true;
	}
	
	@Command("batalLpj")
	@NotifyChange({"detailLpj","lpj"})
	public void batalLpj () {
		detailLpj = false;
		lpj = true;
	}
	
	
	

	public boolean isLpj() {
		return lpj;
	}


	public void setLpj(boolean lpj) {
		this.lpj = lpj;
	}


	public boolean isDetailLpj() {
		return detailLpj;
	}


	public void setDetailLpj(boolean detailLpj) {
		this.detailLpj = detailLpj;
	}
	
	
	
	
}
