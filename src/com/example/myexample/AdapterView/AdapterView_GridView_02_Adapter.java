package com.example.myexample.AdapterView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myexample.R;

import java.util.ArrayList;

public class AdapterView_GridView_02_Adapter extends ArrayAdapter<String> {

    ArrayList<String> arr;

    public AdapterView_GridView_02_Adapter(Context context, int textViewResourceId, ArrayList<String> arr) {
        super(context, textViewResourceId);
        this.arr = arr;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arr.size(); // 그리드뷰에 출력할 목록 수
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return arr.get(position); // 아이템을 호출할 때 사용하는 메소드
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position; // 아이템의 아이디를 구할 때 사용하는 메소드
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.activity_adapterview_gridview_02_row, null);
        }

        TextView textView = (TextView) v.findViewById(R.id.textView1);

        textView.setText(arr.get(position));

        return v;
    }

}
