package io.android_tech.myexample.MultiMedia;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class MultiMedia_07_Activity extends Activity {
    private VideoView mVideoView;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/video_test.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_multimedia_07);

        mVideoView = (VideoView) findViewById(io.android_tech.myexample.R.id.videoview);
        mVideoView.setVideoPath(path);
        mVideoView.start();

        MediaController mc = new MediaController(this);
        mVideoView.setMediaController(mc);

    }
}