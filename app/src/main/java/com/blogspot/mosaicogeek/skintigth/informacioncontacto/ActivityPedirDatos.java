package com.blogspot.mosaicogeek.skintigth.informacioncontacto;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

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

        Bundle bundle = getIntent().getExtras();
        Nombre.setText(bundle.getString("nombre_edit"));
        Telefono.setText(bundle.getString("telefono_edit"));
        Email.setText(bundle.getString("email_edit"));
        Descripcion.setText(bundle.getString("descripcion_edit"));
    }

    public void siguiente(View v) {
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
