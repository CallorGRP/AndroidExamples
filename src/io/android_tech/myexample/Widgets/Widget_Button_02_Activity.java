package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Widget_Button_02_Activity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_widgets_button_02);

        Button btnOK = (Button) findViewById(io.android_tech.myexample.R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnOK:
                Toast.makeText(this, "확인 클릭", Toast.LENGTH_SHORT).show();
                break;
        }

    }

}