package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class GroupApprovalHdrPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String kodeGroupApproval;

	private String kategoriBiaya;
	
	private String idNo;

	public String getKodeGroupApproval() {
		return kodeGroupApproval;
	}

	public void setKodeGroupApproval(String kodeGroupApproval) {
		this.kodeGroupApproval = kodeGroupApproval;
	}

	public String getKategoriBiaya() {
		return kategoriBiaya;
	}

	public void setKategoriBiaya(String kategoriBiaya) {
		this.kategoriBiaya = kategoriBiaya;
	}
	
	

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kodeGroupApproval == null) ? 0 : kodeGroupApproval.hashCode());
		result = prime * result + ((kategoriBiaya == null) ? 0 : kategoriBiaya.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
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
		GroupApprovalHdrPK other = (GroupApprovalHdrPK) obj;
		if (kodeGroupApproval == null) {
			if (other.kodeGroupApproval != null)
				return false;
		} else if (!kodeGroupApproval.equals(other.kodeGroupApproval))
			return false;
		if (kategoriBiaya == null) {
			if (other.kategoriBiaya != null)
				return false;
		} else if (!kategoriBiaya.equals(other.kategoriBiaya))
			return false;
		if (idNo == null) {
			if (other.idNo != null)
				return false;
		} else if (!idNo.equals(other.idNo))
			return false;
		return true;
	}
	
	
	
	

}
