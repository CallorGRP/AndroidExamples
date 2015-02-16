package com.example.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myexample.R;

public class Thread_Thread_07_Activity extends Activity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_thread_06);
        textView = (TextView) findViewById(R.id.textView);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn1:
                textView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("updated!");
                    }
                });
                break;
            case R.id.btn2:
                textView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("updated!");
                    }
                }, 1000);
                break;
        }


    }
}
