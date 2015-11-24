package com.example.myexample.Location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.myexample.R;

public class Location_02_Activity extends Activity implements OnClickListener {
    LocationManager manager;
    MyListener myListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_02);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);
        Button btnGetting = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnGetting.setOnClickListener(this);

        myListener = new MyListener();
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, myListener);
                break;
            case R.id.btnStop:
                manager.removeUpdates(myListener);
                break;
            case R.id.btnGetting:
                Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (location != null) {
                    String message = String.format("현재 위치의 위도와 경도 : ", location.getLongitude(), location.getLatitude());
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.removeUpdates(myListener);
    }

    private class MyListener implements LocationListener {
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            String message = String.format("현재 위치의 위도와 경도 : %f,%f", latitude, longitude);
            Toast.makeText(Location_02_Activity.this, message, Toast.LENGTH_SHORT).show();

        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(Location_02_Activity.this, "위치서비스가 종료되었습니다.", Toast.LENGTH_LONG).show();
        }

        public void onProviderEnabled(String provider) {
            Toast.makeText(Location_02_Activity.this, "위치서비스가 시작되었습니다.", Toast.LENGTH_LONG).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            String message = "";
            switch (status) {
                case LocationProvider.AVAILABLE:
                    message = provider + ": 서비스가 시작되었습니다.";
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    message = provider + ": 서비스가 불가능합니다.";
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    message = provider + ": 서비스가 일시적으로 불가능합니다.";
                    break;
            }
            Toast.makeText(Location_02_Activity.this, message, Toast.LENGTH_SHORT).show();
        }
    }

}