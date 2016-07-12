package io.android_tech.myexample.Service;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Service_01_Activity extends Activity implements View.OnClickListener {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_activity_08);

        Button btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);
        Button btnStop = (Button) findViewById(io.android_tech.myexample.R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        music = MediaPlayer.create(this, io.android_tech.myexample.R.raw.konan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnStart:
                music.start();

                break;
            case io.android_tech.myexample.R.id.btnStop:
                music.stop();
                try {
                    music.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
