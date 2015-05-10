package com.example.myexample.Location;

import android.content.Context;
import android.graphics.Color;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class Location_08_Activity extends FragmentActivity {
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
                map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));

                map.addMarker(new MarkerOptions().position(curPoint).title("현재위치").snippet("이곳이 당신이 현재 있는 위치입니다."));

                LatLng gas_station = new LatLng(latitude + 0.005, longitude + 0.005);
                map.addMarker(new MarkerOptions().position(gas_station).icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)).title("주유소").snippet("가장가까운 주유소입니다."));

                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.color(Color.RED).width(5);
                polylineOptions.add(curPoint).add(gas_station);

                map.addPolyline(polylineOptions);


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