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
//        editor.putInt("press",1);
//        editor.apply();
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
    public void setButton1(View v){
        Log.i("button", "Button 1 Pressed");
        //toast.show();
        int value = sharedPreferences.getInt("button1", 0) + 1;
        editor.putInt("button1",value);
        editor.apply();
        String string="Button 1 was pressed " + value + " times.";
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }
    public void setButton2(View v){
        Log.i("button", "Button 2 Pressed");
        //toast.show();
        int value = sharedPreferences.getInt("button2", 0) + 1;
        editor.putInt("button2",value);
        editor.apply();
        String string="Button 2 was pressed " + value + " times.";
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }
    public void setButton3(View v){
        Log.i("button", "Button 3 Pressed");
        //toast.show();
        int value = sharedPreferences.getInt("button3", 0) + 1;
        editor.putInt("button3",value);
        editor.apply();
        String string="Button 3 was pressed " + value + " times.";
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }
    public void setButton4(View v){
        Log.i("button", "Button 4 Pressed");
        //toast.show();
        int value = sharedPreferences.getInt("button4", 0) + 1;
        editor.putInt("button4",value);
        editor.apply();
        String string="Button 4 was pressed " + value + " times.";
        Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
    }
}
