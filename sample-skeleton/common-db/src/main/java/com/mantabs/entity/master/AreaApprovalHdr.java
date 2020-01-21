package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_AREA_APPROVAL_HDR")
@IdClass(AreaApprovalHdrPK.class)
public class AreaApprovalHdr implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "KODE_AREA_APPROVAL")
	private String kodeAreaApproval;
	
	@Id
	@Column(name = "GROUP_APPROVAL")
	private String groupApproval;
	
	@Column(name = "INISIATOR")
	private String inisiator;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "END_DT")
	private Date endDt;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DT")
	private String modifiedDt;

	public String getKodeAreaApproval() {
		return kodeAreaApproval;
	}

	public void setKodeAreaApproval(String kodeAreaApproval) {
		this.kodeAreaApproval = kodeAreaApproval;
	}

	public String getGroupApproval() {
		return groupApproval;
	}

	public void setGroupApproval(String groupApproval) {
		this.groupApproval = groupApproval;
	}

	public String getInisiator() {
		return inisiator;
	}

	public void setInisiator(String inisiator) {
		this.inisiator = inisiator;
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

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(String modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	
	
}
