package io.android_tech.myexample.Views;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class View_Main extends ListActivity
        implements
        OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(io.android_tech.myexample.R.array.view_menu);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Resources res = getResources();
        String[] args = res.getStringArray(io.android_tech.myexample.R.array.view_menu);
        Intent i;
        switch (arg2) {
            case 0:
                i = new Intent(this, View_Area_Activity.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, View_Background_01_Activity.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, View_Background_02_Activity.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, View_Margin_Activity.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(this, View_Visibility_01_Activity.class);
                startActivity(i);
                break;
            case 5:
                i = new Intent(this, View_Visibility_02_Activity.class);
                startActivity(i);
                break;

        }
        Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();

    }
}
