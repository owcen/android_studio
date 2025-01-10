package com.example.bazy;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public void preferences(View view){
        SharedPreferences myPreferences =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putString("KluczWartoscString", "Ala");
        myEditor.putInt("KluczWartoscInt", 12);
        myEditor.putBoolean("KluczWartoscBool", true);
        myEditor.commit();
        String wartoscString = myPreferences.getString("KluczWartoscString", "unknown");
        int wartoscInt = myPreferences.getInt("KluczWartoscInt", 0);
        boolean wartoscBool = myPreferences.getBoolean("KluczWartoscBool", false);
        Log.d("KluczWartoscString:", wartoscString);
        Log.d("KluczWartoscInt:", ""+ wartoscInt);
        Log.d("KluczWartoscBool:", ""+ wartoscBool);
    }

    public void database(View view){
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);
        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS pierwszaBaza (imie VARCHAR(200), wiek INT,numer INT)"
);
        ContentValues row1 = new ContentValues();
        row1.put("imie", "Marek");
        row1.put("wiek", 22);
        row1.put("numer", 1);
        ContentValues row2 = new ContentValues();
        row2.put("imie", "Agata");
        row2.put("wiek", 19);
        row2.put("numer", 2);
        myDB.insert("pierwszaBaza", null, row1);
        myDB.insert("pierwszaBaza", null, row2);
        Cursor myCursor = myDB.rawQuery("select imie, wiek, numer from pierwszaBaza",
                null);
        while(myCursor.moveToNext()) {
            String imie = myCursor.getString(0);
            int wiek = myCursor.getInt(1);
            int numer = myCursor.getInt(2);
            Log.d("Imie:", imie);
            Log.d("Wiek:", ""+ wiek);
            Log.d("Numer:", ""+ numer);
        }
        myCursor.close();
        myDB.close();
    }

    public void pamiecWewnetrzna(View view) throws IOException {
        File internalStorageDir = getFilesDir();
        File myfile = new File(internalStorageDir, "myfile.csv");
        Log.d("ścieżka pliku", "" + internalStorageDir);
        FileOutputStream fos = new FileOutputStream(myfile);
        fos.write("Pamiec wewnetrzna programu".getBytes());
        fos.close();
        FileInputStream fis = new FileInputStream(myfile);
        int i = 0;
        while ((i = fis.read()) != -1) {
            Log.d("czytanie z pliku", "" + (char) i);
        }
        fis.close();
    }

    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "pracownicy").build();

    }
    public void dodajPracownika(View view) {
        Pracownik pracownik1 = new Pracownik("Jan", "Kowalski", 8000);
        new Thread(() -> {
            db.pracownikDao().insert(pracownik1);
            Log.d("Dodano pracownika", "Pracownik o imieniu: " + pracownik1.getImie() +
                            ", nazwisku: " + pracownik1.getNazwisko() + " i wynagrodzeniu miesiecznym "

                            + pracownik1.getWynagrodzenie() + " został dodany pod id " +

                            pracownik1.getId());
        }).start();
    }
}