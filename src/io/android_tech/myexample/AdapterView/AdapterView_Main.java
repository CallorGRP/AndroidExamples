package io.android_tech.myexample.AdapterView;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import io.android_tech.myexample.R;

public class AdapterView_Main extends ListActivity
        implements
        OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(R.array.adapterview_menu);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Resources res = getResources();
        String[] args = res.getStringArray(R.array.adapterview_menu);
        Intent i = null;
        switch (arg2) {
            case 0:
                i = new Intent(this, AdapterView_ListView_ArrayAdapter_Activity.class);
                break;
            case 1:
                i = new Intent(this, AdapterView_ListView_CursorAdapter_Activity.class);
                break;
            case 2:
                i = new Intent(this, AdapterView_ListView_CursorAdapter_02_Activity.class);
                break;
            case 3:
                i = new Intent(this, AdapterView_ListView_SimpleAdapter_Activity.class);
                break;
            case 4:
                i = new Intent(this, AdapterView_ListView_05_Activity.class);
                break;
            case 5:
                i = new Intent(this, AdapterView_GridView_01_Activity.class);
                break;
            case 6:
                i = new Intent(this, AdapterView_GridView_02_Activity.class);
                break;
            case 7:
                i = new Intent(this, AdapterView_GridView_03_Activity.class);
                break;
            case 8:
                i = new Intent(this, AdapterView_GridView_04_Activity.class);
            case 9:
                i = new Intent(this, AdapterView_Spinner_01_Activity.class);
                break;

        }
        startActivity(i);
        //Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();

    }
}
