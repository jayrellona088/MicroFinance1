package com.example.microfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText m_phoneNumber, m_password;
    private Button m_btnLogin, m_btnSignUp;
    private DatabaseHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Db = new DatabaseHelper(this);
        m_phoneNumber = findViewById(R.id.et_main_phoneNumber);
        m_password = findViewById(R.id.et_main_Password);
        m_btnLogin = findViewById(R.id.btn_main_SignIn);
        m_btnSignUp = findViewById(R.id.btn_signup_SignUp);

        m_btnLogin.setOnClickListener(view -> {
            String phoneNumber = m_phoneNumber.getText().toString();
            String password = m_password.getText().toString();

            if (phoneNumber.equals("") || password.equals("")) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean userExist = Db.checkPhoneNumberAndPassword(phoneNumber, password);
                if (userExist) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT);

                    Intent intent = new Intent(this, Dashboard.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "invalid phone number or password", Toast.LENGTH_SHORT);
                }
            }
        });

        m_btnSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}