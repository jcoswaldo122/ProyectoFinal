package com.example.proyectofinal;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterEstudiante extends StringRequest {
    private static final String REGISTER_RESQUEST_URL="https://localhost/Register.php";
    private Map<String, String> params;
    public  RegisterEstudiante(String nombres, String ci, String telefono, String celular, String correo, String representante, String Direccion, Response.Listener<String> listener){
        super(Method.POST, REGISTER_RESQUEST_URL, listener, null);
        params= new HashMap<>();
        params.put("nombres",nombres);
        params.put("ci",ci);
        params.put("telefono",telefono);
        params.put("celular",celular);
        params.put("correo",correo);
        params.put("representante",representante);
        params.put("Direccion",Direccion);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
