package com.example.pierwszaaplikacja;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NowaAktywnosc extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowa_aktywnosc);

        Intent intent = getIntent();
        String message = intent.getStringExtra("Extra-msg");

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    public void backToStartScreen(View v) {
        Intent intent = new Intent(NowaAktywnosc.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void closeApp(View v) {
        finishAffinity();
    }

}