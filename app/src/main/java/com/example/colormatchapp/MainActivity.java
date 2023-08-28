package com.example.colormatchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //animation
    Animation topAnim, bottomAnim, scaleUp, scaleDown;
    ImageView image;
    TextView appName;
    Button buttonStart;


    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);
        //Hooks
        image = findViewById(R.id.app_start_picture);
        appName = findViewById(R.id.app_name);
        buttonStart = findViewById(R.id.button_start);


        image.setAnimation(bottomAnim);
        appName.setAnimation(topAnim);
        buttonStart.setAnimation(bottomAnim);
        buttonStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                openSelectionActivity();

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonStart.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN)
                    buttonStart.startAnimation(scaleDown);

                return true;
            }
        });

    }

    private void openSelectionActivity() {
        Intent intent = new Intent(this, SelectionActivity.class);
                startActivity(intent);
    }
}