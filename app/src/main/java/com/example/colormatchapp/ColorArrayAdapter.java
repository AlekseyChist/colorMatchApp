package com.example.colormatchapp;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ColorArrayAdapter extends ArrayAdapter<ColorMenuItem> {

    private ColorMenuItem[] objects;

    public ColorArrayAdapter(@NonNull Context context, int resource, @NonNull ColorMenuItem[] objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.color_menu_item, null);
        }

        /*
         * Recall that the variable position is sent in as an argument to this method.
         * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
         * iterates through the list we sent it)
         *
         * Therefore, i refers to the current Item object.
         */
        ColorMenuItem i = objects[position];

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView tt = (TextView) v.findViewById(R.id.item_text);
            ImageView bt = (ImageView) v.findViewById(R.id.item_button);

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (tt != null){
                tt.setText(i.getText());
            }

            if (bt!=null)
            {
                Drawable dr = bt.getBackground();
                ((GradientDrawable)dr).setColor(i.getColor());
            }
        }

        // the view must be returned to our activity
        return v;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        final LayoutInflater inflater = mDropDownInflater == null ? mInflater : mDropDownInflater;
        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.color_menu_item, null);
        }

        ColorMenuItem i = objects[position];

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView tt = (TextView) v.findViewById(R.id.item_text);
            ImageView bt = (ImageView) v.findViewById(R.id.item_button);

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (tt != null){
                tt.setText(i.getText());
            }
            if (bt!=null)
            {
                Drawable dr = bt.getBackground();
                ((GradientDrawable)dr).setColor(i.getColor());
            }
        }
        return v;

        //return super.getDropDownView(position, convertView, parent);
    }
}
