package com.example.colormatchapp;

public enum ColorIdEnum {
    WHITE(0),
    GREY(1),
    BLACK(2),
    RED(3),
    YELLOW(4),
    BLUE(5),
    GREEN(6),
    ORANGE(7),
    PURPLE(8),
    BIEGE(9),
    BROWN(10),
    PINK(11),
    EMPTY(Integer.MAX_VALUE);

    public final int value;

    ColorIdEnum(int value){
        this.value = value;
    }

    public int toInt() {
        return value;
    }
}
