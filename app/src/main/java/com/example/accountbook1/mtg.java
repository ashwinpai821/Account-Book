package com.example.accountbook1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class mtg extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference,ref2,ref3;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtg);
        ls = findViewById(R.id.ls2);
        ArrayList<String> list = new ArrayList<String>();
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this,R.layout.list_item,list);
        ls.setAdapter(adapter2);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference().child("Users");
        ref2 = reference.child("Nadeem");
        ref3 = ref2.child("Customers");
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    UserHelperClass info = snapshot.getValue(UserHelperClass.class);
                    if(info.getStatus())
                    {
                        String txt = "Name = " + info.getName() + ", Deadline : " + info.getDeadline()+" , Amount -  " + info.amount;
                        list.add(txt);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}