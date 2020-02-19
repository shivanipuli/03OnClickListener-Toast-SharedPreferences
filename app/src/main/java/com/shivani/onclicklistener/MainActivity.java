package com.shivani.onclicklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Toast toast;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SeekBar seekBar;
    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toast=Toast.makeText(getApplicationContext(),"Button was Pressed",Toast.LENGTH_SHORT);
        //toast.setGravity(Gravity.TOP|Gravity.RIGHT,30,0);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        button1=findViewById(R.id.topLeft);
        button2=findViewById(R.id.topRight);
        button3=findViewById(R.id.bottomLeft);
        button4=findViewById(R.id.bottomRight);
        editor = sharedPreferences.edit();
        editor.putInt("press",1);
        editor.apply();
        seekBar=findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                button1.setTextSize(progress);
                button2.setTextSize(progress);
                button3.setTextSize(progress);
                button4.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void press(View v){
        Log.i("button", "Button Pressed");
        //toast.show();
        int value = sharedPreferences.getInt("press", 3) + 1;
        editor.putInt("press",value);
        editor.apply();
        String string="Button was pressed " + value + " times.";
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }
}
