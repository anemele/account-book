package com.js.ab;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private final String account = "admin";
    private final String password = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogIn = findViewById(R.id.login_btn_login);
        Button btnSignUp = findViewById(R.id.login_btn_signup);
        EditText etAccount = findViewById(R.id.login_account);
        EditText etPassword = findViewById(R.id.login_password);
        CheckBox checkBox = findViewById(R.id.login_btn_agree);
        TextView tvProtocol = findViewById(R.id.login_agree_protocol);

        btnLogIn.setOnClickListener(v -> {
            if (etAccount.getText().toString().isEmpty()) {
                Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (etPassword.getText().toString().isEmpty()) {
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!checkBox.isChecked()) {
                Toast.makeText(this, "请先同意协议", Toast.LENGTH_SHORT).show();
                return;
            }
            if (etAccount.getText().toString().equals(account) &&
                    etPassword.getText().toString().equals(password)) {
                etAccount.setText("");
                etPassword.setText("");
                checkBox.setChecked(false);

                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
            }
        });

        btnSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
        });

        tvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
    }
}