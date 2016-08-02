package io.android_tech.myexample.AdapterView;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class AdapterView_ListView_ArrayAdapter_Activity extends ListActivity {
    private final String[] sFruits = {"사과", "바나나", "토마토", "오렌지", "키위",};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, sFruits));
    }
}
