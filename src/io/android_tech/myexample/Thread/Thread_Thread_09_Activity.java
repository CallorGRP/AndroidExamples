package io.android_tech.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Thread_Thread_09_Activity extends Activity implements View.OnClickListener {
    Handler mHandler = new Handler();

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_thread_thread_06);
        textView = (TextView) findViewById(io.android_tech.myexample.R.id.textView);
        Button btn1 = (Button) findViewById(io.android_tech.myexample.R.id.btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            Runnable callback = new Runnable() {
                @Override
                public void run() {
                    textView.setText("updated!");
                }
            };

            @Override
            public void run() {
                Message message = Message.obtain(mHandler, callback);

                mHandler.sendMessage(message);

            }
        }).start();

    }
}
