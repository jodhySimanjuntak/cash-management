package com.mantabs.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_MENU")
public class MasterMenu {
    @Id
    @Column(name = "ID_MENU")
    private Long id;

    @Column(name = "PAGE_NAME")
    private String pageName;

    @Column(name = "MODULE_NAME")
    private String moduleName;

    @Column(name = "PARENT_PAGE_NAME")
    private String parentPageName;

    @Column(name = "PAGE_TITLE")
    private String pageTitle;

    @Column(name = "URI")
    private String uri;

    @Column(name = "ORDER_NO")
    private int orderNo;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DT")
    private String createdByDatetime;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DT")
    private String modifiedDatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getParentPageName() {
        return parentPageName;
    }

    public void setParentPageName(String parentPageName) {
        this.parentPageName = parentPageName;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByDatetime() {
        return createdByDatetime;
    }

    public void setCreatedByDatetime(String createdByDatetime) {
        this.createdByDatetime = createdByDatetime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDatetime() {
        return modifiedDatetime;
    }

    public void setModifiedDatetime(String modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }
}
