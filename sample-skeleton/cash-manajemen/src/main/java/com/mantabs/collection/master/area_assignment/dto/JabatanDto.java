package com.mantabs.collection.master.area_assignment.dto;

import java.util.Date;


public class JabatanDto {

	private String idJabatan;
	private String namaJabatan;
	private Integer status;
	private Date createdDt;
	private String createdBy;
	private Date modifiedDt;
	private String modifiedBy;
	private Date endDt;
	public String getIdJabatan() {
		return idJabatan;
	}
	public void setIdJabatan(String idJabatan) {
		this.idJabatan = idJabatan;
	}
	public String getNamaJabatan() {
		return namaJabatan;
	}
	public void setNamaJabatan(String namaJabatan) {
		this.namaJabatan = namaJabatan;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getEndDt() {
		return endDt;
	}
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	
	
	
}
