package io.android_tech.myexample.Layouts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Layout_FrameLayout_02_Activity extends Activity {
    Button btnChange;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_layout_framelayout_02);

        Button btnChange = (Button) findViewById(io.android_tech.myexample.R.id.btnChange);

        tv1 = (TextView) findViewById(io.android_tech.myexample.R.id.tv1);
        tv2 = (TextView) findViewById(io.android_tech.myexample.R.id.tv2);

        btnChange.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (tv1.getVisibility() == View.VISIBLE) {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                } else {
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.INVISIBLE);

                }
            }
        });
    }
}
