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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AutoMatchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ColorMenuItem[] colors = ColorMatrix.GetAllColors();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_color_match);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.simplespinner);
        spin.setOnItemSelectedListener(this);

        ColorArrayAdapter aa = new ColorArrayAdapter(this, R.layout.color_menu_item, colors);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin.setSelection(Adapter.NO_SELECTION, false);

        aa.setDropDownViewResource(R.layout.color_menu_item);
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), colors[position].getText(), Toast.LENGTH_SHORT).show();

        if (colors[position].getId() !=  ColorIdEnum.EMPTY) {
            ColorMenuItem[] items = ColorMatrix.GetMatchingColors(colors[position].getId());
            for (int i = 0; i < items.length; i++)
                Log.d("AutoColor", items[i].getText());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}