package com.example.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;

public class Thread_Thread_04_Activity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_thread_04);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder();
        builder.detectAll();
        builder.penaltyDeath();
        StrictMode.setThreadPolicy(builder.build());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                try {
                    File file;
                    file = new File(this.getFilesDir().getPath()+"/test.txt");

                    FileInputStream fis = new FileInputStream(file);

                    Reader in = new InputStreamReader(fis);
                    int size = fis.available();
                    char[] buffer = new char[size];
                    in.read(buffer);
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btn2:
                try {
                    File file;
                    file = new File(this.getFilesDir().getPath() + "/test.txt");

                    FileOutputStream fos = new FileOutputStream(file);
                    Writer out = new OutputStreamWriter(fos, "UTF-8");
                    out.write("test");
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btn3:
                HttpParams httpParams = new BasicHttpParams();
                HttpClient httpClient = new DefaultHttpClient(httpParams);
                HttpGet httpGet = new HttpGet("http://www.android.com");
                try {
                    httpClient.execute(httpGet);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

        }
    }
}
