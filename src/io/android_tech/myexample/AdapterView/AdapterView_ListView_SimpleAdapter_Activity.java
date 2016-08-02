package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import io.android_tech.myexample.R;

public class AdapterView_ListView_SimpleAdapter_Activity extends Activity {
    private final String[] mKeyList = {"name", "phoneNumber"};
    private final int[] mViewList = {R.id.custom_list_title_main, R.id.custom_list_title_sub};
    private HashMap<String, String> mFruits = null;
    private ArrayList<HashMap<String, String>> mListData;
    private ListView mListView = null;
    private SimpleAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adapterview_listview_simpleadapter);

        mListView = (ListView) findViewById(R.id.listView);

        mListData = new ArrayList<HashMap<String, String>>();
        mFruits = new HashMap<String, String>();

        mFruits.put("브라운", "010-1111-1111");
        mFruits.put("코니", "010-2222-2222");
        mFruits.put("셀리", "010-3333-3333");
        mFruits.put("제임스", "010-4444-4444");
        mFruits.put("레너드", "010-5555-5555");

        mListData.add(mFruits);

        mAdapter = new SimpleAdapter(this, mListData,
                R.layout.activity_adapterview_simpleadapter_row, mKeyList, mViewList);

        mListView.setAdapter(mAdapter);
    }
}
