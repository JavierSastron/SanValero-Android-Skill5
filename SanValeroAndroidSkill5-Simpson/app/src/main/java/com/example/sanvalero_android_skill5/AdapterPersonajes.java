package com.example.sanvalero_android_skill5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPersonajes extends RecyclerView.Adapter<AdapterPersonajes.ViewHolderPersonajes> {

    ArrayList<Simpson> listPersonajes;

    public AdapterPersonajes(ArrayList<Simpson> listPersonajes) {
        this.listPersonajes = listPersonajes;
    }

    @NonNull
    @Override
    public AdapterPersonajes.ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPersonajes.ViewHolderPersonajes holder, int position) {
        holder.nombre.setText(listPersonajes.get(position).getNombre());
        holder.info.setText(listPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        TextView nombre, info;
        ImageView foto;

        public ViewHolderPersonajes(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.idNombre);
            info = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
