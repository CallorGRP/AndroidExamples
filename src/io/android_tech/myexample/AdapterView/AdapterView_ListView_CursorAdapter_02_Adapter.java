package io.android_tech.myexample.AdapterView;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class AdapterView_ListView_CursorAdapter_02_Adapter extends SimpleCursorAdapter {
    Context mContext;
    int mLayout;
    Cursor mCursor;
    String[] mFrom;
    int[] mTo;

    public AdapterView_ListView_CursorAdapter_02_Adapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        mContext = context;
        mLayout = layout;
        mCursor = c;
        mFrom = from;
        mTo = to;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = vi.inflate(mLayout, null);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor c) {

        TextView tvName = (TextView) view.findViewById(mTo[0]);
        TextView tvNumber = (TextView) view.findViewById(mTo[1]);
        ImageView ivImage = (ImageView) view.findViewById(mTo[2]);

        String name = null;
        String number = null;

        if (c != null) {
            name = c.getString(c.getColumnIndex(mFrom[0]));
            number = c.getString(c.getColumnIndex(mFrom[1]));
            long id = c.getLong(c.getColumnIndex(mFrom[2]));

            tvName.setText(name);
            tvNumber.setText(number);

            Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, Long.toString(id));
            InputStream is = ContactsContract.Contacts.openContactPhotoInputStream(context.getContentResolver(), uri);
            Bitmap photo = BitmapFactory.decodeStream(is);
            ivImage.setImageBitmap(photo);
        }
    }
}
