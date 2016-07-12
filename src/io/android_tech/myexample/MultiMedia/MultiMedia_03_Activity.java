package io.android_tech.myexample.MultiMedia;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MultiMedia_03_Activity extends Activity implements View.OnClickListener {

    MediaPlayer music;
    AudioManager manager;
    int volume;
    TextView txtVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_multimedia_03);

        Button btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);
        Button btnStop = (Button) findViewById(io.android_tech.myexample.R.id.btnStop);
        Button btnVolUp = (Button) findViewById(io.android_tech.myexample.R.id.btnVolUp);
        Button btnVolDown = (Button) findViewById(io.android_tech.myexample.R.id.btnVolDown);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnVolUp.setOnClickListener(this);
        btnVolDown.setOnClickListener(this);

        music = MediaPlayer.create(this, io.android_tech.myexample.R.raw.konan);

        txtVolume = (TextView) findViewById(io.android_tech.myexample.R.id.txtVolume);
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volume = manager.getStreamVolume(AudioManager.STREAM_MUSIC);
        txtVolume.setText(String.valueOf(volume));

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
            case io.android_tech.myexample.R.id.btnVolUp:
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, volume++, AudioManager.FLAG_SHOW_UI);
                txtVolume.setText(String.valueOf(volume));
                break;
            case io.android_tech.myexample.R.id.btnVolDown:
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, volume--, AudioManager.FLAG_SHOW_UI);
                txtVolume.setText(String.valueOf(volume));
                break;
            default:
                break;
        }
    }
}
