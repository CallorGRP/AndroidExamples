package io.android_tech.myexample.Thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.android_tech.myexample.R;

public class Thread_Thread_12_Activity extends Activity implements View.OnClickListener {
    EditText edtNumber;
    Button btn1;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_thread_12);

        edtNumber = (EditText) findViewById(R.id.edtNumber);
        btn1 = (Button) findViewById(R.id.btn1);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btn1:
                new FactorialTask().execute(Long.parseLong(edtNumber.getText().toString()));
                break;
            default:
                break;
        }
    }

    class FactorialTask extends AsyncTask<Long, Long, Long> {

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Long result) {
            super.onPostExecute(result);
            tvResult.setText(edtNumber.getText().toString() + "! = " + result);

        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Long doInBackground(Long... params) {
            long result = 1;
            long num = params[0];

            for (long i = 1; i <= num; i++) {
                result = result * i;
            }

            Log.d("test", "result:" + result);
            return result;
        }
    }

}
