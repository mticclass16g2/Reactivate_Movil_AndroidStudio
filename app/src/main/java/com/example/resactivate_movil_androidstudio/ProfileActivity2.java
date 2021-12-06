package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.resactivate_movil_androidstudio.data.databaseHandler;
import com.example.resactivate_movil_androidstudio.model.Servicio;

public class ProfileActivity2 extends AppCompatActivity {
    EditText etNombreCompania;
    EditText etDescripcion;
    String Ciudad_id;
    EditText etUrlServicio;
    EditText etUrlFacebook;
    String strImgLogo;
    String Categoria_id;
    Spinner spnCategoriaServicio;
    String usuario_id;
    Spinner spnCiudades;


    databaseHandler db=new databaseHandler(ProfileActivity2.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        Intent intent=getIntent();
        usuario_id=intent.getStringExtra("usuario_id");
        Categoria_id=intent.getStringExtra("categoria_id");
        spnCiudades=findViewById(R.id.spnCiudades);
        spnCiudades.setSelection(0);
    }
    public void iniciarHome(View view){
        //Capturamos los datos del servicio
        long servicio_id=0;
        etNombreCompania=findViewById(R.id.etNombreNegocio);
        etDescripcion=findViewById(R.id.etDescripcion);
        spnCiudades=findViewById(R.id.spnCiudades);
        Ciudad_id=spnCiudades.getSelectedItem().toString();
        etUrlServicio=findViewById(R.id.etUrlSitioWeb);
        etUrlFacebook=findViewById(R.id.etUrlFacebook);
        strImgLogo="drawable/reactivate_small_business.png";
        spnCiudades=findViewById(R.id.spnCiudades);
        Ciudad_id=spnCiudades.getSelectedItem().toString();

        Servicio servicio=new Servicio();
        servicio.setNombreCompania(String.valueOf(etNombreCompania.getText()));
        //servicio.setDescripcion(String.valueOf(etDescripcion.getText()));
        //servicio.setCiudad_id(Integer.parseInt(String.valueOf(Ciudad_id)));
        //servicio.setUsuario_id(Integer.parseInt(String.valueOf(usuario_id)));
        servicio.setUrlServicio(String.valueOf(etUrlServicio.getText()));
        servicio.setUrlFacebook(String.valueOf(etUrlFacebook.getText()));
        servicio.setImgLogo(String.valueOf(strImgLogo));
        servicio.setCategoria_id(Integer.parseInt(String.valueOf(Categoria_id)));

        //servicio_id=db.addService(servicio);

        if (servicio_id !=-1){
            Toast t=Toast.makeText(this,"Servicio Agreagdo con éxito",Toast.LENGTH_LONG);
            t.show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else{
            Toast t=Toast.makeText(this,"Se ha presentado un error, revise los datos",Toast.LENGTH_LONG);
            t.show();
        }


    }
}