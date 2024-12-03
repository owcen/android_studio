package com.example.menu2;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mute) {
        mute();
        }
        else if (id == R.id.author) {
        author();
        }
        else if (id == R.id.switch_off) {
        closeApp();
        }
        else if (id == R.id.maps) {
        maps();
        }
        else if (id == R.id.browser) {
        browser();
        }
        return true;
    }

    public void mute() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null && audioManager != null) {
            if (notificationManager.isNotificationPolicyAccessGranted()) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(this, "Telefon wyciszony", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Brak uprawnień do trybu Nie przeszkadzać", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Nie udało się wyciszyć telefonu", Toast.LENGTH_SHORT).show();
        }
    }

    private void author() {
        final EditText input = new EditText(this);
        input.setHint("O autorze");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Imie autora")
                .setView(input)
                .setPositiveButton("OK", (dialog, which) -> {
                    String enteredText = input.getText().toString();
                    Intent intent = new Intent(MainActivity.this, Author.class);
                    intent.putExtra("enteredText", enteredText);
                    startActivity(intent);
                })
                .setNegativeButton("Anuluj", (dialog, which) -> dialog.cancel())
                .show();
    }

    public void closeApp() {
        Toast.makeText(this, "Zamkam aplikację", Toast.LENGTH_LONG).show();
        finishAffinity();
    }

    public void maps() {
        Toast.makeText(this, "Uruchamiam mapy Google", Toast.LENGTH_LONG).show();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_APP_MAPS);
        startActivity(i);
    }

    public void browser() {
        Toast.makeText(this, "Uruchamiam przeglądarkę", Toast.LENGTH_LONG).show();
        Uri u = Uri.parse("https://www.google.pl/");
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        startActivity(i);
    }
}