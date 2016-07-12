package io.android_tech.myexample.WebView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class WebView_05_Activity extends Activity implements View.OnClickListener {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_webview_05);

        webView = (WebView) findViewById(io.android_tech.myexample.R.id.webView);
        Button btnWeb = (Button) findViewById(io.android_tech.myexample.R.id.btnWeb);
        Button btnCurrent = (Button) findViewById(io.android_tech.myexample.R.id.btnCurrent);

        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        btnWeb.setOnClickListener(this);
        btnCurrent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnWeb:
                webView.loadUrl("http://www.naver.com/");
                break;
            case io.android_tech.myexample.R.id.btnCurrent:
                Toast.makeText(this, webView.getUrl(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();

    }
}
