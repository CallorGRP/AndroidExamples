package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AdapterView_Spinner_01_Activity extends Activity {
    private final String[] sFruits = {"사과", "바나나", "토마토", "오렌지", "키위",};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_adapterview_spinner_01);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, sFruits);

        Spinner spinner = (Spinner) findViewById(io.android_tech.myexample.R.id.spinner);
        spinner.setPrompt("당신이 좋아하는 과일은?");
        spinner.setAdapter(adapter);
    }
}
