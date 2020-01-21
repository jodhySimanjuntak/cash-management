package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_KATEGORI_BIAYA")
public class KategoriBiaya implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_KATEGORI_BIAYA")
	private String kodeKategoriBiaya;
	
	@Column(name = "KATEGORI_BIAYA")
	private String kategoriBiaya;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "END_DT")
	private Date endDate;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;

	public String getKodeKategoriBiaya() {
		return kodeKategoriBiaya;
	}

	public void setKodeKategoriBiaya(String kodeKategoriBiaya) {
		this.kodeKategoriBiaya = kodeKategoriBiaya;
	}

	public String getKategoriBiaya() {
		return kategoriBiaya;
	}

	public void setKategoriBiaya(String kategoriBiaya) {
		this.kategoriBiaya = kategoriBiaya;
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

	public Date getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	
	

}
