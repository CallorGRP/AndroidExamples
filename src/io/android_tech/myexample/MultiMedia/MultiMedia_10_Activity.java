package io.android_tech.myexample.MultiMedia;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import io.android_tech.myexample.R;

public class MultiMedia_10_Activity extends Activity {

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera camera;
    private ImageView imageview;
    private boolean inProgress;
    private Camera.PictureCallback takePicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            imageview.setImageBitmap(bitmap);
            camera.startPreview();
            inProgress = false;

        }
    };
    private SurfaceHolder.Callback surfaceListener = new SurfaceHolder.Callback() {

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            camera.release();
            camera = null;
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            camera = Camera.open();

            try {
                camera.setPreviewDisplay(holder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPreviewSize(width, height);
            camera.startPreview();

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_multimedia_10);

        imageview = (ImageView) findViewById(R.id.imageView1);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(surfaceListener);

        findViewById(R.id.btnTakePicture).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (camera != null && inProgress == false) {
                            camera.takePicture(null, null, takePicture);
                            inProgress = true;
                        }
                    }
                }
        );
    }
}

