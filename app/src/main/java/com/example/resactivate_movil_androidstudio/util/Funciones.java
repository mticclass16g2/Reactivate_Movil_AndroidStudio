package com.example.resactivate_movil_androidstudio.util;


import android.content.Context;

public class Funciones {
    private static Context context;

    public Funciones(Context current){
        this.context = current;
    }

    public static int idImg(String strImgName) {
        return context.getResources().getIdentifier("com.example.resactivate_movil_androidstudio:drawable/" + strImgName, null, null);

    }
}
