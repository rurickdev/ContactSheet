package com.blogspot.mosaicogeek.skintigth.informacioncontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDetalleContacto extends AppCompatActivity {

    TextView Nombre;
    TextView Telefono;
    TextView Email;
    TextView Descripcion;
    TextView Fecha;

    int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle_contacto);

        Nombre = (TextView) findViewById(R.id.textNomb2);
        Telefono = (TextView) findViewById(R.id.texttel2);
        Email = (TextView) findViewById(R.id.textmail2);
        Descripcion = (TextView) findViewById(R.id.textdesc2);
        Fecha = (TextView) findViewById(R.id.textfecha2);

        //Recibe los datos que se ingresaron en el formulario
        Bundle bundle = getIntent().getExtras();
        Nombre.setText(bundle.getString("nombre"));
        Telefono.setText(bundle.getString("telefono"));
        Email.setText(bundle.getString("email"));
        Descripcion.setText(bundle.getString("descripcion"));
        Fecha.setText(bundle.getString("fecha"));

    }

    //Metodo dedicado a enviar los datos del contacto al editor y permitir la modificacion
    public void editarDatos(View v){

        String nombre_edit = Nombre.getText().toString();
        String telefono_edit = Telefono.getText().toString();
        String email_edit = Email.getText().toString();
        String descripion_edit = Descripcion.getText().toString();
        String fecha_edit = Fecha.getText().toString();

        separarFecha(fecha_edit);

        Intent intent = new Intent(ActivityDetalleContacto.this, ActivityPedirDatos.class);
        intent.putExtra("nombre_edit", nombre_edit);
        intent.putExtra("telefono_edit", telefono_edit);
        intent.putExtra("email_edit", email_edit);
        intent.putExtra("descripcion_edit", descripion_edit);
        intent.putExtra("dia", dia);
        intent.putExtra("mes", mes);
        intent.putExtra("año", año);

        startActivity(intent);
        finish();
    }

    public void separarFecha(String s){

        String strDia="", strMes="", strAño="";
        int helper=0;

        for(int i=0;i<=s.length()-1;i++){
            if(Character.isDigit(s.charAt(i))){
                switch(helper){
                    case 0:
                        strDia=strDia+s.charAt(i);
                        break;

                    case 1:
                        strMes=strMes+s.charAt(i);
                        break;

                    case 2:
                        strAño=strAño+s.charAt(i);
                        break;

                    default:
                        break;
                }
            }else{
                helper++;
            }
        }

        dia=Integer.parseInt(strDia);
        mes=Integer.parseInt(strMes)-1;
        año=Integer.parseInt(strAño);
    }
}
