package com.example.ttit.ui.entity;

public class P42_Hero {
    private int hIcon;
    private String hName;

    public P42_Hero() {
    }

    public P42_Hero(int hIcon, String hName) {
        this.hIcon = hIcon;
        this.hName = hName;
    }

    public int gethIcon() {
        return hIcon;
    }

    public String gethName() {
        return hName;
    }

    public void sethIcon(int hIcon) {
        this.hIcon = hIcon;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }
}
