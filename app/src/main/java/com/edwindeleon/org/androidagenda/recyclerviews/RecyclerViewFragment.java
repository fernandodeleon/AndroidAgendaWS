package com.edwindeleon.org.androidagenda.recyclerviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edwindeleon.org.androidagenda.R;
import com.edwindeleon.org.androidagenda.adapters.ContactoAdaptador;
import com.edwindeleon.org.androidagenda.beans.Contacto;
import com.edwindeleon.org.androidagenda.presentadores.IRecyclerViewFragmentPresenter;
import com.edwindeleon.org.androidagenda.presentadores.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Fernando on 02/11/2017.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Contacto> listaContactos;
    private RecyclerView listaReciclaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaReciclaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        //inicializarListaContactos();

        return v;
    }

    /*public void inicializarListaContactos() {
        idContacto++;
        listaContactos = new ArrayList<>();

        listaContactos.add(new Contacto(idContacto, R.drawable.mt_03, "Juana", "45879639", "juana2016@hotmail.com", likes));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt___r15, "Alan", "45879639", "alan@hotmail.com", R.drawable.ic_megusta));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt_03, "Perla", "58968939", "perla@hotmail.com", R.drawable.ic_megusta));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt_03, "Juana", "45879639", "juana2016@hotmail.com", R.drawable.ic_megusta));
        listaContactos.add(new Contacto(idContacto, R.drawable.mt___r15, "Alan", "45879639", "alan@hotmail.com", R.drawable.ic_megusta));
    }*/

    @Override
    public void generarLinearLayoutVertical() {

        //****Para ubicar los elementos con una orientación
        /*LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaReciclaContactos.setLayoutManager(llm);*/

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);
        listaReciclaContactos.setLayoutManager(glm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaReciclaContactos.setAdapter(adaptador);
    }
}
