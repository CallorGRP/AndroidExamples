package io.android_tech.myexample.AdapterView;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class AdapterView_ListView_02_Activity extends ListActivity {
    private static final String[] CONTACT_PROJECTION = new String[]{
            Contacts._ID, Contacts.DISPLAY_NAME};

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cursor c = getContentResolver().query(Contacts.CONTENT_URI,
                CONTACT_PROJECTION, null, null, null);
        startManagingCursor(c);
        ListAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, c, new String[]{
                Contacts._ID, Contacts.DISPLAY_NAME},
                new int[]{android.R.id.text1, android.R.id.text1});
        setListAdapter(adapter);

    }
}
