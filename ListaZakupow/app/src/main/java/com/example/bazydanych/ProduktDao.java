package com.example.bazydanych;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProduktDao {
    @Insert
    void insert(Produkt produkt);

    @Delete
    void delete(Produkt produkt);

    @Query("SELECT * FROM produkty WHERE nazwa = :nazwa LIMIT 1")
    Produkt findByName(String nazwa);

    @Query("SELECT * FROM produkty")
    List<Produkt> getAllProducts();
}
