package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

import java.io.IOException;

public class MultiMedia_04_Activity extends Activity implements View.OnClickListener {

    private MediaPlayer mPlayer;
    private MediaRecorder mRecorder;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/audio_test.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_multimedia_04);

        Button btnStartRecording = (Button) findViewById(R.id.btnStartRecording);
        Button btnStopRecording = (Button) findViewById(R.id.btnStopRecording);
        Button btnStartPlay = (Button) findViewById(R.id.btnStartPlay);
        Button btnStopPlay = (Button) findViewById(R.id.btnStopPlay);

        btnStartRecording.setOnClickListener(this);
        btnStopRecording.setOnClickListener(this);
        btnStartPlay.setOnClickListener(this);
        btnStopPlay.setOnClickListener(this);

        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mRecorder.setOutputFile(path);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartRecording:
                try {
                    // 레코더 준비
                    mRecorder.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 녹음 시작
                mRecorder.start();

                break;
            case R.id.btnStopRecording:
                try {
                    // 녹음 정지
                    mRecorder.stop();
                    // 다시 사용할 수 있도록 레코더 상태를 리셋
                    mRecorder.reset();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btnStartPlay:
                mPlayer = new MediaPlayer();
                try {
                    mPlayer.setDataSource(path);
                    mPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mPlayer.start();

                break;
            case R.id.btnStopPlay:
                mPlayer.stop();
                try {
                    mPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
