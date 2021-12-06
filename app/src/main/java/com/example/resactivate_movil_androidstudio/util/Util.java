package com.example.resactivate_movil_androidstudio.util;




import  java.lang.Class;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;


public class Util {
    //database related items
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="reactivate_db";
    public static final String TABLE_CATEGORIASERVICIO="categoriasServicio";
    public static final String TABLE_USUARIO="usuario";
    public static final String TABLE_DEPARTAMENTO="departamento";
    public static final String TABLE_CIUDAD="ciudad";
    public static final String TABLE_SERVICO="servicio";
    public static final String TABLE_SERVICIOS_ENCATEGORIA="servicios_encategoria";

    //los columnas comunes
    public static final String KEY_ID="id";
    public static final String KEY_NOMBRE="nombre";

    //otras columnas de CategoriaServicio
    public static final String KEY_IMGLOGO="imgLogo";

    //otras columnas de Servicio
    public static final String KEY_NOMBRECOMAPNIA="nombreCompania";
    public static final String KEY_DESCRIPCION="descripcion";
    public static final String KEY_CIUDAD_ID="ciudad_id";
    public static final String KEY_USUARIO_ID="usuario_id";
    public static final String KEY_URLSERVICIO="urlServicio";
    public static final String KEY_URLFACEBOOK="urlFacebook";

    //otras columnas de Usuario
    public static final String KEY_APELLIDO="apellido";
    public static final String KEY_CEDULA="cedula";
    public static final String KEY_FECHANACIMIENTO="fechaNacimiento";
    public static final String KEY_TELEFONO="telefono";
    public static final String KEY_EMAIL="email";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_ACEPTA_TYCONDICIONES="aceptaTyCondiciones";

    //otras columnas de departamento

    //otras columnas cidud
    public static final String KEY_DEPARTAMENTO_ID="departamento_id";

    //otras columnas Servicios_enCategoria
    public static final String KEY_CATEGORIA_ID="categoria_id";
    public static final String KEY_SERVICIO_ID="servicio_id";




}



