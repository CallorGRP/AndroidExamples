package com.example.myexample.AdapterView;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myexample.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * @author javatechig {@link http://javatechig.com}
 */
public class AdapterView_GridView_03_Activity extends Activity {
    private GridView gridView;
    private AdapterView_GridView_03_Adapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterview_gridview_03);

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new AdapterView_GridView_03_Adapter(this, R.layout.activity_adapterview_gridview_03_row, getData());
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(AdapterView_GridView_03_Activity.this, position + "#Selected", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private ArrayList<AdapterView_GridView_03_Data> getData() {
        ArrayList<AdapterView_GridView_03_Data> data = new ArrayList<AdapterView_GridView_03_Data>();

        String[] projection = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA, MediaStore.Images.Media.DATE_MODIFIED};

        Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        Cursor imageCursor = managedQuery(images, projection, null, null, null);

        while (imageCursor.moveToNext()) {
            String date;

            int imgData = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
            int dateColumn = imageCursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED);
            SimpleDateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss", Locale.KOREA);
            String imageDataPath = imageCursor.getString(imgData);
            date = imageCursor.getString(dateColumn);
            date = format.format(new Date(Integer.parseInt(date)));

            Bitmap bitmap = BitmapFactory.decodeFile(imageDataPath);

            data.add(new AdapterView_GridView_03_Data(bitmap, date));

        }
        return data;
    }
}
