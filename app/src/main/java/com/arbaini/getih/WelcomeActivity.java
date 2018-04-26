package com.arbaini.getih;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private Button mBtnWelcome;
    private TextView tvDot1,tvDot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mBtnWelcome = findViewById(R.id.btn_welcome_start);
        tvDot1 = findViewById(R.id.dot1);
        tvDot2 = findViewById(R.id.dot2);


        // set dot
        tvDot1.setText(Html.fromHtml("&#8226;"));
        tvDot2.setText(Html.fromHtml("&#8226;"));

        //Button Listener

        mBtnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            }
        });

    }
}
