package io.android_tech.myexample.WebView;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import io.android_tech.myexample.R;
import io.android_tech.myexample.R.layout;

public class WebView_08_Activity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_webview_08);

        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new myChromeClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.loadUrl("file:///android_asset/webview_console.html");

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();

    }

    final class myChromeClient extends WebChromeClient {

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {

            Toast.makeText(WebView_08_Activity.this, "sourceId:" + consoleMessage.sourceId() + ",line:" + consoleMessage.lineNumber() + ",level:" + consoleMessage.messageLevel() + ",message:" +
                    consoleMessage.message(), Toast.LENGTH_LONG).show();
            return true;
        }
    }
}
