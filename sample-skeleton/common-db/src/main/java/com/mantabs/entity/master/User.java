package com.mantabs.entity.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMF_MST_USER database table.
 * 
 */
@Entity
@Table(name="MMF_MST_USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal id;

	private String password;

	private String username;

	public User() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}