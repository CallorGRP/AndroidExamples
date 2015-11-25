package com.example.myexample.SNS;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.myexample.R;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

public class SNS_12_Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns_12);

        final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query("#io15")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, searchTimeline);
        setListAdapter(adapter);
    }

}

