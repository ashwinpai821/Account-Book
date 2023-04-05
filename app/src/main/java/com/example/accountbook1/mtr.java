package com.example.accountbook1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class mtr extends AppCompatActivity {
    LinearLayout linear_money_give;
    ImageView arrow;
    TextView tab_name,tab_dead,tab_amount;
    FirebaseDatabase rootNode;
    DatabaseReference reference,ref2,ref3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtr);
        linear_money_give = findViewById(R.id.linear_money_give);
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
                    if(!info.getStatus())
                    {
                        String name = info.getName();
                        String deadline = info.getDeadline();
                        float amount = info.getAmount();
                        addNew(name,deadline,amount);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void addNew(String name,String deadline, float amount) {

        View view1 = getLayoutInflater().inflate(R.layout.money_give_customer, null);
        view1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(mtr.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                removeView(view1);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return false;
            }
        });
        tab_name = view1.findViewById(R.id.tab_name);
        tab_dead = view1.findViewById(R.id.tab_dead);
        tab_amount = view1.findViewById(R.id.tab_amount);
        tab_name.setText("Customer Name - " + name );
        tab_amount.setText("Amount - "+ amount + "/-");
        tab_dead.setText("Deadline - "+  deadline);
        linear_money_give.addView(view1);

    }

    private void removeView(View view) {
        linear_money_give.removeView(view);
    }
}