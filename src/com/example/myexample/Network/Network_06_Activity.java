package com.example.myexample.Network;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myexample.R;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

public class Network_06_Activity extends Activity implements View.OnClickListener {
    // http://whois.kisa.or.kr/openapi/whois.jsp?query=naver.co.kr&key=2015033021490816419014&answer=json
    String whois_url = "http://whois.kisa.or.kr/openapi/whois.jsp?key=2015033021490816419014&answer=json&";
    JSONTask JSONTask = new JSONTask();
    EditText input;
    Button button;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_06);
        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);
        output = (TextView) findViewById(R.id.output);
        button.setOnClickListener(this);

    }

    public class JSONTask extends AsyncTask<String, Void, String> {

        Vector<String> vTitle = new Vector<>();
        Vector<String> vDesc = new Vector<>();
        URL url;
        String tag = "";
        String title = "";
        String desc = "";

        @Override
        protected String doInBackground(String... params) {
            InputStream is = null;
            char[] buffer = new char[1000];

            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                conn.connect();
                int response = conn.getResponseCode();
                is = conn.getInputStream();


                Reader reader = null;
                reader = new InputStreamReader(is, "UTF-8");
                reader.read(buffer);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new String(buffer);
        }

        @Override
        protected void onPostExecute(String strings) {
            super.onPostExecute(strings);
            try {
                JSONObject json = new JSONObject(strings);
                JSONObject whois = json.getJSONObject("whois");
                JSONObject krdomain = whois.getJSONObject("krdomain");
                String name = krdomain.getString("name");
                String regName = krdomain.getString("regName");
                String addr = krdomain.getString("addr");
                String post = krdomain.getString("post");
                String adminName = krdomain.getString("adminName");
                String adminEmail = krdomain.getString("adminEmail");
                String adminPhone = krdomain.getString("adminPhone");
                String regDate = krdomain.getString("regDate");
                String endDate = krdomain.getString("endDate");
                String infoYN = krdomain.getString("infoYN");
                String agency = krdomain.getString("agency");
                String agency_url = krdomain.getString("agency_url");
                String e_regName = krdomain.getString("e_regName");
                String e_addr = krdomain.getString("e_addr");
                String e_adminName = krdomain.getString("e_adminName");
                String e_agency = krdomain.getString("e_agency");
                String dnssec = krdomain.getString("dnssec");
                String ns1 = krdomain.getString("ns1");
                String ns2 = krdomain.getString("ns2");
                String ns3 = krdomain.getString("ns3");

                StringBuilder sb = new StringBuilder();
                sb.append("name:").append(name).append("\n");
                sb.append("regName:").append(regName).append("\n");
                sb.append("addr:").append(addr).append("\n");
                sb.append("post:").append(post).append("\n");
                sb.append("adminName:").append(adminName).append("\n");
                sb.append("adminEmail:").append(adminEmail).append("\n");
                sb.append("adminPhone:").append(adminPhone).append("\n");
                sb.append("regDate:").append(regDate).append("\n");
                sb.append("endDate:").append(endDate).append("\n");
                sb.append("infoYN:").append(infoYN).append("\n");
                sb.append("agency:").append(agency).append("\n");
                sb.append("agency_url:").append(agency_url).append("\n");
                sb.append("e_regName:").append(e_regName).append("\n");
                sb.append("e_addr:").append(e_addr).append("\n");
                sb.append("e_adminName:").append(e_adminName).append("\n");
                sb.append("e_agency:").append(e_agency).append("\n");
                sb.append("dnssec:").append(dnssec).append("\n");
                sb.append("ns1:").append(ns1).append("\n");
                sb.append("ns2:").append(ns2).append("\n");
                sb.append("ns3:").append(ns3).append("\n");

                output.setText(sb);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String data = input.getText().toString();
                JSONTask.execute(whois_url +"&query="+data, null, null);

        }
    }

}