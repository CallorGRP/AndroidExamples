package io.android_tech.myexample.WebView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebView_02_Activity extends Activity implements View.OnClickListener {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_webview_02);

        webView = (WebView) findViewById(io.android_tech.myexample.R.id.webView);
        Button btnWeb = (Button) findViewById(io.android_tech.myexample.R.id.btnWeb);
        Button btnAsset = (Button) findViewById(io.android_tech.myexample.R.id.btnAsset);

        webView.setWebViewClient(new WebViewClient());

        btnWeb.setOnClickListener(this);
        btnAsset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnWeb:
                webView.loadUrl("http://www.google.com/");
                break;
            case io.android_tech.myexample.R.id.btnAsset:
                webView.loadUrl("file:///android_asset/index.html");

                break;
            default:
                break;
        }
    }
}
