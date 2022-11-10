package com.example.microfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText m_phoneNumber, m_password, m_retypePassword;
    private Button m_btnSignUp;
    private DatabaseHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        m_phoneNumber = findViewById(R.id.et_signup_phoneNumber);
        m_password = findViewById(R.id.et_signup_Password);
        m_retypePassword = findViewById(R.id.et_signup_RetypePassword);
        m_btnSignUp = findViewById(R.id.btn_signup_SignUp);

        m_btnSignUp.setOnClickListener(view -> {
            String phoneNumber = m_phoneNumber.getText().toString();
            String password = m_password.getText().toString();
            String retypePassword = m_retypePassword.getText().toString();

            if (phoneNumber.equals("") || password.equals("") | retypePassword.equals("")) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                if (password.equals(retypePassword)) {
                    boolean userExist = Db.checkPhoneNumber(phoneNumber);
                    if (!userExist) {
                        boolean userRegistered = Db.insertData(phoneNumber, password);
                        if (userRegistered) {
                            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Phone number already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Password does no match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}