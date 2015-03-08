package com.example.myexample.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.myexample.R;

import java.io.File;

public class Service_02_Service extends Service {
    MediaPlayer music;
    String FilePath;

    @Override
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this, R.raw.konan);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        music.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        if (music.isPlaying()) {
            music.stop();
            music.release();
        }
    }

}
