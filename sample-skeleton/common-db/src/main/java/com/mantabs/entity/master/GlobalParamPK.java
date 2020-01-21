package com.mantabs.entity.master;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class GlobalParamPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idCondition;
	
	private String idParam;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idParam == null) ? 0 : idParam.hashCode());
		result = prime * result + ((idCondition == null) ? 0 : idCondition.hashCode());
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
		GlobalParamPK other = (GlobalParamPK) obj;
		if (idParam == null) {
			if (other.idParam != null)
				return false;
		} else if (!idParam.equals(other.idParam))
			return false;
		if (idCondition == null) {
			if (other.idCondition != null)
				return false;
		} else if (!idCondition.equals(other.idCondition))
			return false;
		return true;
	}


}
