package com.arbaini.getih;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    private CardView cvJadiDonor, cvCariDonor,cvRiwayatDonor,cvProfile;
    private String stNama,stEmail,stPass,stGolDar,stBB;
    private TextView tvNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvJadiDonor = findViewById(R.id.cv_jadidonor);
        cvCariDonor = findViewById(R.id.cv_caridonor);
        cvRiwayatDonor = findViewById(R.id.cv_riwayatdonor);
        cvProfile = findViewById(R.id.cv_profile_user);
        tvNama = findViewById(R.id.tv_main_nama);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("GETiH App");

/*
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        stNama = extras.getString("NAMA");
        stEmail = extras.getString("EMAIL");
        stPass = extras.getString("PASS");
        stGolDar = extras.getString("GOLDAR");
        stBB = extras.getString("BB");

        tvNama.setText(stNama);*/

        cvJadiDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,JadiDonorActivity.class));
            }
        });
//
        cvCariDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CariDonorActivity.class)); }
        });
//
//        cvRiwayatDonor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,RiwayatDonorActivity.class));
//            }
//        });
//
//
//        cvProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
//                Bundle extras = new Bundle();
//                extras.putString("NAMA",stNama);
//                extras.putString("EMAIL",stEmail);
//                extras.putString("PASS",stPass);
//                extras.putString("GOLDAR",stGolDar);
//                extras.putString("BB",stBB);
//                intent.putExtras(extras);
//                startActivity(intent);
//            }
//        });

    }

}
