package com.example.pierwszaaplikacja;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch upperCase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upperCase = findViewById(R.id.switch1);
    }
    public void wyslijWiadomosc(View v) {
        EditText editText = findViewById(R.id.editText1);
        String message = editText.getText().toString();
        Intent intent = new Intent(this, NowaAktywnosc.class);
        if (upperCase.isChecked()) {
            message = message.toUpperCase();
        }
        intent.putExtra("Extra-msg", message);
        startActivity(intent);
    }

    public void closeApp(View v) {
        finishAffinity();
    }

}