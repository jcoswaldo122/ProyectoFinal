package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void Alumnos(View v){
        Intent intent= new Intent(Menu.this, Alumnos.class);
        Toast.makeText(getApplicationContext(),"Bienvenido Alumnos",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    public void Notas(View v){
        Intent intent= new Intent(Menu.this, Notas.class);
        Toast.makeText(getApplicationContext(),"Bienvenido A Notas",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    public void ListadoReprobados(View v){
        Intent intent= new Intent(Menu.this, ListadoDeReprobados.class);
        Toast.makeText(getApplicationContext(),"Bienvenido Listado De Reprobados",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    public void ListadoAprobados(View v){
        Intent intent= new Intent(Menu.this, ListadoDeAprobados.class);
        Toast.makeText(getApplicationContext(),"Bienvenido Listado De Aprobados",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    public void Usuario(View v){
        Intent intent= new Intent(Menu.this, MainActivity.class);
        Toast.makeText(getApplicationContext(),"Bienvenido Listado De Aprobados",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}