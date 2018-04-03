package com.edwindeleon.org.androidagenda.db;

import android.content.ContentValues;
import android.content.Context;

import com.edwindeleon.org.androidagenda.R;
import com.edwindeleon.org.androidagenda.beans.Contacto;
import com.edwindeleon.org.androidagenda.presentadores.IRecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Fernando de León on 10/01/2018.
 */

public class ConstructorContactos {

    private static final int LIKE = 1;
    private int idContacto = 1;
    private Context context;

    public ConstructorContactos(Context context){
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        /*idContacto++;
        ArrayList<Contacto> listaContactos = new ArrayList<>();

        listaContactos.add(new Contacto(idContacto, R.drawable.mt_03, "Juana", "45879639", "juana2016@hotmail.com", 5));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt___r15, "Alan", "45879639", "alan@hotmail.com", 8));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt_03, "Perla", "58968939", "perla@hotmail.com", 6));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt_03, "Juana", "45879639", "juana2016@hotmail.com", 2));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt___r15, "Alan", "45879639", "alan@hotmail.com", 8));
        return listaContactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarContactos(BaseDatos db){
        //idContacto ++;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Edwin de León");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "2233-9689");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "edwindeleon@yahoo.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mt_03);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Fer");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5633-9689");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "fer@yahoo.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mt___r15);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Guerra");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "3698-9689");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "guerra1098@yahoo.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mt___r15);

        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getIdContacto());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContactos(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
