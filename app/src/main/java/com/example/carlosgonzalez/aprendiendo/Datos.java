package com.example.carlosgonzalez.aprendiendo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Datos extends RecyclerView.Adapter<Datos.ViewHolderDatos> {

    public Datos(ArrayList<ContactModel> listDatos) {
        this.listDatos = listDatos;
    }

    ArrayList<ContactModel> listDatos;

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos_bd,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tv_id_sa, tv_nombre_sa, tv_direccion_sa, tv_telefono_sa, tv_cumpleanos_sa;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            /*comentario prueba*/
            tv_id_sa  = itemView.findViewById(R.id.tv_id_sa);
            tv_nombre_sa  = itemView.findViewById(R.id.tv_nombre_sa);
            tv_direccion_sa = itemView.findViewById(R.id.tv_direccion_sa);
            tv_telefono_sa  = itemView.findViewById(R.id.tv_telefono_sa);
            tv_cumpleanos_sa = itemView.findViewById(R.id.tv_cumpleanos_sa);
        }

        public void asignarDatos(ContactModel datos) {
            //tv_id_sa.setText(datos.getId().toString());
            tv_nombre_sa.setText(datos.getNombre());
            tv_direccion_sa.setText(datos.getDomicilio());
            tv_telefono_sa.setText(datos.getTelefono());
            tv_cumpleanos_sa.setText(datos.getCumpleanos());
        }
    }
}
