package com.js.ab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogIn = findViewById(R.id.login_btn_login);
        EditText etAccount = findViewById(R.id.login_account);
        EditText etPassword = findViewById(R.id.login_password);
        CheckBox checkBox = findViewById(R.id.login_btn_agree);

        btnLogIn.setOnClickListener(v -> {
            if (etAccount.getText().toString().equals("admin") &&
                    etPassword.getText().toString().equals("123456")) {
                if (checkBox.isChecked()) {
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "请先同意协议", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "密码或账号错误", Toast.LENGTH_SHORT).show();
            }
        });
    }
}