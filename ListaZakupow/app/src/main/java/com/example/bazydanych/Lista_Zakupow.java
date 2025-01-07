package com.example.bazydanych;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.room.Room;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Lista_Zakupow extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "produkty").build();

        TextView lista = findViewById(R.id.lista);

        new Thread(() -> {
            List<Produkt> produkty = db.produktDao().getAllProducts();
            for (Produkt p : produkty) {
                Log.d("Produkt", "Name: " + p.getNazwa());
            }
            StringBuilder produktyText = new StringBuilder();
            for (Produkt produkt : produkty) {
                produktyText.append(produkt.getNazwa()).append("\n");
            }
            runOnUiThread(() -> lista.setText(produktyText.toString()));
        }).start();
    }

    public void powrot(View v) {
        Intent intent = new Intent(Lista_Zakupow.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
