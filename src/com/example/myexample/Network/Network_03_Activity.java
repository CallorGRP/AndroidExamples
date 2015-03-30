package com.example.myexample.Network;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myexample.R;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network_03_Activity extends Activity implements View.OnClickListener {
    private static final String DEBUG_TAG = "Network_03_Activity";
    private EditText url;
    private Button button;
    private TextView webpage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_02);
        url = (EditText) findViewById(R.id.url);
        webpage = (TextView) findViewById(R.id.webpage);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                String stringUrl = url.getText().toString();
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    new DownloadWebpageTask().execute(stringUrl);
                } else {
                    webpage.setText("네트워크를 사용할 수 없습니다.");
                }
        }

    }

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            try {

                try {

                    HttpClient httpclient = new DefaultHttpClient(); //httpclient 객체를 생성
                    HttpGet httpget = new HttpGet(urls[0]);

                    // Create a response handler
                    ResponseHandler<String> responseHandler = new BasicResponseHandler();
                    String responseBody = httpclient.execute(httpget, responseHandler);

                    System.out.println(responseBody);
                    return responseBody.toString();

                } finally {
                }
            } catch (IOException e) {
                return "웹페이지를 가져올 수 없습니다.";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            webpage.setText(result);
        }
    }

}
