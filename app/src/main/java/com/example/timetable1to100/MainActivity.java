package com.example.timetable1to100;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lst;


    public void code(int tt)
    {

        ArrayList<String> lstc = new ArrayList<String>();

        for (int i=1;i<=100;i++)
        {
            lstc.add(Integer.toString(tt) +" x "+ Integer.toString(i)+" = " +  Integer.toString(i * tt));
        }

      // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lstc);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.mytext,lstc);
        lst.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seek = findViewById(R.id.seekBar2);
        lst = findViewById(R.id.listview);

        seek.setMax(100);
        seek.setProgress(0);
        code(0);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min =0;
                int tt;
                if (progress<min)
                {
                    tt=min;
                    seek.setProgress(min);
                }
                else
                {
                    tt=progress;
                }
                code(tt);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}