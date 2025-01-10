package com.example.bazydanych;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private Button dodajProdukt, usunProdukt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "produkty").build();

        dodajProdukt = findViewById(R.id.dodajProdukt);
        usunProdukt = findViewById(R.id.usunProdukt);

        dodajProdukt.setOnClickListener(view -> dodajProdukt(view));
        usunProdukt.setOnClickListener(view -> usunProdukt(view));
    }

    public void dodajProdukt(View view) {
        TextView editTextProduct = findViewById(R.id.nazwaProduktu);
        String nazwaProduktu = editTextProduct.getText().toString();

        Log.d("DodajProdukt", "Nazwa entered: " + nazwaProduktu);
        if (nazwaProduktu == null || nazwaProduktu.trim().isEmpty()) {
            Log.e("DodajProdukt", "Error: Nazwa is empty or null");
            return;
        }

        Produkt produkt = new Produkt(nazwaProduktu);
        new Thread(() -> {
            db.produktDao().insert(produkt);
            Log.d("Dodano produkt", "Nazwa: " + produkt.getNazwa());
        }).start();
    }

    public void usunProdukt(View view) {
        TextView editTextProduct = findViewById(R.id.nazwaProduktu);
        String nazwaProduktu = editTextProduct.getText().toString();

        new Thread(() -> {
            Produkt produkt = db.produktDao().findByName(nazwaProduktu);
            if (produkt != null) {
                db.produktDao().delete(produkt);
                Log.d("UsunProdukt", "Produkt o nazwie '" + nazwaProduktu + "' został usunięty.");
            } else {
                Log.d("UsunProdukt", "Produkt o nazwie '" + nazwaProduktu + "' nie istnieje.");
            }
        }).start();
    }

    public void wyswietlListe(View v)  {
        new Thread(() -> {
            List<Produkt> produkty = db.produktDao().getAllProducts();
            for (Produkt produkt : produkty) {
                if (produkt.getNazwa() == null || produkt.getNazwa().trim().isEmpty()) {
                    db.produktDao().delete(produkt);
                    Log.d("ClearList", "Removed invalid entry.");
                }
            }
        }).start();

        Intent intent = new Intent(MainActivity.this, Lista_Zakupow.class);
        startActivity(intent);
        finish();
    }
}