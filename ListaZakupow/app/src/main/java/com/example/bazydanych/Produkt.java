package com.example.bazydanych;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produkty")
public class Produkt {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nazwa")
    private String nazwa;

    public Produkt() {
    }

    public Produkt(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
