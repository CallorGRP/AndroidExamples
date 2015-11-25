package com.example.myexample.SNS;

import android.app.Activity;
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

import java.util.Arrays;
import java.util.List;

public class SNS_08_Activity extends Activity {

    TwitterLoginButton loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sns_07);

        final LinearLayout myLayout
                = (LinearLayout) findViewById(R.id.ll_tweets);

        final List<Long> tweetIds = Arrays.asList(604113612517449728L, 614840636286595073L, 622073314635304960L);

        TweetUtils.loadTweets(tweetIds, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                for (Tweet tweet : result.data)
                    myLayout.addView(new TweetView(SNS_08_Activity.this, tweet));
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(SNS_08_Activity.this, "Tweet load failed", Toast.LENGTH_LONG).show();
            }
        });

    }

}

