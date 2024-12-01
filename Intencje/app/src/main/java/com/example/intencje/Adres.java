package com.example.intencje;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Adres extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adres);
    }

    public void mapa2(View v) {
        TextView editTextAdres = findViewById(R.id.adres);
        String adres = editTextAdres.getText().toString();
        Uri geoUri = Uri.parse("geo:0,0?q=" + Uri.encode(adres));
        Intent i = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(i);
    }
}
