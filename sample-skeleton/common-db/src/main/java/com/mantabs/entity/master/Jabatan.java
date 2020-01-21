package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_JABATAN")
public class Jabatan implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_JABATAN")
	private String idJabatan;
	
	@Column(name = "NAMA_JABATAN")
	private String namaJabatan;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "END_DT")
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
