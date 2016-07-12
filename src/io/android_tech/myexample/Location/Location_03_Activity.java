package io.android_tech.myexample.Location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Location_03_Activity extends Activity {

    private static final String PROX_ALERT_INTENT =
            "com.android.proximity.ProximityIntentReceiver";

    private final BroadcastReceiver ProximityIntentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String key = LocationManager.KEY_PROXIMITY_ENTERING;
            Boolean entering = intent.getBooleanExtra(key, false);
            String message;
            if (entering)
                message = "목적지에 접근하고 있습니다.";
            else message = "목적지에서 벗어나고 있습니다.";

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    };
    private LocationManager locationManager;
    private EditText etLatitude;
    private EditText etLongitude;
    private Button btnStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_location_03);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        etLatitude = (EditText) findViewById(io.android_tech.myexample.R.id.latitude);
        etLongitude = (EditText) findViewById(io.android_tech.myexample.R.id.longitude);
        btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);

        btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                float latitude = Float.valueOf(etLatitude.getText().toString());
                float longitude = Float.valueOf(etLongitude.getText().toString());
                addProximityAlert(latitude, longitude);
            }
        });
    }

    private void addProximityAlert(double latitude, double longitude) {
        Intent intent = new Intent(PROX_ALERT_INTENT);
        PendingIntent proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return  ;
        }

        locationManager.addProximityAlert(
                latitude,
                longitude,
                1000,
                -1,
                proximityIntent
        );

        IntentFilter filter = new IntentFilter(PROX_ALERT_INTENT);
        registerReceiver(ProximityIntentReceiver, filter);
        Toast.makeText(Location_03_Activity.this, "근접경고를 시작합니다.", Toast.LENGTH_LONG).show();
    }
}