package com.example.myexample.Location;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myexample.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;


public class Location_06_Activity extends FragmentActivity implements View.OnClickListener {
    private GoogleMap map;
    private LocationManager locationManager;
    private String provider;
    EditText etLatitude;
    EditText etLongitude;
    Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_05);

        etLatitude = (EditText) findViewById(R.id.etLatitude);
        etLongitude = (EditText) findViewById(R.id.etLongitude);
        btnMove = (Button)findViewById(R.id.btnMove);

        btnMove.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMove:
                float latitude = Float.parseFloat(etLatitude.getText().toString());
                float longitude = Float.parseFloat(etLongitude.getText().toString());

                LatLng curPoint = new LatLng(latitude, longitude);
                map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint,15));

                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        }
    }
}