package com.js.ab;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btnBack = findViewById(R.id.signup_bar_back);
        Button btnSignUp = findViewById(R.id.signup_btn_signup);
        TextView tvProtocol = findViewById(R.id.signup_agree_protocol);

        btnBack.setOnClickListener(v -> this.finish());
        btnSignUp.setOnClickListener(v -> Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show());
        tvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
    }
}