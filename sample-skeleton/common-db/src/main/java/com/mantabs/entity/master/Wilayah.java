package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_WILAYAH")
public class Wilayah implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_WILAYAH")
	private String idWilayah;

	@Column(name = "NAMA_WILAYAH")
	private String namaWilayah;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_DT")
	private Date createdDt;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "END_DT")
	private String endDt;

	@Column(name = "ID_KARYAWAN")
	private String idKaryawan;

	@Column(name = "PIC_WILAYAH_OPR")
	private String picWilayahOpr;

	@Column(name = "PIC_WILAYAH_MKT")
	private String picWilayahMkt;

	@Column(name = "PIC_REG_MKT")
	private String picRegMkt;

	@Column(name = "PIC_REG_OPR")
	private String picRegOpr;

	public String getIdWilayah() {
		return idWilayah;
	}

	public void setIdWilayah(String idWilayah) {
		this.idWilayah = idWilayah;
	}

	public String getNamaWilayah() {
		return namaWilayah;
	}

	public void setNamaWilayah(String namaWilayah) {
		this.namaWilayah = namaWilayah;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(String idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getPicWilayahOpr() {
		return picWilayahOpr;
	}

	public void setPicWilayahOpr(String picWilayahOpr) {
		this.picWilayahOpr = picWilayahOpr;
	}

	public String getPicWilayahMkt() {
		return picWilayahMkt;
	}

	public void setPicWilayahMkt(String picWilayahMkt) {
		this.picWilayahMkt = picWilayahMkt;
	}

	public String getPicRegMkt() {
		return picRegMkt;
	}

	public void setPicRegMkt(String picRegMkt) {
		this.picRegMkt = picRegMkt;
	}

	public String getPicRegOpr() {
		return picRegOpr;
	}

	public void setPicRegOpr(String picRegOpr) {
		this.picRegOpr = picRegOpr;
	}

}
