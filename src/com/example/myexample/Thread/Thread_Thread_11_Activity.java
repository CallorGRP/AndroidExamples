package com.example.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myexample.R;

public class Thread_Thread_11_Activity extends Activity implements View.OnClickListener {
    final private int MESSAGE_UPDATE_TEXT = 100;
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_UPDATE_TEXT: {
                    TextView textView = ((MessageObject) msg.obj).textView;
                    String text = ((MessageObject) msg.obj).text;
                    textView.setText(text);
                }
                break;
                default:
                    break;

            }
        }
    };

    TextView textView;

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
                MessageObject messageObject = new MessageObject();
                messageObject.text = "객체를 통해 업데이트합니다.";
                messageObject.textView = (TextView) findViewById(R.id.textView);

                Message message = Message.obtain(mHandler, MESSAGE_UPDATE_TEXT, messageObject);
                mHandler.sendMessage(message);
            }
        }).start();

    }

    class MessageObject {
        String text;
        TextView textView;
    }
}
