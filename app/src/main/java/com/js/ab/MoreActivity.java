package com.js.ab;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        Button btnBack = findViewById(R.id.more_bar_back);
        btnBack.setOnClickListener(v -> this.finish());
    }
}