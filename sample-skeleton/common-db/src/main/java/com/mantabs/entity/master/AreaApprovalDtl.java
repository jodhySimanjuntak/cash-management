package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_AREA_APPROVAL_DTL")
@IdClass(AreaApprovalDtlPK.class)
public class AreaApprovalDtl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SEQ_NO")
	private Integer seqNo;
	
	@Column(name = "AREA_APPROVAL")
	private String areaApproval;
	
	@Column(name = "CABANG")
	private String cabang;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private String createdDt;
	
	@Column(name = "END_DT")
	private String endDt;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DT")
	private String modifiedDt;

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getAreaApproval() {
		return areaApproval;
	}

	public void setAreaApproval(String areaApproval) {
		this.areaApproval = areaApproval;
	}

	public String getCabang() {
		return cabang;
	}

	public void setCabang(String cabang) {
		this.cabang = cabang;
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

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
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
