package com.example.resactivate_movil_androidstudio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.resactivate_movil_androidstudio.R;
import com.example.resactivate_movil_androidstudio.model.CategoriaServicio;
import com.example.resactivate_movil_androidstudio.util.Funciones;

import java.util.List;

public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<CategoriaServicio> categoriaServicioList;

    public RecyclerViewAdapter(Context context, List<CategoriaServicio> categoriaServicioList) {
        this.context = context;
        this.categoriaServicioList = categoriaServicioList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        CategoriaServicio categoriaServicio= categoriaServicioList.get(position);
        viewholder.tvCategoriaServicio.setText(categoriaServicio.getNombre());
        viewholder.ivImgCategoriaServicio.setImageResource(Funciones.idImg(categoriaServicio.getImgLogo()));
        //pendiente el código para el boton

    }

    //@Override
    //public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    //}

    @Override
    public int getItemCount() {

        return categoriaServicioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivImgCategoriaServicio;
        public TextView tvCategoriaServicio;
        public Button btnExplorar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoriaServicio=itemView.findViewById(R.id.tvcategoriaServicio);
            ivImgCategoriaServicio=itemView.findViewById(R.id.ivimgCategoriaServicio);
            btnExplorar=itemView.findViewById(R.id.btnExplorar);
        }


    }
}
