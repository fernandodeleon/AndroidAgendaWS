package com.edwindeleon.org.androidagenda.presentadores;

import android.content.Context;

import com.edwindeleon.org.androidagenda.adapters.ContactoAdaptador;
import com.edwindeleon.org.androidagenda.beans.Contacto;
import com.edwindeleon.org.androidagenda.db.ConstructorContactos;
import com.edwindeleon.org.androidagenda.recyclerviews.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by Fernando de León on 10/01/2018.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;
    private Context context;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
