package io.android_tech.myexample.Thread;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import io.android_tech.myexample.R;

public class Thread_Main extends ListActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(R.array.thread_menu);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent i = null;
        switch (arg2) {

            case 0:
                i = new Intent(this, Thread_Thread_01_Activity.class);
                break;
            case 1:
                i = new Intent(this, Thread_Thread_02_Activity.class);
                break;
            case 2:
                i = new Intent(this, Thread_Thread_03_Activity.class);
                break;
            case 3:
                i = new Intent(this, Thread_Thread_04_Activity.class);
                break;
            case 4:
                i = new Intent(this, Thread_Thread_05_Activity.class);
                break;
            case 5:
                i = new Intent(this, Thread_Thread_06_Activity.class);
                break;
            case 6:
                i = new Intent(this, Thread_Thread_07_Activity.class);
                break;
            case 7:
                i = new Intent(this, Thread_Thread_08_Activity.class);
                break;
            case 8:
                i = new Intent(this, Thread_Thread_09_Activity.class);
                break;
            case 9:
                i = new Intent(this, Thread_Thread_10_Activity.class);
                break;
            case 10:
                i = new Intent(this, Thread_Thread_11_Activity.class);
                break;
            case 11:
                i = new Intent(this, Thread_Thread_12_Activity.class);
                break;
            default:
                return;

        }
        startActivity(i);
        // Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();

    }
}
