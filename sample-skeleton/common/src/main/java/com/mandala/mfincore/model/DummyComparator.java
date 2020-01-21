package com.mandala.mfincore.model;

import java.io.Serializable;
import java.util.Comparator;

import org.zkoss.zul.GroupComparator;

public class DummyComparator implements Comparator<Dummy>, GroupComparator<Dummy>, Serializable {
	private static final long serialVersionUID = 1L;

	public int compare(Dummy o1, Dummy o2) {
		return o1.getGroup().compareTo(o2.getGroup().toString());
	}

	public int compareGroup(Dummy o1, Dummy o2) {
		if (o1.getGroup().equals(o2.getGroup()))
			return 0;
		else
			return 1;
	}
}
