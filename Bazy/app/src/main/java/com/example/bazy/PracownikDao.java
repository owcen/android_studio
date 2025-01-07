package com.example.bazy;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface PracownikDao {
    @Insert
    void insert(Pracownik pracownik);
}