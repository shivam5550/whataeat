package com.semproject.whataeat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class homepage extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button btnLogout;
    Button btnsubmit;
   FirebaseAuth mFirebaseAuth;
   private FirebaseAuth.AuthStateListener mAuthStateListener;
   EditText mAge,mHeight,mWeight;
   FirebaseFirestore fstore;

   String gender,frequency;
   String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mFirebaseAuth= FirebaseAuth.getInstance();
        fstore =FirebaseFirestore.getInstance();
        mAge = findViewById(R.id.Age);
        mHeight =findViewById(R.id.Height);
        mWeight = findViewById(R.id.Weight);
        Spinner sgender = (Spinner) findViewById(R.id.spinnerg);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(homepage.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.gender));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sgender.setAdapter(myAdapter1);

        sgender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String x = (String) parent.getItemAtPosition(position);
                 gender = x;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner sfrequency = (Spinner) findViewById(R.id.spinnerf);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(homepage.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.frequency));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sfrequency.setAdapter(myAdapter2);

        sfrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String y = (String) parent.getItemAtPosition(position);
                frequency = y;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnsubmit = findViewById(R.id.submit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt( mAge.getText().toString() );
                int weight = Integer.parseInt( mWeight.getText().toString() );
                int height  = Integer.parseInt( mHeight.getText().toString() );
                userID = mFirebaseAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fstore.collection("users").document(userID);

                Map<String,Object> user = new HashMap<>();
                user.put("Gender",gender);
                user.put("Age",age);
                user.put("Weight",weight);
                user.put("Height",height);
                user.put("Frequency",frequency);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG," All Information is added");
                    }
                });
            }
        });


       btnLogout = findViewById(R.id.logout);
       btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
               Intent intToMain = new Intent(homepage.this,loginandregister.class);
               startActivity(intToMain);
            }
        });


    }
}
