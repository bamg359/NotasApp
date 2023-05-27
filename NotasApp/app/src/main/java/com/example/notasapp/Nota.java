package com.example.notasapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas_tabla")
public class Nota {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String titulo;

    public String descripción;

    public Nota(String titulo, String descripción) {
        this.id = id;
        this.titulo = titulo;
        this.descripción = descripción;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }


}



