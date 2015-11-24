package com.example.myexample.SNS;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myexample.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;

public class SNS_07_Activity extends Activity {

    TwitterLoginButton loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sns_07);

        final LinearLayout myLayout
                = (LinearLayout) findViewById(R.id.ll_tweets);

        final long tweetId = 604113612517449728L;
        TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                myLayout.addView(new TweetView(SNS_07_Activity.this, result.data));
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(SNS_07_Activity.this, "Tweet load failed", Toast.LENGTH_LONG).show();
            }
        });


    }


}

