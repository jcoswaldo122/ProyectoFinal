package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Notas extends AppCompatActivity {
    EditText ed0,ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        ed0=findViewById(R.id.txtCodigo);
        ed1= findViewById(R.id.txtCedula);
        ed2= findViewById(R.id.txtNombre);
        ed3=findViewById(R.id.txtApellido);
        ed4= findViewById(R.id.txtnota1);
        ed5=findViewById(R.id.txtnota2);
        ed6= findViewById(R.id.txtnota3);
        ed7=findViewById(R.id.txtTotal);


    }
    public void  Buscar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String cedula= ed1.getText().toString();
        if(!cedula.isEmpty() ){
            Cursor fila=db.rawQuery
                    ("select nombre, apellido from notas where cedula="+ cedula, null);
            if(fila.moveToFirst()){

                ed2.setText(fila.getString(0));
                ed3.setText(fila.getString(1));

                ;
                db.close();

            }
            else{
                Toast.makeText(this, "No exixte el nombre", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Introdusca la cedula correcta", Toast.LENGTH_SHORT).show();
        }

    }
    public void Calcular(View v){
        double valor1,valor2,valor3,valor4,valor5,valor6,valor7,promedio1,promedio2,total;
        valor1= Double.parseDouble(ed4.getText().toString());
        valor2= Double.parseDouble(ed5.getText().toString());
        valor3= Double.parseDouble(ed6.getText().toString());

        promedio1=(valor1+valor2+valor3)/3;
        ed7.setText(String.format("%.1f" ,promedio1));

    }
    public void InsertarNota(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo= ed0.getText().toString();
        String cedula= ed1.getText().toString();
        String nombre= ed2.getText().toString();
        String apellido= ed3.getText().toString();
        String nota1= ed4.getText().toString();
        String nota2=ed5.getText().toString();
        String nota3=ed6.getText().toString();
        String totalr=ed7.getText().toString();

        if(!codigo.isEmpty()  && !nombre.isEmpty() && !apellido.isEmpty() &&!cedula.isEmpty() && !nota1.isEmpty() && !nota2.isEmpty() && !nota3.isEmpty() && !totalr.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("cedula",cedula);
            registro.put("nota1",nota1);
            registro.put("nota2",nota2);
            registro.put("nota3",nota3);
            registro.put("total",totalr);
            db.insert("notas", null, registro);
            db.close();
            ed0.setText("");
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed6.setText("");
            ed7.setText("");
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debe Lllenar Todos Los Campos", Toast.LENGTH_SHORT).show();
        }

    }
    public void menu(View v){
        Intent intent= new Intent(Notas.this, Menu.class);
        Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    public void ModificarNotas(View v){

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo= ed0.getText().toString();
        String cedula= ed1.getText().toString();
        String nombre= ed2.getText().toString();
        String apellido= ed3.getText().toString();
        String nota1= ed4.getText().toString();
        String nota2=ed5.getText().toString();
        String nota3=ed6.getText().toString();
        String totalr=ed7.getText().toString();
         if(!codigo.isEmpty()  && !nombre.isEmpty() && !apellido.isEmpty() &&!cedula.isEmpty() && !nota1.isEmpty() && !nota2.isEmpty() && !nota3.isEmpty() && !totalr.isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("cedula",cedula);
            registro.put("nota1",nota1);
            registro.put("nota2",nota2);
            registro.put("nota3",nota3);
            registro.put("total",totalr);

            int cantidad = db.update("notas",registro,"codigo="+codigo,null);
            db.close();

            if(cantidad==1)
            {
                Toast.makeText(this,"Articulo Modificado Exitosamente", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this,"Articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
    public void EliminarNotas(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo=ed0.getText().toString();
        if(!codigo.isEmpty())
        {
            int cantidad = db.delete("notas", "codigo="+codigo,null);
            db.close();

            ed0.setText("");
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed6.setText("");
            ed7.setText("");

            if(cantidad==1)
            {
                Toast.makeText(this,"notas eliminadas exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"La notas no existen", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(this,"Debe introducir el codigo de la  nota", Toast.LENGTH_SHORT).show();
        }
    }
}
