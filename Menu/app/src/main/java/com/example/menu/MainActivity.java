package com.example.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(1,1,1, "Moje pierwsze menu");
        menu.add(2,2,2, "Moje drugie menu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Naciśnięto", "x=" + item.getItemId());
        int id = item.getItemId();
        if (id == R.id.opcja1) {
            Log.d("kliknięto w Opcje 1!", "Opcja 1");
        }
        else if (id == R.id.opcja2) {
            Log.d("kliknięto w Opcje 2!", "Opcja 2");
        }
        else if (id == R.id.opcja3) {
            Log.d("kliknięto!", "Opcja 3");
        }
        else if (id == R.id.opcja4) {
            Log.d("kliknięto!", "Opcja 4");
            autor();
        }
    return true;
    }

    private void autor() {
        Log.d("Wywołałem metodę autor", "Informacja o autorze");
    }
}