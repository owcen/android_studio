package com.example.menu2;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Author extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        String enteredText = getIntent().getStringExtra("enteredText");
        Log.d("AuthorActivity", "Entered Text: " + enteredText);
        TextView author_name = findViewById(R.id.author_name);
        author_name.setText("Autorem aplikacji jest " + enteredText);
    }
}
