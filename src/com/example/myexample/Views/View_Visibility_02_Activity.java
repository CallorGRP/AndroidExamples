package com.example.myexample.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.myexample.R;

public class View_Visibility_02_Activity extends Activity implements
        OnClickListener {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_view_visibility_02);

        btn1 = (Button) findViewById(R.id.btn1);
        Button btnVisible = (Button) findViewById(R.id.btnVisible);
        Button btnInvisible = (Button) findViewById(R.id.btnInvisible);
        Button btnGone = (Button) findViewById(R.id.btnGone);

        btnVisible.setOnClickListener(this);
        btnInvisible.setOnClickListener(this);
        btnGone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVisible:
                btn1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnInvisible:
                btn1.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnGone:
                btn1.setVisibility(View.GONE);
                break;

        }

    }
}
