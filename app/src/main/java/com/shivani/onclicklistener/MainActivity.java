package com.shivani.onclicklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast=Toast.makeText(getApplicationContext(),"Button was Pressed",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.RIGHT,30,0);
    }
    public void press(View v){
        Log.i("button", "Button Pressed");
        toast.show();
    }
}
