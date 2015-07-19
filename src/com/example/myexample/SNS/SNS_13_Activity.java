package com.example.myexample.SNS;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class SNS_13_Activity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns_13);
        Button btn_tweet = (Button) findViewById(R.id.btn_tweet);
        btn_tweet.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tweet:
                TweetComposer.Builder builder = new TweetComposer.Builder(this)
                        .text("트윗을 작성합니다.");
                builder.show();


                break;
        }
    }
}

