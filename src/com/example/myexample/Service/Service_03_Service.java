package com.example.myexample.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.example.myexample.R;

public class Service_03_Service extends Service {
    private final IBinder mBinder = new LocalBinder();
    MediaPlayer music;

    public class LocalBinder extends Binder {
        Service_03_Service getService() {
            return Service_03_Service.this;
        }
    }

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
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        music.stop();
        music.release();
        return super.onUnbind(intent);

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

    public void pauseMusic() {
        music.pause();
    }
}
