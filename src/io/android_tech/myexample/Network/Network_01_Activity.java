package io.android_tech.myexample.Network;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Network_01_Activity extends Activity implements View.OnClickListener {
    BufferedReader socket_in;
    PrintWriter socket_out;
    EditText input;
    Button button;
    TextView output;
    String data;
    private Socket socket;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_network_01);
        input = (EditText) findViewById(io.android_tech.myexample.R.id.input);
        button = (Button) findViewById(io.android_tech.myexample.R.id.button);
        output = (TextView) findViewById(io.android_tech.myexample.R.id.output);
        button.setOnClickListener(this);

        Thread worker = new Thread() {
            public void run() {
                try {
                    socket = new Socket("192.168.0.26", 5555);
                    socket_out = new PrintWriter(socket.getOutputStream(), true);
                    socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    data = socket_in.readLine();
                    Log.w("NETWORK", data);
                    output.post(new Runnable() {
                        @Override
                        public void run() {
                            output.setText(data);

                        }
                    });
                    socket_in.close();
                    socket_out.close();
                    socket.close();
                } catch (Exception e) {
                }
            }
        };
        worker.start();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.button:
                String data = input.getText().toString();
                Log.w("NETWORK", " " + data);
                if (data != null) {
                    socket_out.println(data);

                }
        }
    }
}
