package com.example.ttit.ui.entity;

public class P43_Item {
    private int iId;
    private String iName;

    public P43_Item() {
    }

    public P43_Item(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
