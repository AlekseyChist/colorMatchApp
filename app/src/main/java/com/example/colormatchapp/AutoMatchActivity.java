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

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AutoMatchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ColorMenuItem[] colors = {
            new ColorMenuItem("white", 0xfff9f4f2),
            new ColorMenuItem("grey",0xff6d7174),
            new ColorMenuItem("black", 0xff111111),
            new ColorMenuItem("red", 0xffaa0011),
            new ColorMenuItem("yellow", 0xfffbb714),
            new ColorMenuItem("blue", 0xff3f6ad7),
            new ColorMenuItem("green", 0xffa4b909),
            new ColorMenuItem("orange", 0xfff27b12),
            new ColorMenuItem("purple", 0xff9400d3),
            new ColorMenuItem("biege", 0xffbaab98),
            new ColorMenuItem("brown", 0xff966a4a),
            new ColorMenuItem("pink", 0xffffc0cb)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_color_match);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.simplespinner);
        spin.setOnItemSelectedListener(this);

        ColorArrayAdapter aa = new ColorArrayAdapter(this, R.layout.color_menu_item, colors);
        aa.setDropDownViewResource(R.layout.color_menu_item);

        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), colors[position].getText(), Toast.LENGTH_LONG).show();
        Log.d("AutoColor", "Hello");
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}