package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Estudiantes extends AppCompatActivity implements View.OnClickListener {
EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes);
        ed1=findViewById(R.id.es1);
        ed2=findViewById(R.id.es2);
        ed3=findViewById(R.id.es3);
        ed4=findViewById(R.id.es4);
        ed5=findViewById(R.id.es5);
        ed6=findViewById(R.id.es6);
        ed7=findViewById(R.id.es7);
        btn=findViewById(R.id.btnregi);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final  String nombres=ed1.getText().toString();
        final String  ci =ed2.getText().toString();
        final String  telefono =ed3.getText().toString();
        final String  celular =ed4.getText().toString();
        final String  correo =ed5.getText().toString();
        final String  representante =ed6.getText().toString();
        final String  Direccion =ed7.getText().toString();
        Response.Listener<String> respoListener= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonReponse = new JSONObject(response);
                    boolean success=jsonReponse.getBoolean("success");
                    if(success){
                         Intent  intent1 = new Intent(Estudiantes.this,MainActivity.class);
                        Estudiantes.this.startActivity(intent1);
                    }else{


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

       //RegisterEstudiante registerEstudiante = new RegisterEstudiante(nombres, ci, telefono, celular, correo, representante, Direccion,);
        RequestQueue queue = Volley.newRequestQueue(Estudiantes.this);
        //queue.add(registerEstudiante);

    }

}
