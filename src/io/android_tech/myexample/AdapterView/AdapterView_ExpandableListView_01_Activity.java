package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.android_tech.myexample.R;

public class AdapterView_ExpandableListView_01_Activity extends Activity {
    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    private ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_adapterview_listview_05);

        HashMap<String, String> group1 = new HashMap<String, String>();
        HashMap<String, String> group2 = new HashMap<String, String>();
        HashMap<String, String> group3 = new HashMap<String, String>();
        HashMap<String, String> group4 = new HashMap<String, String>();
        HashMap<String, String> child1 = new HashMap<String, String>();
        HashMap<String, String> child2 = new HashMap<String, String>();
        HashMap<String, String> child3 = new HashMap<String, String>();
        HashMap<String, String> child4 = new HashMap<String, String>();

        ArrayList<Map<String, String>> groupList = new ArrayList<Map<String, String>>();
        group1.put("Title", "오늘의 업데이트");
        group2.put("Title", "시스템 정기점검 공지");
        group3.put("Title", "회원탈퇴 방법");
        group4.put("Title", "개인정보 동의");

        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);

        List<List<Map<String, String>>> childList = new ArrayList<List<Map<String, String>>>();

        List<Map<String, String>> childList1 = new ArrayList<Map<String, String>>();
        child1.put("Contents", "오늘의 업데이트는 다음과 같습니다.\n최신버전으로 업데이트 해주세요.");
        childList1.add(child1);

        List<Map<String, String>> childList2 = new ArrayList<Map<String, String>>();
        child2.put("Contents", "매월 1일 새벽 3시에 시스템 정기정검을 시행합니다.");
        childList2.add(child2);

        List<Map<String, String>> childList3 = new ArrayList<Map<String, String>>();
        child3.put("Contents", "회원탈퇴를 위해서는 xxx@aaa.com 으로 메일을 주시기 바랍니다.");
        childList3.add(child3);

        List<Map<String, String>> childList4 = new ArrayList<Map<String, String>>();
        child4.put("Contents", "개인정보 동의를 하여야 앱을 정상적으로 사용할 수 있습니다.");
        childList4.add(child4);

        childList.add(childList1);
        childList.add(childList2);
        childList.add(childList3);
        childList.add(childList4);

        mListView = (ExpandableListView) findViewById(R.id.listView1);
//        mListView.setAdapter(new AdapterView_ExpandableListView_01_Adapter(this, R.layout.activity_adapterview_listview_05_row, mGroupList, mChildList));

        mListView.setAdapter(new SimpleExpandableListAdapter(this, groupList, android.R.layout.simple_expandable_list_item_1, new String[]{"Title"}, new int[]{android.R.id.text1}, childList, android.R.layout.simple_expandable_list_item_1, new String[]{"Contents"}, new int[]{android.R.id.text1}));
        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), "g click = " + groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "c click = " + childPosition,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), "g Collapse = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), "g Expand = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
