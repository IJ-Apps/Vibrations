package com.example.anany.myfirstapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
  
        //delay, play, delay, play, delay (milliseconds)
        long[] pattern = {0,300,500,100,600};

	  //repeat the pattern from the 0th index in the array.
        vib.vibrate(pattern, 0);

        //If the device can vibrate, display a text saying it can vibrate otherwise say the opposite.
        if(vib.hasVibrator())
            makeToast("Can Vibrate!");
        else
            makeToast("Device can't vibrate.");

        //When the button is pressed, stop the vibrations.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.cancel();
            }
        });

    }

    private void makeToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

}
