package com.example.myexample.MultiMedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myexample.R;

import java.io.IOException;


public class MultiMedia_09_Activity extends Activity implements View.OnClickListener {

    private static final int REQ_ALBUM = 100;
    private ImageView image_album;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia_09);

        Button btnAlbum = (Button) findViewById(R.id.btnAlbum);
        image_album = (ImageView) findViewById(R.id.image_album);
        btnAlbum.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAlbum:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_ALBUM);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_ALBUM) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());

                    image_album.setImageBitmap(image_bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}