//package com.example.colormatchapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class AutoMatchActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_auto_color_match);
//    }
//}

package com.example.colormatchapp;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AutoMatchActivity extends AppCompatActivity implements ListUpdateListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_color_match);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        ColorArrayAdapter adapter = new ColorArrayAdapter(this, R.layout.color_menu_item, ColorMatrix.GetAllColors());
        Spinner spin = (Spinner) findViewById(R.id.simplespinner);
        spin.setOnItemSelectedListener(new SpinnerListener(this, adapter, this::UpdateList1));


        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(adapter);
        spin.setSelection(Adapter.NO_SELECTION, false);

        adapter.setDropDownViewResource(R.layout.color_menu_item);
    }


    @Override
    public void UpdateList1(ColorMenuItem[] colorsList) {
        ColorArrayAdapter adapter = new ColorArrayAdapter(this, R.layout.color_menu_item, colorsList);
        Spinner spin = (Spinner) findViewById(R.id.simplespinner2);
        spin.setOnItemSelectedListener(new SpinnerListener(this, adapter, this::UpdateList2));

        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(adapter);
        spin.setSelection(Adapter.NO_SELECTION, false);

        adapter.setDropDownViewResource(R.layout.color_menu_item);
    }

    @Override
    public void UpdateList2(ColorMenuItem[] colorsList) {
        ColorArrayAdapter adapter = new ColorArrayAdapter(this, R.layout.color_menu_item, colorsList);
        Spinner spin = (Spinner) findViewById(R.id.simplespinner3);
        spin.setOnItemSelectedListener(new SpinnerListener(this, adapter, null));

        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(adapter);
        spin.setSelection(Adapter.NO_SELECTION, false);

        adapter.setDropDownViewResource(R.layout.color_menu_item);
    }
}