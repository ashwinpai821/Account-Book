package com.example.accountbook1;

import static android.content.ContentValues.TAG;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{

    Button  loginButton1,signup1;
    private FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    EditText email,pass;

            @Override
            protected void onCreate(Bundle savedInstanceState)
            {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);
                 email = findViewById(R.id.emails);
                 pass = findViewById(R.id.pass);
                loginButton1 = findViewById(R.id.loginButton1);
                 loginButton1.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

//                         String email1 = email.getText().toString();
//                         String pass1 = pass.getText().toString();
//                         Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("email").equalTo(email1);
//                         checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//                             @Override
//                             public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                 if(snapshot.exists())
//                                 {
//                                     String systemPassword = snapshot.child(email1).child("password").getValue(String.class);
//                                     if(systemPassword.equals(pass1))
//                                     {
//                                         Intent picture_intent = new Intent(MainActivity.this,homePage_Activity.class);
//                                         startActivity(picture_intent);
//                                     }
//                                     else
//                                         Toast.makeText(MainActivity.this,"Email or Password incorrect",Toast.LENGTH_SHORT).show();
//
//                                 }
//                             }
//
//                             @Override
//                             public void onCancelled(@NonNull DatabaseError error) {
//                                    Toast.makeText(MainActivity.this,"Doesn't exist",Toast.LENGTH_SHORT).show();
//                             }
//                         });
                         Intent picture_intent = new Intent(MainActivity.this,homePage_Activity.class);
                                 startActivity(picture_intent);
                     }
                 });


                // signupbutton
                 signup1 = findViewById(R.id.signup1);
                signup1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent picture_intent = new Intent(MainActivity.this,signUp_Activity.class);
                    startActivity(picture_intent );
                }
            });
             }




}