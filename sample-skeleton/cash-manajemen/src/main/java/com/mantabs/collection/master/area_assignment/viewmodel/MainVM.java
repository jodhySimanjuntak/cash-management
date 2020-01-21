package com.mantabs.collection.master.area_assignment.viewmodel;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import com.mantabs.collection.master.area_assignment.model.MenuItem;
import com.mantabs.collection.master.area_assignment.model.Module;
import com.mantabs.collection.master.area_assignment.service.MasterMenuService;

import java.util.ArrayList;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MainVM extends SelectorComposer<Component> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @WireVariable
    MasterMenuService masterMenuService;


    private List<MenuItem> menuItems;
    private MenuItem selectedMenuItem;
    private String activePage="";
    private List<Module> moduleList;
    private Module selectedModule;
    private String includeSrc = "/pages/empty.zul";


    public MenuItem getSelectedMenuItem() {
//        System.out.println("+++++-------"+selectedMenuItem.getUri());
        return selectedMenuItem;
    }

    private String username="";

    public String getUsername() {
        username="admin";
        return username;
    }

    public String getActivePage() {
        return activePage.toUpperCase();
    }

    @NotifyChange
    public void setActivePage(String pageName) {
        activePage=pageName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    private void initModuleCombobox() {
        moduleList=new ArrayList<>();
        Module item=new Module("CM","cash management");
        moduleList.add(item);
        if (activePage.isEmpty()||activePage.equalsIgnoreCase(item.getValue())) {
            selectedModule = item;
            activePage=item.getValue();
        }
        
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public Module getSelectedModule() {
        return selectedModule;
    }

    @NotifyChange
    public void setSelectedModule(Module item) {
        selectedModule=item;
    }

    @Init
    public void MainVM() {
        initModuleCombobox();
//        System.out.println("active: "+activePage);
        menuItems = masterMenuService.listMenu(activePage);
        MenuItem a = new MenuItem("test", "test", "test", "/pages/empty.zul");
        this.selectedMenuItem = a;
        
    }

    @Command
    public void navigate(@BindingParam("page") MenuItem item) {
        this.selectedMenuItem = item;
//        System.out.println("---"+item.getUri());
        BindUtils.postNotifyChange(null,null,MainVM.this,"selectedMenuItem");
    }

    @Command
    public void logout() {
        Executions.sendRedirect("/logout");
    }

    @NotifyChange({"selectedMenuItem", "activePage","menuItems"})
    @Command
    public void changeModule() {
        activePage=selectedModule.getValue();
//        System.out.println("-------------ss-------"+activePage + "----"+selectedModule.getValue());
        menuItems = masterMenuService.listMenu(activePage);
        this.selectedMenuItem =menuItems.get(0).getChildren().get(0);
    }
}
