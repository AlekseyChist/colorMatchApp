package com.example.colormatchapp;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ColorMatrix {

    private static final ColorMenuItem[] colors = {
            new ColorMenuItem("Select color", 0x00ffffff, ColorIdEnum.EMPTY),//нужно подумать как поменять с костыля на рабочий вариант
            new ColorMenuItem("white", 0xfff9f4f2, ColorIdEnum.WHITE),
            new ColorMenuItem("grey",0xff6d7174, ColorIdEnum.GREY),
            new ColorMenuItem("black", 0xff111111, ColorIdEnum.BLACK),
            new ColorMenuItem("red", 0xffaa0011, ColorIdEnum.RED),
            new ColorMenuItem("yellow", 0xfffbb714, ColorIdEnum.YELLOW),
            new ColorMenuItem("blue", 0xff3f6ad7, ColorIdEnum.BLUE),
            new ColorMenuItem("green", 0xffa4b909, ColorIdEnum.GREEN),
            new ColorMenuItem("orange", 0xfff27b12, ColorIdEnum.ORANGE),
            new ColorMenuItem("purple", 0xff9400d3, ColorIdEnum.PURPLE),
            new ColorMenuItem("biege", 0xffbaab98, ColorIdEnum.BIEGE),
            new ColorMenuItem("brown", 0xff966a4a, ColorIdEnum.BROWN),
            new ColorMenuItem("pink", 0xffffc0cb, ColorIdEnum.PINK)};

    private static final boolean[][] colorMatrix = {
            { true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
            { true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
            { true,  true,  true,  true,  true,  true,  true,  true,  true,  true, false,  true},
            { true,  true,  true,  true,  true,  true,  true, false, false,  true,  true,  true},
            { true,  true,  true,  true, false,  true,  true, false, false, false,  true, false},
            { true,  true,  true,  true,  true,  true,  true,  true, false,  true,  true, false},
            { true,  true,  true,  true, false,  true,  true, false, false,  true,  true, false},
            { true,  true,  true,  true, false,  true, false, false, false, false,  true, false},
            { true,  true,  true, false, false,  true, false, false, false,  true, false, false},
            { true, false, false,  true, false,  true,  true,  true,  true, false,  true,  true},
            { true, false, false,  true, false,  true,  true, false, false,  true,  true,  true},
            { true,  true,  true, false, false,  true,  true, false,  true,  true,  true, false}
    };

    public static ColorMenuItem[] GetAllColors() {
        return colors;
    }

    public static ColorMenuItem[] GetMatchingColors(ColorIdEnum colorId) {

        ArrayList<ColorMenuItem> colorArray = GetEmptyColorList();

        boolean[] colorRow = colorMatrix[colorId.toInt()];
        for (int i=0; i<colorRow.length; i++) {
            if (colorRow[i] == true) {
                for (int j=0; j<colors.length; j++) {
                    if (colors[j].getId().toInt() == i) {
                        colorArray.add(colors[j]);
                    }
                }
            }
        }


        ColorMenuItem[] items = new ColorMenuItem[ colorArray.size() ];
        items = colorArray.toArray(items);

        return items;
    }

    @NonNull
    public static ArrayList<ColorMenuItem> GetEmptyColorList() {
        ArrayList<ColorMenuItem> colorArray = new ArrayList<>();
        colorArray.add(colors[0]); //добавляем пустышку "select color"
        return colorArray;
    }

    public static ColorMenuItem[] GetEmptyColorArray() {
//        ArrayList<ColorMenuItem> list = GetEmptyColorList();
//        ColorMenuItem[] items = new ColorMenuItem[list.size()];
//        items = list.toArray(items);
        ColorMenuItem[] items = new ColorMenuItem[1];
        items[0] = colors[0];

        return items;
    }
}
