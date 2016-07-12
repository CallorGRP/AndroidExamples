package io.android_tech.myexample.SNS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;

public class SNS_13_Activity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterAuthConfig authConfig = new TwitterAuthConfig("vjaoe0JxKau4jFEX4jHVK8BWp", "92wRFWQWHEasfZwT4co7qVADMzftz2wGrbtiGwymAbeZ3raXfV");
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());

        setContentView(io.android_tech.myexample.R.layout.activity_sns_13);
        Button btn_tweet = (Button) findViewById(io.android_tech.myexample.R.id.btn_tweet);
        btn_tweet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btn_tweet:
                TweetComposer.Builder builder = new TweetComposer.Builder(this)
                        .text("트윗을 작성합니다.");
                builder.show();

                break;
        }
    }
}

