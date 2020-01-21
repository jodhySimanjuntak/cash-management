package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AreaApprovalHdrPK implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String kodeAreaApproval;
	private String groupApproval;

	
	
	public String getKodeAreaApproval() {
		return kodeAreaApproval;
	}

	public void setKodeAreaApproval(String kodeAreaApproval) {
		this.kodeAreaApproval = kodeAreaApproval;
	}

	public String getGroupApproval() {
		return groupApproval;
	}

	public void setGroupApproval(String groupApproval) {
		this.groupApproval = groupApproval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kodeAreaApproval == null) ? 0 : kodeAreaApproval.hashCode());
		result = prime * result + ((groupApproval == null) ? 0 : groupApproval.hashCode());
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
		AreaApprovalHdrPK other = (AreaApprovalHdrPK) obj;
		if (kodeAreaApproval == null) {
			if (other.kodeAreaApproval != null)
				return false;
		} else if (!kodeAreaApproval.equals(other.kodeAreaApproval))
			return false;
		if (groupApproval == null) {
			if (other.groupApproval != null)
				return false;
		} else if (!groupApproval.equals(other.groupApproval))
			return false;
		return true;
	}
	
}
