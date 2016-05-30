package com.example.myexample.Widgets;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import com.example.myexample.R;

public class Widget_Main extends ListActivity
        implements
        OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] args = res.getStringArray(R.array.widget_menu);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, args));

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Resources res = getResources();
        String[] args = res.getStringArray(R.array.widget_menu);
        Intent i = null;
        switch (arg2) {
            case 0:
                i = new Intent(this, Widget_TextView_01_Activity.class);
                break;
            case 1 :
				i = new Intent(this, Widget_TextView_02_Activity.class);
				break;
			case 2 :
				i = new Intent(this, Widget_Button_01_Activity.class);
				break;
			case 3 :
				i = new Intent(this, Widget_Button_02_Activity.class);
				break;
			case 4 :
				i = new Intent(this, Widget_Button_03_Activity.class);
				break;
			case 5 :
				i = new Intent(this, Widget_CompoundButton_01_Activity.class);
				break;
			case 6 :
				i = new Intent(this, Widget_CompoundButton_02_Activity.class);
				break;
			case 7 :
				i = new Intent(this, Widget_CompoundButton_03_Activity.class);
				break;
			case 8 :
				i = new Intent(this, Widget_CompoundButton_04_Activity.class);
				break;
			case 9 :
				i = new Intent(this, Widget_CompoundButton_05_Activity.class);
				break;
			case 10 :
				i = new Intent(this, Widget_CompoundButton_06_Activity.class);
				break;
			case 11 :
				i = new Intent(this, Widget_EditText_01_Activity.class);
				break;
			case 12 :
				i = new Intent(this, Widget_EditText_02_Activity.class);
				break;
			/*
			case 11 :
				i = new Intent(this, Widget_ImageView_01_Activity.class);
				break;
			case 12 :
				i = new Intent(this, Widget_ImageView_02_Activity.class);
				break;
			case 13 :
				i = new Intent(this, Widget_ImageView_03_Activity.class);
				break;
			case 14 :
				i = new Intent(this, Widget_TextView_01_Activity.class);
				break;
			case 15 :
				i = new Intent(this, Widget_TextView_01_Activity.class);
				break;
			case 16 :
				i = new Intent(this, Widget_TextView_01_Activity.class);
				break;
			case 17 :
				i = new Intent(this, Widget_TextView_01_Activity.class);
				break;
			case 18 :
				i = new Intent(this, Widget_TextView_01_Activity.class);
				break;
				*/
        }
        startActivity(i);
        //Toast.makeText(this, args[arg2], Toast.LENGTH_SHORT).show();

    }
}
