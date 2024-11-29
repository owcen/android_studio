package com.example.kalkulator2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Kalkulator_Rozszerzony extends AppCompatActivity {
    private EditText pierwszaCyfra, drugaCyfra;
    private TextView wynik;
    private Button dodawanie, odejmowanie, mnozenie, dzielenie, pierwiastkowanie, potegowanie, silnia, powrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rozszerzony_kalkulator);

        pierwszaCyfra = findViewById(R.id.pierwszaCyfra);
        drugaCyfra = findViewById(R.id.drugaCyfra);
        dodawanie = findViewById(R.id.dodawanie);
        odejmowanie = findViewById(R.id.odejmowanie);
        mnozenie = findViewById(R.id.mnozenie);
        dzielenie = findViewById(R.id.dzielenie);
        pierwiastkowanie = findViewById(R.id.pierwiastkowanie);
        potegowanie = findViewById(R.id.potegowanie);
        silnia = findViewById(R.id.silnia);
        powrot = findViewById(R.id.powrot);
        wynik = findViewById(R.id.wynik);

        dodawanie.setOnClickListener(v -> wykonajDzialanie('+'));
        odejmowanie.setOnClickListener(v -> wykonajDzialanie('-'));
        mnozenie.setOnClickListener(v -> wykonajDzialanie('*'));
        dzielenie.setOnClickListener(v -> wykonajDzialanie('/'));
        pierwiastkowanie.setOnClickListener(v -> wykonajDzialanie('p'));
        potegowanie.setOnClickListener(v -> wykonajDzialanie('r'));
        silnia.setOnClickListener(v -> wykonajDzialanie('s'));
    }

    private void wykonajDzialanie(char operacja) {
        String cyfra1Tekst = pierwszaCyfra.getText().toString();
        String cyfra2Tekst = drugaCyfra.getText().toString();

        if (cyfra1Tekst.isEmpty()) {
            wynik.setText("Podaj liczbę");
        } else if (operacja != 's' && cyfra2Tekst.isEmpty()) {
            wynik.setText("Podaj liczbę");
        } else {
            double cyfra1 = Double.parseDouble(cyfra1Tekst);
            double cyfra2 = Double.parseDouble(cyfra2Tekst);
            double wynikDzialania = 0;

            try {
                switch (operacja) {
                    case '+':
                        wynikDzialania = Kalkulator.dodaj(cyfra1, cyfra2);
                        break;
                    case '-':
                        wynikDzialania = Kalkulator.odejmij(cyfra1, cyfra2);
                        break;
                    case '*':
                        wynikDzialania = Kalkulator.mnoz(cyfra1, cyfra2);
                        break;
                    case '/':
                        if (cyfra2 == 0) {
                            wynik.setText("Nie można dzielić przez zero");
                            return;
                        }
                        wynikDzialania = Kalkulator.dziel(cyfra1, cyfra2);
                        break;
                    case 'p':
                        wynikDzialania = Kalkulator.pierwiastkuj(cyfra1, cyfra2);
                        break;
                    case 'r':
                        wynikDzialania = Kalkulator.poteguj(cyfra1, cyfra2);
                        break;
                    case 's':
                        wynikDzialania = Kalkulator.silnia(cyfra1);
                        break;
                }
                wynik.setText(Double.toString(wynikDzialania));
            } catch (IllegalArgumentException e) {
                wynik.setText("Błąd: " + e.getMessage());
            }

            wynik.setText(String.format("%.2f",wynikDzialania));
        }
    }


    public void powrot(View v)  {
        Intent intent = new Intent(Kalkulator_Rozszerzony.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

