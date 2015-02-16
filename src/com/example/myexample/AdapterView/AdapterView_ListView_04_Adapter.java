package com.example.myexample.AdapterView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myexample.R;

import java.io.InputStream;
import java.util.ArrayList;

public class AdapterView_ListView_04_Adapter extends ArrayAdapter<AdapterView_ListView_04_Data> {
    private ArrayList<AdapterView_ListView_04_Data> items;
    private Context context;

    public AdapterView_ListView_04_Adapter(Context context, int textViewResourceId, ArrayList<AdapterView_ListView_04_Data> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.activity_adapterview_listview_04_row, null);
        }
        AdapterView_ListView_04_Data custom_list_data = items.get(position);

        if (custom_list_data != null) {

            ImageView iv = (ImageView) v.findViewById(R.id.custom_list_image);
            TextView tv_Main = (TextView) v.findViewById(R.id.custom_list_title_main);
            TextView tv_Sub = (TextView) v.findViewById(R.id.custom_list_title_sub);

            Uri uri = Uri.withAppendedPath(Contacts.CONTENT_URI, Long.toString(custom_list_data.Image_ID));
            InputStream is = Contacts.openContactPhotoInputStream(context.getContentResolver(), uri);
            Bitmap photo = BitmapFactory.decodeStream(is);
            iv.setImageBitmap(photo);

            tv_Main.setText(custom_list_data.Main_Title);
            tv_Sub.setText(custom_list_data.Sub_Title);
        }
        return v;
    }
}
