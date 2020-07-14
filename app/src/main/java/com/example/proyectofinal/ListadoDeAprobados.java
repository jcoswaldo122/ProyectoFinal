package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class ListadoDeAprobados extends AppCompatActivity {
ListView ListViewAlumnos;
SQLiteDatabase sql;
SimpleCursorAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_de_aprobados);



    }
    public void MostrarAlumnos(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        sql = admin.getWritableDatabase();
        ListViewAlumnos=findViewById(R.id.listView);
        Cursor curso=sql.rawQuery("SELECT * FROM alumnos", null);
        String[] campos={"cedula","nombre","apellido"};
        int [] ids={R.id.tvCedula,R.id.tvNombre,R.id.tvApellido};
        adaptador = new SimpleCursorAdapter(this, R.layout.itemlistviewestudiante,curso,campos,ids);
        ListViewAlumnos.setAdapter(adaptador);
    }
}
