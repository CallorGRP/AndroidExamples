package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import io.android_tech.myexample.R;

public class Widget_TextView_02_Activity extends Activity {
    TextView tvMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_textview_02);
        tvMarquee = (TextView) findViewById(R.id.tvMarquee);
        tvMarquee.setSelected(true);
    }
}
