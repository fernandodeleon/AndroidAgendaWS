package com.edwindeleon.org.androidagenda.presentadores;

import android.content.Context;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.edwindeleon.org.androidagenda.adapters.ContactoAdaptador;
import com.edwindeleon.org.androidagenda.adapters.RestApiAdapter;
import com.edwindeleon.org.androidagenda.beans.Contacto;
import com.edwindeleon.org.androidagenda.db.ConstructorContactos;
import com.edwindeleon.org.androidagenda.recyclerviews.IRecyclerViewFragmentView;
import com.edwindeleon.org.androidagenda.restApi.EndpointsApi;
import com.edwindeleon.org.androidagenda.restApi.model.ContactoResponse;
import com.google.gson.Gson;

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
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
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

    @Override
    public void obtenerMediosRecientes(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Call.Callback<ContactoResponse>()){
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response){
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t){
                Toast.makeText(context, "Pasó algo en la conexión", Toast.LENGTH_LONG).show();
                Log.e("fallo la conexion", t.toString());
            }
        }
    }
}
