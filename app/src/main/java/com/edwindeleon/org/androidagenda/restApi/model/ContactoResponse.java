package com.edwindeleon.org.androidagenda.restApi.model;

import com.edwindeleon.org.androidagenda.beans.Contacto;

import java.util.ArrayList;

/**
 * Created by Fernando on 13/03/2018.
 */

public class ContactoResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
