package com.example.handlingformsubmission.dto;

public class Answer {
    private String text;

    public Answer(String text) {
        this.text = text;
    }

    public Answer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Answer) {
            String s = ((Answer) obj).getText();
            return this.text.equals(s);
        }
        return false;
    }
}
