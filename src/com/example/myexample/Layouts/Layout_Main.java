package com.example.myexample.Layouts;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myexample.R;
import com.example.myexample.R.array;
import com.example.myexample.R.layout;

public class Layout_Main extends ListActivity
        implements
        OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(R.array.layout_menu);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Resources res = getResources();
        String[] args = res.getStringArray(R.array.layout_menu);
        Intent i;
        switch (arg2) {
            case 0:
                i = new Intent(this, Layout_LinearLayout_Orientation_01_Activity.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, Layout_LinearLayout_Orientation_02_Activity.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, Layout_LinearLayout_Orientation_03_Activity.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, Layout_LinearLayout_Weight_01_Activity.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(this, Layout_LinearLayout_Weight_02_Activity.class);
                startActivity(i);
                break;
            case 5:
                i = new Intent(this, Layout_LinearLayout_Gravity_01_Activity.class);
                startActivity(i);
                break;
            case 6:
                i = new Intent(this, Layout_LinearLayout_Gravity_02_Activity.class);
                startActivity(i);
                break;
            case 7:
                i = new Intent(this, Layout_RelativeLayout_01_Activity.class);
                startActivity(i);
                break;
            case 8:
                i = new Intent(this, Layout_RelativeLayout_02_Activity.class);
                startActivity(i);
                break;
            case 9:
                i = new Intent(this, Layout_FrameLayout_01_Activity.class);
                startActivity(i);
                break;
            case 10:
                i = new Intent(this, Layout_FrameLayout_02_Activity.class);
                startActivity(i);
                break;
            case 11:
                i = new Intent(this, Layout_TableLayout_01_Activity.class);
                startActivity(i);
                break;
            case 12:
                i = new Intent(this, Layout_TableLayout_02_Activity.class);
                startActivity(i);
                break;
            case 13:
                i = new Intent(this, Layout_ScrollView_01_Activity.class);
                startActivity(i);
                break;
            case 14:
                i = new Intent(this, Layout_ScrollView_02_Activity.class);
                startActivity(i);
                break;
            case 15:
                i = new Intent(this, Layout_GridLayout_01_Activity.class);
                startActivity(i);
                break;
            case 16:
                i = new Intent(this, Layout_GridLayout_02_Activity.class);
                startActivity(i);
                break;

        }
        Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();

    }
}
