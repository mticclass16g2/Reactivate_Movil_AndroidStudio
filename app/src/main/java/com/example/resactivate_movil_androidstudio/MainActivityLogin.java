package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resactivate_movil_androidstudio.data.databaseHandler;

public class MainActivityLogin extends AppCompatActivity {
    public EditText etEmail;
    public EditText etPassword;
    public EditText etNombre;
    public EditText etApellido;
    public EditText etCelular;
    public EditText etCategoriaServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
    }
    public void Ingresar(View view){
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        databaseHandler db=new databaseHandler(this);
        if (db.checkUsuario(etEmail.getText().toString())){
            this.goCrearPerfil(view);
        }
        Toast t=Toast.makeText(this,"Usuario o password incorrecto",Toast.LENGTH_LONG);
        t.show();
    }


    public void goCrearPerfil(View view){
        //capture Datos Perfil1
        //etEmail=findViewById(R.id.)
        Intent i = new Intent(this, ProfileActivity1.class);
        startActivity(i);
    }
}