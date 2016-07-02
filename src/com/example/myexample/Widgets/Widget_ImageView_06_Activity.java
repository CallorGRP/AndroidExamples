package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myexample.R;

public class Widget_ImageView_06_Activity extends Activity implements View.OnClickListener {

    ImageView ivImage;
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_widgets_imageview_06);

        Button btnMatrix = (Button) findViewById(R.id.btnMatrix);
        Button btnCenter = (Button) findViewById(R.id.btnCenter);
        Button btnCenterCrop = (Button) findViewById(R.id.btnCenterCrop);
        Button btnCenterInside = (Button) findViewById(R.id.btnCenterInside);
        Button btnFitCenter = (Button) findViewById(R.id.btnFitCenter);
        Button btnFitStart = (Button) findViewById(R.id.btnFitStart);
        Button btnFitEnd = (Button) findViewById(R.id.btnFitEnd);
        Button btnFitXY = (Button) findViewById(R.id.btnFitXY);

        tvText = (TextView) findViewById(R.id.tvText);
        ivImage = (ImageView) findViewById(R.id.ivImage);

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
            case R.id.btnMatrix:
                tvText.setText("MATRIX");
                ivImage.setScaleType(ImageView.ScaleType.MATRIX);
                break;
            case R.id.btnCenter:
                tvText.setText("CENTER");
                ivImage.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case R.id.btnCenterCrop:
                tvText.setText("CENTER_CROP");
                ivImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.btnCenterInside:
                tvText.setText("CENTER_INSIDE");
                ivImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case R.id.btnFitCenter:
                tvText.setText("FIT_CENTER");
                ivImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case R.id.btnFitStart:
                tvText.setText("FIT_START");
                ivImage.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case R.id.btnFitEnd:
                tvText.setText("FIT_END");
                ivImage.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case R.id.btnFitXY:
                tvText.setText("FIT_XY");
                ivImage.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
        }
    }

}
