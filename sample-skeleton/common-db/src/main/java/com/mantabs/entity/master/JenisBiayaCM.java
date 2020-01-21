package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_JENIS_BIAYA_CM")
@IdClass(JenisBiayaCMPK.class)
public class JenisBiayaCM implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "SUB_KATEGORI")
	private String subKategori;
	
	@Id
	@Column(name = "KATEGORI_BIAYA")
	private String kategoriBiaya;
	
	@Id
	@Column(name = "ID_JENIS_BIAYA")
	private String kodeJenisBiaya;
	
	@Column(name = "JENIS_BIAYA")
	private String jenisBiaya;
	
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

	public String getSubKategori() {
		return subKategori;
	}

	public void setSubKategori(String subKategori) {
		this.subKategori = subKategori;
	}

	public String getKategoriBiaya() {
		return kategoriBiaya;
	}

	public void setKategoriBiaya(String kategoriBiaya) {
		this.kategoriBiaya = kategoriBiaya;
	}

	public String getKodeJenisBiaya() {
		return kodeJenisBiaya;
	}

	public void setKodeJenisBiaya(String kodeJenisBiaya) {
		this.kodeJenisBiaya = kodeJenisBiaya;
	}

	public String getJenisBiaya() {
		return jenisBiaya;
	}

	public void setJenisBiaya(String jenisBiaya) {
		this.jenisBiaya = jenisBiaya;
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
