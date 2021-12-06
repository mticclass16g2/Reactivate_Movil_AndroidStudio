package com.example.resactivate_movil_androidstudio.model;

import android.media.Image;

import java.sql.Blob;

public class CategoriaServicio {
    private int id;
    private String nombre;
    private String imgLogo;

    public CategoriaServicio() {
    }

    public CategoriaServicio(String nombre, String imgLogo) {
        //this.id = id;
        this.nombre = nombre;
        this.imgLogo = imgLogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }
}


