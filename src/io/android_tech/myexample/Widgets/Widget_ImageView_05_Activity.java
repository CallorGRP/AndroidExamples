package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Widget_ImageView_05_Activity extends Activity implements View.OnClickListener {

    ImageView ivImage;
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(io.android_tech.myexample.R.layout.activity_widgets_imageview_05);

        Button btnMatrix = (Button) findViewById(io.android_tech.myexample.R.id.btnMatrix);
        Button btnCenter = (Button) findViewById(io.android_tech.myexample.R.id.btnCenter);
        Button btnCenterCrop = (Button) findViewById(io.android_tech.myexample.R.id.btnCenterCrop);
        Button btnCenterInside = (Button) findViewById(io.android_tech.myexample.R.id.btnCenterInside);
        Button btnFitCenter = (Button) findViewById(io.android_tech.myexample.R.id.btnFitCenter);
        Button btnFitStart = (Button) findViewById(io.android_tech.myexample.R.id.btnFitStart);
        Button btnFitEnd = (Button) findViewById(io.android_tech.myexample.R.id.btnFitEnd);
        Button btnFitXY = (Button) findViewById(io.android_tech.myexample.R.id.btnFitXY);

        tvText = (TextView) findViewById(io.android_tech.myexample.R.id.tvText);
        ivImage = (ImageView) findViewById(io.android_tech.myexample.R.id.ivImage);

        btnMatrix.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnCenterCrop.setOnClickListener(this);
        btnCenterInside.setOnClickListener(this);
        btnFitCenter.setOnClickListener(this);
        btnFitStart.setOnClickListener(this);
        btnFitEnd.setOnClickListener(this);
        btnFitXY.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnMatrix:
                tvText.setText("MATRIX");
                ivImage.setScaleType(ImageView.ScaleType.MATRIX);
                break;
            case io.android_tech.myexample.R.id.btnCenter:
                tvText.setText("CENTER");
                ivImage.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case io.android_tech.myexample.R.id.btnCenterCrop:
                tvText.setText("CENTER_CROP");
                ivImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case io.android_tech.myexample.R.id.btnCenterInside:
                tvText.setText("CENTER_INSIDE");
                ivImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case io.android_tech.myexample.R.id.btnFitCenter:
                tvText.setText("FIT_CENTER");
                ivImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case io.android_tech.myexample.R.id.btnFitStart:
                tvText.setText("FIT_START");
                ivImage.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case io.android_tech.myexample.R.id.btnFitEnd:
                tvText.setText("FIT_END");
                ivImage.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case io.android_tech.myexample.R.id.btnFitXY:
                tvText.setText("FIT_XY");
                ivImage.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
        }
    }

}
