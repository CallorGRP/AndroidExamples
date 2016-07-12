package io.android_tech.myexample.Network;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URL;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Network_05_Activity extends ListActivity {
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
                DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
                DocumentBuilder parser = f.newDocumentBuilder();
                Document xmlDoc = parser.parse(params[0]);

                Element root = xmlDoc.getDocumentElement();
                NodeList items = root.getElementsByTagName("item");

                for (int i = 0; i < items.getLength(); i++) {
                    Element item = (Element) items.item(i);
                    Node title = item.getElementsByTagName("title").item(0);
                    vTitle.add(title.getTextContent());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return vTitle;
        }

        @Override
        protected void onPostExecute(Vector<String> strings) {
            super.onPostExecute(strings);
            adapter = new ArrayAdapter<>(Network_05_Activity.this, android.R.layout.simple_list_item_1, strings);
            ListView lv = getListView();
            setListAdapter(adapter);
            setContentView(lv);
        }
    }
}