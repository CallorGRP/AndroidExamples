package io.android_tech.myexample.MultiMedia;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import io.android_tech.myexample.R;

public class MultiMedia_Main extends ListActivity
        implements
        OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(R.array.multimedia_menu);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Resources res = getResources();
        String[] args = res.getStringArray(R.array.multimedia_menu);
        Intent i = null;

        try {
            String className = String.format(getPackageName() + ".MultiMedia.MultiMedia_%02d_Activity", arg2 + 1);
            i = new Intent(this, Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        startActivity(i);
        //Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();

    }
}
