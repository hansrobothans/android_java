package com.example.ttit.ui.entity;

public class P38_News {
    private String title;
    private String content;
    private int aIcon;

    public P38_News() {
    }

    public P38_News(String title, String content, int aIcon) {
        this.title = title;
        this.content = content;
        this.aIcon = aIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }
}
