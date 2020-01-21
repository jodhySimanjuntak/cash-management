package com.mantabs.entity.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_GLOBAL_PARAM")
@IdClass(GlobalParamPK.class)
public class GlobalParam implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ID_CONDITION")
	private String idCondition;
	
	@Id
	@Column(name = "ID_PARAM")
	private String idParam;
	
	@Column(name = "NAMA_PARAM")
	private String namaParam;
	
	@Column(name = "CHAR_VALUES")
	private String charValues;
	
	@Column(name = "DATE_VALUES")
	private Date dateValues;
	
	@Column(name = "DATE_TO")
	private Date dateTo;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	public String getIdCondition() {
		return idCondition;
	}

	public void setIdCondition(String idCondition) {
		this.idCondition = idCondition;
	}

	public String getIdParam() {
		return idParam;
	}

	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}

	public String getNamaParam() {
		return namaParam;
	}

	public void setNamaParam(String namaParam) {
		this.namaParam = namaParam;
	}


	public String getCharValues() {
		return charValues;
	}

	public void setCharValues(String charValues) {
		this.charValues = charValues;
	}

	public Date getDateValues() {
		return dateValues;
	}

	public void setDateValues(Date dateValues) {
		this.dateValues = dateValues;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
	
	
	
	

}
