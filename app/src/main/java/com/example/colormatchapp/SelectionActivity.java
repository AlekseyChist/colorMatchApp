package com.example.colormatchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {
    CardView autoCard;
    CardView selfCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        autoCard = findViewById(R.id.card_view_auto_color_match);
        selfCard = findViewById(R.id.card_view_self_color_match);


        selfCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selfActivityIntent = new Intent(SelectionActivity.this, SelfMatchActivity.class);
                startActivity(selfActivityIntent);
            }
        });
        autoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent autoActivityIntent = new Intent(SelectionActivity.this, AutoMatchActivity.class);
                startActivity(autoActivityIntent);
            }
        });
    }
}