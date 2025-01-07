package com.example.bazy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pracownik.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PracownikDao pracownikDao();
}