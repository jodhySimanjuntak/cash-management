package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SubKategoriPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String kodeSubKategori;
	
	private String kategoriBiaya;

	public String getKodeSubKategori() {
		return kodeSubKategori;
	}

	public void setKodeSubKategori(String kodeSubKategori) {
		this.kodeSubKategori = kodeSubKategori;
	}

	public String getKategoriBiaya() {
		return kategoriBiaya;
	}

	public void setKategoriBiaya(String kategoriBiaya) {
		this.kategoriBiaya = kategoriBiaya;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kodeSubKategori == null) ? 0 : kodeSubKategori.hashCode());
		result = prime * result + ((kategoriBiaya == null) ? 0 : kategoriBiaya.hashCode());
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
		SubKategoriPK other = (SubKategoriPK) obj;
		if (kodeSubKategori == null) {
			if (other.kodeSubKategori != null)
				return false;
		} else if (!kodeSubKategori.equals(other.kodeSubKategori))
			return false;
		if (kategoriBiaya == null) {
			if (other.kategoriBiaya != null)
				return false;
		} else if (!kategoriBiaya.equals(other.kategoriBiaya))
			return false;
		return true;
	}
	
}
