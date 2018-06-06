package com.arbaini.getih;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CariDonorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_donor);
        getSupportActionBar().setTitle("Cari Donor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
