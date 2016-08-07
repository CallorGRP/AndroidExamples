package io.android_tech.myexample.AdapterView;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import java.util.ArrayList;

public class AdapterView_GridView_04_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_adapterview_listview_04);
/*
        AdapterView_ListView_04_Adapter adapter = new AdapterView_ListView_04_Adapter(
                this, io.android_tech.myexample.R.layout.activity_adapterview_listview_04_row,
                getContactList());
*/
        ListView list = (ListView) findViewById(io.android_tech.myexample.R.id.listView1);
  //      list.setAdapter(adapter);
    }

    private ArrayList<AdapterView_ListView_04_Data> getContactList() {

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

        ArrayList<AdapterView_ListView_04_Data> contactlist = new ArrayList<AdapterView_ListView_04_Data>();

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

                AdapterView_ListView_04_Data acontact = new AdapterView_ListView_04_Data();
                acontact.Image_ID = (int) contactCursor.getLong(0);
                acontact.Sub_Title = phonenumber;
                acontact.Main_Title = contactCursor.getString(2);

                contactlist.add(acontact);

            } while (contactCursor.moveToNext());

        }

        return contactlist;

    }
}
