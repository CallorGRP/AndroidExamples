package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myexample.R;

public class Widget_ImageView_02_Activity extends Activity implements View.OnClickListener {

    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_widgets_imageview_02);

        Button btnCenter = (Button) findViewById(R.id.btnCenter);
        Button btnCenterCrop = (Button) findViewById(R.id.btnCenterCrop);
        Button btnCenterInside = (Button) findViewById(R.id.btnCenterInside);
        Button btnFitCenter = (Button) findViewById(R.id.btnFitCenter);
        Button btnFitStart = (Button) findViewById(R.id.btnFitStart);
        Button btnFitEnd = (Button) findViewById(R.id.btnFitEnd);
        Button btnFitXY = (Button) findViewById(R.id.btnFitXY);
        ivImage = (ImageView) findViewById(R.id.iv);

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
            case R.id.btnCenter:
                ivImage.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case R.id.btnCenterCrop:
                ivImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.btnCenterInside:
                ivImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case R.id.btnFitCenter:
                ivImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case R.id.btnFitStart:
                ivImage.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case R.id.btnFitEnd:
                ivImage.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case R.id.btnFitXY:
                ivImage.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
        }
    }

}
