package com.mantabs.entity.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_GROUP_APPROVAL_HDR")
@IdClass(GroupApprovalHdrPK.class)
public class GroupApprovalHdr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_GROUP_APPROVAL")
	private String kodeGroupApproval;
	
	@Id
	@Column(name = "KATEGORI_BIAYA")
	private String kategoriBiaya;
	
	@Id
	@Column(name = "SUB_KATEGORI")
	private String subKategori;
	
	@Id
	@Column(name = "JENIS_BIAYA")
	private String jenisBiaya;
	
	@Column(name = "GROUP_APPROVAL")
	private String groupApproval;
	
	@Column(name = "BUDGET")
	private String budget;
	
	@Column(name = "INISIATOR")
	private String inisiator;
	
	@Column(name = "TINGKAT_JABATAN")
	private String tingkatJabatan;

	@Column(name = "START_RANGE_PENGAJUAN")
	private BigDecimal startRangePengajuan;
	
	@Column(name = "END_RANGE_PENGAJUAN")
	private BigDecimal endRangePengajuan;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "BRANCH_ID")
	private String branchId;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "END_DT")
	private Date endDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Id
	@Column(name = "ID_NO")
	private String idNo;
	
	@Column(name = "MODIFIED_DT")
	private Date modofiedDt;

	public String getKodeGroupApproval() {
		return kodeGroupApproval;
	}

	public void setKodeGroupApproval(String kodeGroupApproval) {
		this.kodeGroupApproval = kodeGroupApproval;
	}

	public String getKategoriBiaya() {
		return kategoriBiaya;
	}

	public void setKategoriBiaya(String kategoriBiaya) {
		this.kategoriBiaya = kategoriBiaya;
	}

	public String getGroupApproval() {
		return groupApproval;
	}

	public void setGroupApproval(String groupApproval) {
		this.groupApproval = groupApproval;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getInisiator() {
		return inisiator;
	}

	public void setInisiator(String inisiator) {
		this.inisiator = inisiator;
	}

	public String getTingkatJabatan() {
		return tingkatJabatan;
	}

	public void setTingkatJabatan(String tingkatJabatan) {
		this.tingkatJabatan = tingkatJabatan;
	}

	public BigDecimal getStartRangePengajuan() {
		return startRangePengajuan;
	}

	public void setStartRangePengajuan(BigDecimal startRangePengajuan) {
		this.startRangePengajuan = startRangePengajuan;
	}

	public BigDecimal getEndRangePengajuan() {
		return endRangePengajuan;
	}

	public void setEndRangePengajuan(BigDecimal endRangePengajuan) {
		this.endRangePengajuan = endRangePengajuan;
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

	public Date getModofiedDt() {
		return modofiedDt;
	}

	public void setModofiedDt(Date modofiedDt) {
		this.modofiedDt = modofiedDt;
	}

	public String getSubKategori() {
		return subKategori;
	}

	public void setSubKategori(String subKategori) {
		this.subKategori = subKategori;
	}

	public String getJenisBiaya() {
		return jenisBiaya;
	}

	public void setJenisBiaya(String jenisBiaya) {
		this.jenisBiaya = jenisBiaya;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	
	
	
	
}
