package com.dawanse.ieltsforall.model;

public class Task {

    private String header;
    private String preTitle;
    private String title;
    private String passage;

    public Task(String header, String preTitle, String title, String passage) {
        this.header = header;
        this.preTitle = preTitle;
        this.title = title;
        this.passage = passage;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPreTitle() {
        return preTitle;
    }

    public void setPreTitle(String preTitle) {
        this.preTitle = preTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }
}
