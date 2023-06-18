package com.poetic.FluentCantonese.tools;

public class Flashcard {
    private String frontText;
    private String backText;

    private String jutPing;

    public Flashcard(String frontText, String backText, String jutPing) {
        this.frontText = frontText;
        this.backText = backText;
        this.jutPing = jutPing;
    }

    public String getFrontText() {
        return frontText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    public String getBackText() {
        return backText;
    }

    public void setBackText(String backText) {
        this.backText = backText;
    }

    public String getJutPing() {
        return jutPing;
    }

    public void setJutPing(String jutPing) {
        this.jutPing = jutPing;
    }
}
