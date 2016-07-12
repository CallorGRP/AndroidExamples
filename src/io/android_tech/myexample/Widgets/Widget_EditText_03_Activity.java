package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import io.android_tech.myexample.R;

public class Widget_EditText_03_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_edittext_03);

        final EditText et = (EditText) findViewById(R.id.num);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    if (Integer.parseInt(s.toString()) > 100) {
                        et.setText(null);
                        Toast.makeText(getApplicationContext(), "1부터 100사이의 숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}