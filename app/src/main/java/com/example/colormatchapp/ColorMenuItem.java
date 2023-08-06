package com.example.colormatchapp;

public class ColorMenuItem {
    private String text;
    private int color;

    private ColorIdEnum colorId;

    public ColorMenuItem(String text, int color, ColorIdEnum colorId) {
        this.color = color;
        this.text = text;
        this.colorId = colorId;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public ColorIdEnum getId() { return colorId; }
}
