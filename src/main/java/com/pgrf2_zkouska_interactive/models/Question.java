package com.pgrf2_zkouska_interactive.models;

public class Question {

    private String header;
    private String type;
    private String text;

    public Question(String header, String type, String text) {
        this.header = header;
        this.type = type;
        this.text = text;
    }

    public Question() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
