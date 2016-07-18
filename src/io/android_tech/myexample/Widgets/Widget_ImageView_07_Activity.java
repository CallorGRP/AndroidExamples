package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import io.android_tech.myexample.R;

public class Widget_ImageView_07_Activity extends Activity implements View.OnClickListener {

    Button btnSizeUp, btnSizeDown, btnMoveLeft, btnMoveRight, btnMoveUp, btnMoveDown;
    ImageView iv;
    Matrix matrix;
    float X, Y;
    float scaleX, scaleY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_imageview_07);

        iv = (ImageView) findViewById(R.id.imageViewForMatrix);
        matrix = new Matrix();
        scaleX = 1.0F;
        scaleY = 1.0F;

        btnSizeDown = (Button) findViewById(R.id.btn_sizeDown);
        btnSizeUp = (Button) findViewById(R.id.btn_sizeUp);
        btnMoveUp = (Button) findViewById(R.id.btn_moveUp);
        btnMoveDown = (Button) findViewById(R.id.btn_moveDown);
        btnMoveLeft = (Button) findViewById(R.id.btn_moveleft);
        btnMoveRight = (Button) findViewById(R.id.btn_moveright);

        btnSizeDown.setOnClickListener(this);
        btnSizeUp.setOnClickListener(this);
        btnMoveUp.setOnClickListener(this);
        btnMoveDown.setOnClickListener(this);
        btnMoveLeft.setOnClickListener(this);
        btnMoveRight.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sizeUp:
                scaleX = iv.getScaleX() * 1.1F;
                scaleY = iv.getScaleY() * 1.1F;
                matrix.setScale(scaleX, scaleY);
                iv.setScaleX(scaleX);
                iv.setScaleY(scaleY);
                break;
            case R.id.btn_sizeDown:
                scaleX = iv.getScaleX() * 0.9F;
                scaleY = iv.getScaleY() * 0.9F;
                matrix.setScale(scaleX, scaleY);
                iv.setScaleX(scaleX);
                iv.setScaleY(scaleY);
                break;
            case R.id.btn_moveleft:
                X = iv.getX() - 100F;
                matrix.postTranslate(X, iv.getY());
                iv.setX(X);
                break;
            case R.id.btn_moveright:
                X = iv.getX() + 100F;
                matrix.postTranslate(X, iv.getY());
                iv.setX(X);
                break;
            case R.id.btn_moveDown:
                Y = iv.getY() + 100F;
                matrix.postTranslate(iv.getX(), Y);
                iv.setY(Y);
                break;
            case R.id.btn_moveUp:
                Y = iv.getY() - 100F;
                matrix.postTranslate(iv.getX(), Y);
                iv.setY(Y);
                break;

        }
        iv.setImageMatrix(matrix);

    }

}
