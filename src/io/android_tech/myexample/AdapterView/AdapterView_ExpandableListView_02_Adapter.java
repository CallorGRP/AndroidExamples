package io.android_tech.myexample.AdapterView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import io.android_tech.myexample.R;

public class AdapterView_ExpandableListView_02_Adapter extends BaseExpandableListAdapter {

    private ArrayList<String> titleList = null;
    private ArrayList<String> contentList = null;
    private ViewHolder viewHolder = null;
    private int mResource = 0;
    private Context mContext = null;

    public AdapterView_ExpandableListView_02_Adapter(Context context, int _resource, ArrayList<String> titleList, ArrayList<String> contentList) {

        super();

        mResource = _resource;
        mContext = context;

        this.titleList = titleList;
        this.contentList = contentList;
    }

    @Override
    public String getGroup(int groupPosition) {
        return titleList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return titleList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(mResource, parent, false);
            viewHolder.tv_groupName = (TextView) v.findViewById(R.id.tv_group);
            viewHolder.tv_childName = (TextView) v.findViewById(R.id.tv_child);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        if (isExpanded) {
            viewHolder.tv_childName.setBackgroundColor(Color.GREEN);
        } else {
            viewHolder.tv_childName.setBackgroundColor(Color.WHITE);
        }

        viewHolder.tv_groupName.setText(getGroup(groupPosition));

        return v;
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return contentList.get(childPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return contentList.size();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(mResource, parent, false);
            viewHolder.tv_childName = (TextView) v.findViewById(R.id.tv_child);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.tv_childName.setText(getChild(groupPosition, childPosition));

        return v;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPostion, int childPosition) {
        return true;
    }


    class ViewHolder {
        public TextView tv_groupName;
        public TextView tv_childName;
    }

}