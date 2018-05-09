package com.example.carlosgonzalez.aprendiendo;

//import android.content.Intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int num1 = 0;
    public static final String KEY = "KEY";

    EditText etNombre;
    EditText etdireccion;
    EditText ettelefono;
    EditText etcumple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.nombre);
        etdireccion = findViewById(R.id.direccion);
        ettelefono = findViewById(R.id.tel);
        etcumple = findViewById(R.id.cumple);
        Button add = findViewById(R.id.agregar);
        Button view = findViewById(R.id.mostrar);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContactModel contact = new ContactModel();
                contact.setNombre(etNombre.getText().toString());
                contact.setDomicilio(etdireccion.getText().toString());
                contact.setTelefono(ettelefono.getText().toString());
                contact.setCumpleanos(etcumple.getText().toString());
                if (!contact.getNombre().equals("") && !contact.getDomicilio().equals("") && !contact.getCumpleanos().equals("")) {
                    cleanEditTexts();
                    Funciones.insertContacto(MainActivity.this, contact);
                    Toast.makeText(MainActivity.this, "Registro creado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Faltan datos obligatorios", Toast.LENGTH_SHORT).show();
                }


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view1) {
                                       startActivity(new Intent(MainActivity.this, SegundoActivity.class));

                                   }

                               }
        );
        /*if (savedInstanceState != null) {
            num1 = savedInstanceState.getInt(KEY_NUM_1, 0);
        }*/
    }


    public void cleanEditTexts() {
        etNombre.setText("");
        etdireccion.setText("");
        ettelefono.setText("");
        etcumple.setText("");
    }
   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUM_1, num1);
    }*/
}
