package com.mandala.mfincore.model;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listgroup;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class DummyListGroupRenderer implements ListitemRenderer<Object> {

	@Override
	public void render(Listitem listitem, Object obj, int index) throws Exception {

		if (listitem instanceof Listgroup) {
			ObjModel.DummyGroupInfo groupInfo = (ObjModel.DummyGroupInfo) obj;
			Dummy dummy = groupInfo.getFirstChild();
			String groupTxt;
			switch (groupInfo.getColIndex()) {
			case 0:
				groupTxt = dummy.getNameGroup();
				break;
			case 1:
				groupTxt = dummy.getDummy1();
				break;
			default:
				groupTxt = dummy.getNameGroup();
			}
			listitem.appendChild(new Listcell(groupTxt));
			listitem.setValue(obj);
		} else {
			if (obj instanceof Dummy) {
				Dummy data = (Dummy) obj;
				listitem.appendChild(new Listcell(data.getDummy1()));
				listitem.setValue(data);
			}
		}
	}

}
