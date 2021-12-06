package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetalleServicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_servicio);
    }
    public void Contactar(View view){
        Toast t=Toast.makeText(this,"Se ha enviado un correo, Su solicitud pronto será atendida",Toast.LENGTH_LONG);
        t.show();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}