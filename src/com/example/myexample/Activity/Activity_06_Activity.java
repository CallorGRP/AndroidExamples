package com.example.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Activity_06_Activity extends Activity implements View.OnClickListener {
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_activity_05);

        editText1 = (EditText) findViewById(R.id.editText1);

        Button btnFinish = (Button)findViewById(R.id.finish);

        btnFinish.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finish:

                Intent result = new Intent();
                result.putExtra("result", editText1.getText().toString());
                setResult(RESULT_OK, result);
                finish();
                break;

        }
    }
}
