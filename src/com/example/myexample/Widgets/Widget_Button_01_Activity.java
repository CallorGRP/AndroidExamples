package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.myexample.R;

public class Widget_Button_01_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_button_01);

        Button btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Widget_Button_01_Activity.this, "확인 클릭",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
