package com.example.myexample.Network;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Network_08_Activity extends Activity implements View.OnClickListener {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_network_08);

        webView = (WebView) findViewById(R.id.webView);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnAsset = (Button) findViewById(R.id.btnAsset);

        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        btnWeb.setOnClickListener(this);
        btnAsset.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWeb:
                webView.loadUrl("http://www.google.com/");
                break;
            case R.id.btnAsset:
                webView.loadUrl("file:///android_asset/index.html");

                break;
            default:
                break;
        }
    }
}
