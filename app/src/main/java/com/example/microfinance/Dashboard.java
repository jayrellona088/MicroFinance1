package com.example.microfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    private LinearLayout l_Loan,l_EOQ,l_LoanHistory, l_AccountBook,l_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        l_Loan = findViewById(R.id.l_Loan);
        l_EOQ = findViewById(R.id.l_EOQ);
        l_LoanHistory = findViewById(R.id.l_LoanHistory);
        l_AccountBook = findViewById(R.id.l_AccountBook);
        l_profile = findViewById(R.id.l_profile);



        l_Loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,EOQ.class);
                startActivity(intent);
            }
        });

    }
}