package com.example.bazydanych;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Produkt.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProduktDao produktDao();
}
