package com.edwindeleon.org.androidagenda.recyclerviews;

import com.edwindeleon.org.androidagenda.adapters.ContactoAdaptador;
import com.edwindeleon.org.androidagenda.beans.Contacto;

import java.util.ArrayList;

/**
 * Created by Fernando de León on 10/01/2018.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
