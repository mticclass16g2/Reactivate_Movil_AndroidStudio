package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.resactivate_movil_androidstudio.data.databaseHandler;
import com.example.resactivate_movil_androidstudio.model.CategoriaServicio;
import com.example.resactivate_movil_androidstudio.model.Usuario;
import com.example.resactivate_movil_androidstudio.util.Util;

public class ProfileActivity1 extends AppCompatActivity {
    EditText etNombre;
    EditText etApellido;
    EditText etCedula;
    EditText etEmail;
    EditText etPassword;
    EditText etTelefono;
    EditText etFechaNacimiento;
    String AceptaTyC="-1";
    Spinner spnCategoriaServicio;
    String Categoria_id="-1";
    String CategoriaNombre="";

    databaseHandler db=new databaseHandler(ProfileActivity1.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_1);
        spnCategoriaServicio=findViewById(R.id.spnCategoriaServicio);
        spnCategoriaServicio.setSelection(0);

    }
    public void continuarProfile2(View view){
     long usuario_id=0;

        //capturar los datos para continuar al profile2
        etNombre=findViewById(R.id.etNombrepf1);
        etApellido=findViewById(R.id.etApellidopf1);
        etEmail=findViewById(R.id.etEmailpf1);
        etPassword=findViewById(R.id.etPasswordpf1);
        etCedula=findViewById(R.id.etCedulapf1);
        etTelefono=findViewById(R.id.etTelefonopf1);
        etFechaNacimiento=findViewById(R.id.etFechaNacimmiento);

        Usuario usuario=new Usuario();
        usuario.setNombre(String.valueOf(etNombre.getText()));
        usuario.setApellido(String.valueOf(etApellido.getText()));
        usuario.setCedula(String.valueOf(etCedula.getText()));
        usuario.setTelefono(String.valueOf(etTelefono.getText()));
        usuario.setPassword(String.valueOf(etPassword.getText()));
        usuario.setEmail(String.valueOf(etEmail.getText()));
        usuario.setFechaNacimiento(String.valueOf(etFechaNacimiento.getText()));
        usuario.setAceptaTyCondiciones(Integer.parseInt(String.valueOf(AceptaTyC)));
     /*
        usuario_id=db.addUser(usuario);
      */
        if (usuario_id !=-1){
            spnCategoriaServicio=findViewById(R.id.spnCategoriaServicio);
            try {
                CategoriaNombre=spnCategoriaServicio.getSelectedItem().toString();
            }catch (Exception e){
                Log.e("error-xx",e.getMessage());
            }

            CategoriaServicio categoriaServicio= new CategoriaServicio();

            if(db.getCategoriaServico_ByName(String.valueOf(CategoriaNombre)) !=null) {

                categoriaServicio = db.getCategoriaServico_ByName(String.valueOf(CategoriaNombre));
            }
            else{
                    categoriaServicio=null;
            }

            try {
                //Categoria_id=String.valueOf(categoriaServicio.getId());
                Categoria_id="-1";
            }
            catch (Exception  e){
                Log.e("error-getting categoriaId","categoriaID" + e.getMessage());
            }
            Intent i = new Intent(this, ProfileActivity2.class);
            i.putExtra("usario_id",String.valueOf(usuario_id));
            i.putExtra("categoria_id",String.valueOf(Categoria_id));
            startActivity(i);
        }
        else{
            Toast t=Toast.makeText(this,"No se puede continuar a la siguiente etapa, revisa los datos",Toast.LENGTH_LONG);
            t.show();
        }


    }


}