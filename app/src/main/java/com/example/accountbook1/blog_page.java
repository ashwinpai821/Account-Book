package com.example.accountbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class blog_page extends AppCompatActivity {
    TextView txt;
    String showtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_page);
        showtxt = " BUSINESS GROWTH:" + "\n\n\n" + "Business Growth is a stage where the business reaches " +
                "the point for expansion and seeks additional options to generate more profit. " +
                "Business growth is a function of the business lifecycle," +
                " industry growth trends, and the owners desire for equity value creation."+"\n" +"\n" +
                "Choosing the right business growth capital comes down to the following variables:\n" +
                "\n" +
                "--The size of the capital raise.\n" +
                "--The cost of capital\n" +
                "--The flexibility of capital.\n" +
                "--The term structure of capital."+"\n" +
                "These four variables must be optimized to arrive at the best business growth capital solution. " +
                " Most companies use an advisor to evaluate and source capital, due to the criticality of the job.  " +
                "Each of these variables are solved with market intelligence and deal making expertise." +
                "  The end result is a business growth capital solution that satisfies your unique need, " +
                "and allows your scale-up vision to take flight."+"\n"+"\n"+
                "Successful use cases have been:\n" +
                "\n" +
                "--Growth capital to fund business scale-up\n" +
                "--Growth capital to fund new product development and launch\n" +
                "--Growth capital to fund regional expansion\n" +
                "--Growth capital to fund up front expenses and working capital build up\n" +
                "--Acquisition roll ups\n" +
                "--Acquisitions by Independent sponsors\n" +
                "--Company to Company acquisitions";
        txt = findViewById(R.id.blogtext);
        txt.setText(showtxt);
    }
}