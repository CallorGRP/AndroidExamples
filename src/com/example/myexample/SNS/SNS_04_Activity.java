package com.example.myexample.SNS;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myexample.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareButton;

import java.io.InputStream;
import java.util.Arrays;

public class SNS_04_Activity extends Activity {
    CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);

        setContentView(R.layout.activity_sns_04);

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(SNS_04_Activity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(SNS_04_Activity.this, "로그인 취소", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(SNS_04_Activity.this, "로그인 실패!", Toast.LENGTH_SHORT).show();
            }
        });

        ShareLinkContent contentLink = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("http://www.naver.com"))
                .setContentDescription("네이버의 메인화면")
                .setContentTitle("네이버")
                .build();

        ShareButton btn_share1 = (ShareButton) findViewById(R.id.btn_share1);
        btn_share1.setShareContent(contentLink);


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
                .build();

        SharePhotoContent contentPhoto = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();

        ShareButton btn_share2 = (ShareButton) findViewById(R.id.btn_share2);
        btn_share2.setShareContent(contentPhoto);

        Uri videoFileUri = Uri.parse("https://www.youtube.com/v/lGelRr_7gDE");
        ShareVideo video = new ShareVideo.Builder()
                .setLocalUrl(videoFileUri)
                .build();
        ShareVideoContent contentVideo = new ShareVideoContent.Builder()
                .setVideo(video)
                .build();

        ShareButton btn_share3 = (ShareButton) findViewById(R.id.btn_share3);
        btn_share3.setShareContent(contentVideo);

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

