package com.edwindeleon.org.androidagenda.beans;

/**
 * Created by Fernando on 14/10/2017.
 */

public class Contacto {

    public String id;
    public String urlFoto;
    public String nombreCompleto;
    public int likes = 0;

    public Contacto(String urlFoto, String nombreCompleto, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public Contacto(){

    }

    public String getId() {
        return id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getLikes() {
        return likes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
