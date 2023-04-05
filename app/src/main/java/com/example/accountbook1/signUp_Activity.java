package com.example.accountbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp_Activity extends AppCompatActivity {
    Button loginButton2,signup2;
    FirebaseDatabase rootNode;
    DatabaseReference reference,ref2,ref3;
    EditText NAME,EMAIL,PHNO,PASSWORD,SHOP_NAME;
    String nameio,emailio,passwordio,phnoio,shopio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        NAME = findViewById(R.id.name);
        EMAIL=findViewById(R.id.email);
        PASSWORD=findViewById(R.id.passwordS);
        PHNO=findViewById(R.id.phno);
        SHOP_NAME=findViewById(R.id.sstore_name);
        loginButton2 = findViewById(R.id.login);
        loginButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(signUp_Activity.this,MainActivity.class);
                startActivity(picture_intent );
            }
        });
        signup2 = findViewById(R.id.next);
        signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameio = NAME.getText().toString();
                phnoio = PHNO.getText().toString();
                passwordio = PASSWORD.getText().toString();
                emailio = EMAIL.getText().toString();
                shopio = SHOP_NAME.getText().toString();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");
                UserHelperClass2 helperClass = new UserHelperClass2(nameio,emailio,phnoio,passwordio,shopio);
                reference.child(emailio).setValue(helperClass);
            }
        });

    }
}