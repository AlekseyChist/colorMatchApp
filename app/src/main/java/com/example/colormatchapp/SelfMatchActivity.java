package com.example.colormatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SelfMatchActivity extends AppCompatActivity {

    Spinner spinner, spinner2, spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_color_match);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//ограничивает поворот дисплея, не дает скинуться цветам при смене ориентации экрана.
        spinner = findViewById(R.id.selfcolorspinner);
        spinner2 = findViewById(R.id.selfcolorspinner2);
        spinner3 = findViewById(R.id.selfcolorspinner3);


        ColorArrayAdapter adapter = new ColorArrayAdapter(this, R.layout.color_menu_item, ColorMatrix.GetAllColors());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //String item  = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter.setDropDownViewResource(R.layout.color_menu_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
    }





}

