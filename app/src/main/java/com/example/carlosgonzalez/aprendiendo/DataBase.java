package com.example.carlosgonzalez.aprendiendo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by
 * carlosgonzalez on 03/05/18.
 */

public class DataBase extends SQLiteOpenHelper{

    private static final String NAME = "agenda.db";
    private static final int VERSION = 1;
    public static DataBase db;

    public static DataBase getInstance(Context context){
        if(db == null){
            db = new DataBase(context);
        }
        return db;
    }

    private DataBase(Context context) {
        super(context, NAME, null, VERSION);
    }

    private String create_tabla = "create table agenda(id integer primary key autoincrement, Nombre text, Direccion, text, Telefono text, Cumpleanos text) ";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
