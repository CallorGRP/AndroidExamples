package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import io.android_tech.myexample.R;

public class AdapterView_ExpandableListView_01_Activity extends Activity {
    private ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_adapterview_expandablelistview_01);

        String arrGroup[] = {"과일", "야채", "가공식품"};
        String arrChild1[] = {"사과", "감", "단감", "곶감", "귤", "오랜지", "배", "복숭아", "살구", "자두"};
        String arrChild2[] = {"감자", "고구마", "깻잎", "당근", "도라지", "대파", "마늘", "무", "미나리", "버섯"};
        String arrChild3[] = {"통조림", "병조림 식품,", "건조 식품", "절임 식품", "훈제ㆍ연제 식품", "냉동 식품", "발효 식품", "레토르트 식품", "인스턴트 식품"};
        String arrChild[][] = {arrChild1, arrChild2, arrChild3};

        ArrayList<HashMap<String, String>> groupList = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> childLists = new ArrayList<>();

        for (int i = 0; i < arrGroup.length; i++) {
            HashMap<String, String> mapGroup = new HashMap<>();
            mapGroup.put("Group", arrGroup[i]);
            groupList.add(mapGroup);

            ArrayList<HashMap<String, String>> childList = new ArrayList<>();
            for (int j = 0; j < arrChild[i].length; j++) {
                HashMap<String, String> mapChild = new HashMap<>();
                mapChild.put("Contents", arrChild1[j]);
                childList.add(mapChild);
            }
            childLists.add(childList);
        }

        mListView = (ExpandableListView) findViewById(R.id.listView1);
        mListView.setAdapter(new SimpleExpandableListAdapter(this, groupList, android.R.layout.simple_expandable_list_item_1, new String[]{"Group"}, new int[]{android.R.id.text1}, childLists, android.R.layout.simple_expandable_list_item_1, new String[]{"Contents"}, new int[]{android.R.id.text1}));

        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), "Group click = " + groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "Child click = " + childPosition,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), "Group Collapse = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), "Group Expand = " + groupPosition,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
