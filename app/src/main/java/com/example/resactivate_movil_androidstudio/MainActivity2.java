package com.example.resactivate_movil_androidstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.resactivate_movil_androidstudio.adapter.RecyclerViewAdapter;
import com.example.resactivate_movil_androidstudio.data.databaseHandler;
import com.example.resactivate_movil_androidstudio.model.CategoriaServicio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<CategoriaServicio> categoriasServicioArrayList;
    private ArrayAdapter<String> categoriasServicioArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoriasServicioArrayList= new ArrayList<>();
        databaseHandler db=new databaseHandler(MainActivity2.this);
        List<CategoriaServicio> categoriaServicioList=db.getAllCategoriaServicio();

        for (CategoriaServicio categoriaServicio: categoriaServicioList){
            Log.d("Maintivity2", "onCreate:" + categoriaServicio.getNombre());
            categoriaServicioList.add(categoriaServicio);

        }
        //setup adapter
        recyclerViewAdapter=new RecyclerViewAdapter(MainActivity2.this,categoriasServicioArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}