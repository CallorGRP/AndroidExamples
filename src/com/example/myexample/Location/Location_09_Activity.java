package com.example.myexample.Location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.myexample.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location_09_Activity extends FragmentActivity implements GoogleMap.OnMapClickListener {
    MyListener gpsListener = new MyListener();
    GoogleMap map;
    boolean isMoved = false;
    private LocationManager manager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_04);

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        long minTime = 1000;
        float minDistance = 0;
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, gpsListener);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);

        map.addMarker(markerOptions);

    }

    private class MyListener implements LocationListener {
        public void onLocationChanged(Location location) {
            if (!isMoved) {
                isMoved = true;
                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();
                String msg = "Latitude : " + latitude + "\nLongitude:" + longitude;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                LatLng curPoint = new LatLng(latitude, longitude);
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
                map.addMarker(new MarkerOptions().position(curPoint).title("현재위치").snippet("이곳이 당신이 현재 있는 위치입니다."));

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