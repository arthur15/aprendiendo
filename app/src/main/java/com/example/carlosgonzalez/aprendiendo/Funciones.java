package com.example.carlosgonzalez.aprendiendo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by
 * carlosgonzalez on 03/05/18.
 */

public class Funciones extends AppCompatActivity{
    public static void insertContacto(Context context, ContactModel contacto)
    {
        DataBase db = DataBase.getInstance(context);
        SQLiteDatabase dba = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Nombre", contacto.getNombre());
        cv.put("Direccion", contacto.getDomicilio());
        cv.put("Telefono", contacto.getTelefono());
        cv.put("Cumpleanos", contacto.getCumpleanos());
        dba.insert("agenda",null, cv);
        db.close();
    }


    public static ArrayList<ContactModel> leerContacto(Context context){
        ArrayList <ContactModel> contactos = new ArrayList<>();
        try {
            DataBase db = DataBase.getInstance(context);
            SQLiteDatabase dba = db.getReadableDatabase();
            Cursor cursor = dba.rawQuery("select * from agenda", null);
            if (cursor != null && !cursor.isClosed() && cursor.moveToFirst()) {
                do {
                    ContactModel contacto = new ContactModel();
                    //contacto.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    contacto.setNombre(cursor.getString(cursor.getColumnIndex("Nombre")));
                    contacto.setDomicilio(cursor.getString(cursor.getColumnIndex("Direccion")));
                    contacto.setTelefono(cursor.getString(cursor.getColumnIndex("Telefono")));
                    contacto.setCumpleanos(cursor.getString(cursor.getColumnIndex("Cumpleanos")));
                    contactos.add(contacto);
                } while (cursor.moveToNext());
                cursor.close();
                dba.close();
            }
        }catch(Exception e){
            Log.e("error_select",e.getMessage());
        }
    return contactos;
    }


}
