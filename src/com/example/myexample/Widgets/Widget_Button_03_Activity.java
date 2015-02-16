package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myexample.R;

public class Widget_Button_03_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_button_03);
    }

    public void click(View v) {
        Toast.makeText(this, "확인 클릭", Toast.LENGTH_SHORT).show();
    }

}
