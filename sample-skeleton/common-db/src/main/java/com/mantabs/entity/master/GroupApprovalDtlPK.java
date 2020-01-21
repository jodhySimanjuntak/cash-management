package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class GroupApprovalDtlPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idNo;
	
	private Integer seqNo;

	private String groupApproval;

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getGroupApproval() {
		return groupApproval;
	}

	public void setGroupApproval(String groupApproval) {
		this.groupApproval = groupApproval;
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
		result = prime * result + ((seqNo == null) ? 0 : seqNo.hashCode());
		result = prime * result + ((groupApproval == null) ? 0 : groupApproval.hashCode());
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
		GroupApprovalDtlPK other = (GroupApprovalDtlPK) obj;
		if (seqNo == null) {
			if (other.seqNo != null)
				return false;
		} else if (!seqNo.equals(other.seqNo))
			return false;
		if (groupApproval == null) {
			if (other.groupApproval != null)
				return false;
		} else if (!groupApproval.equals(other.groupApproval))
			return false;
		if (idNo == null) {
			if (other.idNo != null)
				return false;
		} else if (!idNo.equals(other.idNo))
			return false;
		return true;
	}
}
