package com.example.colormatchapp;

public class ColorMenuItem {
    private String text;
    private int color;

    public ColorMenuItem(String text, int color) {
        this.color = color;
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
