package com.example.intencje;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntencjaParametr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intencja_parametr);
        Bundle b = getIntent().getExtras();
        String parametr = b.getString("zmienna");
        TextView poleTekstowe = findViewById(R.id.textView2);
        poleTekstowe.setText(parametr);
    }
}
