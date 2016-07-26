package com.blogspot.mosaicogeek.skintigth.informacioncontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityDetalleContacto extends AppCompatActivity {

    TextView Nombre;
    TextView Telefono;
    TextView Email;
    TextView Descripcion;
    TextView Fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle_contacto);

        Nombre = (TextView) findViewById(R.id.textNomb2);
        Telefono = (TextView) findViewById(R.id.texttel2);
        Email = (TextView) findViewById(R.id.textmail2);
        Descripcion = (TextView) findViewById(R.id.textdesc2);
        Fecha = (TextView) findViewById(R.id.textfecha2);


        Bundle bundle = getIntent().getExtras();
        Nombre.setText(bundle.getString("nombre"));
        Telefono.setText(bundle.getString("telefono"));
        Email.setText(bundle.getString("email"));
        Descripcion.setText(bundle.getString("descripcion"));
        Fecha.setText(bundle.getString("fecha"));

    }

    public void editarDatos(View v){

        String nombre_edit = "nombre";//Nombre.getText().toString();
        String telefono_edit = "0123456789";//Telefono.getText().toString();
        String email_edit = "ejemplo@dominio.net";//Email.getText().toString();
        String descripion_edit = "sjhgfdjashvbcjlwhavbwhvb";//Descripcion.getText().toString();

        Intent intent = new Intent(ActivityDetalleContacto.this, ActivityPedirDatos.class);
        intent.putExtra("nombre_edit", nombre_edit);
        intent.putExtra("telefono_edit", telefono_edit);
        intent.putExtra("email_edit", email_edit);
        intent.putExtra("descripcion_edit", descripion_edit);

        startActivity(intent);
        finish();
    }
}
