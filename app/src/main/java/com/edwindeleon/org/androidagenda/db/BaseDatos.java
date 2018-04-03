package com.edwindeleon.org.androidagenda.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.edwindeleon.org.androidagenda.beans.Contacto;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

/**
 * Created by Fernando de León on 15/01/2018.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                ConstantesBaseDatos.TABLE_CONTACTS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE       + " TEXT," +
                ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO     + " TEXT," +
                ConstantesBaseDatos.TABLE_CONTACTS_EMAIL        + " TEXT," +
                ConstantesBaseDatos.TABLE_CONTACTS_FOTO         + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT + "(" +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "(" + ConstantesBaseDatos.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setIdContacto(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setCorreo(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + ") as like" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                    " WHERE "+ ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contactoActual.getIdContacto();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if(registrosLikes.moveToNext()){
                contactoActual.setLike(registrosLikes.getInt(0));
            }else{
                contactoActual.setLike(0);
            }

            contactos.add(contactoActual);
            //contactoActual.setLike();
        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + ")" +
            " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                " WHERE "+ ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "=" + contacto.getIdContacto();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }
}
