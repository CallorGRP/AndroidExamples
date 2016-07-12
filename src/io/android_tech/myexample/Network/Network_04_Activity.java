package io.android_tech.myexample.Network;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.Vector;

public class Network_04_Activity extends ListActivity {
    String rss_url = "http://blog.rss.naver.com/ironlove77.xml";
    RssReadTask rssreadtask = new RssReadTask();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rssreadtask.execute(rss_url, null, null);
    }

    public class RssReadTask extends AsyncTask<String, Void, Vector<String>> {

        Vector<String> vTitle = new Vector<>();
        Vector<String> vDesc = new Vector<>();
        URL url;
        String tag = "";
        String title = "";
        String desc = "";

        @Override
        protected Vector<String> doInBackground(String... params) {
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();

                url = new URL(params[0]);
                InputStream in = url.openStream();
                xpp.setInput(in, "utf-8");

                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        tag = xpp.getName();
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (tag.equals("title")) title += xpp.getText();
                        else if (tag.equals("description")) desc += xpp.getText();
                    } else if (eventType == XmlPullParser.END_TAG) {
                        tag = xpp.getName();
                        if (tag.equals("item")) {
                            vTitle.add(title);
                            vDesc.add(desc);
                            title = "";
                            desc = "";
                        }
                    }
                    eventType = xpp.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return vTitle;
        }

        @Override
        protected void onPostExecute(Vector<String> strings) {
            super.onPostExecute(strings);
            adapter = new ArrayAdapter<>(Network_04_Activity.this, android.R.layout.simple_list_item_1, strings);
            ListView lv = getListView();
            setListAdapter(adapter);
            setContentView(lv);
        }
    }
}