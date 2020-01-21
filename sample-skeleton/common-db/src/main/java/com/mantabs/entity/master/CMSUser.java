package com.mantabs.entity.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_CMS.MF_USER")
public class CMSUser {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "DELETED")
	private int deleted;
	
	@Column(name = "DELETED_AT")
	private Date deletedAt;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FULLNAME")
	private String fullname;
	
	@Column(name = "IS_ACTIVE")
	private int isActive;
	
	@Column(name = "LOCALDB")
	private Integer localdb;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "UTYPE")
	private String utype;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	
	@Column(name = "CABANG_ID")
	private String cabangId;
	
	@Column(name = "WILAYAH_ID")
	private String wilayahId;
	
	@Column(name = "REGIONAL_ID")
	private String regionalId;
	
	@Column(name = "BRANCH_ID")
	private Integer branchId;
	
	@Column(name = "DISTRICT_ID")
	private Integer districtId;
	
	@Column(name = "CENTRO_ID")
	private String centroId;
	
	@Column(name = "PASSWORD")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Integer getLocaldb() {
		return localdb;
	}

	public void setLocaldb(Integer localdb) {
		this.localdb = localdb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCabangId() {
		return cabangId;
	}

	public void setCabangId(String cabangId) {
		this.cabangId = cabangId;
	}

	public String getWilayahId() {
		return wilayahId;
	}

	public void setWilayahId(String wilayahId) {
		this.wilayahId = wilayahId;
	}

	public String getRegionalId() {
		return regionalId;
	}

	public void setRegionalId(String regionalId) {
		this.regionalId = regionalId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getCentroId() {
		return centroId;
	}

	public void setCentroId(String centroId) {
		this.centroId = centroId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}
