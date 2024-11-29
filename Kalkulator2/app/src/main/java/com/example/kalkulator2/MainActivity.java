package com.example.kalkulator2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText pierwszaCyfra, drugaCyfra;
    private TextView wynik;
    private Button dodawanie, odejmowanie, mnozenie, dzielenie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pierwszaCyfra = findViewById(R.id.pierwszaCyfra);
        drugaCyfra = findViewById(R.id.drugaCyfra);
        wynik = findViewById(R.id.wynik);
        dodawanie = findViewById(R.id.dodawanie);
        odejmowanie = findViewById(R.id.odejmowanie);
        mnozenie = findViewById(R.id.mnozenie);
        dzielenie = findViewById(R.id.dzielenie);

        dodawanie.setOnClickListener(view -> wykonajDzialanie('+'));
        odejmowanie.setOnClickListener(view -> wykonajDzialanie('-'));
        mnozenie.setOnClickListener(view -> wykonajDzialanie('*'));
        dzielenie.setOnClickListener(view -> wykonajDzialanie('/'));
    }

    private void wykonajDzialanie(char operacja) {
        String liczba1Text = pierwszaCyfra.getText().toString();
        String liczba2Text = drugaCyfra.getText().toString();

        if (!liczba1Text.isEmpty() && !liczba2Text.isEmpty()) {
            double liczba1 = Double.parseDouble(liczba1Text);
            double liczba2 = Double.parseDouble(liczba2Text);
            double wynikDzialania = 0;

            try {
                switch (operacja) {
                    case '+':
                        wynikDzialania = Kalkulator.dodaj(liczba1, liczba2);
                        break;
                    case '-':
                        wynikDzialania = Kalkulator.odejmij(liczba1, liczba2);
                        break;
                    case '*':
                        wynikDzialania = Kalkulator.mnoz(liczba1, liczba2);
                        break;
                    case '/':
                        wynikDzialania = Kalkulator.dziel(liczba1, liczba2);
                        break;
                }
                wynik.setText(Double.toString(wynikDzialania));
            } catch (ArithmeticException e) {
                wynik.setText("Błąd: " + e.getMessage());
            }
        } else {
            wynik.setText("Błąd: Oba pola muszą być wypełnione");
        }
    }

    public void rozszerzone(View v) {
        Intent intent = new Intent(MainActivity.this, Kalkulator_Rozszerzony.class);
        startActivity(intent);
    }
}

