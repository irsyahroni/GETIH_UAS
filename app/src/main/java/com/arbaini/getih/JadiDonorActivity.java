package com.arbaini.getih;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class JadiDonorActivity extends AppCompatActivity {

//    private LocationListener locationListener;
//    private LocationManager locationManager;
    private Button donorkan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadi_donor);
        getSupportActionBar().setTitle("Jadi Pendonor");

        Button donorkan = findViewById(R.id.cv_donorkan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
                //text untuk lokasi.append("\n " + location.getLongitude() + " " + location.getLatitude());
//            }

//            @Override
//            public void onStatusChanged(String s, int i, Bundle bundle) {

//            }

//            @Override
//            public void onProviderEnabled(String s) {

//            }

//            @Override
//            public void onProviderDisabled(String s) {

//                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                startActivity(i);
//            }
//        };

//        configure_button();


        donorkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.pop, null);

                final PopupWindow popupWindow = new PopupWindow(container, ViewGroup.LayoutParams.MATCH_PARENT, 800, true);
                popupWindow.showAsDropDown(view, 0, 100);

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }
        });
    }

//    private void configure_button() {
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
//                (this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
//                                android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.INTERNET}
//                        , 10);
//            }
//            return;
//        }
        // this code won't execute IF permissions are not allowed, because in the line above there is return statement.
//        donorkan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                //noinspection MissingPermission
//                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
//    }
}
