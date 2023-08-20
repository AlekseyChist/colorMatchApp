package com.example.colormatchapp;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.function.Consumer;

public class FirstSpinnerListener implements AdapterView.OnItemSelectedListener {
    private AppCompatActivity appCompatActivity;
    private ColorArrayAdapter adapter;
    private Consumer<ColorMenuItem[]> notifyMethod;

    //Performing action onItemSelected and onNothing selected
    public FirstSpinnerListener(AppCompatActivity appCompatActivity, ColorArrayAdapter adapter, Consumer<ColorMenuItem[]> notifyMethod)
    {
        this.appCompatActivity = appCompatActivity;
        this.adapter = adapter;
        this.notifyMethod = notifyMethod;
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        ColorMenuItem[] colors = adapter.getItems();
        //Toast.makeText(appCompatActivity.getApplicationContext(), colors[position].getText(), Toast.LENGTH_SHORT).show();

        if (colors[position].getId() !=  ColorIdEnum.EMPTY) {
            ColorMenuItem[] items = ColorMatrix.GetMatchingColors(colors[position].getId());
            Log.d("AutoColor", "-----------------");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < items.length; i++)
                builder.append(items[i].getText()).append(", ");
            Log.d("AutoColor", builder.toString());
            Log.d("AutoColor", "=================");

            //((ListUpdateListener)appCompatActivity).UpdateList1(items);
            if (notifyMethod != null)
                notifyMethod.accept(items);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
