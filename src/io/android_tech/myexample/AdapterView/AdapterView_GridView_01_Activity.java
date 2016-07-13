package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.GridView;

import java.util.ArrayList;

import io.android_tech.myexample.R;

public class AdapterView_GridView_01_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterview_gridview_01);

        AdapterView_GridView_01_Adapter adapter = new AdapterView_GridView_01_Adapter(
                this, R.layout.activity_adapterview_gridview_01_row,
                getContactList());

        GridView list = (GridView) findViewById(R.id.gridView1);
        list.setAdapter(adapter);
    }

    private ArrayList<AdapterView_GridView_01_Data> getContactList() {

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        String[] projection = new String[]{

                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
        String[] selectionArgs = null;

        String sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                + " COLLATE LOCALIZED ASC";

        Cursor contactCursor = managedQuery(uri, projection, null,
                selectionArgs, sortOrder);

        ArrayList<AdapterView_GridView_01_Data> contactlist = new ArrayList<AdapterView_GridView_01_Data>();

        if (contactCursor.moveToFirst()) {

            do {

                String phonenumber = contactCursor.getString(1).replaceAll("-",

                        "");

                if (phonenumber.length() == 10) {

                    phonenumber = phonenumber.substring(0, 3) + "-"

                            + phonenumber.substring(3, 6) + "-"

                            + phonenumber.substring(6);

                } else if (phonenumber.length() > 8) {

                    phonenumber = phonenumber.substring(0, 3) + "-"

                            + phonenumber.substring(3, 7) + "-"

                            + phonenumber.substring(7);

                }

                AdapterView_GridView_01_Data acontact = new AdapterView_GridView_01_Data();
                acontact.Image_ID = (int) contactCursor.getLong(0);
                acontact.Sub_Title = phonenumber;
                acontact.Main_Title = contactCursor.getString(2);

                contactlist.add(acontact);

            } while (contactCursor.moveToNext());

        }

        return contactlist;

    }
}
