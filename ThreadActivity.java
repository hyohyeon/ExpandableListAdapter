package com.example.java.a_zapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class ThreadActivity extends Activity {

    private TextView tv1;
    private Button btn1, btn2;
    private int maxValue;
    private int minValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_main);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxValue = 11;
                BackThread thread = new BackThread();
                thread.setDaemon(true);
                thread.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxValue = 11;
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(String.valueOf(maxValue));
            }
        });
    }

    class BackThread extends Thread {
        @Override
        public void run() {
            boolean loopFlag = true;
            while (loopFlag) {
                maxValue--;
                if (maxValue < minValue) {
                    handler.sendEmptyMessage(1);
                    loopFlag = false;
                } else {
                    handler.sendEmptyMessage(0);
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                tv1.setText(String.valueOf(maxValue));
            } else if (msg.what == 1) {
                tv1.setText("FINISH!!");
            }
        }
    };

    // 1 : params 2 : progress 3 : result
    class MyAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... param) {
            boolean loopFlag = true;
            while (loopFlag) {
                int num = Integer.parseInt(param[0]);
                num--;
                if (num < minValue) {
                    return "FINISH!!";
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return String.valueOf(num);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            tv1.setText(values[0]);
        }
    }
}
