package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_GROUP_APPROVAL_DTL")
@IdClass(GroupApprovalDtlPK.class)
public class GroupApprovalDtl implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SEQ_NO")
	private Integer seqNo;
	
	@Id
	@Column(name = "GROUP_APPROVAL")
	private String groupApproval;
	
	@Column(name = "JABATAN")
	private String jabatan;
	
	@Column(name = "LEVEL_JABATAN")
	private String levelJabatan;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private Date craetedDt;
	
	@Column(name = "END_DT")
	private Date endDate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;
	
	@Column(name = "ID_NO")
	private String idNo;
	

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getGroupApproval() {
		return groupApproval;
	}

	public void setGroupApproval(String groupApproval) {
		this.groupApproval = groupApproval;
	}

	public String getLevelJabatan() {
		return levelJabatan;
	}

	public void setLevelJabatan(String levelJabatan) {
		this.levelJabatan = levelJabatan;
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

	public Date getCraetedDt() {
		return craetedDt;
	}

	public void setCraetedDt(Date craetedDt) {
		this.craetedDt = craetedDt;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	
	
	
}
