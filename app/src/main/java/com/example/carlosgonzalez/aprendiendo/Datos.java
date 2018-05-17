package com.example.carlosgonzalez.aprendiendo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Datos extends RecyclerView.Adapter<Datos.ViewHolderDatos> {

    public Datos(Context context, ArrayList<ContactModel> listDatos) {
        this.context = context;
        this.listDatos = listDatos;
    }

    ArrayList<ContactModel> listDatos;
    Context context;

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    final String[] option = {"Editar", "Eliminar"};
                    builder.setTitle("Selecciona Opcion")
                            .setItems(option, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.i("Dialogos", "Opcion:"+option[which]);

                                    if(which == 0 )
                                    {
                                    
                                    }
                                    if(which == 1 )
                                    {
                                        if(Funciones.deleteContacto(context,listDatos.get(getAdapterPosition()).getId())){
                                            listDatos.remove(getAdapterPosition());
                                            notifyItemRemoved(getAdapterPosition());
                                        }
                                    }

                                }
                            }).show();

                }
            });

        }

        public void asignarDatos(ContactModel datos) {
            tv_id_sa.setText(String.valueOf(datos.getId()));
            tv_nombre_sa.setText(datos.getNombre());
            tv_direccion_sa.setText(datos.getDomicilio());
            tv_telefono_sa.setText(datos.getTelefono());
            tv_cumpleanos_sa.setText(datos.getCumpleanos());
        }
    }
}
