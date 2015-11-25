package com.example.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myexample.R;

public class Thread_Thread_10_Activity extends Activity implements View.OnClickListener {
    final private int MESSAGE_UPDATE_TEXT = 100;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_UPDATE_TEXT: {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("updated!");
                }
                break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_thread_06);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(MESSAGE_UPDATE_TEXT);
            }
        }).start();

    }
}
