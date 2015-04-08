package com.example.myexample.WebView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class WebView_09_Activity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_webview_09);

        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new myChromeClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);


        webView.loadUrl("file:///android_asset/webview_dialog.html");

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
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder alert = new AlertDialog.Builder(WebView_09_Activity.this);

            alert.setMessage(message);

            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    result.confirm();
                }
            });
            alert.create().show();
            return true;

        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder alert = new AlertDialog.Builder(WebView_09_Activity.this);

            alert.setMessage(message);


            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    result.confirm();
                }
            });
            alert.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            result.cancel();

                        }
                    });
            alert.create().show();
            return true;
        }


        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
            AlertDialog.Builder alert = new AlertDialog.Builder(WebView_09_Activity.this);

            alert.setMessage(message);

            final EditText input = new EditText(WebView_09_Activity.this);
            alert.setView(input);

            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    result.confirm();
                }
            });


            alert.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            result.cancel();
                        }
                    });

            alert.create().show();
            return true;
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {

            Toast.makeText(WebView_09_Activity.this, "sourceId:" + consoleMessage.sourceId() + ",line:" + consoleMessage.lineNumber() + ",level:" + consoleMessage.messageLevel() + ",message:" +
                    consoleMessage.message(), Toast.LENGTH_LONG).show();
            return true;
        }
    }
}
