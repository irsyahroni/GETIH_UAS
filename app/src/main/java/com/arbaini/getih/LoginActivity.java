package com.arbaini.getih;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arbaini.getih.utils.PrefManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnSignup;
    private EditText etEmail, etPass;
    private String txtEmail,txtPass;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btn_login_register);
        etEmail = findViewById(R.id.et_login_email);
        etPass = findViewById(R.id.et_login_password);
        getSupportActionBar().setTitle("Login");
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait...");
        progressDialog.setIndeterminate(true);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LoginActivity.this, "Anda belum memiliki akun, silahkan Register!", Toast.LENGTH_SHORT).show();
                login();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });

    }

    private void login() {
        checkEditText();
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(txtEmail,txtPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    PrefManager prefManager = new PrefManager(LoginActivity.this);
                    prefManager.setStatusLogin(true);
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    progressDialog.dismiss();

                }else{
                    Toast.makeText(getApplicationContext(),"Gagal Login",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }

            }
        });
        }

    private void checkEditText(){


        txtEmail = etEmail.getText().toString();
        if (TextUtils.isEmpty(txtEmail)) {
            etEmail.setError("Tidak boleh Kosong");
            return;
        }

        txtPass = etPass.getText().toString();
        if (TextUtils.isEmpty(txtPass)) {
            etPass.setError("Tidak boleh Kosong");
            return;
        }
    }
}
