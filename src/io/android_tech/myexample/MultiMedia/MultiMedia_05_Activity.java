package io.android_tech.myexample.MultiMedia;

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

import java.io.IOException;

public class MultiMedia_05_Activity extends Activity implements View.OnClickListener {
    SurfaceHolder holder;
    private MediaPlayer mPlayer;
    private MediaRecorder mRecorder;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/video_test.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(io.android_tech.myexample.R.layout.activity_multimedia_05);

        SurfaceView surface = new SurfaceView(this);
        holder = surface.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        FrameLayout frame = (FrameLayout) findViewById(io.android_tech.myexample.R.id.videoLayout);
        frame.addView(surface);

        Button btnStartRecording = (Button) findViewById(io.android_tech.myexample.R.id.btnStartRecording);
        Button btnStopRecording = (Button) findViewById(io.android_tech.myexample.R.id.btnStopRecording);
        Button btnStartPlay = (Button) findViewById(io.android_tech.myexample.R.id.btnStartPlay);
        Button btnStopPlay = (Button) findViewById(io.android_tech.myexample.R.id.btnStopPlay);

        btnStartRecording.setOnClickListener(this);
        btnStopRecording.setOnClickListener(this);
        btnStartPlay.setOnClickListener(this);
        btnStopPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnStartRecording:
                try {
                    mRecorder = new MediaRecorder();

                    mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                    mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);

                    mRecorder.setOutputFile(path);

                    mRecorder.setPreviewDisplay(holder.getSurface());
                    mRecorder.prepare();
                    mRecorder.start();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case io.android_tech.myexample.R.id.btnStopRecording:
                mRecorder.stop();
                mRecorder.reset();
                mRecorder.release();
                break;
            case io.android_tech.myexample.R.id.btnStartPlay:
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
            case io.android_tech.myexample.R.id.btnStopPlay:
                mPlayer.stop();
                mPlayer.release();
                break;
        }
    }
}
