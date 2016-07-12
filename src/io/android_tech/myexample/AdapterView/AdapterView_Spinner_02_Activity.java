package io.android_tech.myexample.AdapterView;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class AdapterView_Spinner_02_Activity extends ListActivity {
    private final String[] sFruits = {"���", "�ٳ���", "�丶��", "������", "Ű��",};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, sFruits));
    }
}
