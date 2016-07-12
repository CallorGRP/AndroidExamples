package io.android_tech.myexample.SNS;

import android.app.ListActivity;
import android.os.Bundle;

import com.twitter.sdk.android.tweetui.CollectionTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

public class SNS_11_Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_sns_11);

        final CollectionTimeline collectionTimeline = new CollectionTimeline.Builder()
                .id(569961150045896704L)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, collectionTimeline);
        setListAdapter(adapter);
    }

}

