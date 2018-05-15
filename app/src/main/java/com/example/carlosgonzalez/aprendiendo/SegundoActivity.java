package com.example.carlosgonzalez.aprendiendo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(SegundoActivity.this, 1));
        Datos datos = new Datos(this, Funciones.leerContacto(SegundoActivity.this));
        recyclerView.setAdapter(datos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

         recyclerView = findViewById(R.id.recycler);



        FloatingActionButton back = findViewById(R.id.fabAtras);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View back) {
                startActivity(new Intent(SegundoActivity.this, MainActivity.class));
            }
        });

    }




}
