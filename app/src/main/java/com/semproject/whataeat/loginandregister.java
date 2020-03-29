package com.semproject.whataeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginandregister extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginandregister);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.signup);
        tvSignIn = findViewById(R.id.already);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();

                if (email.isEmpty()) {
                    emailId.setError("Please enter the email ID");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter the password");
                    password.requestFocus();
                } else if (pwd.isEmpty() && email.isEmpty()) {
                    Toast.makeText(loginandregister.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

                } else if (!(pwd.isEmpty() && email.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(loginandregister.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(loginandregister.this, " SIGNUP UNSUCCESSFUL ", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(loginandregister.this, homepage.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(loginandregister.this, "ERROR OCURRED!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginandregister.this,loginactivity.class);
                startActivity(i);
            }
        });
    }

}
