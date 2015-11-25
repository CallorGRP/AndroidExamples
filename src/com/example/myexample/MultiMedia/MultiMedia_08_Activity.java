package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myexample.R;

public class MultiMedia_08_Activity extends Activity implements View.OnClickListener {

    private static final int REQ_CAMERA = 100;
    private ImageView image_camera;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia_08);

        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        image_camera = (ImageView) findViewById(R.id.image_camera);
        btnCamera.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCamera:
                Intent intent = new Intent();
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, REQ_CAMERA);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                image_camera.setImageBitmap(bitmap);
            }
        }
    }

}