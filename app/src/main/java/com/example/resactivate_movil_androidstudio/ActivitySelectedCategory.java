package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivitySelectedCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_category);
    }

    public void verDetalleServicio(View view){
        //String.valueOf(view)
        String[] imgb_id=getResources().getResourceName(view.getId()).split("/");
        String imgId=String.valueOf(imgb_id[1]);
        //ImageButton imb=findViewById(view.getId());
        //Toast t= Toast.makeText(this,String.valueOf(imb.sou.toString()), Toast.LENGTH_LONG);
        //t.show();
        Intent i = new Intent(this,DetalleServicioActivity.class);

        startActivity(i);
    }
}