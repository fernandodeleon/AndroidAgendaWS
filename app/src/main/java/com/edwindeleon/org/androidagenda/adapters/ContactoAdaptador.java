package com.edwindeleon.org.androidagenda.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edwindeleon.org.androidagenda.R;
import com.edwindeleon.org.androidagenda.activities.Contactos;
import com.edwindeleon.org.androidagenda.activities.DetalleContactos;
import com.edwindeleon.org.androidagenda.beans.Contacto;
import com.edwindeleon.org.androidagenda.db.ConstructorContactos;

import java.util.ArrayList;

/**
 * Created by Fernando on 26/10/2017.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    private ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactosVienen){
        this.contactos = contactosVienen;
    }

    //Infla el layout y lo pasa al viewHolder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getUrlFoto());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " Likes");

        contactoViewHolder.imgFoto.setOnClickListener((View activity) -> {
            Intent intent = new Intent(activity.getContext(), DetalleContactos.class);

            intent.putExtra("url", contacto.getUrlFoto());
            intent.putExtra("like", contacto.getLikes());

            activity.getContext().startActivity(intent);
        });

        /*contactoViewHolder.btnLike.setOnClickListener((View activity) -> {
            Toast.makeText(activity.getContext(), "Diste like a: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

            ConstructorContactos constructorContactos = new ConstructorContactos(activity.getContext());
            constructorContactos.darLikeContacto(contacto);

            //contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContactos(contacto));
        });*/
    }

    //Cantidad de elementos que tiene mi lista
    @Override
    public int getItemCount() { return contactos.size(); }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgContacto);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }


}
