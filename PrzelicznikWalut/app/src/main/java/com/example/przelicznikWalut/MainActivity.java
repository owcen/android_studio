package com.example.przelicznikWalut;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText ilePrzeliczyc;
    private TextView wynik;
    private Button buttonUsd, buttonEur, buttonChf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ilePrzeliczyc = findViewById(R.id.ilePrzeliczyc);
        wynik = findViewById(R.id.wynik);
        buttonUsd = findViewById(R.id.buttonUsd);
        buttonEur = findViewById(R.id.buttonEur);
        buttonChf = findViewById(R.id.buttonChf);

        buttonUsd.setOnClickListener(v -> przeliczWalute(3.99));
        buttonEur.setOnClickListener(v -> przeliczWalute(4.32));
        buttonChf.setOnClickListener(v -> przeliczWalute(4.53));
    }

    private void przeliczWalute (double kurs) {
        String kwotaTekst = ilePrzeliczyc.getText().toString();

        if (kwotaTekst.isEmpty()){
            wynik.setText("Nie podałeś kwoty do przeliczenia");
        } else {
            double kwota = Double.parseDouble(kwotaTekst);
            double wynikPrzeliczenia = kwota * kurs;

            wynik.setText(String.format("Wynik: %.2f PLN", wynikPrzeliczenia));
        }

    }
}