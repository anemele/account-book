package com.js.ab;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        ImageButton btnBack = findViewById(R.id.create_bar_back);
        btnBack.setOnClickListener(v -> this.finish());
    }

}
