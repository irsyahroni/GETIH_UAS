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
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.arbaini.getih.Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText etNama, etEmail, etPass, etGolDar, etBB;
    private String stNama, stEmail, stPass, stUmur, stGolDar, stBB;
    private Button btnRegister;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private android.widget.Spinner spinner1;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().setTitle("Register");

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        etNama = findViewById(R.id.et_register_nama);
        etEmail = findViewById(R.id.et_register_email);
        etPass = findViewById(R.id.et_register_password);
        etBB = findViewById(R.id.et_register_bb);
        btnRegister = findViewById(R.id.btn_register);
        spinner1 = findViewById(R.id.et_register_goldarah);
        spinner1.setOnItemSelectedListener(new SpinnerSelectedListener());


        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait...");
        progressDialog.setIndeterminate(true);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stNama = etNama.getText().toString();
                if (TextUtils.isEmpty(stNama)) {
                    etNama.setError("Tidak boleh kosong");
                    return;
                }


                stEmail = etEmail.getText().toString();
                if (TextUtils.isEmpty(stEmail)) {
                    etEmail.setError("Tidak boleh Kosong");
                    return;
                }

                stPass = etPass.getText().toString();
                if (TextUtils.isEmpty(stPass)) {
                    etPass.setError("Tidak boleh Kosong");
                    return;
                }

                stBB = etBB.getText().toString();
                if (TextUtils.isEmpty(stBB)) {
                    etBB.setError("Tidak boleh Kosong");
                    return;
                }


                progressDialog.show();

                auth.createUserWithEmailAndPassword(stEmail,stPass).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this,"Register Gagal",Toast.LENGTH_SHORT).show();


                        } else {

                            String userId = auth.getCurrentUser().getUid();


                            Users users = new Users("08998660666",stGolDar,stBB,stEmail);

                            databaseReference.child("users").child(userId).setValue(users);

                            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                            Bundle extras = new Bundle();
                            extras.putString("NAMA", stNama);
                            extras.putString("EMAIL", stEmail);
                            extras.putString("PASS", stPass);
                            extras.putString("GOLDAR", stGolDar);
                            extras.putString("BB", stBB);
                            intent.putExtras(extras);
                            startActivity(intent);
                            finish();
                        }
                    }
                });


            }
        });
    }

    public void setGoldarValue(String stGoldar) {


        stGolDar = stGoldar;

    }

    public class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {


                setGoldarValue(parent.getItemAtPosition(pos).toString());

               /* Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
*/

            } else {

                setGoldarValue(parent.getItemAtPosition(pos).toString());
                /*Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                */
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }


}