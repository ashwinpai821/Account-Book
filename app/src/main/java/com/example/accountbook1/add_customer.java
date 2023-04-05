package com.example.accountbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_customer extends AppCompatActivity {
    Button finalAdd;
    ImageView arrow;
    EditText name,phno,amt,deadline;
    RadioGroup radGrp;
    String nameio,phnoio,deadlineio;
    FirebaseDatabase rootNode;
    DatabaseReference reference,ref2,ref3;
    boolean status;
    float amtio;
    RadioButton radsend,radrec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        name = findViewById(R.id.name);
        phno = findViewById(R.id.phno);
        amt = findViewById(R.id.amount);
        deadline = findViewById(R.id.date);
        radGrp = findViewById(R.id.radioGroup);
        radsend = findViewById(R.id.send);
        radrec = findViewById(R.id.receive);
        finalAdd = findViewById(R.id.finalAdd);

        finalAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameio = name.getText().toString();
                phnoio = phno.getText().toString();
                amtio = Float.parseFloat(amt.getText().toString());
                deadlineio = deadline.getText().toString();
                int temp  = radGrp.getCheckedRadioButtonId();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");
                ref2 = reference.child("Nadeem");
                ref3 = ref2.child("Customers");
                if(radGrp.getCheckedRadioButtonId()==R.id.send)
                {
                    status = true;
                }
                else
                    status = false;
                UserHelperClass helperClass = new UserHelperClass(nameio,phnoio, deadlineio, amtio,status);
                ref3.child(nameio).setValue(helperClass);

                name.setText("");
                phno.setText("");
                amt.setText("");
                deadline.setText("");
                radGrp.clearCheck();
                Toast.makeText(add_customer.this,"Customer Added Successfully!",Toast.LENGTH_LONG).show();

                /*if(temp==R.id.send)
                {
                    Intent intent=new Intent(add_customer.this,Money_Give.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(add_customer.this,mtr.class);
                    startActivity(intent);
                }*/
            }
        });

    }




}