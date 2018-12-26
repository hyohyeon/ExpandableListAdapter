package com.example.java.a_zapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent intent1 = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent1);

                break;
            case R.id.btn2:
                Intent intent2 = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent2);

                break;
            case R.id.btn3:
                Intent intent3 = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent(MainActivity.this, ThreadActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn5:
                Intent intent5 = new Intent(MainActivity.this, SeekBarActivity.class);
                startActivity(intent5);
            case R.id.btn6:
                Intent intent6 = new Intent(MainActivity.this, AutoCompleteTextView.class);
                startActivity(intent6);
        }
    }
}
