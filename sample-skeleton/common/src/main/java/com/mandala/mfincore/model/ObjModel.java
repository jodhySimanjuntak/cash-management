package com.mandala.mfincore.model;


import java.util.Comparator;

import org.zkoss.zul.GroupsModelArray;

public class ObjModel extends GroupsModelArray<Dummy, ObjModel.DummyGroupInfo, Object, Object> {
    private static final long serialVersionUID = 1L;
 
    public ObjModel(Dummy[] data, Comparator<Dummy> cmpr) {
    	super(data, cmpr);
    }
 
    protected DummyGroupInfo createGroupHead(Dummy[] groupdata, int index, int col) {
        return new DummyGroupInfo(groupdata[0], index, col);
    }
 
//    protected Object createGroupFoot(Dummy[] groupdata, int index, int col) {
//        // Return the sum number of each group
//        return groupdata.length;
//    }
     
    public static class DummyGroupInfo {
        private Dummy firstChild;
        private int groupIndex;
        private int colIndex;
         
        public DummyGroupInfo(Dummy firstChild, int groupIndex, int colIndex) {
            super();
            this.firstChild = firstChild;
            this.groupIndex = groupIndex;
            this.colIndex = colIndex;
        }
         
        public Dummy getFirstChild() {
            return firstChild;
        }
        public int getGroupIndex() {
            return groupIndex;
        }
        public int getColIndex() {
            return colIndex;
        }
    }
}

