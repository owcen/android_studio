package com.example.bazy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pracownicy")
public class Pracownik {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "imie")
    private String imie;
    @ColumnInfo(name = "nazwisko")
    private String nazwisko;
    @ColumnInfo(name = "wynagrodzenie")
    private double wynagrodzenie;
    public Pracownik(String imie, String nazwisko, double wynagrodzenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wynagrodzenie = wynagrodzenie;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public double getWynagrodzenie() {
        return wynagrodzenie;
    }
    public void setWynagrodzenie(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}