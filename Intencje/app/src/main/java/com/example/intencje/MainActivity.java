package com.example.intencje;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void reakcja(View v) {
        Intent i = new Intent(this, Intencja.class);
        startActivity(i);
    }

    public void reakcjaParametr(View v) {
        Intent i = new Intent(this, IntencjaParametr.class);
        i.putExtra("zmienna", "jestem przekazanym parametrem");
        startActivity(i);
    }

    public void strona(View v){
        Uri u = Uri.parse("https://www.ue.katowice.pl/");
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        startActivity(i);
    }

    public void mapa(View v) {
        Uri geoUri = Uri.parse("geo:50.26081,19.04552");
        Intent i = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(i);
    }

    public void kalendarz(View v) {
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, Calendar.getInstance().getTimeInMillis());
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
        startActivity(intent);
    }

    public void wlaczAparat(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(takePictureIntent);
    }

    public void reakcja2(View v) {
        Intent i = new Intent(this, Adres.class);
        startActivity(i);
    }
}