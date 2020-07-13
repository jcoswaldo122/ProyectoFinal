package com.example.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL("create table alumnos(codigo int primary key , nombre Text, apellido Text, cedula Text, correo Text, telefono Text, nombrer Text, direccion Text )");
          db.execSQL("create table notas( codigo int primary key,nombre Text, apellido Text,cedula Text, nota1 real, nota2 real,nota3 real,total real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
