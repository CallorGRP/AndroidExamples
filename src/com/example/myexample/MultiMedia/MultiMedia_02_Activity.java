package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

import java.io.IOException;

public class MultiMedia_02_Activity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_multimedia_02);

        Button btnStart = (Button) findViewById(R.id.btnStartResource);
        Button btnStartFile = (Button) findViewById(R.id.btnStartFile);
        Button btnStartStream = (Button) findViewById(R.id.btnStartStream);

        btnStart.setOnClickListener(this);
        btnStartFile.setOnClickListener(this);
        btnStartStream.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartResource:

                MediaPlayer player_raw = MediaPlayer.create(MultiMedia_02_Activity.this, R.raw.merry_christmas);
                player_raw.start();

                break;
            case R.id.btnStartFile:
                try {
                    MediaPlayer player_file = new MediaPlayer();
                    player_file.setDataSource(Environment.getExternalStorageDirectory() + "/myexample/Handprints.mp3");
                    player_file.prepare();
                    player_file.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnStartStream:
                MediaPlayer player_stream = new MediaPlayer();
                try {
                    Uri uri = Uri.parse("");
                    player_stream.setDataSource(MultiMedia_02_Activity.this, uri);
                    player_stream.prepare();
                    player_stream.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

}
