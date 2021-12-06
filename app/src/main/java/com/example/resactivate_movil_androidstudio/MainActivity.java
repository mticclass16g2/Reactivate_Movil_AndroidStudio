package com.example.resactivate_movil_androidstudio;

import static android.graphics.Bitmap.*;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.resactivate_movil_androidstudio.data.databaseHandler;
import com.example.resactivate_movil_androidstudio.model.CategoriaServicio;
import com.example.resactivate_movil_androidstudio.util.Util;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {
    //@SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHandler db=new databaseHandler(MainActivity.this);

       /* ---------Insercion de registros en categoriasServicio---------------------------
        CategoriaServicio categoriaServicio1 = new CategoriaServicio("Abogados", "reactivate_seccion_03_03_asesoria_juridica.png");
        db.addCategoriaServicio(categoriaServicio1);

        CategoriaServicio categoriaServicio2 = new CategoriaServicio("Construccion", "reactivate_seccion_03_07_arquitectura_construccion.png");
        db.addCategoriaServicio(categoriaServicio2);

        CategoriaServicio categoriaServicio3 = new CategoriaServicio("Asesores Contables", "reactivate_seccion_03_08_asesoria_contable.png");
        db.addCategoriaServicio(categoriaServicio3);

        CategoriaServicio categoriaServicio4 = new CategoriaServicio("Cuidado de Muebles", "reactivate_seccion_03_05_cuidado_de_muebles.png");
        db.addCategoriaServicio(categoriaServicio4);

        CategoriaServicio categoriaServicio5 = new CategoriaServicio("Cuidado de Mascotas", "reactivate_seccion_03_04_cuidado_de_mascotas.png");
        db.addCategoriaServicio(categoriaServicio5);

        CategoriaServicio categoriaServicio6 = new CategoriaServicio("Electricistas", "reactivate_seccion_03_09_electricistas.png");
        db.addCategoriaServicio(categoriaServicio6);


        CategoriaServicio categoriaServicio7 = new CategoriaServicio("Gimnasios", "reactivate_seccion_03_06_gimnasios_entrenadores_personales.png");
        db.addCategoriaServicio(categoriaServicio7);

        CategoriaServicio categoriaServicio8 = new CategoriaServicio("Atención de Eventos", "reactivate_seccion_03_01_atencion_de_eventos.png");
        db.addCategoriaServicio(categoriaServicio8);

        CategoriaServicio categoriaServicio9 = new CategoriaServicio("Plomeros", "reactivate_seccion_03_02_plomeros.png");
        db.addCategoriaServicio(categoriaServicio9);

        CategoriaServicio categoriaServicio10 = new CategoriaServicio("Profesores", "reactivate_seccion_03_03_profesores.png");
        db.addCategoriaServicio(categoriaServicio10);

        CategoriaServicio categoriaServicio11 = new CategoriaServicio("Restaurantes", "reactivate_seccion_03_04_restaurantes.png");
        db.addCategoriaServicio(categoriaServicio11);

        CategoriaServicio categoriaServicio12 = new CategoriaServicio("Servicios de Salud", "reactivate_seccion_03_05_servicios_de_salud.png");
        db.addCategoriaServicio(categoriaServicio12);

        CategoriaServicio categoriaServicio13 = new CategoriaServicio("Servicios de Limpieza", "reactivate_seccion_03_06_servicios_de_limpieza.png");
        db.addCategoriaServicio(categoriaServicio13);

        CategoriaServicio categoriaServicio14 = new CategoriaServicio("Servicios de Marketing Digital", "reactivate_seccion_03_02_marketing_digital.png");
        db.addCategoriaServicio(categoriaServicio14);

        CategoriaServicio categoriaServicio15 = new CategoriaServicio("Servicios Odontologicos", "reactivate_seccion_03_07_servicios_odontologicos.png");
        db.addCategoriaServicio(categoriaServicio15);

        CategoriaServicio categoriaServicio16 = new CategoriaServicio("Servicios en Tecnologia", "reactivate_seccion_03_08_servicios_en_tecnologia.png");
        db.addCategoriaServicio(categoriaServicio16);

        */

/*
        String CREATE_TABLE_SERVICIO="CREATE TABLE " + Util.TABLE_SERVICO + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY, " +
                Util.KEY_NOMBRECOMAPNIA + " TEXT," +
                Util.KEY_DESCRIPCION + " TEXT," +
                Util.KEY_CIUDAD_ID + " INTEGER," +
                Util.KEY_USUARIO_ID + " INTEGER," +
                Util.KEY_URLSERVICIO + " TEXT," +
                Util.KEY_URLFACEBOOK + " TEXT," +
                Util.KEY_IMGLOGO + " TEXT" + ")";
        db.crearTabla(CREATE_TABLE_SERVICIO);

*/
       //String strInsert="INSERT INTO usuario VALUES(1,'pepito1','apellido1', '12345678', '2000/12/01', '1213123','prueba@gmail.com','123',1)";
       //db.insertData(strInsert);
   }

    public void iniciarLogin(View view){
        Intent i = new Intent(this, MainActivityLogin.class);
        startActivity(i);
    }

    public void iniciarSelected(View view){
        Intent j = new Intent(this, ActivitySelectedCategory.class);
        startActivity(j);
    }
    public void iniciarPrueba(View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}