package com.example.myexample.SNS;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myexample.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.io.InputStream;
import java.util.Arrays;

public class SNS_05_Activity extends Activity implements View.OnClickListener {
    CallbackManager callbackManager;
    LoginManager loginManager;
    Button loginButton;
    Button btn_share1;
    Button btn_share2;
    Button btn_share3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);

        setContentView(R.layout.activity_sns_05);

        loginManager = LoginManager.getInstance();
        callbackManager = CallbackManager.Factory.create();
        loginButton = (Button) findViewById(R.id.login_button);
        btn_share1 = (Button) findViewById(R.id.btn_share1);
        btn_share2 = (Button) findViewById(R.id.btn_share2);
        btn_share3 = (Button) findViewById(R.id.btn_share3);

        loginButton.setOnClickListener(this);
        btn_share1.setOnClickListener(this);
        btn_share2.setOnClickListener(this);
        btn_share3.setOnClickListener(this);

        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(SNS_05_Activity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(SNS_05_Activity.this, "로그인 취소", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(SNS_05_Activity.this, "로그인 실패!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                loginManager.logInWithReadPermissions(this, Arrays.asList("email"));

                break;
            case R.id.btn_share1:
                ShareLinkContent contentLink = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("http://www.naver.com"))
                        .setContentDescription("네이버의 메인화면입니다.")
                        .setContentTitle("네이버")
                        .build();

                ShareApi.share(contentLink, new FacebookCallback<Sharer.Result>() {

                    @Override
                    public void onSuccess(Sharer.Result result) {
                        Toast.makeText(SNS_05_Activity.this, "공유 성공!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(SNS_05_Activity.this, "공유 취소!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(FacebookException e) {
                        Toast.makeText(SNS_05_Activity.this, "공유 실패!", Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case R.id.btn_share2:
                AssetManager assetmanager = getResources().getAssets();
                Bitmap bitmap = null;
                try {
                    InputStream is = assetmanager.open("ferrari.jpg", AssetManager.ACCESS_BUFFER);
                    bitmap = BitmapFactory.decodeStream(is);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .setCaption("페라리 사진")
                        .build();

                SharePhotoContent contentPhoto = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();

                ShareApi.share(contentPhoto, null);
                break;
            case R.id.btn_share3:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}

