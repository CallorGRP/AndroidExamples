package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myexample.R;

public class MultiMedia_07_Activity extends Activity {
    private VideoView mVideoView;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/video_test.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia_07);

        mVideoView = (VideoView) findViewById(R.id.videoview);
        mVideoView.setVideoPath(path);
        mVideoView.start();

        MediaController mc = new MediaController(this);
        mVideoView.setMediaController(mc);

    }
}