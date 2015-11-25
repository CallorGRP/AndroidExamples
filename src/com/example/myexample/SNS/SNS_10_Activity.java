package com.example.myexample.SNS;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.myexample.R;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetViewFetchAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class SNS_10_Activity extends ListActivity {

    final TweetViewFetchAdapter adapter =
            new TweetViewFetchAdapter<CompactTweetView>(SNS_10_Activity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns_10);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("Android")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, userTimeline);
        setListAdapter(adapter);
    }

}

