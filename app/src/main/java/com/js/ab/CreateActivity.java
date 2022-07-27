package com.js.ab;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button btnBack = findViewById(R.id.create_bar_back);
        btnBack.setOnClickListener(v -> this.finish());

        Button btnSave = findViewById(R.id.create_save_btn);
        EditText etName = findViewById(R.id.create_main_et_account_name);
        EditText etAccount = findViewById(R.id.create_main_et_account);
        EditText etPassword = findViewById(R.id.create_main_et_password);
        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String account = etAccount.getText().toString();
            String password = etPassword.getText().toString();
            if (name.isEmpty() || account.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "保存成功！\n" +
                        "\n名称：" + name +
                        "\n账号：" + account +
                        "\n密码：" + password, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
