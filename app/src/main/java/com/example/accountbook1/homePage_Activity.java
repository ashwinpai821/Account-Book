package com.example.accountbook1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class homePage_Activity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    LinearLayout mtg,stat,blog;
    FloatingActionButton float1,f2;
    TextView sn;
    DatabaseReference reference,ref2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        sn = findViewById(R.id.storename);
        BottomNavigationView bottom = findViewById(R.id.nav);
        bottom.setOnItemSelectedListener(this);
        LinearLayout mtr = (LinearLayout )findViewById(R.id.mtr);
        LinearLayout mtg = (LinearLayout )findViewById(R.id.mtg);
        LinearLayout stats = (LinearLayout )findViewById(R.id.stats);
        LinearLayout blog = (LinearLayout )findViewById(R.id.blog);
        FloatingActionButton float1 = findViewById(R.id.floatAdd);

        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        ref2 = reference.child("Nadeem");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass2 info = snapshot.getValue(UserHelperClass2.class);
                sn.setText(info.getStore_name());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }*/
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"My Notification");
        builder.setContentTitle("Your payment is due today! ");
        builder.setContentText("To Pay : " + "Name ,"+ "   Amount : " + "xx/-"  );
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(1,builder.build());



        mtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(homePage_Activity.this,mtr.class);
                startActivity(picture_intent );
            }
        });
        mtg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(homePage_Activity.this,Money_Give.class);
                startActivity(picture_intent );
            }
        });
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(homePage_Activity.this,stats.class);
                startActivity(picture_intent );
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(homePage_Activity.this,blog_page.class);
                startActivity(picture_intent );
            }
        });

        float1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(homePage_Activity.this,add_customer.class);
                startActivity(picture_intent );
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.profilepage12)
        {
            Intent picture_intent = new Intent(homePage_Activity.this,profileactivity1.class);
            startActivity(picture_intent );
            return true;
        }
        else {

            return true;
        }
    }
}