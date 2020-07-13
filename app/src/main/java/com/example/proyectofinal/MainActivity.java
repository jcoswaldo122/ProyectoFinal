package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Usuario,Contraseña,dato;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usuario= (EditText)  findViewById(R.id.txtUsuario);
        Contraseña=(EditText) findViewById(R.id.txtPass);
    }
    public void Ingresar(View v){
        String V_Usuario= Usuario.getText().toString();
        String V_Contraseña= Contraseña.getText().toString();
        if(V_Usuario.equals("victor")&& V_Contraseña.equals("jose")){
            Intent intent= new Intent(getApplicationContext(),Menu.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Usuario y Contraseña Incorrectas",Toast.LENGTH_SHORT);
        }

    }

}
