package com.edwindeleon.org.androidagenda.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.edwindeleon.org.androidagenda.R;

public class DetalleContactos extends AppCompatActivity {

    /*public TextView tvNombre;
    public TextView tvTelefono;
    public TextView tvCorreo;*/
    public ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contactos);

        Bundle parametros = getIntent().getExtras();

        String url = parametros.getString("url");
        int likes = parametros.getInt("like");

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);


        tvLikesDetalle.setText(String.valueOf(likes));
    }

    //aca iban los metodos de llamar y enviar correo

}
