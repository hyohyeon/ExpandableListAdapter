package com.example.java.a_zapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.java.a_zapp.customView.CustomCycleView;

public class SeekBarActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    SeekBar seekBar;
    CustomCycleView donutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seek_bar_main);

        seekBar = findViewById(R.id.seekbar);
        donutView = findViewById(R.id.donut);

        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        donutView.setValue(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
