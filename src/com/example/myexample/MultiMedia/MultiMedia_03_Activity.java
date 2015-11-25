package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myexample.R;
import com.example.myexample.R.layout;

import java.io.IOException;

public class MultiMedia_03_Activity extends Activity implements View.OnClickListener {

    MediaPlayer music;
    AudioManager manager;
    int volume;
    TextView txtVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_multimedia_03);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);
        Button btnVolUp = (Button) findViewById(R.id.btnVolUp);
        Button btnVolDown = (Button) findViewById(R.id.btnVolDown);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnVolUp.setOnClickListener(this);
        btnVolDown.setOnClickListener(this);

        music = MediaPlayer.create(this, R.raw.konan);

        txtVolume = (TextView) findViewById(R.id.txtVolume);
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volume = manager.getStreamVolume(AudioManager.STREAM_MUSIC);
        txtVolume.setText(String.valueOf(volume));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                music.start();

                break;
            case R.id.btnStop:
                music.stop();
                try {
                    music.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnVolUp:
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, volume++, AudioManager.FLAG_SHOW_UI);
                txtVolume.setText(String.valueOf(volume));
                break;
            case R.id.btnVolDown:
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, volume--, AudioManager.FLAG_SHOW_UI);
                txtVolume.setText(String.valueOf(volume));
                break;
            default:
                break;
        }
    }
}
