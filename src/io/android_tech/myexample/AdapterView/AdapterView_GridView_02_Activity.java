package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class AdapterView_GridView_02_Activity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_adapterview_gridview_01);
        ArrayList<String> arr = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            arr.add("숫자" + Integer.toString(i));
        }

        GridView gridView = (GridView) findViewById(io.android_tech.myexample.R.id.gridView1);
        gridView.setAdapter(new AdapterView_GridView_02_Adapter(this, io.android_tech.myexample.R.layout.activity_adapterview_gridview_02_row, arr));
    }

}
