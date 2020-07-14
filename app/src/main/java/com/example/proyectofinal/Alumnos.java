package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Alumnos extends AppCompatActivity {
    EditText ed0,ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    ImageView img;
    Button btnfoto;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        img = findViewById(R.id.imageView);
        ed0= findViewById(R.id.txtCodigo);
        ed1= findViewById(R.id.tvCedula);
        ed2= findViewById(R.id.tvNombre);
        ed3= findViewById(R.id.tvCedula);
        ed4= findViewById(R.id.txtCorreo);
        ed5= findViewById(R.id.txtTelefono);
        ed6= findViewById(R.id.txtNombrer);
        ed7= findViewById(R.id.txtDireccion);
        btnfoto=findViewById(R.id.btnFoto);
        btnfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llenar();
            }

            private void llenar() {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
    }
    public void RegistrarAlumno(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo= ed0.getText().toString();
        String nombre= ed1.getText().toString();
        String apellido= ed2.getText().toString();
        String cedula= ed3.getText().toString();
        String correo=ed4.getText().toString();
        String telefono=ed5.getText().toString();
        String nombrer=ed6.getText().toString();
        String direccion=ed7.getText().toString();
        if(!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !nombrer.isEmpty() && !direccion.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("cedula",cedula);
            registro.put("correo",correo);
            registro.put("telefono",telefono);
            registro.put("nombrer",nombrer);
            registro.put("direccion",direccion);
            db.insert("alumnos", null, registro);
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
    public void  BuscarAlumnos(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String cedula= ed3.getText().toString();
        if(!cedula.isEmpty() ){
            Cursor fila=db.rawQuery
                    ("select nombre, apellido from alumnos where cedula="+ cedula, null);
            if(fila.moveToFirst()){

                ed1.setText(fila.getString(0));
                ed2.setText(fila.getString(1));

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
    public void Menu(View v){
        Intent intent= new Intent(Alumnos.this, Menu.class);
        Toast.makeText(getApplicationContext(),"Bienvenido al Menu",Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
    public void ModificarAlumnos(View v){

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo= ed0.getText().toString();
        String nombre= ed1.getText().toString();
        String apellido= ed2.getText().toString();
        String cedula= ed3.getText().toString();
        String correo=ed4.getText().toString();
        String telefono=ed5.getText().toString();
        String nombrer=ed6.getText().toString();
        String direccion=ed7.getText().toString();
        if(!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !nombrer.isEmpty() && !direccion.isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("cedula",cedula);
            registro.put("correo",correo);
            registro.put("telefono",telefono);
            registro.put("nombrer",nombrer);
            registro.put("direccion",direccion);

            int cantidad = db.update("alumnos",registro,"codigo="+codigo,null);
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
    public void EliminarAlumnos(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper
                (this,"administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo=ed0.getText().toString();
        if(!codigo.isEmpty())
        {
            int cantidad = db.delete("alumnos", "codigo="+codigo,null);
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
                Toast.makeText(this,"Alumno eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El Alumno no existe", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(this,"Debe introducir el codigo del alumno", Toast.LENGTH_SHORT).show();
        }
    }
}
