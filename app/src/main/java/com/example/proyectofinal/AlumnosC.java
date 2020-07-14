package com.example.proyectofinal;

public class AlumnosC {
    int codigo;
    String nombre;
    String apellido;
    String  cdula;
    String correo;
    String  telefono;
    String nombrer;
    String direccion;

    public int getCodigo() {
        return codigo;
    }

    public AlumnosC(int codigo, String nombre, String apellido, String cdula, String correo, String telefono, String nombrer, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cdula = cdula;
        this.correo = correo;
        this.telefono = telefono;
        this.nombrer = nombrer;
        this.direccion = direccion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCdula() {
        return cdula;
    }

    public void setCdula(String cdula) {
        this.cdula = cdula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombrer() {
        return nombrer;
    }

    public void setNombrer(String nombrer) {
        this.nombrer = nombrer;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public AlumnosC(){


    }

}
