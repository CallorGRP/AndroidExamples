package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myexample.R;

import java.io.IOException;

public class MultiMedia_06_Activity extends Activity implements View.OnClickListener {
    SurfaceHolder holder;
    private MediaPlayer mPlayer;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/video_test.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multimedia_06);

        SurfaceView surface = new SurfaceView(this);
        holder = surface.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        FrameLayout frame = (FrameLayout) findViewById(R.id.videoLayout);
        frame.addView(surface);

        Button btnStartPlay = (Button) findViewById(R.id.btnStartPlay);
        Button btnStopPlay = (Button) findViewById(R.id.btnStopPlay);

        btnStartPlay.setOnClickListener(this);
        btnStopPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartPlay:
                mPlayer = new MediaPlayer();


                try {
                    mPlayer.setDataSource(path);
                    mPlayer.setDisplay(holder);

                    mPlayer.prepare();
                    mPlayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnStopPlay:
                mPlayer.stop();
                mPlayer.release();
                break;
        }
    }
}
