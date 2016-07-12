package io.android_tech.myexample.MultiMedia;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MultiMedia_06_Activity extends Activity implements View.OnClickListener {
    SurfaceHolder holder;
    private MediaPlayer mPlayer;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/video_test.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(io.android_tech.myexample.R.layout.activity_multimedia_06);

        SurfaceView surface = new SurfaceView(this);
        holder = surface.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        FrameLayout frame = (FrameLayout) findViewById(io.android_tech.myexample.R.id.videoLayout);
        frame.addView(surface);

        Button btnStartPlay = (Button) findViewById(io.android_tech.myexample.R.id.btnStartPlay);
        Button btnStopPlay = (Button) findViewById(io.android_tech.myexample.R.id.btnStopPlay);

        btnStartPlay.setOnClickListener(this);
        btnStopPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
