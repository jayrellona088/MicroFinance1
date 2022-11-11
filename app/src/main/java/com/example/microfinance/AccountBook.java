package com.example.microfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountBook extends AppCompatActivity {
    private Button btn_actBookEnter;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_book);

        btn_actBookEnter = findViewById(R.id.btn_actBookEnter);

        dialog = new Dialog(AccountBook.this);
        dialog.setContentView(R.layout.activity_account_book_enter);

        btn_actBookEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}