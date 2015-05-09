package com.example.myexample.Location;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.myexample.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;


public class Location_07_Activity extends FragmentActivity  {
    private LocationManager manager;
    private String provider;
    MyListener gpsListener = new MyListener();
    GoogleMap map;
    boolean isMoved = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_04);

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        long minTime = 1000;
        float minDistance = 0;
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);
    }

    private class MyListener implements LocationListener {
        public void onLocationChanged(Location location) {
            if ( !isMoved ) {
                isMoved = true;
                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();
                String msg = "Latitude : " + latitude + "\nLongitude:" + longitude;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                LatLng curPoint = new LatLng(latitude, longitude);
                map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
            }
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

}