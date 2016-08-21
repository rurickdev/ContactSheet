package com.blogspot.mosaicogeek.skintigth.informacioncontacto;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class ActivityPedirDatos extends AppCompatActivity {

    TextInputEditText Nombre;
    TextInputEditText Telefono;
    TextInputEditText Email;
    TextInputEditText Descripcion;

    DatePicker Fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pedir_datos);

        Nombre = (TextInputEditText) findViewById(R.id.nombreText);
        Telefono = (TextInputEditText) findViewById(R.id.telefonoText);
        Email = (TextInputEditText) findViewById(R.id.emailText);
        Descripcion = (TextInputEditText) findViewById(R.id.descripcionText);
        Fecha = (DatePicker) findViewById(R.id.datePic);

        //Recibe los datos a editar del activity "DetalleContacto"
        Bundle bundle = getIntent().getExtras();
        try{
            Nombre.setText(bundle.getString("nombre_edit"));
            Telefono.setText(bundle.getString("telefono_edit"));
            Email.setText(bundle.getString("email_edit"));
            Descripcion.setText(bundle.getString("descripcion_edit"));
            Fecha.updateDate(bundle.getInt("año"),bundle.getInt("mes"),bundle.getInt("dia"));
        }catch(Exception e){
        }

    }

    //Metodo dedicado a preguntar al usuario si desea enviar los datos
    public void botonSiguiente(View v) {

        AlertDialog.Builder constructor = new AlertDialog.Builder(this);

        constructor.setTitle("Confirmacion")
                .setMessage("¿Desea enviar los datos del contacto?")
                .setCancelable(true)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        enviarDatos();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        constructor.show();
    }

    //Metodo dedicado a enviar los datos de una activity a otra
    private void enviarDatos() {

        String nombre = Nombre.getText().toString();
        String telefono = Telefono.getText().toString();
        String email = Email.getText().toString();
        String descripion = Descripcion.getText().toString();
        String fecha = Fecha.getDayOfMonth() + "/" + (Fecha.getMonth() + 1) + "/" + Fecha.getYear();

        Intent intent = new Intent(ActivityPedirDatos.this, ActivityDetalleContacto.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("telefono", telefono);
        intent.putExtra("email", email);
        intent.putExtra("descripcion", descripion);
        intent.putExtra("fecha", fecha);

        startActivity(intent);
        finish();
    }

}
