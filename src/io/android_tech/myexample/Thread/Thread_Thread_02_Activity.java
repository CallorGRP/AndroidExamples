package io.android_tech.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Thread_Thread_02_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.v("THREAD", "count=" + i);

                }
            }

        });

        thread.start();
    }
}
