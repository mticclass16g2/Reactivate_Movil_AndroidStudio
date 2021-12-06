package com.example.resactivate_movil_androidstudio.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.resactivate_movil_androidstudio.R;
import com.example.resactivate_movil_androidstudio.model.CategoriaServicio;
import com.example.resactivate_movil_androidstudio.model.Servicio;
import com.example.resactivate_movil_androidstudio.model.Usuario;
import com.example.resactivate_movil_androidstudio.util.Util;

//import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class databaseHandler extends SQLiteOpenHelper {
    public databaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String CREATE_TABLE_CATEGORIASERVICIO="CREATE TABLE " + Util.TABLE_CATEGORIASERVICIO + "(" +
            Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NOMBRE + " TEXT," +
            Util.KEY_IMGLOGO + " TEXT" + ")";

        try {
            db.execSQL(CREATE_TABLE_CATEGORIASERVICIO);
        } catch (SQLException e) {
            Log.e("error-creando","onCreate sqlite" + e.getLocalizedMessage());
        }
    Log.e("Crea-Serviciocategoria","onCreate de sqlite");



    //Creación de la taba de Usuario
        String CREATE_TABLE_USUARIO="CREATE TABLE " + Util.TABLE_USUARIO + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY, " +
                Util.KEY_NOMBRE + " TEXT," +
                Util.KEY_APELLIDO + " TEXT," +
                Util.KEY_CEDULA + " TEXT," +
                Util.KEY_FECHANACIMIENTO + " TEXT," +
                Util.KEY_TELEFONO + " TEXT," +
                Util.KEY_EMAIL + " TEXT," +
                Util.KEY_PASSWORD + " TEXT," +
                Util.KEY_ACEPTA_TYCONDICIONES + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_USUARIO);

        //para crear la taba de Servicio

        String CREATE_TABLE_SERVICIO="CREATE TABLE " + Util.TABLE_SERVICO + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY, " +
                Util.KEY_NOMBRECOMAPNIA + " TEXT," +
                Util.KEY_DESCRIPCION + " TEXT," +
                Util.KEY_CIUDAD_ID + " INTEGER," +
                Util.KEY_USUARIO_ID + " INTEGER," +
                Util.KEY_URLSERVICIO + " TEXT," +
                Util.KEY_URLFACEBOOK + " TEXT," +
                Util.KEY_IMGLOGO + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_SERVICIO);

        //para crear la taba de Departamento

        String CREATE_TABLE_DEPARTAMENTO="CREATE TABLE " + Util.TABLE_DEPARTAMENTO + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY, " +
                Util.KEY_NOMBRE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_DEPARTAMENTO);

        //para crear la taba Ciudad

        String CREATE_TABLE_CIUDAD="CREATE TABLE " + Util.TABLE_CIUDAD + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY, " +
                Util.KEY_NOMBRE + " TEXT," +
                Util.KEY_DEPARTAMENTO_ID + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_CIUDAD);

        //para crear la taba Servicios_enCategoria

        String CREATE_TABLE_SERVICIOS_ENCATEGORIA="CREATE TABLE " + Util.TABLE_SERVICIOS_ENCATEGORIA+ "(" +
                Util.KEY_CATEGORIA_ID + " INTEGER," +
                Util.KEY_SERVICIO_ID + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_SERVICIOS_ENCATEGORIA);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String DROP_TABLESERVICIOCATEGORIA=String.valueOf(R.string.db_drop_ServicioCategoria);
        //db.execSQL(DROP_TABLESERVICIOCATEGORIA, new String[]{Util.DATABASE_NAME});

        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_CATEGORIASERVICIO);

        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_SERVICO);
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_CIUDAD);
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_DEPARTAMENTO);
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_SERVICIOS_ENCATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_USUARIO);

        onCreate(db);
    }
    /*==================================
    *  Metodos para categoriasServicio
    * =================================
    *
    * AGREGAR UNA CATEGORIA DE SERVICO
    * */
    public void addCategoriaServicio(CategoriaServicio categoriaServicio){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Util.KEY_NOMBRE,categoriaServicio.getNombre());
        values.put(Util.KEY_IMGLOGO,categoriaServicio.getImgLogo());
        //insert
        //db.execSQL("create table if not exists categoriasServicio (id INTEGER PRIMARY KEY,nombre TEXT,imgLogo TEXT)");
        db.insert(Util.TABLE_CATEGORIASERVICIO,null,values);
        //db.close();
    }

    // OBTENER UNA CATEGORIA DE SERVICIO A PARTIR DEL NOMBRE

    public CategoriaServicio getCategoriaServico_ByName(String NombreCategoria) {
        // array of columns to fetch
        String[] columns = {
                Util.KEY_ID,
                Util.KEY_NOMBRE,
                Util.KEY_IMGLOGO
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = Util.KEY_NOMBRE + " = ?";
        // selection argument
        String[] selectionArgs = {NombreCategoria};


        Cursor cursor = db.query(Util.TABLE_CATEGORIASERVICIO, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);
        if (cursor.getCount() >0) {
            cursor.moveToFirst();
            CategoriaServicio categoriaServicio = new CategoriaServicio();
            categoriaServicio.setId(Integer.parseInt(cursor.getString(0)));
            categoriaServicio.setNombre(cursor.getString(1));
            categoriaServicio.setImgLogo(cursor.getString(2));
            return categoriaServicio;
        }
        return null;

    }

    // OBTENER UNA CATEGORIA DE SERVICIO A PARTIR DEL ID
    public CategoriaServicio getcategoriaServicio(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(Util.TABLE_CATEGORIASERVICIO, new String[]{Util.KEY_ID,
                Util.KEY_NOMBRE, Util.KEY_IMGLOGO},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null,null);
        if (cursor != null) {
            cursor.moveToFirst();
            CategoriaServicio categoriaServicio = new CategoriaServicio();
            categoriaServicio.setId(Integer.parseInt(cursor.getString(0)));
            categoriaServicio.setNombre(cursor.getString(1));
            categoriaServicio.setImgLogo(cursor.getString(2));
            return categoriaServicio;
        }
    return null;
    }

    //OBTENER TODAS LAS CATEGORIAS DE SERVICO
       public List<CategoriaServicio> getAllCategoriaServicio(){
          List<CategoriaServicio> categoriaServicioList=new ArrayList<CategoriaServicio>();
         //Select all CategoriaServicio
            String selectAll="SELECT * FROM " + Util.TABLE_CATEGORIASERVICIO;
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor=db.rawQuery(selectAll,null);
            //Loop through all data
           if (cursor.moveToFirst()) {
               do {
                   CategoriaServicio categoriaServicio = new CategoriaServicio();
                   categoriaServicio.setId(Integer.parseInt(cursor.getString(0)));
                   categoriaServicio.setNombre(cursor.getString(1));
                   categoriaServicio.setImgLogo(cursor.getString(2));
                   // agregar categoría de servicio a la lista
                   categoriaServicioList.add(categoriaServicio);
               } while (cursor.moveToNext());
           }
           return categoriaServicioList;
        }

    /**
     * CHEQUEAR SI LA BASE DE DATOS EXISTE Y PUEDE SER LEIDA.
     * @return
     **/

    public boolean checkDataBase(String InDBFile) {
        SQLiteDatabase checkDB = null;
        boolean res = false;
        try {
            checkDB = SQLiteDatabase.openDatabase(InDBFile, null,
                    SQLiteDatabase.OPEN_READONLY);
            res = (checkDB.getVersion() > 0);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
            Log.e("checkDataBase", "El archivo no pudo abrirse como base de datos.");

            res = false;
        }
        return res;
    }

    //====================================================
    //          METODOS PARA EL MANEJO DE USUARIOS
    //====================================================
    /**
     *
     * =================================================
     * Ese método agrega un usuario
     * =================================================
     * @param usuario
     */
    public long addUser(Usuario usuario) {
        long usuario_id=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NOMBRE, usuario.getNombre());
        values.put(Util.KEY_APELLIDO, usuario.getApellido());
        values.put(Util.KEY_CEDULA, usuario.getCedula());
        values.put(Util.KEY_FECHANACIMIENTO, usuario.getFechaNacimiento());
        values.put(Util.KEY_TELEFONO, usuario.getTelefono());
        values.put(Util.KEY_EMAIL, usuario.getEmail());
        values.put(Util.KEY_PASSWORD, usuario.getPassword());
        values.put(Util.KEY_ACEPTA_TYCONDICIONES, usuario.getAceptaTyCondiciones());

       //db.insert(Util.TABLE_USUARIO, null, values);
        try{
            usuario_id= db.insert(Util.TABLE_USUARIO, null, values) ;
            return usuario_id;
        } catch(SQLiteException e){
            Log.e("Error-creandoUsuario", e.getMessage());
        } finally {
            db.close();
        }
        return usuario_id;
    }

    /**
     *
     * @return list
     */
    @SuppressLint("Range")
    public List<Usuario> getAllUsers() {
        // arreglo de columnas a obtener
        String[] columns = {
                Util.KEY_USUARIO_ID,
                Util.KEY_NOMBRE,
                Util.KEY_APELLIDO,
                Util.KEY_CEDULA,
                Util.KEY_FECHANACIMIENTO,
                Util.KEY_TELEFONO,
                Util.KEY_EMAIL,
                Util.KEY_PASSWORD,
                Util.KEY_ACEPTA_TYCONDICIONES,

        };
        // ordenamiento
        String sortOrder =
                Util.KEY_NOMBRE + " ASC";
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_USUARIO, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Util.KEY_USUARIO_ID))));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(Util.KEY_NOMBRE)));
                usuario.setApellido(cursor.getString(cursor.getColumnIndex(Util.KEY_APELLIDO)));
                usuario.setCedula(cursor.getString(cursor.getColumnIndex(Util.KEY_CEDULA)));
                usuario.setFechaNacimiento(cursor.getString(cursor.getColumnIndex(Util.KEY_FECHANACIMIENTO)));
                usuario.setTelefono(cursor.getString(cursor.getColumnIndex(Util.KEY_TELEFONO)));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex(Util.KEY_EMAIL)));
                usuario.setPassword(cursor.getString(cursor.getColumnIndex(Util.KEY_PASSWORD)));
                usuario.setAceptaTyCondiciones(cursor.getInt(cursor.getColumnIndex(Util.KEY_ACEPTA_TYCONDICIONES)));

                // agregando usuario a la lista de registros
                usuarioList.add(usuario);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // returnamos la lista de usuarios
        return usuarioList;
    }
 //...
    /**
     * Este metodo actualiza un usuario
     *
     * @param usuario
     */
    public void updateUser(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NOMBRE, usuario.getNombre());
        values.put(Util.KEY_APELLIDO, usuario.getApellido());
        values.put(Util.KEY_CEDULA, usuario.getCedula());
        values.put(Util.KEY_FECHANACIMIENTO, usuario.getFechaNacimiento());
        values.put(Util.KEY_TELEFONO, usuario.getTelefono());
        values.put(Util.KEY_EMAIL, usuario.getEmail());
        values.put(Util.KEY_PASSWORD, usuario.getPassword());
        values.put(Util.KEY_ACEPTA_TYCONDICIONES, usuario.getAceptaTyCondiciones());

        db.update(Util.TABLE_USUARIO, values, Util.KEY_USUARIO_ID + " = ?",
                new String[]{String.valueOf(usuario.getId())});
        db.close();
    }
    /**
     * Este Método borra un Usuario
     *
     * @param usuario
     */
    public void deleteUser(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete usuario record by id
        db.delete(Util.TABLE_USUARIO, Util.KEY_USUARIO_ID + " = ?",
                new String[]{String.valueOf(usuario.getId())});
        db.close();
    }
    /**
     * Este metodo chequea si un usario existe
     *
     * @param email
     * @return true/false
     */
    public boolean checkUsuario(String email) {
        // array of columns to fetch
        String[] columns = {
                Util.KEY_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = Util.KEY_EMAIL + " = ?";
        // selection argument
        String[] selectionArgs = {email};
        // query usuario table with condition

        Cursor cursor = db.query(Util.TABLE_USUARIO, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
/*
=======================================
      Metodos para Manejar Servicios
======================================
*/
  /*
  *Ese método agrega un Servicio
  * @param servicio
  */
    public Long addService(Servicio servicio) {
        long servicio_id=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NOMBRECOMAPNIA, servicio.getNombreCompania());
        values.put(Util.KEY_DESCRIPCION, servicio.getDescripcion());
        values.put(Util.KEY_CIUDAD_ID, servicio.getCiudad_id());
        values.put(Util.KEY_USUARIO_ID, servicio.getUsuario_id());
        values.put(Util.KEY_URLSERVICIO, servicio.getUrlServicio());
        values.put(Util.KEY_URLFACEBOOK, servicio.getUrlFacebook());
        values.put(Util.KEY_IMGLOGO, servicio.getImgLogo());
        db.insert(Util.TABLE_SERVICO, null, values);
        db.close();

        try{
            servicio_id= db.insert(Util.TABLE_USUARIO, null, values) ;
            return servicio_id;
        } catch(SQLiteException e){
            Log.e("Error-creandoServico", e.getMessage());
        } finally {
            db.close();
        }
        return servicio_id;
    }

    /**
     * Estemeto nos retorna todos los servicos o los asociados a una categoria
     * @return list
     */

    @SuppressLint("Range")
    public List<Servicio> getAllServices(String categoria_id ) {
        // arreglo de columnas a obtener
        String[] columns = {
                Util.KEY_NOMBRECOMAPNIA,
                Util.KEY_DESCRIPCION,
                Util.KEY_USUARIO_ID,
                Util.KEY_CIUDAD_ID,
                Util.KEY_URLSERVICIO,
                Util.KEY_URLFACEBOOK,
                Util.KEY_IMGLOGO,
                Util.KEY_CATEGORIA_ID
        };

        // Criterio de seleccion
        if (!categoria_id.equals("-1")){
            String selection = Util.KEY_CATEGORIA_ID + " = ?";
            // selection argument
            String[] selectionArgs = {categoria_id};
        }


        // ordenamiento
        String sortOrder =
                Util.KEY_NOMBRECOMAPNIA + " ASC";
        List<Servicio> servicioList = new ArrayList<Servicio>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_SERVICO, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Servicio servicio = new Servicio();
                servicio.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Util.KEY_USUARIO_ID))));
                servicio.setNombreCompania(cursor.getString(cursor.getColumnIndex(Util.KEY_NOMBRECOMAPNIA)));
                servicio.setDescripcion(cursor.getString(cursor.getColumnIndex(Util.KEY_DESCRIPCION)));
                servicio.setUsuario_id(cursor.getInt(cursor.getColumnIndex(Util.KEY_USUARIO_ID)));
                servicio.setCiudad_id(cursor.getInt(cursor.getColumnIndex(Util.KEY_CIUDAD_ID)));
                servicio.setUrlServicio(cursor.getString(cursor.getColumnIndex(Util.KEY_URLSERVICIO)));
                servicio.setUrlFacebook(cursor.getString(cursor.getColumnIndex(Util.KEY_URLFACEBOOK)));
                servicio.setImgLogo(cursor.getString(cursor.getColumnIndex(Util.KEY_IMGLOGO)));
                // agregamos servicio a la lista de registros
                servicioList.add(servicio);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // returnamos la lista de servicios
        return servicioList;
    }

    /*
    * METODOS ALTERNATIVOS
    *
    * */
    public boolean insertData(String sentence){
        boolean success = false;
        try {
            SQLiteDatabase db1 = getWritableDatabase();
            db1.execSQL(sentence);
            success = true;
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    public Cursor getData(String sentence, String[] params) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cu = db.rawQuery(sentence, params);
        return cu;
    }

    public int deleteData(String tabla, String whereClause, String[] params) {
        SQLiteDatabase db = getWritableDatabase();
        int nRows = db.delete(tabla, whereClause, params);
        return  nRows;
    }

    public int updateData(String tabla, ContentValues cv, String whereClause, String[] params) {
        SQLiteDatabase db = getWritableDatabase();
        int nRows = db.update(tabla, cv, whereClause, params);
        return  nRows;
    }

    public void Sqlquery(String strQuery){

        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL(strQuery);
    }
}
