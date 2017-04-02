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

public class AdapterView_ExpandableListView_02_Activity extends Activity {
    private ExpandableListView mListView;
    private ArrayList<String> titleList = new ArrayList<String>();
    private ArrayList<String> childList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterview_expandablelistview_01);

        titleList.add("오늘의 업데이트");
        titleList.add("시스템 정기점검 공지");
        titleList.add("회원탈퇴 방법");
        titleList.add("개인정보 동의");


        childList.add("오늘의 업데이트는 다음과 같습니다.\n최신버전으로 업데이트 해주세요.");
        childList.add("매월 1일 새벽 3시에 시스템 정기정검을 시행합니다.");
        childList.add("회원탈퇴를 위해서는 xxx@aaa.com 으로 메일을 주시기 바랍니다.");
        childList.add("개인정보 동의를 하여야 앱을 정상적으로 사용할 수 있습니다.");

        mListView = (ExpandableListView) findViewById(R.id.listView1);
        mListView.setAdapter(new AdapterView_ExpandableListView_02_Adapter(this, R.layout.activity_adapterview_listview_05_row, titleList, childList));

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
