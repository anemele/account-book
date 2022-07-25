package com.js.ab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        ImageButton btnBack = findViewById(R.id.more_bar_back);
        btnBack.setOnClickListener(v -> this.finish());
    }
}