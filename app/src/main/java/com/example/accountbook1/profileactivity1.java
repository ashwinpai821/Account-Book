package com.example.accountbook1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class profileactivity1 extends AppCompatActivity {
    ImageView storeImage ;
    Uri imageUri;
    ProgressDialog progressDialog;
    FirebaseDatabase rootNode;
    DatabaseReference reference,ref2;

    TextView name,email,phno,store_name;
    Button home,imageChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_profileactivity1);
        home = findViewById(R.id.homepageB);
        storeImage = findViewById(R.id.pro_store_image);
        name = findViewById(R.id.pro_name);
        email = findViewById(R.id.pro_email);
        phno = findViewById(R.id.pro_phno);
        store_name= findViewById(R.id.store_name);


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference().child("Users");
        ref2 = reference.child("Nadeem");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass2 info = snapshot.getValue(UserHelperClass2.class);
                name.setText("Name : "+info.getName());
                email.setText("Email : "+info.getEmail());
                phno.setText("Phone No : "+info.getPhoneNo());
                store_name.setText("Store Name : "+info.getStore_name());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent picture_intent = new Intent(profileactivity1.this,homePage_Activity.class);
                startActivity(picture_intent );
            }
        });




    }
}