package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Widget_Button_03_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_widgets_button_03);
    }

    public void click(View v) {
        Toast.makeText(this, "확인 클릭", Toast.LENGTH_SHORT).show();
    }

}
