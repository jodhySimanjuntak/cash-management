package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class JenisBiayaCMPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String subKategori;

	private String kategoriBiaya;
	
	private String kodeJenisBiaya;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subKategori == null) ? 0 : subKategori.hashCode());
		result = prime * result + ((kategoriBiaya == null) ? 0 : kategoriBiaya.hashCode());
		result = prime * result + ((kodeJenisBiaya == null) ? 0 : kodeJenisBiaya.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JenisBiayaCMPK other = (JenisBiayaCMPK) obj;
		if (subKategori == null) {
			if (other.subKategori != null)
				return false;
		} else if (!subKategori.equals(other.subKategori))
			return false;
		if (kategoriBiaya == null) {
			if (other.kategoriBiaya != null)
				return false;
		} else if (!kategoriBiaya.equals(other.kategoriBiaya))
			return false;
		if (kodeJenisBiaya == null) {
			if (other.kodeJenisBiaya != null)
				return false;
		} else if (!kodeJenisBiaya.equals(other.kodeJenisBiaya))
			return false;
		return true;
	}

}
