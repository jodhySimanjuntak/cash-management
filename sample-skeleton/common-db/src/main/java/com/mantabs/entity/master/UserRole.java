package com.mantabs.entity.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMF_MST_USER_ROLES database table.
 * 
 */
@Entity
@Table(name="MMF_MST_USER_ROLES")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ROLES_ID")
	private BigDecimal rolesId;

	@Id
	@Column(name="USERS_ID")
	private BigDecimal usersId;

	public UserRole() {
	}

	public BigDecimal getRolesId() {
		return this.rolesId;
	}

	public void setRolesId(BigDecimal rolesId) {
		this.rolesId = rolesId;
	}

	public BigDecimal getUsersId() {
		return this.usersId;
	}

	public void setUsersId(BigDecimal usersId) {
		this.usersId = usersId;
	}

}