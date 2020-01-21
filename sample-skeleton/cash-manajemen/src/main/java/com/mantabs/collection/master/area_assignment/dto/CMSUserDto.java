package com.mantabs.collection.master.area_assignment.dto;

import java.util.Date;
import java.util.List;

import com.mantabs.entity.master.CMSUser;



public class CMSUserDto {
	
	private int id;
	private Date createdAt;
	private int deleted;
	private Date deletedAt;
	private String email;
	private String fullname;
	private int isActive;
	private int localdb;
	private String name;
	private String username;
	private String utype;
	private Date updatedAt;
	private String cabangId;
	private String wilayahId;
	private String regionalId;
	private int branchId;
	private int districtId;
	private String centroId;
	private String password;
	private List<CMSMenuDto> menuList;
	
	public CMSUserDto(CMSUser user){
		this.email =user.getEmail();
		this.fullname=user.getFullname();
		this.isActive=user.getIsActive();
		this.password=user.getPassword();
		this.name=user.getName();
		this.id=user.getId();
		this.username=user.getUsername();
	}
	
	public CMSUserDto(){
		
	}
	
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
	public int getLocaldb() {
		return localdb;
	}
	public void setLocaldb(int localdb) {
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
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
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
	public List<CMSMenuDto> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<CMSMenuDto> menuList) {
		this.menuList = menuList;
	}
	
	
	
	
	
}
